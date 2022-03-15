FROM openjdk:17
VOLUME /tmp
EXPOSE 8080
ADD target/annuaire-0.0.1-SNAPSHOT.jar annuaire-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/annuaire-0.0.1-SNAPSHOT.jar"]