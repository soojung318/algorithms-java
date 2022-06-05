package com.ezen.vo;

import java.sql.Date;
import java.util.Objects;

public class BBSVO {
	private int no;
	private String writer;
	private String title;
	private Date date;
	private String content;
	
	
	public BBSVO() {}

	public BBSVO(int no) {
		this.no = no;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.no);
	}
	
	@Override
	public boolean equals(Object obj) {
		BBSVO other = (BBSVO) obj;
		return this.no==other.no;
	}
	
	@Override
	public String toString() {
		return String.format("%d|%s|%s|%s|%s", no, title, writer, date, content);
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date now) {
		this.date = now;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	/*
	 * ㅎ
	*/
	

	
	
}
