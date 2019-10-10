package com.tuandai.baseproject.service.impl;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.tuandai.baseproject.entity.CallEntiry;
import com.tuandai.baseproject.model.AddressBookDetail;
import com.tuandai.baseproject.model.AddressBookStat;
import com.tuandai.baseproject.model.CallRecordDetail;
import com.tuandai.baseproject.model.CallRecordStat;
import com.tuandai.baseproject.service.CallService;
import com.tuandai.baseproject.util.DateUtils;
import com.tuandai.baseproject.util.HBaseUtils;
import com.tuandai.baseproject.util.HbaseCommonUtils;
import com.tuandai.baseproject.util.ImpalaUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service("callService")
public class CallServiceImpl implements CallService {

    static String familyName = "info";
    static String table_contacter_total_info = "contacter_total_info";
    static String table_contact_total_info = "contact_total_info";

    @Override
    public JsonObject getContactInfo(CallEntiry callEntiry) throws IOException {
        JsonObject jsonObject =new JsonObject();
        JsonArray jsonArray = new JsonArray();
        JsonObject userinfo_json =new JsonObject();
        List<Result> list = HBaseUtils.getRowsByColumns(table_contacter_total_info, callEntiry.getUserId()+"_user", familyName,new String[]{"sum","abnormal_sum","call_sum","updateTime","device"});
        userinfo_json = HbaseCommonUtils.splitList(userinfo_json,list);
        jsonObject.add("user_info",userinfo_json);
        list = HBaseUtils.getRowsByColumns(table_contacter_total_info, callEntiry.getUserId()+"_contacter", familyName,new String[]{"sensitivity","contactIn6months","name","is_emg","is_valid","phone"});
        for (Result rs : list) {
            JsonObject contacter_info_json =new JsonObject();
            for (Cell cell : rs.listCells()) {
                contacter_info_json.addProperty(Bytes.toString(CellUtil.cloneQualifier(cell)),Bytes.toString(CellUtil.cloneValue(cell)));
            }
            jsonArray.add(contacter_info_json);
        }
        jsonObject.add("contacter_info",jsonArray);
        jsonObject.addProperty("ret","success");
        return jsonObject;
    }

    @Override
    public JsonObject getContactRecord(CallEntiry callEntiry) throws IOException {
        JsonObject jsonObject =new JsonObject();
        JsonArray jsonArray = new JsonArray();
        JsonObject user_contact_json =new JsonObject();
        String userid_phone = callEntiry.getUserId()+"_"+callEntiry.getPhone();
        List<Result> list = HBaseUtils.getRowsByColumns(table_contact_total_info,  callEntiry.getUserId()+"_user_"+callEntiry.getPhone(), familyName,new String[]{"open_time","double_call","name","idcard","mobile","vaild_phone_sum","vaild_call_sum"});
        user_contact_json = HbaseCommonUtils.splitContactTotalInfo(user_contact_json,list);
        jsonObject.add("user_contact_info",user_contact_json);

        list = HBaseUtils.getRowsByColumns(table_contact_total_info, callEntiry.getUserId()+"_contacter_"+callEntiry.getPhone(), familyName,new String[]{"call_location","total_call","dial","dialed","total_time","first_time","last_time","name"});
        for (Result rs : list) {
            JsonObject contact_record_json =new JsonObject();
            String userid_phone_name = new String(rs.getRow());
            String[] value_arr = userid_phone_name.split("_");
//            if(!value_arr[2].equals(callEntiry.getPhone())){
//                continue;
//            }
            contact_record_json.addProperty("phone",value_arr[3]);
            contact_record_json.addProperty("name","");
            for (Cell cell : rs.listCells()) {
                if("total_call".equals(Bytes.toString(CellUtil.cloneQualifier(cell)))){
                    contact_record_json.addProperty("totail_call",Bytes.toString(CellUtil.cloneValue(cell)));
                }else if("total_time".equals(Bytes.toString(CellUtil.cloneQualifier(cell)))){
                    contact_record_json.addProperty("totail_time",Bytes.toString(CellUtil.cloneValue(cell)));
                }else{
                    contact_record_json.addProperty(Bytes.toString(CellUtil.cloneQualifier(cell)),Bytes.toString(CellUtil.cloneValue(cell)));
                }
            }
            jsonArray.add(contact_record_json);
        }
        jsonObject.add("contact_record_info",jsonArray);
        jsonObject.addProperty("ret","success");
        return jsonObject;
    }

