<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
		<title>음성 녹음 테스트</title>
		<script src="<c:url value='/js/jquery-3.6.0.min.js' />"></script>
      	<script src="<c:url value='/js/voiceRecord.js' />"></script>
	</head>
	<body>
		<button id ="record">녹음</button>
		<button id ="stop">정지</button>
		<div id="sound-clips"></div>
		<br><br>
		<a href="<c:url value='/'/>">index 페이지로 이동</a>
		
	</body>
</html>