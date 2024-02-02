package com.keane.training.domain;

public class User {
	
	private int uid;
	private String name;
	private String password;
	private String city;
	private String email;
	private int contactno;
	private int rno;
	public User(int uid,String name,String city,String email,int contactno,int rno,String password)
	{
			super();
			this.uid=uid;
			this.name=name;
			this.password=password;
		    this.city=city;
		    this.email=email;
			this.contactno=contactno;
			this.rno=rno;
		
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getContactno() {
		return contactno;
	}
	public void setContactno(int contactno) {
		this.contactno = contactno;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", name=" + name + ", password=" + password + ", city=" + city + ", email=" + email
				+ ", contactno=" + contactno + "]";
	}

	

}
