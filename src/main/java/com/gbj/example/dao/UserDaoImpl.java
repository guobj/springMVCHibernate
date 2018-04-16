package com.gbj.example.dao;

import com.gbj.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<User> login(String email, String password) {
		String sql = "select * from test_user where email="+email+" and password="+password;
		List<User> user = jdbcTemplate.queryForList(sql,User.class);
		return user;
	}

	public List test() {
		String sql ="select * from test_user";
		List list = jdbcTemplate.queryForList(sql);
		return list;
	}
}
