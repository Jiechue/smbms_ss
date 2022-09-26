package com.smbms.dao;

import com.smbms.pojo.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
	
	User selectUserByCodeAndPwd(String userCode, String pwd) throws SQLException;
	 List<User> selectUserList() throws  SQLException;
	 
	 int insertUser(User user)throws  SQLException;
	 
	 int updateUser(User user)throws  SQLException;
	 
	 int delUser(Long id)throws  SQLException;
	 
	 User findById(Long id)throws  SQLException;

	List<User> showUserListByName(String name) throws SQLException;
	 
}
