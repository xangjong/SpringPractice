<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
		<title>도서 검색 결과</title>
	</head>
	<body>
		<table border="1" width="600">
			<tr>
				<th>도서번호</th>
				<th>도서명</th>
				<th>가격</th>
				<th>출판사</th>
				<th>출간일</th>
				<th>사진</th>
			</tr>
			
			<c:choose>
				<c:when test="${empty bookList }">
					<tr align="center">
						<td colspan="6">찾는 도서가 없습니다.</td>
					</tr>
				</c:when>
				
				
				<c:otherwise>
					<c:forEach var="book"  items="${bookList}">
					    <tr align="center">
					    	<td><a href="<c:url value='/books/bookDetailView/${book.bookNo}'/>">${book.bookNo }</a></td>
					    	<td>${book.bookName }</td>
							<td>${book.bookPrice }</td>
							<td>${book.bookPub }</td>
							<td><fmt:formatDate value="${book.bookDate}" pattern="yyyy-MM-dd"/></td>
					    	<td><img src="<c:url value='/images/${book.bookNo}.PNG'/>" width='30' height='20'></td>
				    	</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</table>
	</body>
</html>