package com.gbj.example.service;

import com.gbj.example.dao.UserDao;
import com.gbj.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;

	public List<User> login(String email, String password) {
		List<User> users = userDao.login(email,password);
//		User user = new User();
//		if(users!=null && users.size()>0){
//			user = users.get(0);
//		}
		return users;
	}

	public List test() {
		List list = userDao.test();
		return list;
	}
}
