<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>index</title>
	</head>
	<body>
		<h3>mybatis 사용</h3>
	
		<a href="/mybatis/product/productAllList">전체 상품 조회</a><br><br>
		
		<a href="product/productNewForm">상품 등록</a><br><br>
		
		<img src="/mybatis/resources/image/apple.png">
		<img src="img/apple.png">
		<img src="<c:url value='img/apple.png'/>">
		
		<hr>
		<h3>ajax</h3>
		<a href="loginForm">로그인(로그인 폼으로 이동)</a><br><br>
		<a href="loginForm2">로그인2(로그인 폼으로 이동/포워딩)</a><br><br>
		
		<a href="product/productSearchForm1">상품 검색1</a><br><br>
		<a href="product/productSearchForm2">상품 검색2</a><br><br>
		
		<h3>@RestController</h3>
		<a href="product/productSearchForm3">상품 검색3</a><br><br>
	</body>
</html>