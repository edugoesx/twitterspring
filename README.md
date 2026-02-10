API RESTful simplificada que simula as funcionalidades básicas de uma rede social (Twitter), desenvolvida com o ecossistema Spring.

## Descrição

Este é um projeto backend focado em demonstrar a implementação de uma arquitetura escalável utilizando Java e Spring Boot. O sistema permite a criação de usuários, gerenciamento de tweets e possui um sistema de segurança completo com autenticação via Token JWT e OAuth2.

O objetivo principal é fornecer funcionalidades de feed, criação de publicações e gerenciamento de permissões (Admin e User).

## Tecnologias Utilizadas

* **Java 17** (ou superior)
* **Spring Boot 3**
* **Spring Web** (REST API)
* **Spring Data JPA** (Persistência de dados)
* **Spring Security** (Autenticação e Autorização)
* **OAuth2 Resource Server & JWT** (Segurança baseada em tokens)
* **PostgreSQL** (Banco de dados relacional)
* **Maven** (Gerenciador de dependências)

## Funcionalidades

* **Autenticação e Segurança:**
    * Login seguro com geração de Token JWT.
    * Controle de acesso baseado em Roles (`ADMIN` e `BASIC`).
* **Gestão de Usuários:**
    * Criação de novas contas.
    * Listagem de usuários (apenas Admin).
* **Gestão de Tweets:**
    * Criação de novos tweets (com imagens ou apenas texto).
    * Remoção de tweets (pelo dono ou Admin).
* **Feed:**
    * Listagem de tweets para consumo no feed principal.

## Como rodar o projeto

### Pré-requisitos
* Java JDK 17+ instalado.
* Maven instalado.
* PostgreSQL instalado e rodando.

### 1. Configuração do Banco de Dados
Crie um banco de dados no PostgreSQL chamado `twitterspring` (ou ajuste no arquivo `application.properties`).

### 2. Configuração do Projeto
No arquivo src/main/resources/application.properties, verifique se as credenciais do banco estão corretas:


spring.datasource.url=jdbc:postgresql://localhost:5432/twitterspring
spring.datasource.username=postgres
spring.datasource.password=senha
spring.jpa.hibernate.ddl-auto=update
(Lembre-se de configurar as chaves RSA para assinatura do JWT se estiver usando chaves assimétricas).

3. Executar a aplicação
Abra o terminal na raiz do projeto e execute:

mvn spring-boot:run

A aplicação estará disponível em http://localhost:8080.

🔗 Endpoints da API
Aqui estão os principais endpoints disponíveis:

Autenticação
POST /login - Realiza o login e retorna o Token JWT.

Usuários
POST /users - Cria um novo usuário.

GET /users - Lista todos os usuários (Requer Role ADMIN).

Tweets
POST /tweets - Cria um novo tweet.

GET /feed - Lista os tweets do feed.

DELETE /tweets/{id} - Deleta um tweet (Requer ser dono ou ADMIN).

Este projeto foi desenvolvido para fins de estudo sobre Spring Security e Arquitetura REST.
