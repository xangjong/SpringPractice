<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
		<title>상품 등록 결과</title>
	</head>
	<body>	
			상품번호 :${prdNo }<br>
			상품명 :${prdName }<br>
			가격 :${prdPrice }<br>
			제조회사 :${prdCompany }<br>
			제조일 :${prdDate }<br>
			재고 :${prdStock }<br>
			url <br>
			상품번호 : <a href="/project/product/productDetailView/${prdNo}">${prdNo }</a>
	</body>
</html>