FROM openjdk:17-jdk-slim as builder

WORKDIR /app

# Copy the Maven wrapper and pom.xml
COPY .mvn/ .mvn
COPY mvnw pom.xml ./

# Make the wrapper executable
RUN chmod +x mvnw

# Download dependencies
RUN ./mvnw dependency:go-offline

# Build the application JAR
COPY src ./src
RUN ./mvnw package -DskipTests

# --- Runtime stage ---
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy the executable jar file from the builder stage
COPY --from=builder /app/target/edu-bot-backend-0.0.1-SNAPSHOT.jar app.jar

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Define environment variable
ENV SPRING_PROFILES_ACTIVE=docker

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]
