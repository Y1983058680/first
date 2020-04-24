package com.stcp.entity;

public class UserEntity {
	private int id;
	private String zh;
	private String pass;
	private String realname;
	
	public UserEntity() {
		super();
	}
	public UserEntity(int id, String zh, String pass, String realname) {
		super();
		this.id = id;
		this.zh = zh;
		this.pass = pass;
		this.realname = realname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getZh() {
		return zh;
	}
	public void setZh(String zh) {
		this.zh = zh;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	
}
