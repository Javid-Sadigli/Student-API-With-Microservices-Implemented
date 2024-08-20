FROM openjdk:17-jdk-slim
WORKDIR /app
COPY gradlew /app/gradlew
COPY gradle /app/gradle
COPY build.gradle /app/build.gradle
COPY settings.gradle /app/settings.gradle
COPY src /app/src
RUN chmod +x ./gradlew
RUN ./gradlew build --no-daemon
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/build/libs/your-app.jar"]
