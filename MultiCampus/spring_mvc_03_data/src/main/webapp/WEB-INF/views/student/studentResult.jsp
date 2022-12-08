<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
		<title>학생 정보 등록 결과</title>
	</head>
	<body>
		학번 : ${stdNo }<br>
		성명 : ${stdName }<br>
		학년 : ${stdYear }<br>
		url을 통한 데이터 전달<br>
		학번 : <a href="/project/student/studentDetailView/${stdNo}">${stdNo }</a>
	</body>
</html>