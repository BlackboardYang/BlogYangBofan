package com.yangbofan.blog.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yangbofan.blog.models.User;



@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	User findByUsername(String username);
}


