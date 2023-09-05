package org.example.controller;

import org.example.kafka.Producer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    private Producer kp;

    public MessageController(Producer kp){
        this.kp = kp;
    }

    @GetMapping("/")
    public ResponseEntity<String> home(){
//        kp.sendMessage(msg);
        return ResponseEntity.ok("welcome home");
    }

    @GetMapping("api/v1/kafka/publish")
    public ResponseEntity<String> publish(@RequestParam("Message") String msg){
        kp.sendMessage(msg);
        return ResponseEntity.ok("ok msg sent");
    }
}
