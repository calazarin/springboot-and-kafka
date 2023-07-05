# SpringBoot & Kafka Demo Project

Sample SpringBoot app created using Docker and Kafka
What does it do?
1. This app has an endpoint to publish an `account` message to a Kafka topic
2. Then, once published, we have a listener configured to consume those messages and log them.

### Docker compose config

1. `KAFKA_ADVERTISED_HOST_NAME` - IP of the docker host
2. `KAFKA_ZOOKEEPER_CONNECT` - port number zookeeper cluster is monitoring
3. `KAFKA_AUTO_CREATE_TOPICS_ENABLE` - disable kafka topics auto generation

### Running this app

1. Start docker containers: in the command line, go to project root folder and type `docker-compose up`
2. If you want to double-check if your containers are running fine (for unix use grep): 
   1. `docker-compose logs zookeeper | findstr -i started`
   2. `docker-compose logs kafka | findstr -i started`
3. Type `.\gradlew build` to build the app
4. Now type `.\gradlew bootRun` to run the app
5. If you want, Kafka cluster manager is available at `http://localhost:9000/`

### Sample request used to POST a new account message

```
curl -X POST http://localhost:8081/api/kafka/messages -H "Content-Type: application/json" -d "{ \"holder\": \"Holder Name\", \"funds\": \"3500\"}" 
```