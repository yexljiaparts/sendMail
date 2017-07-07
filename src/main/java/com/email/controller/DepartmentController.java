package com.email.controller;

import com.alibaba.fastjson.JSONArray;
import com.email.entity.Department;
import com.email.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017/4/22.
 */
@Controller
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    //创建部门树
    @RequestMapping("/createDepTreeNode")
    @ResponseBody
    public JSONArray createDepTreeNode(){
        return departmentService.createDepTreeNode(1);
    }


    //操作部门树
    @RequestMapping("/operationDep")
    @ResponseBody
    public void operationDep(Integer id,String operation,String title){
        //判断如果是创建节点
        if("create_node".equals(operation)){
           // System.out.print("保存成功");
            Department dept=new Department();
            dept.setParentId(id);
            if(StringUtils.isEmpty(title)){
                title="新部门";
            }
            dept.setName(title);
            departmentService.save(dept);
            //判断如果是修改节点
        }else  if("rename_node".equals(operation)){
            Department dept=null;
            if(StringUtils.isEmpty(id)){
                dept=departmentService.findLastDep();
          }else{
                dept=departmentService.findOne(id);
            }
            dept.setName(title);
            departmentService.save(dept);
            //判断如果是删除节点
        }else  if("delete_node".equals(operation)){
            if(!StringUtils.isEmpty(id)){
                departmentService.delete(id);
            }
    }
}

}
