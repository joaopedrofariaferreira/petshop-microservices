
# Petshop Microservices

Projeto com 4 microserviços em Java Spring Boot:

- catalog-service (Catálogo de Produtos)
- user-service (Usuários)
- orders-service (Pedidos)
- payment-service (Pagamento simulado)

Cada serviço tem seu banco MySQL isolado e independente.

## Rodando localmente com Docker Compose

1. Compile todos os serviços:

```
mvn clean package
```

2. Configure o arquivo application.properties de cada serviço para conectar ao MySQL via Docker, ex:

```
spring.datasource.url=jdbc:mysql://mysql-catalog:3306/catalogdb?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=root_password
```

3. Suba os containers:

```
docker-compose up --build
```

4. Acesse os serviços em:

- http://localhost:8081 (Catálogo)
- http://localhost:8082 (Usuários)
- http://localhost:8083 (Pedidos)
- http://localhost:8084 (Pagamento)

Swagger UI disponível em cada serviço no /swagger-ui.html

---

## Estrutura do projeto

Cada serviço tem:

- src/main/java/com/petshop/{servicename}
- src/main/resources/application.properties
- pom.xml
- Dockerfile

---

## Tecnologias usadas

- Java 17+
- Spring Boot 3.x
- Spring Data JPA
- Lombok
- MySQL 8
- Docker e Docker Compose
- Springdoc OpenAPI (Swagger)

---

## Melhorias futuras

- Segurança com JWT
- Gateway API
- Comunicação assíncrona entre serviços
- Frontend para consumir as APIs
