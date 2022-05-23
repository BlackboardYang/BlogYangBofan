package com.yangbofan.blog.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.yangbofan.blog.Model.BlogContents;

public interface BlogContentsRepository extends JpaRepository<BlogContents, String>{
	
	BlogContents findByTitle(String title);
	
}