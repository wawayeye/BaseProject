package com.tuandai.baseproject.util;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;

public final class KafkaProducerUtils {
    private static KafkaProducer<String, String> kafkaProducer;

    private String topic;

    private int retry;

    private KafkaProducerUtils() {

    }


    /**
     * 静态内部类
     *
     * @author tanjie
     *
     */
    private static class LazyHandler {

        private static final KafkaProducerUtils instance = new KafkaProducerUtils();
    }

    /**
     * 单例模式,kafkaProducer是线程安全的,可以多线程共享一个实例
     *
     * @return
     */
    public static final KafkaProducerUtils getInstance() {
        return LazyHandler.instance;
    }

    /**
     * kafka生产者进行初始化
     *
     * @return KafkaProducer
     */
    public void init(String topic,int retry) {
        this.topic = topic;
        this.retry = retry;
        if (null == kafkaProducer) {
            Properties props = new Properties();
            if (System.getProperties().getProperty("os.name").equals("Windows 10")) {
                System.setProperty("java.security.krb5.conf",
                        Thread.currentThread().getContextClassLoader().getResource("kafka-conf/krb5.conf").getPath());
                System.setProperty("java.security.auth.login.config",
                        Thread.currentThread().getContextClassLoader().getResource("kafka-conf/jaas.conf").getPath());
            } else {
                System.setProperty("java.security.krb5.conf",
                        "/etc/krb5.conf");
                System.setProperty("java.security.auth.login.config",
                        "/opt/keytabs/kafka_jaas.conf");
            }
//        System.out.println("java.security.krb5.conf===========>"+Thread.currentThread().getContextClassLoader().getResource("kafka-conf/krb5.conf").getPath());

//        System.out.println("java.security.auth.login.config===========>"+Thread.currentThread().getContextClassLoader().getResource("kafka-conf/jaas.conf").getPath());
            //初始化jaas.conf文件

            System.setProperty("javax.security.auth.useSubjectCredsOnly", "false");
            System.setProperty("sun.security.krb5.debug", "true");
            // 设置kafka的ip和端口
            props.put("acks", "all");
            props.put("bootstrap.servers", "node51:9092,node52:9092");
//            props.put("bootstrap.servers", "kafka1-172-18-12-101:9092,kafka2-172-18-12-102:9092,kafka3-172-18-12-103:9092");
            props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
            props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
            props.put("security.protocol", "SASL_PLAINTEXT");
            props.put("sasl.mechanism", "GSSAPI");
            props.put("sasl.kerberos.service.name", "kafka");
            kafkaProducer = new KafkaProducer<String, String>(props);
        }
    }

    /**
     * 通过kafkaProducer发送消息
     *
     */
    public void sendKafkaMessage(final String message,final String key) {
        /**
         * 1、如果指定了某个分区,会只讲消息发到这个分区上 2、如果同时指定了某个分区和key,则也会将消息发送到指定分区上,key不起作用
         * 3、如果没有指定分区和key,那么将会随机发送到topic的分区中 4、如果指定了key,那么将会以hash<key>的方式发送到分区中
         */
        ProducerRecord<String, String> record = new ProducerRecord<String, String>(
                topic, key, message);
        // send方法是异步的,添加消息到缓存区等待发送,并立即返回，这使生产者通过批量发送消息来提高效率
        // kafka生产者是线程安全的,可以单实例发送消息
        kafkaProducer.send(record, new Callback() {
            public void onCompletion(RecordMetadata recordMetadata,
                                     Exception exception) {
                if (null != exception) {
                    System.err.println("kafka发送消息失败");
                    retryKakfaMessage(message,key);
                }
                System.out.println("已存key=========>" + key);
            }
        });
    }

    /**
     * 当kafka消息发送失败后,重试
     *
     * @param retryMessage
     */
    private void retryKakfaMessage(final String retryMessage,final String key) {
        ProducerRecord<String, String> record = new ProducerRecord<String, String>(
                topic, key, retryMessage);
        for (int i = 1; i <= retry; i++) {
            try {
                kafkaProducer.send(record);
                return;
            } catch (Exception e) {
                System.err.println("kafka发送消息失败:" + e.getMessage());
                retryKakfaMessage(retryMessage,key);
            }
        }
    }

    /**
     * kafka实例销毁
     */
    public void close() {
        if (null != kafkaProducer) {
            kafkaProducer.close();
        }
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public int getRetry() {
        return retry;
    }

    public void setRetry(int retry) {
        this.retry = retry;
    }
}
