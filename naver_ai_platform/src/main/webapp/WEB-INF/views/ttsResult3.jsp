<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>TTS</title>
		<script src="<c:url value='/js/jquery-3.6.0.min.js' />"></script>
      	<script src="<c:url value='/js/tts3.js' />"></script>
	</head>
	<body>
		<h3>TTS3 : 업로드한 텍스트 파일 내용도 함께 받아서 출력</h3>
		
		<!-- 파일 업로드  -->
		<h3>파일 업로드</h3>
		<form id="ttsForm" enctype="multipart/form-data">
			파일 : <input type="file" id="uploadFile" name="uploadFile">
			<br><br>
			<select name="lang">
				<option value="dara_ang">아라(한국어, 여성)</option>
				<option value="njoonyoung">준영(한국어, 남성)</option>
				<option value="djoey">조이(영어, 여성)</option>
				<option value="matt">매트(영어, 남성)</option>
				<option value="nnaomi">나오미(일본어, 여성)</option>
				<option value="shinji">신지(일본어, 남성)</option>
				<option value="meimei">메이메이(중국어, 여성)</option>
				<option value="liangliang">량량(중국어, 남성)</option>
				<option value="carmen">카르멘(스페인어, 여성)</option>
				<option value="jose">호세(스페인어, 남성)</option>
			</select><br><br>
			
			<input type="submit" value="결과 확인">
		</form>
		<br><br>
		
		<h3>음성</h3>
		<div id="audioBox">
			<audio preload="auto" controls></audio>
		</div><br><br>
		
		<h3>음성 파일명</h3>
		<div id="resultBox">
			
		</div><br><br>
		
		<h3>파일 내용</h3>
		<div id="resultTextBox"></div>
		
		<br><br>
		<a href="<c:url value='/'/>">index 페이지로 이동</a>
	</body>
</html>