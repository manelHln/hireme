FROM eclipse-temurin:17-jdk-jammy

WORKDIR /usr/app/backend

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:resolve

COPY src ./src

EXPOSE 8081

CMD ["./mvnw", "spring-boot:run"]