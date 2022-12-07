package com.techneis.producer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    public static final Logger LOGGER = LoggerFactory.getLogger(ProducerService.class);

    //It can be Autowired either
    private KafkaTemplate<String, String> kafkaTemplate;

    public ProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(final String message){
        LOGGER.info(String.format("Message sending : %s", message));
        kafkaTemplate.send("techneis-str-topic", message);
        LOGGER.info(String.format("Message Published: %s", message));
    }


}
