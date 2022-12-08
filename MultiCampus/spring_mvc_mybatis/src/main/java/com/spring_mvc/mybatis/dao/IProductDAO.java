package com.spring_mvc.mybatis.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.spring_mvc.mybatis.model.ProductVO;

public interface IProductDAO {
	public ArrayList<ProductVO> listAllProduct(); // 전체 상품 정보 조회
	public void insertProduct(ProductVO prd); // 상품 정보 등록
	public void updateProduct(ProductVO prd); // 상품 정보 수정
	public void deleteProduct(String prdNo); // 상품 정보 삭제
	public ProductVO detailViewProduct(String prdNo); // 상세 상품 정보 조회(1개의 상품만 조회)
	public String prdNoCheck(String prdNo); // 상품번호 중복 체크
	public ArrayList<ProductVO> productSearch(HashMap<String, Object> map); // 상품 검색
}
