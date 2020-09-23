package com.kafka.demo.amoeba.consumer;

import com.kafka.demo.amoeba.InputEvent;

public interface EventConsumerInterface {

    void listen(InputEvent.RawText rawText);

}
