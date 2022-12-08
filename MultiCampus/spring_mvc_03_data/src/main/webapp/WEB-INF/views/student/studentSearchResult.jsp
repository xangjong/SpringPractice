<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>학생 검색 결과</title>
	</head>
	<body>
		<h2>검색 결과</h2>
		
		<table border="1">
			<tr><th>학번</th><th>성명</th><th>학년</th></tr>
			<c:forEach var="std"  items="${stdList}">
			    <tr>
			    	<td>${std.stdNo}</td>
			    	<td>${std.stdName}</td>
			    	<td>${std.stdYear}</td>
		    	</tr>
			</c:forEach>
		</table>
	</body>
</html>