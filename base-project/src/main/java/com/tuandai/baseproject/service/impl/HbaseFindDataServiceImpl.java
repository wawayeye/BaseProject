package com.tuandai.baseproject.service.impl;


import com.tuandai.baseproject.entity.HbaseDataEntity;
import com.tuandai.baseproject.service.HbaseFindDataService;
import com.tuandai.baseproject.util.HBaseUtils;
import com.tuandai.baseproject.util.HbaseCommonUtils;
import org.apache.hadoop.hbase.client.Result;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service("hbaseFindDataService")
public class HbaseFindDataServiceImpl implements HbaseFindDataService {
    protected static Logger logger = Logger.getLogger(HbaseFindDataServiceImpl.class);

    @Override
    public HashMap findByRowkeyLike(HbaseDataEntity hbaseDataEntity) {
        HashMap<String, String> hbaseMap = new HashMap<String, String>();
        String tableName = hbaseDataEntity.getTableName();
        String rowKeyLike = hbaseDataEntity.getRowKeyLike();
        String familyName = hbaseDataEntity.getFamilyName();
        List<Result> list = HBaseUtils.getRowsByColumns(tableName, rowKeyLike, familyName, hbaseDataEntity.getColumeName());
        hbaseMap = HbaseCommonUtils.splitList(hbaseMap,list);
        hbaseMap.put("ret","success");
        return hbaseMap;
    }
}
