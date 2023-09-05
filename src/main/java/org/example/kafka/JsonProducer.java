package org.example.kafka;

import org.example.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonProducer {

    private static final Logger logger = LoggerFactory.getLogger(JsonProducer.class);

    private KafkaTemplate<String, User> template;

    public JsonProducer(KafkaTemplate<String,User> temp){
        this.template = temp;
    }

    public void sendMessage(User data){
        Message<User> msg = MessageBuilder.withPayload(data).setHeader(KafkaHeaders.TOPIC, "TestJsonTopic").build();
        template.send(msg);
        logger.info(String.format(" Message sent -> %s", data.toString()));
    }

}
