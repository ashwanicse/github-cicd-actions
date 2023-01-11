FROM openjdk:11
EXPOSE 8080
ADD target/github-cicd-actions.jar github-cicd-actions.jar
ENTRYPOINT ["java","-jar","/github-cicd-actions.jar"]