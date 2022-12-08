<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>전체 상품 조회</title>
		
	</head>
	<body>
		<h3>전체 상품 조회</h3>
		<table border="1">
			<tr>
				<th>상품번호</th>
				<th>상품명</th>
				<th>가격</th>
				<th>제조사</th>
				<th>재고</th>
				<th>제조일</th>
				<th>사진</th>
			</tr>
			<c:forEach var="prd" items="${prdList}">
			<tr>
				<td><a href="<c:url value='/product/productDetailView/${prd.prdNo}'/>">${prd.prdNo}</a></td>
				<td>${prd.prdName}</td>
				<td>${prd.prdPrice}</td>
				<td>${prd.prdCompany}</td>
				<td>${prd.prdStock}</td>
				<td><fmt:formatDate value="${prd.prdDate}" pattern="yyyy-MM-dd"/></td>
				<td><img src="<c:url value='/images/${prd.prdNo}.PNG'/>" width='30' height='20'></td>
			</tr>
			</c:forEach>
		</table> <br>
		
		<a href="<c:url value='/'/>">메인 화면으로 이동</a><br><br> 
	</body>
</html>