    @Override
    public JSONObject getContactInfoBykudu(CallEntiry callEntiry) throws Exception {
        JSONObject jsonObject =new JSONObject();
        JSONArray jsonArray = new JSONArray();
        JSONObject userinfo_json = new JSONObject();
        String address_book_stat_sql = "select * from dm_tdloan.address_book_stat where user_id = '"+callEntiry.getUserId()+"'";
        String address_book_detail_sql = "select * from dm_tdloan.address_book_detail where user_id = '"+callEntiry.getUserId()+"'";
        List<AddressBookStat> addressBookStatList = ImpalaUtils.executeQuery(AddressBookStat.class,address_book_stat_sql);
        List<AddressBookDetail> addressBookDetailList = ImpalaUtils.executeQuery(AddressBookDetail.class,address_book_detail_sql);
        for(AddressBookStat a :addressBookStatList){
            a.setUpdateTime(DateUtils.getDateString(a.getUpdatetime()));
            userinfo_json = JSONObject.fromObject(a);
        }

        jsonObject.put("user_info",userinfo_json);
        for(AddressBookDetail a : addressBookDetailList){
            a.setContactIn6months(a.getContactin6months());
            jsonArray.add(JSONObject.fromObject(a));
        }
        jsonObject.put("contacter_info",jsonArray);
        jsonObject.put("ret","success");
        return jsonObject;
    }

    @Override
    public JSONObject getContactRecordBykudu(CallEntiry callEntiry) throws Exception {
        JSONObject jsonObject =new JSONObject();
        JSONArray jsonArray = new JSONArray();
        JSONObject userinfo_json = new JSONObject();
        String call_record_stat_sql = "select * from dm_tdloan.call_record_stat where user_id = '"+callEntiry.getUserId()+"'";
//        String call_record_detail_sql = "select a.*,b.name from dw_ods.call_record_detail a left join dw_ods.address_book_detail b on a.user_id = b.user_id and a.phone =b.phone where a.user_id = '"+callEntiry.getUserId()+"'";
        String call_record_detail_sql = "select * from dm_tdloan.call_record_detail  where user_id = '"+callEntiry.getUserId()+"'";
        List<CallRecordStat> callRecordStatList = ImpalaUtils.executeQuery(CallRecordStat.class,call_record_stat_sql);
        List<CallRecordDetail> callRecordDetailList = ImpalaUtils.executeQuery(CallRecordDetail.class,call_record_detail_sql);
        for(CallRecordStat c :callRecordStatList){
            c.setVaild_call_sum(c.getValid_call_sum());
            c.setVaild_phone_sum(c.getValid_phone_sum());
            c.setOpen_time(DateUtils.getDateString(c.getOpen_time()));
            userinfo_json = JSONObject.fromObject(c);
        }
        jsonObject.put("user_contact_info",userinfo_json);
        for(CallRecordDetail a : callRecordDetailList){
            a.setFirst_time(DateUtils.getDateString(a.getFirst_time()));
            a.setLast_time(DateUtils.getDateString(a.getLast_time()));
            a.setTotail_time(DateUtils.getM2Date(a.getTotail_time()));
            jsonArray.add(JSONObject.fromObject(a));
        }
        jsonObject.put("contact_record_info",jsonArray);
        jsonObject.put("ret","success");
        return jsonObject;

    }
}
