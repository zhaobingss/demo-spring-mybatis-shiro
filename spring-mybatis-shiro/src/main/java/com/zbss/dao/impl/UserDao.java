package com.zbss.dao.impl;

import com.zbss.dao.Dao;
import com.zbss.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhaobing on 2017/7/3.
 */
@Repository("userDap")
public class UserDao {

	@Autowired
	private Dao dao;

	public User selectById(Integer userId) throws Exception {
		return (User) dao.findForObject("UserMapper.selectById", userId);
	}

	public List<User> selectByName(String userName) throws Exception{
		return (List<User>) dao.findForList("UserMapper.selectByName", userName);
	}

	public User selectByNameAndPassword(User user) throws Exception{
		return (User) dao.findForObject("UserMapper.selectByNameAndPassword", user);
	}

	public void insertSelective(User user) throws Exception{
		dao.save("UserMapper.insertSelective", user);
	}
}
