package com.learning.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
    private final Logger logger = LoggerFactory.getLogger(KafkaConsumerService.class);

    @KafkaListener(topics = "test-topic", groupId = "test-group")

    void listener(String message) {
        logger.info(String.format("Subscriber received message -> %s", message));
    }
}
