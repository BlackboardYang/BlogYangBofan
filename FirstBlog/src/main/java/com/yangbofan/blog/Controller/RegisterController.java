package com.yangbofan.blog.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.yangbofan.blog.Model.UserStatus;
import com.yangbofan.blog.Repository.UserStatusRepository;

@Controller	
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
			@RequestParam("email1") String email1,
			@RequestParam("email2") String email2,
			@RequestParam("phone_number") int phoneNumber ,
			@RequestParam("passoword") String password,
			@RequestParam("password_again") String passwordAgain,
			ModelAndView mv) {
		
		UserStatus userStatus = UserStatus.builder()//
				.username(username)
				.email(email1 + email2)
				.phoneNumber(phoneNumber)
				.password(password)
				.build();
		userStatusRepository.save(userStatus);
		
		mv.addObject("username",username);
		mv.addObject("email",username);
		mv.addObject("phone_number", phoneNumber);
		mv.addObject("username",username);
		mv.addObject("password",password);
		
		mv.setViewName("RegisterSuccess");
		return mv;
		
	}
			
}
