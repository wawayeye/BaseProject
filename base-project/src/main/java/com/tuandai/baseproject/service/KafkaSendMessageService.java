package com.tuandai.baseproject.service;

import com.tuandai.baseproject.entity.KafkaMessageEntity;

public interface KafkaSendMessageService {
    public void sendMessage(KafkaMessageEntity kafkaMessageEntity);
}
