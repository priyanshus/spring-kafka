package com.learning.controller;

import com.learning.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Publisher {
    private KafkaProducerService producerService;

    @Autowired
    Publisher(KafkaProducerService producerService) {
        this.producerService = producerService;
    }

    @GetMapping("/publish")
    void publish(@RequestParam("message") String message) {
        producerService.sendMessage(message);
    }
}
