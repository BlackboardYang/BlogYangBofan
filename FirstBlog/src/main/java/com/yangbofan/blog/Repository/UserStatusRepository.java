package com.yangbofan.blog.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yangbofan.blog.Model.UserStatus;

public interface UserStatusRepository extends JpaRepository<UserStatus, String>{
	
	UserStatus findByUsername(String username);
	UserStatus findByEmail(String email);

}
