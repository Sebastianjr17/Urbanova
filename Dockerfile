FROM openjdk:17
COPY "./target/Transpiedecuesta-1.jar" "app.jar"
EXPOSE 8023
ENTRYPOINT ["java", "-jar", "app.jar"]