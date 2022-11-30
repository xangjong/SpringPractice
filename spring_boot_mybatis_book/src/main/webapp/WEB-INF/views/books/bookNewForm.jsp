<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
		<title>도서 등록 폼</title>
		<script src="<c:url value='/js/jquery-3.6.0.min.js' />"></script>
		<script src="<c:url value='/js/bookNoCheck.js' />"></script>
	</head>
	<body>
		<h3>도서 등록</h3>
		<form method="post" action ="<c:url value='/books/insertBook'/>">
		
		<table>
			<tr>
				<td>도서번호</td><td><input type="text" id="bookNo" name="bookNo">
				<button id="bookCheckBtn">도서 중복 확인</button>
				</td>
			</tr>
			<tr>
				<td>도서명</td><td><input type="text" name="bookName"></td>
			</tr>
			<tr>
				<td>가격</td><td><input type="text" name="bookPrice"></td>
			</tr>
			<tr>
				<td>출판사</td><td><input type="text" name="bookPub"></td>
			</tr>
			<tr>
				<td>출간일</td><td><input type="date" name="bookDate"></td>
			</tr>
			<tr><td colspan="2">
				<input type="submit" value="등록">
				<input type="reset" value="취소">
			</tr>
		</table>
		</form><br><br>
		
			<a href="<c:url value='/'/>">메인 화면으로 이동</a><br><br>
	</body>
</html>