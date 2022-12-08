<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
		<title>상품 검색 결과</title>
	</head>
	<body>
		<h2>검색 결과</h2>
		
		<table border="1">
			<tr>
				<th>상품번호</th><th>상품명</th><th>가격</th>
				<th>제조회사</th><th>제조일</th><th>재고</th>
			</tr>
			<c:forEach var="prd"  items="${prdList}">
			    <tr align="center">
			    	<td>${prd.prdNo}</td>
			    	<td>${prd.prdName}</td>
			    	<td>${prd.prdPrice}</td>
			    	<td>${prd.prdCompany}</td>
			    	<td>${prd.prdDate}</td>
			    	<td>${prd.prdStock}</td>
		    	</tr>
			</c:forEach>
		</table>
	</body>
</html>