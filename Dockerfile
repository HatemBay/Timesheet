FROM openjdk:8-jdk-alpine
EXPOSE 8083
ADD target/Timesheet-0.0.3.jar Timesheet-0.0.3.jar
ENTRYPOINT ["java","-jar","/Timesheet-0.0.3.jar"]
