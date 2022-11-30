<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
</head>
<body>
	index 페이지 입니다.<br>
	<P>  현재 시간 : ${serverTime}. </P>
	<img src="/second/resources/image/apple.png"> <br> <br> <br>
	
	<a href="/second/showName">Show Name</a>
</body>
</html>