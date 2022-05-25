package com.yangbofan.blog.controllers;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.yangbofan.blog.models.User;
import com.yangbofan.blog.services.UserService;


@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/login")
	public String login() {
		return "login"; 
	}
	
	@PostMapping("/login")
	public ModelAndView loginValidate(//
			@RequestParam("username") String username, //
			@RequestParam("password") String password) {
		ModelAndView mv;
		if (userService.findByUsername(username) != null //
				&& userService//
				.findByUsername(username)//
				.getPassword()//
				.equals(password)) {
			
			mv = new ModelAndView("redirect:/blog"); 
			Long userId = userService.findByUsername(username).getId();
			mv.addObject("user_id", userId); 
			
			return mv;
		}
		mv = new ModelAndView("/login");
		mv.addObject("isFailed", true); 
		return mv; 
	}
	
	@GetMapping("/register")
	public String register() {
		return "register"; 
	}
	
	@PostMapping("/register") 
	public String registerValidate(//
			@RequestParam("username") String username, //
			@RequestParam("email") String email, //
			@RequestParam("phone_number") String phoneNumber, //
			@RequestParam("password") String password, //
			@RequestParam("password_again") String passwordAgain) {
		if (userService.createUser(username, email, phoneNumber, password) != null) {
			System.out.println("录入成功");
			return "/login"; 
		}
		System.out.println("用户名重复");
		return "/register"; 
	}
	
	@GetMapping("/user")
	public String user(@RequestParam("bye_username") String username, Map<String, Object> map) { // 作为参数传进来
		User user = userService.findByUsername(username);
		map.put("user", user); 
		return "user"; 
	}
	
	
	
	
}
