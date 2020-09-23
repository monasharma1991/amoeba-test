package com.kafka.demo.amoeba.domain;


import com.kafka.demo.amoeba.InputEvent;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Serializer;

public class RawTextSerializer extends Adapter implements Serializer<InputEvent.RawText> {

    @Override
    public byte[] serialize(String topic, InputEvent.RawText data) {
        return data.toByteArray();
    }

    @Override
    public byte[] serialize(String topic, Headers headers, InputEvent.RawText data) {
        return data.toByteArray();
    }
}
