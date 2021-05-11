<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home.jsp</title>
</head>
<body>
	<h1>섭취 내역</h1>
	<c:forEach items="${myFoodList}" var="MF">
		<p>${MF.mf_date } ${MF.mf_fname } ${MF.mf_value } ${MF.mf_total }
			${MF.mf_sugar }</p>
	</c:forEach>
	<form action="food/dateselect">
		<input name="mf_date" />
		<button>날짜조회</button>
	</form><br/>
	<form action="food/insert">
		<button>섭취정보등록</button>
		
	</form>

</body>
</html>