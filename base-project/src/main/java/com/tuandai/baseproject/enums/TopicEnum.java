package com.tuandai.baseproject.enums;

public enum TopicEnum {
    NIWOJINRONG_CREDIT_TOPIC("niwo_credit", "你我金融 爬虫topic",11);

    private final String topic;
    private final String desc;
    private final int channel_no;

    public String getTopic() {
        return topic;
    }
    public String getDesc() {
        return desc;
    }
    public int getChannel_no() {
        return channel_no;
    }


    TopicEnum(String topic, String desc, int channel_no) {
        this.topic = topic;
        this.desc = desc;
        this.channel_no = channel_no;
    }
}
