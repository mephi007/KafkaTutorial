package org.example.controller;

import org.example.kafka.JsonProducer;
import org.example.payload.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonController {

    private JsonProducer producer;

    public JsonController(JsonProducer producer){
        this.producer = producer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User user){
        producer.sendMessage(user);
        return ResponseEntity.ok("Message sent to kafka topic");
    }
}
