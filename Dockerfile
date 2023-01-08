FROM amazoncorretto:19-alpine-jdk
MAINTAINER emaaristimuno
COPY target/jal-0.0.1-SNAPSHOT.jar jal-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/jal-0.0.1-SNAPSHOT.jar"]