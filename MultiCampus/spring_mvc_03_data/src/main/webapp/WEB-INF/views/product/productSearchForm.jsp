<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
		<title>상품 검색 기능 추가</title>
	</head>
	<body>
		<h3>상품 검색</h3>
		<form method="post" action="/project/product/productSearch">
			<select name="type">
				<option value ="">검색 조건 선택</option>
				<option value ="prdNo">상품번호</option>
				<option value ="prdName">상품명</option>
				<option value ="prdPrice">가격</option>
				<option value ="prdCompany">제조회사</option>
				<option value ="prdDate">제조일</option>
				<option value ="prdStock">재고</option>
			</select>
			<input type="text" name="keyword">
			<input type="submit" value="검색">
		</form>
	</body>
</html>