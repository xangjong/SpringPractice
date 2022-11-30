<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>index 페이지</title>
		
	</head>
	<body>
		<h3>Naver AI Platform 사용</h3>
		
		<a href="<c:url value='/celFaceRecgForm'/>">유명인 언굴 인식</a><br><br>
		<a href="<c:url value='/faceRecogForm'/>">얼굴 감지</a><br><br>
		
		<a href="<c:url value='/poseEstimateForm'/>">포즈 인식</a><br><br>
		<a href="<c:url value='/objectDetectForm'/>">객체 탐지</a><br><br>
		
		<a href="<c:url value='/OCRForm'/>">OCR General</a><br><br>
		<a href="<c:url value='/OCRTemplate'/>">OCR Template</a><br><br>
		
		<a href="<c:url value='/sttForm'/>">STT : Speech To Text</a><br><br>
		<a href="<c:url value='/sttForm2'/>">STT : Speech To Text2</a><br><br>
		
		<a href="<c:url value='/ttsForm'/>">TTS : Text To Speech</a><br><br>
		<a href="<c:url value='/ttsForm2'/>">TTS : Text To Speech2</a><br><br>
		<a href="<c:url value='/ttsForm3'/>">TTS : Text To Speech3</a><br><br>
		
		<a href="<c:url value='/chatbotForm'/>">ChatBot : Text</a><br><br>
		<a href="<c:url value='/chatbotForm2'/>">ChatBot : Text + Voice</a><br><br>
		<a href="<c:url value='/chatbotFormJSON'/>">ChatBotJSON : Text + Voice</a><br><br>
		
		<a href="<c:url value='/voiceRecord'/>">음성 녹음 테스트</a><br><br>

	</body>
</html>
