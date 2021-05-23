<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath }" var="rootPath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home.jsp</title>
</head>
<body>
	<h1>Hello World</h1>
	<c:forEach items="${ST}" var="ST">
		<p>${ST.st_name}</p>
	
	
	</c:forEach>
	<form action="student/view">
	<button>성적리스트 열람하기</button></form>
</body>
</html>