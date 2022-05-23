package com.yangbofan.blog.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.yangbofan.blog.Model.UserStatus;
import com.yangbofan.blog.Repository.UserStatusRepository;

import lombok.extern.slf4j.Slf4j;

@Controller	
@Slf4j
public class RegisterController {
	
	@Autowired
	private UserStatusRepository userStatusRepository;
	
	@GetMapping("/register")
	public String getRegisterView() {
		return "register";
	}

	@PostMapping("/register")
	public ModelAndView register(//
			@RequestParam("username") String username,
			@RequestParam("email") String email,
			@RequestParam("phone_number") int phoneNumber ,
			@RequestParam("passoword")
			@RequestParam("password_again") String passwordAgain,
			ModelAndView mv) {
		
		if (! password.equals())
	}
			
}
