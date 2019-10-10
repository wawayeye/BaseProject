package com.tuandai.baseproject.service.impl;

import com.tuandai.baseproject.entity.KafkaMessageEntity;
import com.tuandai.baseproject.service.KafkaSendMessageService;
import com.tuandai.baseproject.util.KafkaProducerUtils;
import org.springframework.stereotype.Service;

@Service("kafkaSendMessageService")
public class KafkaSendMessageServiceImpl implements KafkaSendMessageService {
    @Override
    public void sendMessage(KafkaMessageEntity kafkaMessageEntity) {
//        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(20);
        //TODO 后面权限不同，会走不同的keytab，default会加一个默认权限
        if(null ==kafkaMessageEntity.getKerberosName()){
            kafkaMessageEntity.setKerberosName("hive.keytab");
        }
        switch (kafkaMessageEntity.getKerberosName()) {
            case "xiaoyong.keytab":
                System.out.println("kerberos_name ====>" + kafkaMessageEntity.getKerberosName());
                break;
            default:
                break;
        }
//        fixedThreadPool.execute(new Runnable() {
//            @Override
//            public void run() {
//                KafkaProducerUtils.sendMessage(kafkaMessageEntity.getMessage(),kafkaMessageEntity.getTopic());
                KafkaProducerUtils kafkaProducerSingleton = KafkaProducerUtils
                        .getInstance();
                kafkaProducerSingleton.init(kafkaMessageEntity.getTopic(),3);
                kafkaProducerSingleton.sendKafkaMessage(kafkaMessageEntity.getMessage(),kafkaMessageEntity.getKey());
            }
//        });
//    }
}
