# Java web app links Kafka platform in Docker containers

## Prerequisite
- Docker Engine
- JDK 11

## How to start
```sh
docker-compose up -d
```

When Successfully start, call below and then you can see index page.
```
http://localhost:8082/java-kafka-docker/
```

After checking, access resource like below.
http://localhost:8082/java-kafka-docker/resouces/kafka?param1=TEST

you can see the parameter you request on your console like this.
"TEST : this is the record from producer client"

## Links
[Kafka Docker Network](https://www.confluent.io/blog/kafka-listeners-explained/)
- kafka listener
- advertised listener
- HOST IP Protocol

[Kafka Docker Compose](https://github.com/conduktor/kafka-stack-docker-compose/blob/master/full-stack.yml)
- can see yml for kafka stack
- zookeeper, broker, schema-registry

[How to start Kafka using Docker](https://www.conduktor.io/kafka/how-to-start-kafka-using-docker/)<br>
[How to implements kafka producer with Java](https://www.conduktor.io/kafka/complete-kafka-producer-with-java/)<br>
[Official Kafka Document](https://kafka.apache.org/intro)