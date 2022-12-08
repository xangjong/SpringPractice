<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
		<title>인덱스 페이지</title>
	</head>
	<body>
		<h3>도서 index 페이지</h3>
		
		<a href="<c:url value='/books/bookAllList'/>">전체 도서 조회</a><br><br>
		<a href="books/bookAllList">전체 도서 조회</a><br><br>
		
		<a href="<c:url value='/books/bookNewForm'/>">도서 등록</a><br><br>
		<a href="books/bookNewForm">도서 등록</a><br><br>
		
		<a href="<c:url value='/books/bookSearchForm'/>">도서 검색</a><br><br>
		<a href="books/bookSearchForm">도서 검색</a><br><br>
		
		
		
		
	</body>
</html>