<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
		<title>도서 상세 정보 조회</title>
	</head>
	<body>
		<h3>도서 상세 정보</h3>
		<table border="1" width="500">
			<tr>
				<td>도서 번호</td>
				<td>${book.bookNo }</td>
			</tr>
			
			<tr>
				<td>도서명</td>
				<td>${book.bookName }</td>
			</tr>
			
			
			<tr>
				<td>도서 가격</td>
				<td>${book.bookPrice }</td>
			</tr>
			
			<tr>
				<td>출판사</td>
				<td>${book.bookPub }</td>
			</tr>
			
			<tr>
				<td>출간일</td>
				<td><fmt:formatDate value="${book.bookDate}" pattern="yyyy-MM-dd"/></td>
			</tr>
		</table><br><br>
		
		<a href=" <c:url value='/' />">메인 화면으로 이동</a><br><br>
		
		
		<a href="<c:url value='/books/bookUpdateForm/${book.bookNo}'/>">도서 수정</a><br><br>
		
		
		<a href="javascript:deleteCheck();">도서 정보 삭제</a><br><br>
		<script>
			function deleteCheck(){
				var answer = confirm("삭제하시겠습니까?");
				if(answer){
					location.href="/books/deleteBook/${book.bookNo}";
				}
			}
		</script>
	</body>
</html>