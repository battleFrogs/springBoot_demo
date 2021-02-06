package com.gjc.kafka_demo.consume;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumeInfo {


    @KafkaListener(topics = "demo")
    public void listen(ConsumerRecord<?, ?> record) {

        System.out.printf("topic is %s, offset is %d, value is %s \n", record.topic(), record.offset(), record.value());

    }

}
