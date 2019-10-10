package com.tuandai.baseproject.entity;

import org.springframework.stereotype.Component;

@Component
public class KafkaMessageEntity {
    private String message;
    private String kerberosName;
    private String topic;
    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getKerberosName() {
        return kerberosName;
    }

    public void setKerberosName(String kerberosName) {
        this.kerberosName = kerberosName;
    }

    @Override
    public String toString() {
        return "KafkaMessageEntity{" +
                "message='" + message + '\'' +
                ", kerberosName='" + kerberosName + '\'' +
                ", topic='" + topic + '\'' +
                '}';
    }
}
