package com.tuandai.baseproject.util;

import com.google.gson.JsonObject;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;

import java.util.HashMap;
import java.util.List;

public class HbaseCommonUtils {
    public static HashMap splitList(HashMap map,List<Result> list){
        for (Result rs : list) {
            String rowkey = new String(rs.getRow());
            map.put("rowkey",rowkey);
            for (Cell cell : rs.listCells()) {
                map.put(Bytes.toString(CellUtil.cloneQualifier(cell)), Bytes.toString(CellUtil.cloneValue(cell)));
            }
        }
        return map;
    }

    public static JsonObject splitList(JsonObject jsonObject, List<Result> list){
        for (Result rs : list) {
            String rowkey = new String(rs.getRow());
            jsonObject.addProperty("rowkey",rowkey);
            for (Cell cell : rs.listCells()) {
//                map.put(Bytes.toString(CellUtil.cloneQualifier(cell)), Bytes.toString(CellUtil.cloneValue(cell)));
                jsonObject.addProperty(Bytes.toString(CellUtil.cloneQualifier(cell)), Bytes.toString(CellUtil.cloneValue(cell)));
            }
        }
        return jsonObject;
    }

    public static JsonObject splitContactTotalInfo(JsonObject jsonObject, List<Result> list){
        for (Result rs : list) {
            String rowkey = new String(rs.getRow());
            jsonObject.addProperty("rowkey",rowkey);
            for (Cell cell : rs.listCells()) {
                if("mobile".equals(Bytes.toString(CellUtil.cloneQualifier(cell)))){
                    jsonObject.addProperty("phone", Bytes.toString(CellUtil.cloneValue(cell)));
                } else{
                    jsonObject.addProperty(Bytes.toString(CellUtil.cloneQualifier(cell)), Bytes.toString(CellUtil.cloneValue(cell)));
                }

            }
        }
        return jsonObject;
    }
}
