<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath }" var="rootPath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>write.jsp</title>
<style>
form.v1 {
	width: 50%;
	margin: 10px auto;
}

form.v1 fieldset {
	border: 1px solid blue;
	border-radius: 10px;
	padding: 5px;
}

form.v1 label, 
form.v1 input,
form.v1 textarea {
	display: inline-block;
	padding: 5px;
	margin: 5px;
}

form.v1 label {
	width: 150px;
	text-align: right;
}

form.v1 input, 
form.v1 textarea {
	width: 300px;
	border: 1px solid green;
	border-radius: 5px;
}

form.v1 button {
	outline: 0;
	border: 0;
	width: 100px;
	color: white;
	padding: 5px;
}
/* button:nth~ 띄어쓰기 유의하기*/
form.v1 button:nth-child(2) {
	background-color: green;
}

form.v1 button:nth-child(3) {
	background-color: orange;
}

form.v1 button:nth-child(4) {
	background-color: red;
}

form.v1 button:hover {
	box-shadow: 2px 2px 2px rgba(0, 0, 0, 0.3);
}

form.v1 div:nth-child(8) {
	width: 460px;
	margin: 0px auto;
	border: 1px green;
	text-align: right;
}
</style>
<script>
// script를 본문 어디에나 두기위해
// ducument에 Event 설정
// 화면에 모든 요소가 다 드려지면...
	document.addEventListener("DOMContentLoaded", function(){
		document.querySelector("button.btn_save")
		.addEventListener("click", function(ev){
			
			let dom = document;
			let gb_writer = dom.querySelector("input[name='gb_writer']");
			let gb_email = dom.querySelector("input[name='gb_email']");
			let gb_password = dom.querySelector("input[name='gb_password']");
			let gb_content = dom.querySelector("textarea");
			
			if(gb_writer.value == ""){
				alert("작성자 이름은 반드시 입력해야 합니다")
				gb_writer.focus();
				// 이벤트 코드 진행을 멈춰라
				return false;
			}
			
			if(gb_email.value == ""){
				alert("작성자 이메일을 입력하세요");
				gb_email.focus()
				return false;
			}
			
			if(gb_password.value == ""){
				alert("작성자 비밀번호를 입력하세요");
				gb_password.focus()
				return false;
			}
			
			if(gb_content.value == ""){
				alert("내용을 입력하세요");
				gb_content.focus()
				return false;
			}
			alert("저장버튼" + "\n"
			+ gb_writer.value + "\n"
			+ gb_email.value + "\n"
			+ gb_password.value + "\n"
			+ gb_content.value + "\n"
			)
			// 서버에 전송하라(submit)
			dom.querySelector("form.v1").submit();
		})
	})
</script>
</head>
<body>
	<%@ include file="/WEB-INF/views/include_nav.jsp"%>
	<form class="v1" method="POST">
		<fieldset>
			<legend>방명록쓰기</legend>
			<div>
				<label>작성일자</label> <input name="gb_date" type="date"
					value="${GB.gb_date }">
			</div>
			<div>
				<label>작성시간</label> <input name="gb_time" type="time"
					value="${GB.gb_time}">
			</div>
			<div>
				<label>작성자</label> <input name="gb_writer" type="text"
					value="${GB.gb_writer}">
			</div>
			<div>
				<label>작성자 email</label> <input name="gb_email" type="email"
					value="${GB.gb_email}">
			</div>
			<div>
				<label>비밀번호</label> <input name="gb_password" type="password">
			</div>
			<div>
				<label>내용</label>
				<textarea name="gb_content"rows="5">${GB.gb_content}</textarea>
			</div>
			<div>
				<label></label>
				<button class="btn_save"type="button">저장</button>
				<button type="reset">다시작성</button>
				<button class="btn_home"type="button">처음으로</button>
			</div>
		</fieldset>
	</form>
</body>
</html>