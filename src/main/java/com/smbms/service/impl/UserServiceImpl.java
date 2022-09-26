package com.smbms.service.impl;

import com.smbms.dao.UserDao;
import com.smbms.pojo.User;
import com.smbms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	public User login(String userCode, String pwd) throws Exception {
		
		return userDao.selectUserByCodeAndPwd(userCode, pwd);
	}



	public List<User> showUserList() throws Exception {


		return userDao.selectUserList();
		
		
	}

	public List<User> showUserListByName(String name) throws Exception {
		return userDao.showUserListByName(name);
	}


	public boolean addUser(User user) throws Exception {
		if(userDao.insertUser(user)>0)
			return true;
		return false;
	}



	public boolean updateUser(User user) throws Exception {
		int i = userDao.updateUser(user);
		if(i>0)
			return true;
		return false;
	}



	public User findById(Long id) throws Exception {
		
		return userDao.findById(id);
	}


	public boolean delUser(Long id) throws Exception {
		int row = userDao.delUser(id);
		System.out.println(row);
		//int i=90/0;
		if(row>0)
			return true;
		return false;
	}

}
