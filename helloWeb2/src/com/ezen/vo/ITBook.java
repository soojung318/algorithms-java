package com.ezen.vo;

import java.sql.Date;
import java.util.Objects;

public class ITBook {
	private String title;
	private String pub;
	private Date pubdate;
	private String author;
	private int price;
	private int qty;
	private int idx;
	

public ITBook(String title, String pub, String pubdate, String author, Integer price, Integer qty) {
		// TODO Auto-generated constructor stub
	}

	public ITBook() {
	// TODO Auto-generated constructor stub
}

	public ITBook(int idx) {
		this.idx = idx;
	}



	//equals와 hashcode는 짝꿍임.
	@Override
	public boolean equals(Object obj) {	//저자, 제목, 출판일
		ITBook other = (ITBook) obj;
		return this.author.equals(other.author) &&
				this.title.equals(other.title) &&
				this.pubdate.equals(other.pubdate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.author,this.title,this.pubdate);
	}

	@Override
	public String toString() {
		return String.format("%s|%s|%s|%s|%d|%d", title, pub, pubdate, author ,price, qty);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPub() {
		return pub;
	}

	public void setPub(String pub) {
		this.pub = pub;
	}

	public Date getPubdate() {
		return pubdate;
	}

	public void setPubdate(Date date) {
		this.pubdate = date;
	}

	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	
	
}
