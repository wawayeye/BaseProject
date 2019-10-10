package com.tuandai.baseproject.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.tuandai.baseproject.entity.CrawlerEntity;
import com.tuandai.baseproject.service.FilterService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("filterService")
public class FilterServiceImpl implements FilterService{
    @Value("${ip.whiteList}")
    private  String ipAddr;
    @Value("${topic.whiteList}")
    private  String topicAddr;
    @Value("${ip.own.whiteList}")
    private  String ownIpAddr;
    @Value("${topic.own.whiteList}")
    private  String ownTopicAddr;

    @Override
    public boolean getWhiteIp(String ip) {
        if(ipAddr.contains(ip)){
            return true;
        }
        return false;
    }

    @Override
    public boolean getWhiteTopic(String topic) {
        if(topicAddr.contains(topic)){
            return true;
        }
        return false;
    }

    @Override
    public boolean getOwnWhiteIp(String ip) {
        if(ownIpAddr.contains(ip)){
            return true;
        }
        return false;
    }

    @Override
    public boolean getOwnWhiteTopic(String topic) {
        return false;
    }

    @Override
    public boolean userIdFilter(String user_id) {
        if(StringUtils.isEmpty(user_id.trim())){
            return true;
        }
        return false;
    }

    @Override
    public boolean crawlerFilter(CrawlerEntity crawlerEntity) {
        if(StringUtils.isEmpty(crawlerEntity.getOrder_sn())||StringUtils.isEmpty(crawlerEntity.getType())||StringUtils.isEmpty(crawlerEntity.getRecord_version())){
            return true;
        }
        return false;
    }
}
