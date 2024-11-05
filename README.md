# Content API Spring

A basic example of a Spring Boot API for managing content data. This repository provides a foundation for developing RESTful APIs in Java using the Spring framework.

## Features

- RESTful API structure with CRUD operations
- Uses Spring Boot for dependency management and application setup
- Simple configuration with `pom.xml` for dependency handling

## Prerequisites

- Java 11 or higher
- Maven

## Getting Started

1. **Clone the repository**:
   ```bash
   git clone https://github.com/marvintv/content-api-spring.git
2. **Navigate to the project directory**:
   ```bash
   cd content-api-spring
3. **Run the Application**:
   ```bash
   ./mvnw spring-boot:run

## API Endpoints
* **GET** `/api/content` - Retrieve all content
* **POST** `/api/content` - Add new content
* **PUT** `/api/content/{id}` - Update content by ID
* **DELETE** `/api/content/{id}` - Delete content by ID
