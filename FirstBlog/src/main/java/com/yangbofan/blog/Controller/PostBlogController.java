package com.yangbofan.blog.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.yangbofan.blog.Model.BlogContents;
import com.yangbofan.blog.Repository.BlogContentsRepository;

@Controller
public class PostBlogController {
	
	@Autowired
	private BlogContentsRepository BlogContentsRepository;
	
	@GetMapping("/postblog")
	public String getPostBlogView() {
		return "Post";
	}
	
	@PostMapping
	public ModelAndView postBlog(//
			@RequestParam("title") String title,
			@RequestParam("tag") String tag,
			@RequestParam("blog_body") String blogBody,
			@RequestParam("date") String date,
			ModelAndView mv
			) {
		
		BlogContents blogContents = BlogContents.builder()//
				.title(title)
				.tag(tag)
				.blogBody(blogBody)
				.date(date)
				.build();
		
		BlogContentsRepository.save(blogContents);
		mv.addObject("title", title);
		mv.addObject("tag", tag);
		mv.addObject("blogBody", blogBody);
		mv.addObject("date", date);
		
		mv.setViewName("PostSuccess");
		return mv;
		
	}
			
	

}
