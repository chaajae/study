# 1. 빌드 단계
FROM gradle:7.6.1-jdk17 AS builder
WORKDIR /app
COPY . .
RUN gradle bootJar --no-daemon

# 2. 실행 단계
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=builder /app/build/libs/practice-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8085
ENTRYPOINT ["java", "-Dspring.profiles.active=dev", "-jar", "app.jar"]