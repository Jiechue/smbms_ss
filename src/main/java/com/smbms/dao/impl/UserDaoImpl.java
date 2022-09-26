package com.smbms.dao.impl;

import com.smbms.dao.UserDao;
import com.smbms.pojo.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
	private QueryRunner queryRunner;


	public User selectUserByCodeAndPwd(String userCode, String pwd) throws SQLException {
		String sql="select * from smbms_user where usercode=? and userpassword=?";
		return queryRunner.query(sql, new BeanHandler<User>(User.class), userCode,pwd);
	}


	public List<User> selectUserList() throws SQLException {
		String sql="select * from smbms_user order by id desc";
		return queryRunner.query(sql,new BeanListHandler<User>(User.class));
	}


	public int insertUser(User user) throws SQLException {
		String sql="insert into smbms_user(usercode,username,userpassword,gender,birthday,phone,address,userrole) values(?,?,?,?,?,?,?,?)";
		return queryRunner.update(sql, user.getUsercode(),user.getUsername(),user.getUserpassword(),user.getGender(),user.getBirthday(),user.getPhone(),user.getAddress(),user.getUserrole());
	}


	public int updateUser(User user) throws SQLException {
		String sql="update smbms_user set gender=?,birthday=?,phone=?,address=?,userrole=? where id=?";
		return queryRunner.update(sql,user.getGender(),user.getBirthday(),user.getPhone(),user.getAddress(),user.getUserrole(),user.getId());
	
	}


	public User findById(Long id) throws SQLException {
		String sql="select * from smbms_user where id=?";
		return queryRunner.query(sql, new BeanHandler<User>(User.class),id);
	}

	public List<User> showUserListByName(String name) throws SQLException {
		String sql="select * from smbms_user where username like concat('%',?,'%') order by id desc";
		return queryRunner.query(sql,new BeanListHandler<User>(User.class),name);
	}


	public int delUser(Long id) throws SQLException {
		String sql="delete from smbms_user where id=?";
		return queryRunner.update(sql, id);
	}

}
