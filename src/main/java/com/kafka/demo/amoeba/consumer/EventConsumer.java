package com.kafka.demo.amoeba.consumer;

import com.kafka.demo.amoeba.InputEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class EventConsumer implements EventConsumerInterface {

    @KafkaListener(topics = "raw-text-topic")
    @Override
    public void listen(InputEvent.RawText rawText) {
        System.out.println("message recieved: {} " + rawText.toString());
    }
}
