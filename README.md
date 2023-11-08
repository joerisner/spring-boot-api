# Spring Boot API

Spring Boot REST API for Books and Authors. I built this project for ongoing learning while progressing through [Devtiro's Spring Boot Course](https://www.youtube.com/watch?v=Nv2DERaMx-4).

## Running the application

The project uses PostgreSQL for its database while running. Tests utilize the H2 in-memory database. Follow the steps below to setup PostgreSQL using Docker.

1. Ensure Java 21 is installed
2. Ensure Docker is running on your machine
3. Start the database on port **5433** (connection info. can be found in the project's `application.yml` file)
   ```sh
   docker-compose up
   ```
4. Run the application on port **5000**
   ```sh
   ./mvnw spring-boot:run
   ```

## Running tests

Build the application and run the tests

```sh
  ./mvnw clean verify
```
