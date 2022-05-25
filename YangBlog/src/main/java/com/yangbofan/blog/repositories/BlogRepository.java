package com.yangbofan.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yangbofan.blog.models.Blog;



@Repository
public interface BlogRepository extends JpaRepository<Blog, Long>{

    List<Blog> findByUserId(Long userId);
}
