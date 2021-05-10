<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
		prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home.jsp</title>
</head>
<body>
	<h1> 홈 화면입니다</h1>
	<form action="food/insert">
		<button>섭취정보등록</button>
		</form>
	<c:forEach items="${myFoodList}" var="MF">
		<p>
			<a href="insert/">섭취정보등록</a>	
			${MF.mf_date }
			${MF.mf_name }
			${MF.mf_value }
			${MF.mf_total }
			${MF.mf_sugar }
		
		</p>
		</c:forEach>
		
</body>
</html>