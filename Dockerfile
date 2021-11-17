FROM openjdk:8-jdk-alpine
ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS \JAVA_OPTS=""
WORKDIR /app
EXPOSE 8080
ADD target/Timesheet-0.0.3.jar app.jar
CMD ["java", "-jar", "/app/app.jar"]