<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Chatbot Service</title>
		<script src="<c:url value='/js/jquery-3.6.0.min.js'/>"></script>
		<script src="<c:url value='/js/chatbotJSON.js'/>"></script>
		<link rel="stylesheet"  type="text/css" href="/css/chatbot.css">
	</head>
	
	<body>
		<div id="wrap">
		
			<!-- Header -->
			<div id="chatHeader">
				<span>챗봇</span>
				<button id="btnClose">X</button>
			</div>
			
			<!-- 채팅 내용 출력 영역  -->
			<div id="chatBox"></div>
			
			<div>
				<form id="chatForm" name="chatForm">
					<input type="text" id="message" name="message" size="30"  placeholder="질문을 입력하세요"/>
					<input type="submit" value="전송">
				</form>
			</div>
			
			<br><br>	
			
			음성 메세지 <button id ="record">녹음</button>
			<button id ="stop">정지</button>
			<div id="sound-clips"></div>
			
			<br><br>	
			
			<div>
				<audio id="audio" preload="auto" controls></audio>
			</div>
			
			<br><br>
			
			<a href="<c:url value='/'/>">index 페이지로 이동</a>	
		</div>
	</body>
</html>