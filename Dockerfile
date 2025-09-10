# -------- Build stage --------
FROM maven:3.9.8-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn -q -e -DskipTests dependency:go-offline
COPY src ./src
RUN mvn -q -DskipTests package

# -------- Run stage --------
FROM eclipse-temurin:17-jre 
WORKDIR /app
ENV JAVA_OPTS="-Xms256m -Xmx512m"
# Your app listens on 9009
EXPOSE 9009
# copy jar built in previous stage
COPY --from=build /app/target/*.jar app.jar

ENTRYPOINT ["sh","-c","java $JAVA_OPTS -jar app.jar"]
