package com.techneis.config;

import jakarta.transaction.Transaction;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.TopicBuilder;

@EnableKafka
@Configuration
public class KafkaConfiguration {

    @Bean
    public NewTopic createNewTopic(){
        return TopicBuilder.name("techneis-str-topic")
                .build();
    }

}
