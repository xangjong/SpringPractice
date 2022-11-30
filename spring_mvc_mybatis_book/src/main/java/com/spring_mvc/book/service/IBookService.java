package com.spring_mvc.book.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.spring_mvc.book.model.BookVO;

public interface IBookService {
	
	public ArrayList<BookVO> listAllBook();
	
	public void insertBook(BookVO book);
	
	public void updateBook(BookVO book);
	
	public void deleteBook(String bookNo);
	
	public BookVO detailViewBook(String bookNo);
	
	public String bookNoCheck(String bookNo);
	
	public ArrayList<BookVO> bookSearch(HashMap<String, Object> map);
}
