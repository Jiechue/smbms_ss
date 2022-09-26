package com.smbms.controller;

import com.smbms.pojo.User;
import com.smbms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(String userCode, String password,HttpSession session) throws Exception {
        User login = userService.login(userCode, password);
        if(login!=null){
            session.setAttribute("user",login);
            return "welcome";
        }else{
            return "login";
        }

    }
    @RequestMapping("/list")
    public String list(HttpSession session) throws Exception {
       // int i=90/0;
        List<User> users = userService.showUserList();
        session.setAttribute("userList",users);
        return "userList";

    }

    @RequestMapping("/delele")
    @ResponseBody
    public Boolean del(Long id) throws Exception {
        boolean b = userService.delUser(id);
        return b;
    }

    @RequestMapping("/add")
    public String add(User user) throws Exception {
        boolean b = userService.addUser(user);
        if(b){
            //成功
            return "forward:list";
        }else{
           return "useradd" ;
        }
    }

    @RequestMapping("/show")
    public String show(Long id,Model model)throws Exception{
        User user = userService.findById(id);
        model.addAttribute("u",user);
        return "userView";
    }

    @RequestMapping("/find")
    public String find(Long id,Model model)throws Exception{
        User user = userService.findById(id);
        model.addAttribute("u",user);
        return "userUpdate";
    }


    @RequestMapping("/update")
    public String update(User user) throws Exception {
        boolean b = userService.updateUser(user);
        if(b){
            //成功
            return "forward:list";
        }else{
            return "userUpdate" ;
        }
    }


    //@RequestMapping(value = "/findByName",method = RequestMethod.GET)
    @GetMapping("/{username}")
    public String findByName(@PathVariable String username,Model model) throws Exception {
        System.out.println(username);
        List<User> users = userService.showUserListByName(username);
        model.addAttribute("userList",users);
        return "userList";
    }
}
