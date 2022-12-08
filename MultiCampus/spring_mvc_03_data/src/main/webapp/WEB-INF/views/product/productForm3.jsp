<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
		<title>상품 등록 예제</title>
	</head>
	<body>
		<h3>상품 등록</h3>
			<form method="post" action="/project/product/newProduct3">
				<span>상품번호</span> : <input type="text" name="prdNo"><br>
				<span>상품명</span> : <input type="text" name="prdName"><br>
				<span>가격</span> : <input type="text" name="prdPrice"><br><br>
				<span>제조회사</span>: <input type="text" name="prdCompany"><br><br>
				<span>제조일</span> : <input type="text" name="prdDate"><br><br>
				<span>재고</span> : <input type="text" name="prdStock"><br><br>
				<input type="submit" value="등록"><input type="reset" value="취소">		
			</form>
	</body>
</html>