package com.tuandai.baseproject.control;

import com.tuandai.baseproject.common.Common;
import com.tuandai.baseproject.common.ResultJson;
import com.tuandai.baseproject.entity.CreditEntity;
import com.tuandai.baseproject.entity.CreditResponEntity;
import com.tuandai.baseproject.entity.KafkaMessageEntity;
import com.tuandai.baseproject.service.KafkaSendMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.tuandai.baseproject.enums.TopicEnum.NIWOJINRONG_CREDIT_TOPIC;

@RestController
@RequestMapping("/credit")
public class CreditControl {
    @Autowired
    private KafkaSendMessageService kafkaSendMessageService;
    @Autowired
    private KafkaMessageEntity kafkaMesEntity;

    /**
     * 接收风控模型 返回结果
     *
     * @param creditResponEntity
     * @return
     */
    @PostMapping("/sendCreditRespones")
    public String sendCreditRespon(@RequestBody CreditResponEntity creditResponEntity) {
        System.out.println(creditResponEntity.toString());
        //TODO 史晓对接接口
        return new ResultJson(true, Common.SUCCESS_CODE, Common.SUCCESS_MESSAGE).toString();
    }

    /**
     * 接收你我金融 爬虫数据
     *
     * @param creditEntity
     * @return
     */
    @PostMapping("/sendCreditMes")
    public String sendCredit(@RequestBody CreditEntity creditEntity) {
        kafkaMesEntity.setTopic(NIWOJINRONG_CREDIT_TOPIC.getTopic());
        kafkaMesEntity.setMessage(creditEntity.getReport_json());
        kafkaMesEntity.setKey(creditEntity.getRequest_no());
        kafkaSendMessageService.sendMessage(kafkaMesEntity);
        return new ResultJson(true, Common.SUCCESS_CODE, Common.SUCCESS_MESSAGE).toString();
    }


}