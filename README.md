# Spring Boot API

Spring Boot REST API for Books and Authors.

## Setting up PostgreSQL

A PostgreSQL database is used for this project. Follow the steps below to start one using Docker.

1. Ensure Docker is running on your machine
2. Run `docker-compose up` from this `hibernate` directory
3. Run the tests (see below)
   - You should be able to open the database using Postico or any other SQL client supported by Postgres and connect using the connection info in this project's `application.yml` file.

## Running tests

1. Ensure Java 21 is installed
2. Build the application and run the tests
   ```sh
   ./mvnw clean verify
   ```
