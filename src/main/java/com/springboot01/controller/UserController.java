package com.springboot01.controller;


import com.springboot01.dao.UserDao;
import com.springboot01.entity.User;
import com.springboot01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    UserDao userDao;
    @RequestMapping("/test")
    public User getUser(){
        User user = new User();
        user.setName("张三");
        user.setAge(18);
        userService.setUser(user);
        return user;
    }
    @ResponseBody
    @RequestMapping("/getAll")
    public List<User> getAll(){
        List list = userService.getAll();
        return list;
    }
    @RequestMapping("/login")
    public String login(@RequestParam String userName, @RequestParam String passWord, HttpSession session){
        User user =  userDao.getAllBynameAndPassWord(userName,passWord);
       if (user==null){
           return "index";
       }
        //session.setAttribute("userName",user.getName());
        //ession.setAttribute("passWord",user.getAge());
        session.setAttribute("user",user);
        return "main";
    }
}
