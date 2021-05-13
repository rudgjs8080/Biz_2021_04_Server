<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	*{
		box-sizing : border-box;
	}
	
	h1, form{
		width: 80%;
		margin:10px auto;
	}
	h1 {
		background-color: rgba(0,255,0,0.3);
		color:white;
		padding : 1.2rem;
		text-align: center;
	}
	form{
		border: 1px solid green;
		border-radius: 20px;
		padding:10px;
	}
	label{
		display: inline-block;
		width: 20%;
		text-algn: right;
	}
	
	input{
		width: 50%;
		padding : 8px;
		text-align:  left;
	}
	button{
		background-color: lightblue;
		color: white;
		padding: 8px;
		width:10%;
		outline:0;
		border: 0;
		border-radius: 50px;
		cursor:pointer;
	}
	button:hover{
	/*x-offset, y-offset blue spread shcolar*/
		box-shadow: 5px 5px 5px rgba(0,0,0,3))
	}
</style>
</head>
<body>
	<h1>식품 섭취 내역 입력</h1>
	<form method="POST">
		<p><label>식품코드</label>
			<input name="mf_code" value="${FOOD.fd_code }">
		<p><label>식품이름</label>
			<input name="mf_name" value="${FOOD.fd_name }">
		<p><label>섭취일자</label>
			<input type="date" name="mf_date" value="${TODAY }">
		<p><label>섭취량 </label>
			<input type="number" name="mf_amt">
		<p><button>등록</button>
	</form>
</body>
</html>