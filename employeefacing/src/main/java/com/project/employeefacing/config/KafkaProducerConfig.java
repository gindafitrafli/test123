package com.project.employeefacing.config;

import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
@EnableKafka
public class KafkaProducerConfig {

    @Value("${broker.uri:localhost}")
    String brokerUri;

    @Bean
    public ProducerFactory producerFactory() {
        DefaultKafkaProducerFactory<String, String> pf = new DefaultKafkaProducerFactory<>(producerConfigs());

//        TransactionIdSuffixStrategy ss = new DefaultTransactionIdSuffixStrategy(5);
//        pf.setTransactionIdSuffixStrategy(ss);
        return pf;
    }

    @Bean
    public Map producerConfigs() {
        Map props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, brokerUri);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, true);
        props.put(ProducerConfig.ACKS_CONFIG, "all");

        //gabutuh min insync replica buat 1 node


        return props;
    }

    @Bean
    public KafkaTemplate kafkaTemplate() {
        return new KafkaTemplate(producerFactory());
    }
}
