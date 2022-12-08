<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>로그인 폼2</title>
		<script src="js/jquery-3.6.0.min.js"></script>
		<script src="js/login2.js"></script>
	</head>
	<body>	
	<h3>로그인</h3>	
	  <form id="frmLogin">
		   아이디  :<input type="text" name="user_id" id="user_id"><br>
	     비밀번호:<input type="password" name="user_pw"  id="user_pw" ><br>
	    <input type="submit" value="로그인">  <input type="reset" value="다시입력">
	  </form>
	</body>
</html>