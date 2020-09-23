package com.kafka.demo.amoeba.domain;

import java.util.Map;

public abstract class Adapter {
    public void close() {}
    public void configure(Map<String, ?> configs, boolean isKey) {}
}
