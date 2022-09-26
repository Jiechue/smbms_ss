package com.smbms.controller;

import com.smbms.pojo.User;
import com.smbms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user2")
public class UserController2 {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> list() throws Exception {
        List<User> users = userService.showUserList();
        return users;
    }

    @PostMapping
    public Boolean add(@RequestBody User user) throws Exception {
        boolean b = userService.addUser(user);
        return b;
    }
    @DeleteMapping("/{uid}")
    public Boolean del(@PathVariable(value = "uid") Long id) throws Exception {
        boolean b = userService.delUser(id);
        return b;
    }
    @PutMapping
    public Boolean update(@RequestBody User user)throws Exception{
        System.out.println(user);
        boolean b = userService.updateUser(user);
        return b;
    }

    @GetMapping({"/{name}/{code}","/{name}"})
    public String findByNameOrCode(@PathVariable String name,@PathVariable(required=false) String code){
        System.out.println("name:"+name);
        System.out.println("code:"+code);
        return name+code;
    }

}
