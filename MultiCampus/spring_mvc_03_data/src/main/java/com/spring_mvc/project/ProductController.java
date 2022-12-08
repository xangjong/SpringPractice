package com.spring_mvc.project;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
	// index에서 studentForm 페이지 요청 처리
	@RequestMapping("/product/productForm")
	public String productFormView() {
		return "product/productForm";	// student 폴더 안의 studentForm.jsp
	}
	
	@RequestMapping("/product/productForm2")
	public String productFormView2() {
		return "product/productForm2";	// student 폴더 안의 studentForm.jsp
	}
	
	@RequestMapping("/product/productForm3")
	public String productFormView3() {
		return "product/productForm3";	// student 폴더 안의 studentForm.jsp
	}
	
	// View 페이지로부터 전달된 데이터 처리
	
	// (1)HttpServletRequest 클래스의 getParameter() 메서드 사용
	@RequestMapping("/product/newProduct")
	public String newProduct(HttpServletRequest request, Model model) {
		// form의 각 <input> 태그의 name 속성 값으로 전달된 값 받기
		String prdNo = request.getParameter("prdNo");
		String prdName = request.getParameter("prdName");
		String prdPrice = request.getParameter("prdPrice");
		String prdCompany = request.getParameter("prdCompany");
		String prdDate = request.getParameter("prdDate");
		String prdStock = request.getParameter("prdStock");
		
		// model로 설정 : view 페이지로 전달
		model.addAttribute("prdNo", prdNo);
		model.addAttribute("prdName", prdName);
		model.addAttribute("prdPrice", prdPrice);
		model.addAttribute("prdCompany", prdCompany);
		model.addAttribute("prdDate", prdDate);
		model.addAttribute("prdStock", prdStock);
		
		return "product/productResult";
	}	
	
	@RequestMapping("/product/newProduct2")
	public String newProduct2(@RequestParam("prdNo")String prdNo,
						     @RequestParam("prdName")String prdName,
						     @RequestParam("prdPrice")String prdPrice,
							  @RequestParam("prdCompany")String prdCom,
							  @RequestParam("prdDate")String prdDate,
							  @RequestParam("prdStock")String prdStock,
							  Model model) {
		
		model.addAttribute("prdNo", prdNo);
		model.addAttribute("prdName", prdName);
		model.addAttribute("prdPrice", prdPrice);
		model.addAttribute("prdCompany", prdCom);
		model.addAttribute("prdDate", prdDate);
		model.addAttribute("prdStock", prdStock);
		
		return "product/productResult";
	}
	
	
	// (3) Command 객체 사용
		@RequestMapping("product/newProduct3")
		public String newProduct3(Product product) {
			System.out.println(product.getPrdNo());
			System.out.println(product.getPrdName());
			System.out.println(product.getPrdPrice());
			System.out.println(product.getPrdCompany());
			System.out.println(product.getPrdDate());
			System.out.println(product.getPrdStock());
			
			return "product/productResult3"; 
		}
		
		@RequestMapping("/product/productDetatilView/{prdNo}")
		public String productDetailView(@PathVariable String prdNo) {
			
			return "index";

		}
		
		@RequestMapping("/product/productSearchForm")
		public String productSearchForm() {
			return "product/productSearchForm";
		}
		
		
		@RequestMapping("/product/productSearch")
		public String productSearch(@RequestParam HashMap<String, Object> param, Model model) {
			
			System.out.println(param.get("type"));
			System.out.println(param.get("keyword"));
			
			Product prd1 = new Product();
			
			prd1.setPrdNo("1");
			prd1.setPrdName("노트북");
			prd1.setPrdPrice(1000000);
			prd1.setPrdCompany("삼성");
			prd1.setPrdDate("2020-01-01");
			prd1.setPrdStock(10);
			
			Product prd2 = new Product();
			
			prd2.setPrdNo("3");
			prd2.setPrdName("핸드폰");
			prd2.setPrdPrice(2000000);
			prd2.setPrdCompany("삼성");
			prd2.setPrdDate("2020-02-01");
			prd2.setPrdStock(6);
			
			ArrayList<Product> prdList = new ArrayList<Product>();
			prdList.add(prd1);
			prdList.add(prd2);
			
			model.addAttribute("prdList", prdList);
			
			return "product/productSearchResult";
		}
}














