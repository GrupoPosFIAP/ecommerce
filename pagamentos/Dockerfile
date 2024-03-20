FROM openjdk:11-jdk-slim

WORKDIR /app

COPY target/pagamento0.0.1-SNAPSHOT.jar /app/app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
