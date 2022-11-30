<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<!DOCTYPE html>
<html>
		<head>
		<meta charset="UTF-8">
	<title>유명인 얼굴 인식 결과</title>
	</head>
	<body>
		<h3>유명인 얼굴 인식</h3>
			<form id="celebrityForm" method="post" action="<c:url value='/celFaceRecg'/>" enctype="multipart/form-data">
			파일 : <input type="file" id="uploadFile" name="uploadFile">
			<input type="submit" value="결과 확인">			
		</form>
		
		<hr>
			
		<c:if test="${not empty celList }">
			<h3>유명인 얼굴 인식 결과</h3>		
			<table border="1" width="400">
				<tr><th>유명인</th><th>정확도</th></tr>
			
				<c:forEach items="${celList}" var="cel">
					<tr><td>${cel.value}</td>
					<td><fmt:formatNumber value="${cel.confidence}" pattern="0.0000"/></td> </tr>
				</c:forEach>			
			</table>		
		</c:if>
		<br><br>
		
		<c:if test="${not empty fileName }">
				<img src="/images/${fileName}">
		</c:if>
		
		<br><br>
		<a href="<c:url value='/'/>">index 페이지로 이동</a>
	</body>
</html>