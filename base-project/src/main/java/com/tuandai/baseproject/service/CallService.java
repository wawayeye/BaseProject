package com.tuandai.baseproject.service;

import com.google.gson.JsonObject;
import com.tuandai.baseproject.entity.CallEntiry;
import net.sf.json.JSONObject;

import java.io.IOException;

public interface CallService {
    public JsonObject getContactInfo(CallEntiry callEntiry) throws IOException;

    public JsonObject getContactRecord(CallEntiry callEntiry) throws IOException;

    public JSONObject getContactInfoBykudu(CallEntiry callEntiry) throws Exception;

    public JSONObject getContactRecordBykudu(CallEntiry callEntiry) throws Exception;
}
