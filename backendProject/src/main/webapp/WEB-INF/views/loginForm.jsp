<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>로그인</title> 
		<script src="<c:url value='/js/jquery-3.6.0.min.js' />"></script>
		<script src="<c:url value='/js/login.js' />"></script>
		<link rel="stylesheet" type="text/css" href ="<c:url value='/css/login.css'/>">
		
	</head>
	<body>
		<h2>로그인</h2>
		<h3></h3>
		<form id="loginForm" name="loginForm" method="post"  action="<c:url value='/login'/>">
			<table>
				<tr>
					<td>아이디</td>
					<td><input type="text" id="id" name="id" ></td>
				</tr>
			
				<tr>
					<td>비밀번호</td>
					<td><input type="password" id="pw" name="pw"></td>
				</tr>
					
			</table>
				<div class="btnBox">
					<input type="submit" value="로그인" id="loginBtn">
					<input type="reset" value="취 소" id="resetBtn">
				</div>
		</form>	
	</body>
</html>


