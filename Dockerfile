# 1. Build stage
FROM gradle:7.3.0-jdk11 as builder

WORKDIR /app

COPY --chown=gradle:gradle build.gradle settings.gradle ./
COPY --chown=gradle:gradle src ./src
RUN gradle build --no-daemon

# 2. Deployment stage
FROM payara/server-full:5.2022.5-jdk11

COPY --from=builder /app/build/libs/java-kafka-docker-app-1.0-SNAPSHOT.war $DEPLOY_DIR
