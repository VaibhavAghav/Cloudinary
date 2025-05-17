package com.scm.model;

public class DbUser {

	private int id;
	private String name;
	private boolean ishuman;
	private String userImageId;
	private String publicUserImageId;

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

	public String getUserImageId() {
		return userImageId;
	}

	public void setUserImageId(String userImageId) {
		this.userImageId = userImageId;
	}

	public String getPublicUserImageId() {
		return publicUserImageId;
	}

	public void setPublicUserImageId(String publicUserImageId) {
		this.publicUserImageId = publicUserImageId;
	}

	public DbUser(int id, String name, boolean ishuman, String userImageId, String publicUserImageId) {
		super();
		this.id = id;
		this.name = name;
		this.ishuman = ishuman;
		this.userImageId = userImageId;
		this.publicUserImageId = publicUserImageId;
	}

	public DbUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "DbUser [id=" + id + ", name=" + name + ", ishuman=" + ishuman + ", userImageId=" + userImageId
				+ ", publicUserImageId=" + publicUserImageId + "]";
	}

}
