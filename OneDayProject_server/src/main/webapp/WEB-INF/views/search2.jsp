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
	<c:forEach items="${FOOD }" var="F">
	<h1>날짜와 섭취량을 입력하세요</h1>
	<form action="search3">
		제품명 : <input name="f_name" value="${F.f_name }"/><br/>
		제조사코드 : <input name="c_code" value="${F.f_code }"/><br/>
		날짜 : <input name="mf_date" /><br/>
		섭취량 : <input name="mf_value" /><br/>
		<button>전송</button>
	</form>
	</c:forEach>
	
	
</body>
</html>