package com.email.service;

import com.email.common.bean.DataVo;
import com.email.common.inject.annotation.BaseComponent;
import com.email.common.service.BaseService;
import com.email.common.util.PageUtil;
import com.email.entity.Department;
import com.email.entity.Employees;
import com.email.repository.DepartmentRepository;
import com.email.repository.EmployeesRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2017/2/22.
 */
@Service
public class EmployeesService extends BaseService<Employees, Integer> {
    @Autowired
    @BaseComponent
    private EmployeesRepository employeesRepository;
@Resource
    private DepartmentRepository departmentRepository;

    public String getEmpData(Pageable pageable, Integer id){
        if(StringUtils.isEmpty(id)){
            id=1;
        }
        Page<Employees> page=employeesRepository.getPage(pageable,id);



   /*     DataVo<Employees> dataVo=new DataVo<Employees>();
        dataVo.setAaData(list);
        dataVo.setiTotalDisplayRecords(page.getTotalElements());
        dataVo.setiTotalRecords(page.getTotalElements());
        String json=gson.toJson(dataVo);*/
   String json=PageUtil.getPage(page);
        return json;
    }

    public Integer getAll(Integer id){
        Department department=departmentRepository.findOne(id);
        Integer b=0;
        //无法删除最外层父节点
        if(department.getParentId()==0){
               b=1;
        }else{
        List<Employees> list=employeesRepository.getAll(id);
             b=list.size()>0?2:0;
        }
        return  b;
    }
}
