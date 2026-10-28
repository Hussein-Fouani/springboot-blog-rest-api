# Spring Boot Blog REST API

A REST API for a simple blog built with Spring Boot: manage posts and their comments, with pagination, sorting, validation and centralized error handling.

## Tech Stack

- Java 17, Spring Boot 3.1
- Spring Web, Spring Data JPA (Hibernate)
- MySQL
- Bean Validation
- ModelMapper, Lombok

## Features

- CRUD for posts
- CRUD for comments nested under a post (one-to-many mapping)
- Pagination and sorting for the post list
- Request validation with field-level error messages
- Global exception handling (404 for missing resources, 400 for invalid requests or a comment that does not belong to the post)

The project also contains `User` and `Role` entities and repositories (many-to-many mapping) as groundwork for authentication; there are no authentication endpoints yet.

## Getting Started

### Prerequisites

- JDK 17
- MySQL running locally

### Configuration

Create the database:

```sql
CREATE DATABASE blogappdb;
```

Connection settings are in `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/blogappdb?useSSL=false
spring.datasource.username=${DB_USERNAME:root}
spring.datasource.password=${DB_PASSWORD:root}
```

Set the `DB_USERNAME` and `DB_PASSWORD` environment variables to override the default `root`/`root` credentials. Tables are created automatically (`spring.jpa.hibernate.ddl-auto=update`).

### Run

```bash
git clone https://github.com/Hussein-Fouani/springboot-blog-rest-api.git
cd springboot-blog-rest-api
./mvnw spring-boot:run
```

The API runs on `http://localhost:8080`.

## API Endpoints

### Posts

| Method | Path | Description |
|--------|------|-------------|
| POST | `/api/posts/` | Create a post |
| GET | `/api/posts/?pageNo=0&pageSize=10&sortBy=id&sortDir=asc` | List posts (all query parameters optional) |
| GET | `/api/posts/{id}` | Get a post by id |
| PUT | `/api/posts/{id}` | Update a post |
| DELETE | `/api/posts/{id}` | Delete a post and its comments |

Post body:

```json
{ "title": "My first post", "description": "Short description", "content": "Post content" }
```

`title` needs at least 4 characters, `description` at least 10, `content` must not be empty.

### Comments

| Method | Path | Description |
|--------|------|-------------|
| POST | `/api/posts/{postId}/comment` | Add a comment to a post |
| GET | `/api/posts/{postId}/comment` | List a post's comments |
| GET | `/api/posts/{postId}/comment/{commentId}` | Get a comment |
| PUT | `/api/posts/{postId}/comment/{commentId}` | Update a comment |
| DELETE | `/api/posts/{postId}/comment/{commentId}` | Delete a comment |

Comment body:

```json
{ "name": "John Doe", "email": "john@example.com", "body": "Great article, thanks!" }
```

`name` needs 5–255 characters, `body` 10–255 characters, `email` must be a valid email address.
