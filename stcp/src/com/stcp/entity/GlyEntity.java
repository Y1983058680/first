package com.stcp.entity;

public class GlyEntity {
	private int id;
	private String zh;
	private String pass;
	
	
	
	public GlyEntity(int id, String zh, String pass) {
		super();
		this.id = id;
		this.zh = zh;
		this.pass = pass;
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
	
	
}
