package org.example.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfiguration {

    @Bean
    public NewTopic testTopic(){
        return TopicBuilder.name("TestTopic").build();
    }

    @Bean
    public NewTopic testJsonTopic(){
        return TopicBuilder.name("TestJsonTopic").build();
    }
}
