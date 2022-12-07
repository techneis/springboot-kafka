package com.techneis.producer.controller;

import com.techneis.config.KafkaConfiguration;
import com.techneis.producer.service.ProducerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/kafka-producer")
public class ProducerController {

    public static final Logger LOGGER = LoggerFactory.getLogger(ProducerController.class);

    private ProducerService service;
    @Autowired
    KafkaConfiguration configuration;

    public ProducerController(ProducerService service) {
        this.service = service;
    }

    @GetMapping("publish")
    public ResponseEntity<String> publish(@RequestParam final String message) {
        LOGGER.info("Sending Message to Kafka Broker");
        service.send(message);
        return ResponseEntity.ok("Message sent.");
    }
}
