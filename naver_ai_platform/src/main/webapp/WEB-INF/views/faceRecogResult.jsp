<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>얼굴 감지 결과</title>
	</head>
		
	<body>
		<h3>얼굴 감지</h3>
		<form id="faceRecogForm" method="post" action="<c:url value='/faceRecog'/>" enctype="multipart/form-data">
			파일 : <input type="file" id="uploadFile" name="uploadFile">
			<input type="submit" value="결과 확인">			
		</form>
		<hr>
		<br><br>	
		
		<c:if test="${not empty faceList}">
			<h3>얼굴 감지 결과</h3>
			<table border="1">
				<tr>
					<th>성별</th><th>성별 정확도</th>
					<th>나이</th><th>나이 정확도</th>
					<th>감정</th><th>감정 정확도</th>
					<th>포즈</th><th>포즈 정확도</th>
				</tr>
				
				<c:forEach items="${faceList}" var="face">
					<tr>
						<td>${face.genderValue}</td>
						<td><fmt:formatNumber value="${face.genderConfidence}" pattern="0.0000"/></td>

						<td>${face.ageValue}</td>
						<td><fmt:formatNumber value="${face.ageConfidence}" pattern="0.0000"/></td>

						<td>${face.emotionValue}</td>
						<td><fmt:formatNumber value="${face.emotionConfidence}" pattern="0.0000"/></td>

						<td>${face.poseValue}</td>
						<td><fmt:formatNumber value="${face.poseConfidence}" pattern="0.0000"/></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		<br><br>
		
		<c:if test="${not empty fileName}">
			<img src="/images/${fileName}">
		</c:if>
		
		<br><br>
		<a href="<c:url value='/'/>">index 페이지로 이동</a>	
	</body>
</html>