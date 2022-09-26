package com.smbms.service;

import com.smbms.pojo.User;

import java.util.List;

public interface UserService {

	User login(String userCode, String pwd) throws Exception;

    List<User> showUserList() throws Exception;


    List<User> showUserListByName(String name) throws Exception;
    
    boolean addUser(User user)throws Exception;
    
    boolean updateUser(User user)throws Exception;
    
    User findById(Long id)throws Exception;

    boolean delUser(Long id)throws Exception;
}
