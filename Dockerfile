FROM adoptopenjdk/openjdk8
ARG JAR_FILE=target/Inventory-*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080