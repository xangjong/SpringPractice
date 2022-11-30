<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>객체 탐지 결과</title>
		<script src="<c:url value='/js/jquery-3.6.0.min.js'/>"></script>
		<script src="<c:url value='/js/object.js'/>"></script>
	</head>
	<body>
		<!-- 파일 업로드 -->
		<h3>객체 탐지</h3>
			<form id="objectForm"  enctype="multipart/form-data">
			파일 : <input type="file" id="uploadFile" name="uploadFile">
			<input type="submit" value="결과 확인">			
		</form>
		<hr>
		<br><br>
		
		<!-- 결과 출력 -->
		<h3>객체 탐지 결과를 이미지에  박스로 표시</h3>
		<canvas id="objectCanvas"  width="600" height="600"></canvas>
		<br><br>
		
		<!-- 각 신체부위와 좌표 값 출력 -->
		<div id="resultBox"></div>
		
		
		<br><br>
		<a href="<c:url value='/'/>">index 페이지로 이동</a>
	</body>
</html>