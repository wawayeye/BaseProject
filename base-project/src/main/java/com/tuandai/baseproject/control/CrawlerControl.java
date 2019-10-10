package com.tuandai.baseproject.control;

import com.tuandai.baseproject.common.Common;
import com.tuandai.baseproject.common.ResultJson;
import com.tuandai.baseproject.entity.CrawlerEntity;
import com.tuandai.baseproject.service.CrawlerService;
import com.tuandai.baseproject.service.FilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 深圳技术中心爬虫数据接口
 */
@RestController
@RequestMapping("/crawler")
public class CrawlerControl {

    @Autowired
    private CrawlerService crawlerService;
    @Autowired
    private FilterService filterService;

    @PostMapping("/findCrawler")
    public String findData(@RequestBody CrawlerEntity crawlerEntity) throws Exception {
        if(filterService.crawlerFilter(crawlerEntity)){
            return new ResultJson(true, Common.NO_ORDER_TYPE_VERSION_CODE,Common.NO_ORDER_TYPE_VERSION_MESSAGE).toString();
        }
        return crawlerService.getCrawlerInfo(crawlerEntity).toString();
    }

}