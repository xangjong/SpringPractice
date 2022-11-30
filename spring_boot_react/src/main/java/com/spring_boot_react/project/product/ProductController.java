package com.spring_boot_react.project.product;



import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@CrossOrigin("*") // http://127.0.0.1 또는 localhost 둘다 사용 가능
@RestController
public class ProductController {

		// DI 설정
		@Autowired
		ProductService prdService;
		
		@RequestMapping("/product/productList")
		public HashMap<String, Object> viewProductList(){
			HashMap<String, Object>  map = new HashMap<String, Object>();
			map.put("prdList", prdService.listAllProduct());
			return map;
			
		}
		
		// 상품 상세 정보 조회 : 1개 상품 조회
			@RequestMapping("/product/productDetailView/{prdNo}")
			public ProductVO detailViewProduct(@PathVariable String prdNo) {
				return  prdService.detailViewProduct(prdNo);
			}
			
		// Model 사용 안 하고 view 페이지 리턴없음
	
		
		// 상품 등록 : 상품 정보 DB 저장
		@RequestMapping("/product/insert")
		public String insertProduct(ProductVO prd) {
			prdService.insertProduct(prd);
			
			// DB에 데이터 저장한 후 전체 상품 조회 화면으로 포워딩
			return "redirect:./productAllList";
		}
		
		// 수정 내용 DB 저장
		@RequestMapping("/product/update")
		public void updateProduct(ProductVO prd) {
			prdService.updateProduct(prd);
		}
		
		
		// 상품 정보 삭제
		@RequestMapping("/product/delete/{prdNo}")
		public void deleteProduct(@PathVariable String prdNo) {
			prdService.deleteProduct(prdNo);
			
		}
}

