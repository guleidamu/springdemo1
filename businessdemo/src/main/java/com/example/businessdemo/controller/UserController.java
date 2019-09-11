package com.example.businessdemo.controller;

import com.example.businessdemo.entity.User;
import com.example.businessdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/user")
public class UserController {


    @Autowired
    private UserService userService;
    @ResponseBody
    @RequestMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    public int addUser(User user){
        return userService.addUser(user);
    }
    @ResponseBody
    @RequestMapping(value="/addTest",produces = {"application/json;charset=UTF-8"})
    public String addUserTest(){
        User user=new User();
        user.setUserId(656);
        user.setPassword("8764");
        user.setPhone("434344");
        user.setUserName("people8");
        userService.addUser(user);
        return "添加数据成功";
    }

    @ResponseBody
    @RequestMapping(value="/update",produces = {"application/json;charset=UTF-8"})
    public int update(){
        User user=new User();
        user.setUserId(64256);
        user.setPassword("99ew");
        user.setPhone("3809626");
        user.setUserName("da");
        return userService.updateUser(user);
    }

    @ResponseBody
    @RequestMapping(value="/getUserById",produces = {"application/json;charset=UTF-8"})
    public int getUserById(){
        int id=53438;
        int flag=0;
        User user=userService.getUserById(id);

        if(user!=null){
            flag=1;
        }
        return  flag;
    }




    @ResponseBody
    @RequestMapping(value="/delete",produces = {"application/json;charset=UTF-8"})
    public String delete(){
        int id=6543;
        userService.delete(id);
        return "删除数据成功";
    }

    @RequestMapping("/mvcTestModel")
    public String mvcTest( Model m){
        int id=6456789;
        m.addAttribute("id",id);
        String name="调试成功";
        User user=userService.getUserById(id);
        m.addAttribute("user",user);
        m.addAttribute("id",id);

        return "mvcTestModel";
    }



    @GetMapping("/getUserTest")
    public String addTest(User user){
        return "getUserTest success";
    }
}




