package com.qf.sp_crud;

import com.qf.dto.Department;
import com.qf.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @GetMapping(value = "/getUserList")
    public String getUserList(Map map){
        System.out.println("获取用户列表");

        List<User> list = new ArrayList<>();
        User user1 = new User(1001,"AAA","MAN");
        User user2 = new User(1002,"BBB","WOMAN");
        User user3 = new User(1003,"CCC","MAN");
        User user4 = new User(1004,"DDD","WOMAN");

        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);

        map.put("users",list);
        return "userList";
    }

    @GetMapping(value = "/deleteUser")
    public String deleteUser(Integer userId){
        System.out.println("删除userId="+userId);
        return "redirect:/user/getUserList";
    }

    @PostMapping(value = "/addUser")
    public String addUser(User user){
        System.out.println(user);
        return "redirect:/user/getUserList";
    }

    @GetMapping(value = "/jumpUpdateUser")
    public String jumpUpdateUser(Integer userId, Model model){

        System.out.println("跳转更新页面");

        List<Department> departments = new ArrayList<>();

        Department dept1 = new Department(1001,"人事部");
        Department dept2 = new Department(1002,"行政部");
        Department dept3 = new Department(1003,"产品研发部");
        Department dept4 = new Department(1004,"财务部");
        departments.add(dept1);
        departments.add(dept2);
        departments.add(dept3);
        departments.add(dept4);

        model.addAttribute("departments",departments);
        model.addAttribute("deptShowId",1003);
        return "user_update";
    }

    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    public String updateUser(){
        System.out.println("更新用户");
        return "redirect:/user/getUserList";
    }

}
