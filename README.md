Product API

A RESTful Product Management API built using Java and Spring Boot.

Technologies Used

- Java 21
- Spring Boot
- Spring Data JPA / Hibernate
- MySQL
- Spring Security
- JWT Authentication
- Refresh Token
- Jakarta Validation
- Swagger / OpenAPI
- JUnit 5
- Mockito
- H2 Database for Testing
- Maven
- Docker

API Endpoints

Authentication

- "POST /api/v1/auth/register"
- "POST /api/v1/auth/login"
- "POST /api/v1/auth/refresh"

Products

- "GET /api/v1/products"
- "GET /api/v1/products/{id}"
- "POST /api/v1/products"
- "PUT /api/v1/products/{id}"
- "DELETE /api/v1/products/{id}"
- "GET /api/v1/products/{id}/items"

Security

The application uses JWT-based authentication with role-based authorization.

- USER: Can view products
- ADMIN: Can create, update and delete products
- Refresh token rotation is implemented
- Passwords are encrypted using BCrypt

Validation

Jakarta Bean Validation is used for validating API request data.

Swagger

Swagger UI is available at:

"http://localhost:8080/swagger-ui/index.html"

Database

MySQL is used as the primary database.

Database name:

"product_db"

Running the Application

1. Clone the repository.
2. Configure MySQL.
3. Update database credentials in "application.properties".
4. Run the application using Maven:

mvn spring-boot:run

The application runs on:

"http://localhost:8080"

Project Structure

src/main/java/com/adesh/Productapi
├── controller
├── service
├── repository
├── entity
├── dto
├── security
└── exception

Author

Aadesh Nimkar
