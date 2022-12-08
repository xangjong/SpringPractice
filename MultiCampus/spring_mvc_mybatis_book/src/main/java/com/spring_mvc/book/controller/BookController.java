package com.spring_mvc.book.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring_mvc.book.model.BookVO;
import com.spring_mvc.book.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	BookService bookService;
	
//	인덱스 조회
	@RequestMapping("/")
	public String viewIndex() {
		return "index";
	}
	
// 	전체 도서 조회 요청 처리
	@RequestMapping("/books/bookAllList")
	public String viewBookAllList(Model model) {
		// 서비스 클래스의 메소드 호출해서 결과 받아옴
		ArrayList<BookVO> bookList = bookService.listAllBook();
		// 모델 설정
		model.addAttribute("bookList", bookList);
		return "books/bookAllListView"; // product 폴더의 productAllListView.jsp
	}
	
	// 도서 등록 폼 열기 요청 처리
	@RequestMapping("/books/bookNewForm")
	public String viewbookNewForm() {
		return "books/bookNewForm";
	}
	
	// 도서 등록 : 도서 정보 DB 저장
	@RequestMapping("/books/insertBook")
	public String insertProduct(BookVO book) {
		bookService.insertBook(book);
		
		// DB에 데이터 저장한 후 전체 상품 조회 화면으로 포워딩
		return "redirect:./bookAllList";
	}
	
	// 도서 상세 정보 조회 : 1개 상품 조회
	@RequestMapping("/books/bookDetailView/{bookNo}")
	public String detailViewProduct(@PathVariable String bookNo, Model model) {
		BookVO book = bookService.detailViewBook(bookNo);
		model.addAttribute("book", book);
		return "books/bookDetailView";
	}
	
	// 상품 정보 수정 폼 열기 요청 처리
	@RequestMapping("/books/bookUpdateForm/{bookNo}")
	public String updateBookForm(@PathVariable String bookNo, Model model) {
		// 수정할 상품번호 받아서, detailViewProduct()메소드 호출하면서 전달하고
		// 해당 상품 정보 (1개) 받아서 모델 설정
		BookVO book = bookService.detailViewBook(bookNo);
		model.addAttribute("book", book);
		return "books/bookUpdateForm";
	}
	
	// 수정 내용 DB 저장
	@RequestMapping("/books/UpdateBook")
	public String updateProduct(BookVO book) {
		bookService.updateBook(book);
		// DB에 수정된 데이터 저장한 후 전체 상품 조회 화면으로 포워딩
		return "redirect:./bookAllList";
	}
	
	// 도서 정보 삭제
	@RequestMapping("/books/deleteBook/{bookNo}")
	public String deleteProduct(@PathVariable String bookNo) {
		bookService.deleteBook(bookNo);
		// 삭제한 후 전체 도서 조회 화면으로 포워딩
		return "redirect:/books/bookAllList";
	}
	
	
	// 도서 중복 확인
	@ResponseBody
	@RequestMapping("/books/bookNoCheck")
	public String bookNoCheck(@RequestParam("bookNo") String bookNo) {
		
		String bookNo_result = bookService.bookNoCheck(bookNo);
		
		String result ="use";
		if(bookNo_result !=null)
			result ="no_use";
		
		return result;
	}
	
	// 도서 검색 폼 열기 요청 처리
		@RequestMapping("/books/bookSearchForm")
		public String viewBookSearchForm() {
		return "books/bookSearchForm";
	}
	
	// 도서 검색 : 방법2
	@RequestMapping("/books/bookSearch")
	public String bookSearch(@RequestParam HashMap<String, Object> param, Model model){
		ArrayList<BookVO> bookList = bookService.bookSearch(param);
		
		model.addAttribute("bookList", bookList);
		
		return "books/bookSearchResultView"; // 뷰 페이지 반납
	}	
	
	
}
