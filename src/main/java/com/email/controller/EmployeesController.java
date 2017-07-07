package com.email.controller;

import com.email.common.bind.annotation.DataTableModel;
import com.email.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017/4/22.
 */
@Controller
@RequestMapping("/employees")
public class EmployeesController {
    @Autowired
    private EmployeesService employeesService;
    //获取员工信息
    @RequestMapping("/getEmployees")
    @ResponseBody
    public String getEmployees(@DataTableModel Pageable pageable, Integer id){
        return employeesService.getEmpData(pageable,id);
    }

    @RequestMapping("/booleanEmp")
    @ResponseBody
    public Integer booleanEmp(Integer id){
        return employeesService.getAll(id);
    }
}
