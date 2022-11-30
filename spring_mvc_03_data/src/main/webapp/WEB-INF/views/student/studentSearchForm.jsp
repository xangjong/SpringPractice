<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>학생 정보 검색</title>
	</head>
	<body>
		<h3>학생 검색</h3>
		<form method="post" action="/project/student/studentSearch">
			<select name="type">
				<option value="">검색 조건 선택</option>
				<option value="stdNo">학번</option>
				<option value="stdName">성명</option>
			</select>
			<input type="text" name="keyword">
			<input type="submit" value="검색">
		</form>
	</body>
</html>