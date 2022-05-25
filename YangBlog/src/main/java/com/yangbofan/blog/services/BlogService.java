package com.yangbofan.blog.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yangbofan.blog.models.Blog;
import com.yangbofan.blog.models.User;
import com.yangbofan.blog.repositories.BlogRepository;


@Service
public class BlogService{
	@Autowired
    private BlogRepository blogRepository;
	
	public List<Blog> findBlogsByUserId(Long userId) {
		return blogRepository.findByUserId(userId);
	}
	public Blog addBlog(String title, String tag, String content, User user) {
		return blogRepository.save(new Blog(title, tag, content, user));		
	}
	
}
