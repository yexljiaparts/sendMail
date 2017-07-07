package com.email.common.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.email.common.bean.DataVo;
import com.email.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.data.domain.Page;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/2/22.
 */
public  class PageUtil{
/*    private static Gson gson;

    public static Gson getInstance() {
        if (gson == null)
            gson = new Gson();
        return gson;
    }*/

    private static ObjectMapper om = new ObjectMapper();

    private static class GsonHolder{
        private static final Gson INSTANCE = new Gson();
    }

    /**
     * 获取Gson实例，由于Gson是线程安全的，这里共同使用同一个Gson实例
     */
    public static Gson getGsonInstance()
    {
        return GsonHolder.INSTANCE;
    }


    public static <Object> Object deserializeObj(String param, Class<Object> clazz) { // 将json字符串反序列化为相关对象
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Object o = null;
        try {
            o = objectMapper.readValue(param, clazz);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return o;
    }

    public static <W> String getPage(Page<W> p){
       // Gson gson = new Gson();
        Gson gson = getGsonInstance();
        List<W> list=new ArrayList<W>();
        for (W t:p){
            list.add(t);
        }
        DataVo<W> dataVo=new DataVo<W>();
        dataVo.setAaData(list);
        dataVo.setiTotalDisplayRecords(p.getTotalElements());
        dataVo.setiTotalRecords(p.getTotalElements());
        String json=null;
        try {
            json =om.writeValueAsString(dataVo);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }


    public static <W> String getList(List<W> p){
        Gson gson = getGsonInstance();
        List<W> list=new ArrayList<W>();
        for (W t:p){
            list.add(t);
        }
        DataVo<W> dataVo=new DataVo<W>();
        dataVo.setAaData(list);
  /*      dataVo.setiTotalDisplayRecords(p.getTotalElements());
        dataVo.setiTotalRecords(p.getTotalElements());*/
        String json=gson.toJson(dataVo);
        return json;
    }

    public static  String getList2(List<User> p){
//        Gson gson2 = new Gson();
        List<User> list=new ArrayList<User>();
        for (User t:p){
            list.add(t);
        }
        DataVo<User> dataVo=new DataVo<User>();
        dataVo.setAaData(list);
  /*      dataVo.setiTotalDisplayRecords(p.getTotalElements());
        dataVo.setiTotalRecords(p.getTotalElements());*/
        String json=null;
        try {
            json =om.writeValueAsString(dataVo);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }


    public static  String getList3(List<User> p){
        List<User> list=new ArrayList<User>();
     /*   for (W t:p){
            list.add(t);
        }*/
        JSONArray json = new JSONArray();
        for(User w:p){
            JSONObject jo = new JSONObject();
            jo.put("id", w.getId());
            jo.put("password", w.getPassword());
            jo.put("username", w.getUsername());
            json.add(jo);
        }
        String json2=json.toString();
        DataVo<User> dataVo=new DataVo<User>();
        dataVo.setAaData(list);
  /*      dataVo.setiTotalDisplayRecords(p.getTotalElements());
        dataVo.setiTotalRecords(p.getTotalElements());*/
        return dataVo.toString();
    }

}
