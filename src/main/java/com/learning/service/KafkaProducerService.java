package com.learning.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public class KafkaProducerService {
    private final Logger logger = LoggerFactory.getLogger(KafkaProducerService.class);
    private static final String TOPIC_NAME = "test-topic";

    final KafkaTemplate<String, String> template;

    @Autowired
    KafkaProducerService(KafkaTemplate<String, String> template) {
        this.template = template;
    }

    public void sendMessage(String message) {
        logger.info(String.format("Publishing to Kafka topic -> %s", message));
        ListenableFuture<SendResult<String, String>> future = this.template.send(TOPIC_NAME, message);

        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(Throwable throwable) {
                logger.error(String.format("Failed to send message to topic -> %s", throwable.getCause()));
            }

            @Override
            public void onSuccess(SendResult<String, String> stringStringSendResult) {
                logger.info("Sent to Kafka topic");
            }
        });
    }
}
