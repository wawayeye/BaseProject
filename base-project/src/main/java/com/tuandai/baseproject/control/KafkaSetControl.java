package com.tuandai.baseproject.control;


import com.cxytiandi.encrypt.anno.Decrypt;
import com.tuandai.baseproject.entity.KafkaMessageEntity;
import com.tuandai.baseproject.service.FilterService;
import com.tuandai.baseproject.service.KafkaSendMessageService;
import com.tuandai.baseproject.util.RequestCommon;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/kafka")
public class KafkaSetControl {
    @Autowired
    private KafkaSendMessageService kafkaSendMessageService;
    @Autowired
    private FilterService filterService;


    @PostMapping("/sendMessage")
    public HashMap sendData(@RequestBody KafkaMessageEntity kafkaMessageEntity,HttpServletRequest request) {
        HashMap<String, String> retMap = new HashMap<String, String>();
        String ip = RequestCommon.getRealIpAddress(request);
        if(!filterService.getOwnWhiteIp(ip)){
            retMap.put("ret","fail");
            retMap.put("message","当前ip不在内部白名单内");
            return retMap;
        }
        kafkaSendMessageService.sendMessage(kafkaMessageEntity);
        retMap.put("ret","success");
        retMap.put("message","发送成功");
        return retMap;
    }
    @Decrypt
    @PostMapping("/sendThirdData")
    public HashMap findData(@RequestBody KafkaMessageEntity kafkaMessageEntity,HttpServletRequest request) {
        HashMap<String, String> retMap = new HashMap<String, String>();
        String ip = RequestCommon.getRealIpAddress(request);
        if(!filterService.getWhiteIp(ip)||!filterService.getWhiteTopic(kafkaMessageEntity.getTopic())){
            retMap.put("ret","fail");
            retMap.put("message","当前ip不在白名单内 或者 当前topic不存在");
            return retMap;
        }
        kafkaSendMessageService.sendMessage(kafkaMessageEntity);
        retMap.put("ret","success");
        retMap.put("message","发送成功");
        return retMap;
    }

    @GetMapping("/sendMessageByget")
    public String findDataByget(String topic,String message) {
        KafkaMessageEntity kafkaMessageEntity = new KafkaMessageEntity();
        kafkaMessageEntity.setTopic(topic);
        kafkaMessageEntity.setMessage(message);
        System.out.println(kafkaMessageEntity.toString());
        kafkaSendMessageService.sendMessage(kafkaMessageEntity);

        return "success";
    }
}