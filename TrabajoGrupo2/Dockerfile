FROM openjdk:21
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=TrabajoGrupo2/target/TrabajoGrupo2-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} TrabajoGrupo2.jar

ENTRYPOINT ["java", "-jar", "/TrabajoGrupo2.jar"]