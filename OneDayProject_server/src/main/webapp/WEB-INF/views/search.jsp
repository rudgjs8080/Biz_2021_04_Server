<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>상품명 조회 결과</h1>
	<c:if test="${empty MF}">상품정보 없음</c:if>
	
	<c:forEach items="${MF }" var="F">
	<p>
	<a href="search2?mf_fname=${F.f_name }">${F.f_name }</a>
	</p>
	
	
	</c:forEach>

</body>
</html>