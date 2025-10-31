# 🚀 Spring Boot: Database Initialization with Multiple SQL Files

This is a simple Spring Boot project that demonstrates how to initialize a database using multiple, organized SQL script files at startup.

Instead of relying on the default `schema.sql` and `data.sql` files, this project uses a custom `DatabaseInitializationService` to load scripts from specific directories (`db/migration/schema/` and `db/migration/data/`). This allows for better organization of your database scripts.

## 🛠️ Technologies Used

* **Java 21**
* **Spring Boot**
* **Spring Data JPA:** For database interaction
* **Spring Web:** For creating REST endpoints
* **MySQL:** The relational database
* **Lombok:** To reduce boilerplate code

## ⚙️ How to Run This Project

### 1. Prerequisites

* You must have **Java 21 (JDK)** installed.
* You must have a **MySQL Server** running on your computer.

### 2. Configure the Database

1.  **Create the Database:** Before running the application, you must create the database that Spring Boot will connect to. Run this command in your MySQL client (like MySQL Workbench or the command line):

    ```sql
    CREATE DATABASE example;
    ```

2.  **Edit `application.properties`:** Open the `src/main/resources/application.properties` file. You **must** update the username and password to match your local MySQL credentials.

    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/example
    spring.datasource.username=root
    spring.datasource.password=Aman  
    ```

### 3. Run the Application

The easiest way to run the project is from your IDE (like IntelliJ IDEA):

1.  Find the `SpringBootWithMultipleSqlImportFilesApplication.java` file.
2.  Right-click on it and select "Run".

The application will start on `http://localhost:8080`.

## 🧪 Testing the Endpoints

Once the application is running, the database will be automatically initialized with data from the SQL files. You can view the data by visiting these URLs in your web browser:

* **Get All Users:**
    `http://localhost:8080/api/users`

* **Get All Products:**
    `http://localhost:8080/api/products`

## 📁 Key Project Files

* `service/DatabaseInitializationService.java`
    This is the most important file. The `@PostConstruct` annotation tells Spring to run the `initializeDatabase()` method at startup, which executes all scripts in the schema and data folders.

* `application.properties`
    Note that `spring.jpa.hibernate.ddl-auto=none` is set. This is important! It tells Hibernate *not* to create tables, allowing our custom scripts to take full control.

* `src/main/resources/db/migration/schema/`
    This directory holds all the `CREATE TABLE` scripts (`schema1.sql`, `schema2.sql`).

* `src/main/resources/db/migration/data/`
    This directory holds all the `INSERT INTO` scripts (`data1.sql`, `data2.sql`).


## 👨‍💻 Author

   Aman Manwatkar
