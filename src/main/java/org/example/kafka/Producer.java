package org.example.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;



@Service
public class Producer {
    private static final Logger logger = LoggerFactory.getLogger(Producer.class);
    private KafkaTemplate<String,String> template;
    private Producer(KafkaTemplate<String, String> temp){
        this.template = temp;
    }
    public void sendMessage(String msg){
        template.send("TestTopic", msg);
        logger.info(String.format("Msg %s", msg));
    }
}

