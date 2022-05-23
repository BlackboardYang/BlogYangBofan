package com.yangbofan.blog.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.yangbofan.blog.Model.BlogContents;
import com.yangbofan.blog.Repository.BlogContentsRepository;

@Controller
public class EditBlogController {
//	
//	@Autowired
//	private BlogContentsRepository BlogContentsRepository;
//	
//	@GetMapping("/postblog")
//	public String getPostBlogView() {
//		
//		List<BlogContents> blogs = new ArrayList<>();
//		blogs = BlogContentsRepository.findByTitle(getPostBlogView())
//		
//	}
//		public ModelAndView postBlog(//
//				@RequestParam("title") String title,
//				@RequestParam("tag") String tag,
//				@RequestParam("blog_body") String blogBody,
//				ModelAndView mv
//				) {
//			
//			BlogContents blogContents = BlogContents.builder()//
//					.title(title)
//					.tag(tag)
//					.blogBody(blogBody)
//					.date(date)
//					.build();
//		return "";
//		
//		List<UserInfo> users = new ArrayList<>();
//		users = userInfoRepository.findAll();
//		
//		mv.addObject("users", users);
//		mv.setViewName("userList");
//		
//		return mv;
//	}

}
