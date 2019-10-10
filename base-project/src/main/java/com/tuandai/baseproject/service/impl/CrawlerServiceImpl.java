package com.tuandai.baseproject.service.impl;

import com.tuandai.baseproject.common.Common;
import com.tuandai.baseproject.common.ResultJson;
import com.tuandai.baseproject.entity.CrawlerEntity;
import com.tuandai.baseproject.enums.SqlsEnum;
import com.tuandai.baseproject.model.CrawlerModel;
import com.tuandai.baseproject.service.CrawlerService;
import com.tuandai.baseproject.util.BuildSqlUtils;
import com.tuandai.baseproject.util.ImpalaUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("crawlerService")
public class CrawlerServiceImpl implements CrawlerService{
    @Override
    public ResultJson getCrawlerInfo(CrawlerEntity crawlerEntity) throws Exception {
        ResultJson res = new ResultJson(true,Common.SUCCESS_CODE,Common.SUCCESS_MESSAGE);
        JSONArray jsonArray = new JSONArray();
        String sql =  BuildSqlUtils.SqlsEnumBuild(SqlsEnum.FindApplyAduitDataLogSql.getSql(),crawlerEntity);
        List<CrawlerModel> crawlerModels = ImpalaUtils.executeQuery(CrawlerModel.class,sql);
        for (CrawlerModel c :crawlerModels){
            jsonArray.add(JSONObject.fromObject(c));
            res.setResult(jsonArray);
        }
        return res;
    }

}
