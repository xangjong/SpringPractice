package com.spring_boot_mybatis_book.project.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.spring_boot_mybatis_book.project.dao.IBookDAO;
import com.spring_boot_mybatis_book.project.model.BookVO;

@Service
public class BookService implements IBookService {
	
	@Autowired
	@Qualifier("IBookDAO")
	IBookDAO dao;
	
	@Override
	public ArrayList<BookVO> listAllBook() {
		return dao.listAllBook();
	}

	@Override
	public void insertBook(BookVO book) {
		dao.insertBook(book);

	}

	@Override
	public void updateBook(BookVO book) {
		dao.updateBook(book);
	}

	@Override
	public void deleteBook(String bookNo) {
		dao.deleteBook(bookNo);

	}

	@Override
	public BookVO detailViewBook(String bookNo) {
		return dao.detailViewBook(bookNo);
	}

	@Override
	public String bookNoCheck(String bookNo) {
		return dao.bookNoCheck(bookNo);
	}

	@Override
	public ArrayList<BookVO> bookSearch(HashMap<String, Object> map) {
		return dao.bookSearch(map);
	}

}
