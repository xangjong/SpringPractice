package com.spring_mvc.mybatis.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring_mvc.mybatis.model.ProductVO;
import com.spring_mvc.mybatis.service.ProductService;

@RestController
public class ProductRestController {
	
	
	@Autowired
	ProductService prdService;
	
	// 상품 검색 : 방법1
	@ResponseBody
	@RequestMapping("/product/productSearch3")
	public ArrayList<ProductVO> productSearch1(@RequestParam HashMap<String, Object> param,
												Model model){
		ArrayList<ProductVO> prdList = prdService.productSearch(param);
		model.addAttribute("prdList", prdList);
		
		return prdList;
	}
}
