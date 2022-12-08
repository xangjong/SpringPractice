<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
 
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<style>
		th { background-color:skyblue;
			color:#fff;
		}
	</style>
		<title>전체 도서 조회</title>
	</head>
	<body>
		<h3>전체 도서 조회</h3>
		<table border="1">
			<tr align="center">
				<th>도서 번호</th>
				<th>도서명</th>
				<th>가격</th>
				<th>출판사</th>
				<th>출간일</th>
				<th>사진</th>
			</tr>
			
			<c:forEach var= "book" items= "${bookList }">
			<tr>
				<td><a href="<c:url value='/books/bookDetailView/${book.bookNo}'/>">${book.bookNo }</a></td>
				<td>${book.bookName }</td>
				<td>${book.bookPrice }</td>
				<td>${book.bookPub }</td>
				<td><fmt:formatDate value="${book.bookDate}" pattern="yyyy-MM-dd"/></td>		
				<td><img src="<c:url value='/images/${book.bookNo}.PNG'/>" width='30' height='20'></td>
			</tr>
			
			</c:forEach>
		</table> <br>
		
		<a href="<c:url value='/'/>">메인 화면으로 이동</a><br><br>
		
	
	</body>
</html>