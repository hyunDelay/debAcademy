package com.kh.app.vo;

public class DateVo {
	
	private String title;
	private String date;
	
	public DateVo(String title, String date) {
		this.title = title;
		this.date = date;
	}
	
	public DateVo() {
		
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "DateVo [title=" + title + ", date=" + date + "]";
	}
	
}
