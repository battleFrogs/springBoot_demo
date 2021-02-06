package com.gjc.kafka_demo.produce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class ProduceInfo {


    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void test(String msg) {
        kafkaTemplate.send("demo", msg);
    }


}
