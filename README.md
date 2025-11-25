# Complaints Service

Spring Boot application for capturing and viewing complaints submitted from a browser form.

## Run locally with Maven
1. Ensure Java 21+ is installed.
2. Start the application:
   ```bash
   ./mvnw spring-boot:run
   ```
3. Visit http://localhost:8080/complaints to submit complaints. The in-memory H2 database starts automatically; the console is available at http://localhost:8080/h2-console using JDBC URL `jdbc:h2:mem:complaintsdb` and user `sa`.

## Build and run a Docker image
1. Build the container image (multi-stage build uses the Maven wrapper inside the project):
   ```bash
   docker build -t complaints-service:local .
   ```
2. Run the container exposing port 8080:
   ```bash
   docker run --rm -p 8080:8080 complaints-service:local
   ```
3. Open http://localhost:8080/complaints in your browser.

The Docker image uses the same in-memory H2 database configuration, so data resets when the container stops.
