package com.gbj.example.service;

import com.gbj.example.model.User;

import java.util.List;

public interface UserService {
	List test();
	List<User> login(String email,String password);
}
