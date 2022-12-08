package com.spring_mvc.mybatis.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.spring_mvc.mybatis.dao.IProductDAO;
import com.spring_mvc.mybatis.model.ProductVO;

@Service
public class ProductService implements IProductService {
	// MyBatis 사용하는 경우
	@Autowired
	@Qualifier("IProductDAO")
	IProductDAO prdDAO;
	
	
	@Override
	public ArrayList<ProductVO> listAllProduct() {
		return prdDAO.listAllProduct();
	}

	@Override
	public void insertProduct(ProductVO prd) {
		prdDAO.insertProduct(prd);

	}

	@Override
	public void updateProduct(ProductVO prd) {
		prdDAO.updateProduct(prd);

	}

	@Override
	public void deleteProduct(String prdNo) {
		prdDAO.deleteProduct(prdNo);

	}

	@Override
	public ProductVO detailViewProduct(String prdNo) {
		return prdDAO.detailViewProduct(prdNo);
		 
	}

	@Override
	public String prdNoCheck(String prdNo) {
		return prdDAO.prdNoCheck(prdNo);
	}

	@Override
	public ArrayList<ProductVO> productSearch(HashMap<String, Object> map) {
		return prdDAO.productSearch(map);
	}
	
	
}
