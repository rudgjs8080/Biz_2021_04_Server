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
	<a href="search2?mf_fname=${F.f_name }">제품명 : ${F.f_name }</a>
	제조사코드 : ${F.f_code }
	출시연도 : ${F.f_year }
	제조사명 : ${F.c_name }
	분류명 : ${F.i_name }
	제공량 : ${F.f_one }
	총제공량 : ${F.f_total }
	에너지 : ${F.f_energy }
	단백질 : ${F.f_protein }
	지방 : ${F.f_fat }
	탄수화물 : ${F.f_carbon }
	총당류 : ${F.f_sugar }
	</p>
	</c:forEach>

</body>
</html>