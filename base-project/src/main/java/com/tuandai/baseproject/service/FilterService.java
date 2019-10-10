package com.tuandai.baseproject.service;

import com.tuandai.baseproject.entity.CrawlerEntity;

public interface FilterService {

     /**是否在白名单ip*/
     boolean getWhiteIp(String ip);

     /**是否在白名单指定topic*/
     boolean getWhiteTopic(String topic);

     /**是否在内部白名单*/
     boolean getOwnWhiteIp(String ip);

     /**是否在内部白名单指定topic*/
     boolean getOwnWhiteTopic(String topic);

     /** 判断user_id 有传没有，空格，null，len=0*/
     boolean userIdFilter(String user_id);

     /**
      * 判断是否缺字段
      * @param crawlerEntity
      * @return
      */
     boolean crawlerFilter(CrawlerEntity crawlerEntity);
}
