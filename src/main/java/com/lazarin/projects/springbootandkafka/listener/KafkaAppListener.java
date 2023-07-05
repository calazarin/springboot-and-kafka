package com.lazarin.projects.springbootandkafka.listener;

import com.lazarin.projects.springbootandkafka.model.Account;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaAppListener {

    @KafkaListener(topics = "transaction-topic")
    public void listener(@Payload Account account, ConsumerRecord<String, Account> consumerRecord) {
        log.info("Topic [transaction-topic] received message from {} with {} as fund ", account.getHolder(), account.getFunds());
        log.info("Consumed message is {}", consumerRecord.value());
    }
}
