package com.yangbofan.blog.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class UserStatus {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private String email;
	private String username;
	private int phoneNumber;
	private String password;
	
}
