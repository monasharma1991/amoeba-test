package com.kafka.demo.amoeba.domain;

import com.google.protobuf.InvalidProtocolBufferException;
import com.kafka.demo.amoeba.InputEvent;
import org.apache.kafka.common.serialization.Deserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RawTextDeserializer extends Adapter implements Deserializer<InputEvent.RawText> {

    private static final Logger logger = LoggerFactory.getLogger(RawTextDeserializer.class);

    @Override
    public InputEvent.RawText deserialize(final String topic, byte[] data) {
        try {
            return InputEvent.RawText.parseFrom(data);
        } catch (InvalidProtocolBufferException e) {
            logger.error("Received un-parse message exception and skip.");
            return null;
            // throw new RuntimeException("Received un-parse message " + e.getMessage(), e);
        }
    }
}
