package com.mat.user.model;




public class UserVO {

	
	//화면 and 데이터베이스 컬럼과 동일한 멤버변수를 가짐
	private String id;
	private String pw;
	private String userAddress;
	private String contact ;
	private String email;
	
	
	public UserVO() {
		// TODO Auto-generated constructor stub
	}


	public UserVO(String id, String pw, String userAddress, String contact, String email) {
		super();
		this.id = id;
		this.pw = pw;
		this.userAddress = userAddress;
		this.contact = contact;
		this.email = email;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPw() {
		return pw;
	}


	public void setPw(String pw) {
		this.pw = pw;
	}


	public String getUserAddress() {
		return userAddress;
	}


	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}


	public String getContact() {
		return contact;
	}


	public void setContact(String contact) {
		this.contact = contact;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
