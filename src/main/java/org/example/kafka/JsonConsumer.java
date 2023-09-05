package org.example.kafka;

import org.example.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonConsumer {

    private static final Logger logger = LoggerFactory.getLogger(JsonConsumer.class);


    @KafkaListener(topics = "TestJsonTopic", groupId = "group-id")
    public void consumer(User user){
        logger.info(String.format("json msg received -> %s ", user.toString()));

    }
}
