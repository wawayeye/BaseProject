package com.tuandai.baseproject.service;

import com.tuandai.baseproject.common.ResultJson;
import com.tuandai.baseproject.entity.CrawlerEntity;

public interface CrawlerService {
    ResultJson getCrawlerInfo(CrawlerEntity crawlerEntity) throws Exception;

}
