package com.stcp.entity;

public class LxEntity {
	private int id;
	private String lxmc;
	
	
	
	public LxEntity(int id, String lxmc) {
		super();
		this.id = id;
		this.lxmc = lxmc;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLxmc() {
		return lxmc;
	}
	public void setLxmc(String lxmc) {
		this.lxmc = lxmc;
	}
	
	
}
