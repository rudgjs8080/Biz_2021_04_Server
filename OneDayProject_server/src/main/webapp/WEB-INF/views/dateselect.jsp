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
	<h1>날짜조회</h1>
	<c:forEach items="${FoodDate }" var="FD">
	<p>
	날짜 : ${FD.mf_date } 
	식품명 : ${FD.mf_fname }
	제공량 :${FD.mf_value }
	총내용량 : ${FD.mf_total }
	에너지 :${FD.mf_energy }
	단백질 : ${FD.mf_protein }
	지방 : ${FD.mf_fat }
	탄수화물 : ${FD.mf_carbon }
	총당류 : ${FD.mf_sugar}
	</p>
	</c:forEach>
	
</body>
</html>