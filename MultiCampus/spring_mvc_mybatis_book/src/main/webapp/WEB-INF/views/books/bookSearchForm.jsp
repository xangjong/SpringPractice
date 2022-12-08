<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>도서 검색</title>
		<script src="<c:url value='/js/jquery-3.6.0.min.js'/>"></script>
		<script src="<c:url value='/js/bookSearch.js'/>"></script>
	</head>
	<body>
		<h3>도서 검색</h3>
		<form id="bookSearchFrm">
			<select name="type">
				<option value="">검색</option>
				<option value="bookName">도서명</option>
				<option value="bookPub">출판사</option>
			</select>
			<input type="text" name="keyword">
			<input type="submit" value="검색">
		</form>
		
		<div id="searchResultBox"></div><br><br>
	
		<a href="<c:url value="/"/>">메인 화면으로 이동</a>	
	</body>
</html>