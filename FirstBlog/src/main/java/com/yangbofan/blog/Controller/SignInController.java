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
public class SigninController {
	@Autowired
	private UserStatusRepository userStatusRepository;
	
	@GetMapping("/SignIn")
	public String getSignInView() {
		return "SignIn";
	}

	
	@PostMapping("/SignIn")
	public ModelAndView signin(//
			@RequestParam("email") String email,//
			@RequestParam("password") String password,//
			ModelAndView mv) {
		
		mv.addObject("email",email);
		
		UserStatus userStatus = userStatusRepository.findByEmail(email);
		
		if(userStatus != null && password.equals(userStatus.getPassword())) {
			mv.setViewName("BlogMain");
		} else {
			mv.setViewName("SignInFail");
		}
		return mv;
	}

}