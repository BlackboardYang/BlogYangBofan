package com.yangbofan.blog.controllers;

import java.util.List;
import java.util.Map; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.yangbofan.blog.models.Blog;
import com.yangbofan.blog.models.User;
import com.yangbofan.blog.services.BlogService;
import com.yangbofan.blog.services.UserService;


@Controller
public class BlogController {
	@Autowired
	private BlogService blogService;
	@Autowired
	private UserService userService;
	
	@GetMapping("/blog")
	public String blog(@RequestParam("user_id") Long userId, Map<String, Object> map) { 
		
		map.put("username", userService.findById(userId).get().getUsername()); 
		List<Blog> blogs = blogService.findBlogsByUserId(userId);
		map.put("blogs", blogs);
		return "blog"; 
	}
	
	@GetMapping("/editor")
	public String editor(@RequestParam("username") String username, Map<String, Object> map) { 
		map.put("username", username);
		return "editor"; 
	}
	
	@GetMapping("/reedit")
	public ModelAndView reedit(//
			@RequestParam("title") String title, //
			@RequestParam("tag") String tag, //
			@RequestParam("content") String content, //
			@RequestParam("username") String username, //
			@RequestParam("user_id") Long userId, //
			Map<String, Object> map) { 
		map.put("username", userService.findById(userId).get().getUsername()); 
		List<Blog> blogs = blogService.findBlogsByUserId(userId);
		map.put("blogs", blogs);
		User user = userService.findByUsername(username);
		blogService.addBlog(title, tag, content, user);
		ModelAndView mv = new ModelAndView("redirect:/blog");
		mv.addObject("user_id", user.getId());
		return mv; 
	}
	
	@PostMapping("/editor")
	public ModelAndView addBlog(//
			@RequestParam("title") String title, //
			@RequestParam("tag") String tag,
			@RequestParam("content") String content, //
			@RequestParam("username") String username//
			) {
		User user = userService.findByUsername(username);
		blogService.addBlog(title, tag, content, user);
		ModelAndView mv = new ModelAndView("redirect:/blog");
		mv.addObject("user_id", user.getId());
		return mv;
		
	}
	
	
	
}