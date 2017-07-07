package com.email.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.email.common.bean.DataVo;
import com.email.common.inject.annotation.BaseComponent;
import com.email.common.service.BaseService;
import com.email.common.util.PageUtil;
import com.email.entity.Department;
import com.email.entity.Employees;
import com.email.repository.DepartmentRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2017/2/22.
 */
@Service
public class DepartmentService extends BaseService<Department, Integer> {
    @Autowired
    @BaseComponent
    private DepartmentRepository departmentRepository;
    //获取员工数据
    public String getEmpData(Pageable pageable,Integer id){
if(StringUtils.isEmpty(id)){
    id=1;
}
        Page<Department> page=departmentRepository.findById(id,pageable);
        Gson gson = new Gson();
        List<Department> list=new ArrayList<Department>();
     /*   for(Department dataInfo:page){
            Set<Employees> set=dataInfo.getEmployees();
            Iterator<Employees> it = set.iterator();
            while (it.hasNext()) {
                String str = it.next().getName();
                System.out.println(str);
            }
            list.add(dataInfo);
         //   System.out.println(dataInfo.getEmployees().iterator());
        }*/

        /*DataVo<Department> dataVo=new DataVo<Department>();
        dataVo.setAaData(list);
        dataVo.setiTotalDisplayRecords(page.getTotalElements());
        dataVo.setiTotalRecords(page.getTotalElements());*/
       // String json=gson.toJson(dataVo);
        String json= PageUtil.getPage(page);
        return json;
    }
    //获取部门树
    public JSONArray createDepTreeNode(Integer parentId){
        JSONArray jsonArray = new JSONArray();
        Department department=departmentRepository.findOne(parentId);
        JSONObject jsonObject = new JSONObject();
        String _id="a_a_"+department.getId();
        jsonObject.put("id",_id);
        jsonObject.put("text", department.getName());
        JSONObject state = new JSONObject();
        state.put("opened", true);
        jsonObject.put("state",state);
//            jsonObject.put("type", "moduleTreeType");
//        jsonArray.add(jsonObject);
        List<Department> list=departmentRepository.findByParentId(parentId);
        //如果树形结构下有子节点
        if(list.size()!=0) {
            JSONArray children = new JSONArray();
            for (Department d : list) {
                JSONObject jsonObject2 = new JSONObject();
                String _id2="a_b_"+d.getId();
                jsonObject2.put("id", _id2);
                jsonObject2.put("text", d.getName());
                children.add(jsonObject2);
            }
            jsonObject.put("children", children);
            jsonArray.add(jsonObject);
        }else {
      /*      Department department=departmentRepository.findOne(parentId);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", department.getId());
            jsonObject.put("text", department.getName());
//            jsonObject.put("type", "moduleTreeType");
            jsonArray.add(jsonObject);*/
        }
        return jsonArray;
    }

    public Department findLastDep(){
        return  departmentRepository.findLastDep();
    }
}
