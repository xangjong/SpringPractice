<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>TTS</title>
		<script src="<c:url value='/js/jquery-3.6.0.min.js' />"></script>
      	<script src="<c:url value='/js/tts.js' />"></script>
	</head>
	<body>
		<h3>TTS</h3>
		
		<!-- 파일 업로드  -->
		<h3>파일 업로드</h3>
		<form id="ttsForm" enctype="multipart/form-data">
			파일 : <input type="file" id="uploadFile" name="uploadFile">
			<input type="submit" value="확인"><br><br>
		</form>
		<hr>
		<br><br>
		
		<h3>음성</h3>
		<div id="audioBox">
			<audio preload="auto" controls></audio>
		</div>
		
		<h3>음성 파일명</h3>
		<div id="resultBox"></div>
		<a href="<c:url value='/' />">index 페이지로 이동</a>
	</body>
</html>