package com.email.controller;

import com.alibaba.fastjson.JSONArray;
import com.email.common.bind.annotation.DataTableModel;
import com.email.service.DepartmentService;
import com.email.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017/2/22.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/index")
    @ResponseBody
    public Integer index(){
        return 1;
    }


}
