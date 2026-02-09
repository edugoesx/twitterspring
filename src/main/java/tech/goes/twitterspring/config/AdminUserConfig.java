package tech.goes.twitterspring.config;

import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import tech.goes.twitterspring.entities.Role;
import tech.goes.twitterspring.entities.User;
import tech.goes.twitterspring.repositories.RoleRepository;
import tech.goes.twitterspring.repositories.UserRepository;

import java.util.Set;

@Configuration
public class AdminUserConfig implements CommandLineRunner {

    private RoleRepository roleRepository;
    private UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder;

    public AdminUserConfig(RoleRepository roleRepository, UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        var roleName = Role.Values.admin.name();
        var roleFromDb = roleRepository.findByName(roleName);

        final Role roleAdmin;
        if (roleFromDb == null) {
            var newRole = new Role();
            newRole.setName(roleName);
            roleRepository.save(newRole);
            roleAdmin = newRole;
            System.out.println("Role 'ADMIN' não existia e foi criada.");
        } else {
            roleAdmin = roleFromDb;
        }

        var userAdmin = userRepository.findByUsername("admin");

        userAdmin.ifPresentOrElse(
                (user) -> {
                    System.out.println("admin already exists");
                },
                () -> {
                    var user = new User();
                    user.setUsername("admin");
                    user.setPassword(passwordEncoder.encode("123"));
                    user.setRoles(Set.of(roleAdmin));
                    userRepository.save(user);
                    System.out.println("Usuário 'admin' criado com sucesso.");
                }
        );
    }
}