package com.julianocarpes.springmongo.dto;

import java.io.Serializable;

import com.julianocarpes.springmongo.domain.User;

public class PostDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	

	public PostDTO() {

	}

	public PostDTO(User obj) {
		id = obj.getId();
		name =obj.getName();
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

}
