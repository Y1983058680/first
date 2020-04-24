package com.stcp.entity;

public class PlEntity {
	private int id;
	private int mid;
	private String content;
	private String plr;
	private String plsj;
	
	
	public PlEntity(int id, int mid, String content, String plr, String plsj) {
		super();
		this.id = id;
		this.mid = mid;
		this.content = content;
		this.plr = plr;
		this.plsj = plsj;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPlr() {
		return plr;
	}
	public void setPlr(String plr) {
		this.plr = plr;
	}
	public String getPlsj() {
		return plsj;
	}
	public void setPlsj(String plsj) {
		this.plsj = plsj;
	}
	
	
}
