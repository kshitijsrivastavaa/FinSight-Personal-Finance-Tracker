# ---- Build Stage ----
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copy only backend
COPY backend ./backend

# Build project
WORKDIR /app/backend
RUN mvn -B -DskipTests clean package

# ---- Run Stage ----
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

COPY --from=build /app/backend/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
