package com.scm.model;

import org.springframework.web.multipart.MultipartFile;

public class User {
	
	
	private int id;
	private String name ;
	private boolean ishuman;
	private	MultipartFile photo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isIshuman() {
		return ishuman;
	}
	public void setIshuman(boolean ishuman) {
		this.ishuman = ishuman;
	}
	public MultipartFile getPhoto() {
		return photo;
	}
	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String name, boolean ishuman, MultipartFile photo) {
		super();
		this.id = id;
		this.name = name;
		this.ishuman = ishuman;
		this.photo = photo;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", ishuman=" + ishuman + ", photo=" + photo + "]";
	}
	
	
	

}
