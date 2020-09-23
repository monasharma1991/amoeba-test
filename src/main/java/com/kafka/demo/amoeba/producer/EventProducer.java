package com.kafka.demo.amoeba.producer;

import com.kafka.demo.amoeba.InputEvent;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EventProducer {

    @Autowired
    KafkaTemplate<String, InputEvent.RawText> kafkaTemplate;

    public void sendEvent() {

        log.info("Sending message ......");
        InputEvent.RawText rawText = InputEvent.RawText.newBuilder()
                .setText("this is just for the purpose of testing")
                .setLanguage(InputEvent.RawText.Language.ENGLISH)
                .build();

        InputEvent.Event event_1 = InputEvent.Event.newBuilder()
                .setEventId("1")
                .setEventTopic("raw-text-topic")
                .setRawText(rawText)
                .build();

        //ProducerRecord record = new ProducerRecord(event_1.getEventTopic(), null, event_1.getEventId(), event_1.getRawText());
        kafkaTemplate.send(event_1.getEventTopic(), rawText);
    }

}
