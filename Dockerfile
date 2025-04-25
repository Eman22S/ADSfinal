# ---------- Stage 1: Build & Test ----------
FROM gradle:8.4-jdk21 AS builder

WORKDIR /app

# Copy only Gradle files first for better caching
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .

# Pre-download dependencies (cached if nothing changes)
RUN gradle build --no-daemon -x test || return 0

# Now copy everything else
COPY . .

# Run tests and full build
RUN gradle build --no-daemon

# ---------- Stage 2: Runtime ----------
FROM openjdk:23

WORKDIR /app

# Copy only the final jar
COPY --from=builder /app/build/libs/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
