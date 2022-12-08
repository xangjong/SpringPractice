package com.spring_boot_mybatis_book.project.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class BookVO {
	private String bookNo;
	private String bookName;
	private int bookPrice;
	private String bookPub;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date bookDate;
	
	public String getBookNo() {
		return bookNo;
	}
	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}
	public String getBookPub() {
		return bookPub;
	}
	public void setBookPub(String bookPub) {
		this.bookPub = bookPub;
	}
	public Date getBookDate() {
		return bookDate;
	}
	public void setBookDate(Date bookDate) {
		this.bookDate = bookDate;
	}
	
}
