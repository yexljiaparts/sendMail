package testCon;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.email.common.inject.annotation.BaseComponent;
import com.email.common.util.PageUtil;
import com.email.entity.Employees;
import com.email.entity.User;
import com.email.repository.EmployeesRepository;
import com.email.repository.UserRepository;

import com.google.gson.JsonObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/2/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/spring.xml" })
public class test {

    @Resource
    private UserRepository userRepository;

    @Autowired
    private EmployeesRepository employeesRepository;
    @Test
    public void test() {
        User user=userRepository.findOne(1);
        System.out.println(user);
    }


    @Test
    public void test2() {
       // Page<Employees> page=employeesRepository.getPage(pageable,id);
List<User> list1=new ArrayList<User>();

        for(int i=0;i<5000;i++){
            User user=new User();
            user.setId(i);
            user.setUsername("111");
            user.setPassword("222");
            list1.add(user);
        }
        long startTime = System.currentTimeMillis();//获取当前时间
String json1= PageUtil.getList(list1);
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间："+(endTime-startTime)+"ms");
        System.out.println("======");

        long startTime2 = System.currentTimeMillis();//获取当前时间

    /*    JSONArray json = new JSONArray();
        for(User user:list1){
            JSONObject jo = new JSONObject();
            jo.put("id", 1);
            jo.put("password", "111");
            jo.put("username", "222");
            json.add(jo);
        }
        String json2=json.toString();
        */
        String json2=PageUtil.getList2(list1);
        long endTime2 = System.currentTimeMillis();
        System.out.println("程序运行时间："+(endTime2-startTime2)+"ms");


        long startTime3 = System.currentTimeMillis();//获取当前时间
        String json3= PageUtil.getList3(list1);
        long endTime3 = System.currentTimeMillis();
        System.out.println("程序运行时间："+(endTime3-startTime3)+"ms");

    }


}
