package com.giu7.kafkaproducerexample.controller;

import com.giu7.kafkaproducerexample.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("kafka")
public class UserController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplateString;

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplateUser;

    private static final String TOPIC = "testTopic";
    private static final String TOPIC_JSON = "testTopicUser";


    @GetMapping("string/{message}")
    public String publishString (@PathVariable("message") String message){

        kafkaTemplateString.send(TOPIC, message);
        return "Published message as String " + message;
    }

    @GetMapping("user/{message}")
    public String publishUser (@PathVariable("message") String message){
        String[] split = message.split("-");
        String name = split[0];
        String surname = split[1];
        int age = Integer.parseInt(split[2]);

        User user = new User(name, surname, age);

        kafkaTemplateUser.send(TOPIC_JSON, user);
        return "Published message as JSON " + message;
    }
}
