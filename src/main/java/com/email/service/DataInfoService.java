package com.email.service;

import com.email.common.bean.DataVo;
import com.email.common.inject.annotation.BaseComponent;
import com.email.common.service.BaseService;
import com.email.common.util.PageUtil;
import com.email.entity.DataInfo;
import com.email.repository.DataInfoRepository;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/18.
 */
@Service
public class DataInfoService extends BaseService<DataInfo, Integer> {
    @Autowired
    @BaseComponent
    private DataInfoRepository dataInfoRepository;

    public String getData(Pageable pageable){
        Gson gson = new Gson();
        Map<String,Object> jsonResult=new HashMap<String,Object>();
        Page<DataInfo> result=dataInfoRepository.findAll(pageable);
        List<DataInfo> list=new ArrayList<DataInfo>();
        for(DataInfo dataInfo:result){
            list.add(dataInfo);
        }
        DataVo<DataInfo> dataVo=new DataVo<DataInfo>();
        dataVo.setAaData(list);
        dataVo.setiTotalDisplayRecords(result.getTotalElements());
        dataVo.setiTotalRecords(result.getTotalElements());
     //   String json=gson.toJson(dataVo);
        String json= PageUtil.getPage(result);
/*        jsonResult.put("aaData", json);
        jsonResult.put("iTotalRecords", result.getTotalElements());
        jsonResult.put("iTotalDisplayRecords", result.getTotalElements());*/
        return json;
    }
}
