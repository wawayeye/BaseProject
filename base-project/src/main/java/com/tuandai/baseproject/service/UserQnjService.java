package com.tuandai.baseproject.service;


import net.sf.json.JSONObject;

public interface UserQnjService {

    /**
     * 解析qnj 二推数据
     * @param record
     * @return
     */
    void handleUserAdditionalInfo(JSONObject record);



}
