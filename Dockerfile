FROM openjdk

WORKDIR /app

COPY target/sistema-financeiro-0.0.1-SNAPSHOT.jar /app/sistema-financeiro.jar

ENTRYPOINT [ "java","-jar","sistema-financeiro.jar" ]
EXPOSE 8080