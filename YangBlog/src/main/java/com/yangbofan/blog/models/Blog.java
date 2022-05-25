package com.yangbofan.blog.models;

import java.sql.Date;

import javax.persistence.*;
import org.hibernate.annotations.Type;

import lombok.Data;

@Entity 
@Table(name = "blogs")
@Data
public class Blog {
	
	public Blog(String title, String tag, String content, byte[] image, User user) {
		super();
		this.title = title;
		this.tag = tag;
		this.content = content;
		this.image = image;
		this.user = user;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private Long id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "tag")
	private String tag;

	@Column(name = "content")
	private String content;
	
	@Column(name = "created_at", insertable = false, updatable = false)
	private Date createdAt;
	
	@Lob
	@Column(name="image")
	@Type(type="org.hibernate.type.BinaryType")
	private byte[] image;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	public Blog(String title, String tag, String content, User user) {
		this(title, tag, content, null, user);
	}

	public Blog() {}
	
}
