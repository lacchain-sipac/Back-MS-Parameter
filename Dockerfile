################### Stage 2: A minimal docker image with command to run the app 
FROM openjdk:8-jre-alpine
ENV APP_FILE ms-parameter-1.0.0.jar

ENV APP_HOME /usr/apps

ENV APP_SOURCE ms-parameter/target

ARG JAR_FILE=target/ms-parameter-1.0.0.jar
COPY $JAR_FILE $APP_HOME/
WORKDIR $APP_HOME
ENTRYPOINT ["sh", "-c"]
EXPOSE 8083
CMD ["exec java -Djava.security.egd=file:/dev/./urandom -jar $APP_FILE"]

# docker build  -t us.gcr.io/hondu-pf/ms-parameter:1.0.9 -f Dockerfile .
# gcloud docker -- push us.gcr.io/hondu-pf/ms-parameter:1.0.9
