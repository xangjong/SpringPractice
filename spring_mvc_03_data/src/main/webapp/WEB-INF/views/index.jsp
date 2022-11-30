<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>index</title>
</head>
<body>
	<h3>index</h3><br>
	<a href="/project/showInfo">showInfo 페이지로 이동</a><br><br>
	<a href="/project/showInfo2">showInfo2 페이지로 이동</a><br><br>
	<a href="/project/showInfo3">showInfo3 페이지로 이동 </a><br><br>
	
	<hr> 
	
	<h3>book Info</h3><br>
	<a href="/project/bookInfoView1">bookInfo1 페이지로 이동</a><br><br>
	<a href="/project/bookInfoView2">bookInfo2 페이지로 이동</a><br><br>
	<a href="/project/book/bookInfoView3">bookInfo3 페이지로 이동</a><br><br>
	<a href="/project/book/bookInfoView4">bookInfo4 페이지로 이동</a><br><br>
	
	<hr>
	
	<h3>학생 정보</h3>
	<a href="/project/student/studentForm">studentForm</a><br><br>
	<a href="/project/student/studentForm2">studentForm2</a><br><br>
	<a href="/project/student/studentForm3">studentForm3</a><br><br>
	<a href="/project/student/studentForm4">studentForm4</a><br><br>
	<a href="/project/student/studentSearchForm">학생 검색</a><br><br>
	
	<hr>
	
	<h3>상품 등록</h3>
	<a href="/project/product/productForm">productForm</a><br><br>
	<a href="/project/product/productForm2">productForm2</a><br><br>
	<a href="/project/product/productForm3">productForm3</a><br><br>
	<a href="/project/product/productSearchForm">상품 검색</a><br><br>
	<hr>
	
	<h3>요청 경로 주의</h3>
	<a href="/project/newView">newView 페이지</a><br><br>
	<a href="project/newView">newView 페이지</a><br><br> <!-- 실행되지 않음 -->
	<!-- 상대 경로로 찾음. 현재 위치가 ContextPath(/project).
		현재 위치를 기준으로 project를 찾고 그 안의 newView를 찾음
	  -->
	<a href="newView">newView 페이지</a><br><br> <!-- 현재 위치를 기준으로 찾음 -->
</body>
</html>