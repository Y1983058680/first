package com.stcp.entity;

public class MenuEntity {
	private int id;
	private int uid;
	private String auther;
	private String title;
	private String content;
	private int ydl;
	private String createtime;
	private int lxid;
	
	public MenuEntity() {
		super();
	}

	public MenuEntity(int id, int uid, String auther, String title, String content, int ydl, String createtime,
			int lxid) {
		super();
		this.id = id;
		this.uid = uid;
		this.auther = auther;
		this.title = title;
		this.content = content;
		this.ydl = ydl;
		this.createtime = createtime;
		this.lxid = lxid;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getAuther() {
		return auther;
	}
	public void setAuther(String auther) {
		this.auther = auther;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getYdl() {
		return ydl;
	}
	public void setYdl(int ydl) {
		this.ydl = ydl;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public int getLxid() {
		return lxid;
	}
	public void setLxid(int lxid) {
		this.lxid = lxid;
	}
}
