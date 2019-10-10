package com.tuandai.baseproject.service;

import com.tuandai.baseproject.entity.HbaseDataEntity;

import java.util.HashMap;


public interface HbaseFindDataService {
    public HashMap findByRowkeyLike(HbaseDataEntity hbaseDataEntity);

}
