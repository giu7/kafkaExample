# kafkaExample
Experiment to learn kafka with spring boot

First install latest version of apche kafka from official website https://kafka.apache.org/

CD in kafka folder and run zookeper instance with command
bin/zookeeper-server-start.sh config/zookeeper.properties

Then launch kafka server with
bin/kafka-server-start.sh config/server.properties

Now create the two topics the application needs with the following commands
bin/kafka-topics.sh --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic testTopic
bin/kafka-topics.sh --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic testTopicUser
