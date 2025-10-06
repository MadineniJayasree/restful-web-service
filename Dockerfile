# Use OpenJDK 21 as base
FROM openjdk:21

# Set working directory in container
WORKDIR /app

# Copy jar built by Maven
COPY target/*.jar app.jar

# Expose application port
EXPOSE 8080

# Run the jar
ENTRYPOINT ["java","-jar","app.jar"]
