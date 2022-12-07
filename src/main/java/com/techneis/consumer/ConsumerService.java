package com.techneis.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerService.class);

    @KafkaListener(topics = "techneis-str-topic", groupId = "techneis")
    public void consume(String message) {
        LOGGER.info(String.format("Message Received: ", message));
    }
}
