package com.tuandai.baseproject.control;


import com.tuandai.baseproject.entity.HbaseDataEntity;
import com.tuandai.baseproject.service.HbaseFindDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/hbase")
public class HbaseControl {

    @Autowired
    private HbaseFindDataService hbaseMysqlResultService;

    @PostMapping("/findByColumeName")
    public HashMap findData(@RequestBody HbaseDataEntity hbaseDataEntity) {
        System.out.println(hbaseDataEntity.toString());
        HashMap<String, String> hbaseMap = new HashMap<String, String>();
        if(hbaseDataEntity.getRowKeyLike().equals("")){
            hbaseMap.put("ret","fail");
            hbaseMap.put("message","rowkey 不能为空");
            return hbaseMap;
        }
        hbaseMap = hbaseMysqlResultService.findByRowkeyLike(hbaseDataEntity);
        return  hbaseMap;
    }
}