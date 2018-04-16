package com.gbj.example.dao;

import com.gbj.example.model.User;

import java.util.List;

public interface UserDao {

	public List test();
	List<User> login(String email, String password);
}
