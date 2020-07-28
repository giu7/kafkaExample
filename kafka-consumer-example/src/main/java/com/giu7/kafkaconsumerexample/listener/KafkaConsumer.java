package com.giu7.kafkaconsumerexample.listener;

import com.giu7.kafkaconsumerexample.model.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "testTopic", groupId = "giuGroup", containerFactory = "kafkaListenerContainerFactoryString")
    public void consumeString(String message){
        System.out.println("Consumed string: " + message);
    }

    @KafkaListener(topics = "testTopicUser", groupId = "giuGroupUser", containerFactory = "kafkaListenerContainerFactoryUser")
    public void consumeUser(User user){
        System.out.println("Consumed user: " + user);
    }

}
