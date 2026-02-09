package tech.goes.twitterspring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.goes.twitterspring.entities.Role;

import java.util.UUID;

@Repository
public interface RoleRepository extends JpaRepository<Role, UUID> {
}
