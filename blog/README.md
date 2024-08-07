# RESTful API with Spring Boot

This project demonstrates how to build a RESTful API using Spring Boot with three different data storage solutions. Each branch in this repository showcases CRUD (Create, Read, Update, Delete) operations using various storage methods:

1. **In-Memory Storage** (`in-memory` branch)
2. **Embedded H2 Database** (`h2-branch`)
3. **PostgreSQL Database** (`postgres-branch`)

## Branches and Implementations

### `main` Branch - In-Memory Storage

- **Purpose:** Demonstrates CRUD operations using in-memory data storage.
- **Implementation:**
    - **Data Storage:** Uses an in-memory list for data storage.
    - **Repository:** Implements CRUD operations using an in-memory data structure.
    - **Controller:** Provides RESTful endpoints to interact with the in-memory data.
- **Use Case:** Suitable for development and testing where persistent storage is not required.

### `h2-branch` Branch - Embedded H2 Database

- **Purpose:** Demonstrates CRUD operations using an embedded H2 database.
- **Implementation:**
    - **Data Storage:** Utilizes H2, an in-memory database that can also be file-based.
    - **Repository:** Implements CRUD operations with the H2 database via `JdbcClient`.
    - **SQL Script:** SQL scripts are used for schema initialization and management (`schema.sql`).
    - **Configuration:** Includes H2 console for database management and visualization.
- **Use Case:** Ideal for lightweight applications and testing scenarios requiring persistent storage.

### `postgres-branch` Branch - PostgreSQL Database

- **Purpose:** Demonstrates CRUD operations using PostgreSQL, a full-featured relational database.
- **Implementation:**
    - **Data Storage:** Uses PostgreSQL as the database.
    - **Repository:** Implements CRUD operations using Spring Data JDBC.
    - **Configuration:** Configured with PostgreSQL via JDBC, and Spring Data JDBC manages the data.
    - **SQL Script:** SQL scripts are used for database schema creation and management.
- **Use Case:** Best for production scenarios where a robust and scalable relational database is needed.

## Key Steps for Each Branch

1. **In-Memory Storage (`in-memory` branch):**
    - **Define Entity Classes:** Create POJOs for data representation.
    - **Create Repository:** Use an in-memory data structure for CRUD operations.
    - **Build Controller:** Expose RESTful endpoints for CRUD operations.

2. **Embedded H2 Database (`h2-branch` branch):**
    - **Add H2 Dependency:** Include H2 dependency in `pom.xml`.
    - **Configure H2:** Set up the H2 datasource in `application.properties` and enable the H2 console.
    - **Write SQL Scripts:** Manage schema using SQL scripts in `schema.sql`.
    - **Use `JdbcClient`:** Implement CRUD operations using `JdbcClient`.

3. **PostgreSQL Database (`postgres-branch` branch):**
    - **Add PostgreSQL Dependency:** Include PostgreSQL dependency in `pom.xml`.
    - **Configure PostgreSQL:** Set up PostgreSQL datasource in `application.properties`.
    - **Create Database Schema:** Use SQL scripts or Spring Data JDBC configuration for schema management.
    - **Use Spring Data JDBC:** Implement CRUD operations using Spring Data JDBC.

## Getting Started

1. **Clone the Repository:**

   ```bash
   git clone <repository-url>
   
   git checkout <branch-name>


replace <branch-name> with main, h2-branch, or postgres-branch depending on the branch you want to work with.

    ./mvnw spring-boot:run

2. **Access the API:**

    In-Memory Storage (main branch): http://localhost:8080/api/runs
    H2 Database (h2-branch branch): http://localhost:8080/h2-console
    PostgreSQL Database (postgres-branch branch): Ensure PostgreSQL is running and configured.