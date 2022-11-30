<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>stt2 결과</title>
		<script src="<c:url value='/js/jquery-3.6.0.min.js' />"></script>
		<script src="<c:url value='/js/stt2.js' />"></script>
	</head>
	<body>
		<!-- 파일 업로드 -->
		<h3>STT</h3>
		<form id="sttForm2" method="post" enctype="multipart/form-data">
			언어 선택 : <select name="lang">
						<option value="Kor" selected>한국어</option>
						<option value="Jpn">일본어</option>
						<option value="Eng">영어</option>
						<option value="Chn">중국어</option>
					</select><br><br>
			파일 : <input type="file" id="uploadFile" name="uploadFile">
			<input type="submit" value="결과 확인"><br><br>
		</form>
		<hr>
		<br><br>
		
		<!-- 결과 출력 -->	
		<h3>텍스트</h3>
		<div id="resultBox"></div>
		<br><br>
		
		<h3>오디오</h3>
		<div id="audioBox">
			<audio preload=”auto” controls></audio>
		</div>
		<br><br>
		
		<h3>번역</h3>
		<div id="transBox"></div>
		<br><br>		
		
		<a href="<c:url value='/' />">index 페이지로 이동</a>
	</body>
</html>
