package com.gbj.example.controller;

import com.gbj.example.model.User;
import com.gbj.example.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class MainController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "test",method = RequestMethod.GET)
	public String test(){
		System.out.println("test");
		List list = userService.test();
		return "index";
	}

	@RequestMapping(value = "toLogin")
	public String toLogin(){
		System.out.println("tologin");
		System.out.println("tologin");
		return "login";
	}

	@RequestMapping(value = "login")
	public String login(String email,String password){
//		ModelAndView mav = new ModelAndView();
		List<User> users = userService.login(email,password);
		if (users == null || users.size()==0) {
			return "error";
		}
//		if (!user.getPassword().equals(password)) {
//			return "error";
//		}
		SecurityUtils.getSecurityManager().logout(SecurityUtils.getSubject());
		// 登录后存放进shiro token
		UsernamePasswordToken token = new UsernamePasswordToken(
				users.get(0).getUsername(), users.get(0).getPassword());
		Subject subject = SecurityUtils.getSubject();
		subject.login(token);
		// 登录成功后会跳转到successUrl配置的链接，不用管下面返回的链接。
//		mav.setView("redirect:/home");
		return "login";
	}

}

