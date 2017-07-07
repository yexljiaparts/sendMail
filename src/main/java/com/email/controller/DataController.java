package com.email.controller;

import com.email.common.bind.annotation.DataTableModel;
import com.email.repository.DataInfoRepository;
import com.email.service.DataInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2017/2/18.
 */
@Controller
@RequestMapping("/data")
public class DataController {
@Autowired
private DataInfoService dataInfoService;
    //数据dataTable
    @RequestMapping("/getData")
    @ResponseBody
    public String getData(@DataTableModel Pageable pageable){
        return dataInfoService.getData(pageable);
    }
}
