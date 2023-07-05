package com.lazarin.projects.springbootandkafka;

import com.lazarin.projects.springbootandkafka.model.Account;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@Slf4j
@RequestMapping("/api/kafka")
@RestController
public class KafkaAppController {

    private final KafkaTemplate kafkaTemplate;

    @PostMapping(path="messages", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public String sentMessage(@RequestBody Account account) {
        this.kafkaTemplate.send("transaction-topic", new Account(account.getHolder(), account.getFunds()));
        return "New transaction posted";
    }

}
