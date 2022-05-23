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

public class BlogContents {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private String title;
	private String tag;
	private String blogBody;
	private String date;

}
