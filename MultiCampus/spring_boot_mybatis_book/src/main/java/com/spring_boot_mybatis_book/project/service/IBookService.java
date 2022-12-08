package com.spring_boot_mybatis_book.project.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.spring_boot_mybatis_book.project.model.BookVO;

public interface IBookService {
	
	public ArrayList<BookVO> listAllBook();
	
	public void insertBook(BookVO book);
	
	public void updateBook(BookVO book);
	
	public void deleteBook(String bookNo);
	
	public BookVO detailViewBook(String bookNo);
	
	public String bookNoCheck(String bookNo);
	
	public ArrayList<BookVO> bookSearch(HashMap<String, Object> map);
}
