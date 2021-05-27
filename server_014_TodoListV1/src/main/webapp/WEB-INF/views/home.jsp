<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath }" var="rootPath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>TO DO List</title>
<style>
/* style 지정을 위하여 전체 초기화*/
* {
	border-sizing: border-box;
	margin: 0;
	padding: 0;
}

h1, form.doit, table.td_list {
	width: 50%;
	margin: 10px auto;
	border-radius: 5px;
}

h1 {
	background-color: rgba(0, 255, 0, 0.3);
	color: white;
	padding: 1rem;
	text-align: center;
	text-shadow: 1px 1px 1px #000;
}

form.doit {
	border: 1px solid red;
	padding: 10px;
	text-align: center;
}

form.doit input {
	width: 90%;
	outline: 0; /* box를 클릭하면 진한 box가 생기는 것을 방지*/
	border: 1px solid #eee;
	border-radius: 5px;
	padding: 15px;
	margin: 10px;
	font-weight: bold;
}

form.doit input:hover {
	background-color: #eee;
}

table.td_list {
	border-collapse: collapse;
	/*
		table을 그릴 때 각 td와 td 간격에
		미세하게 여백이 있어서 가끔 선을 그리면
		선과 선 사이에 틈새가 보인다
		이러한 틈새를 막기위해 설정하는 값
		*/
	border-spacing: 0px;
}

table.td_list td {
	padding: 7px;
	border-top: 1px solid green;
	cursor: pointer;
}

table.td_list tr:hover {
	background-color: #eee;
}
/* table의 가장 마지막 tr(line)의 칼럼들에게만 적용*/
table.td_list tr:last-child {
	border-bottom: 1px solid green;
}

table.td_list td.sdate, table.td_list td.edate {
	font-size: 15px;
	text-align: center;
	width: 20%;
}

table.td_list td.doit {
	font-size: 30px;
	text-align: left;
	max-width: 80%;
	max-width: 0px;
	overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;
	/*
	width : 무조건 폭을 지정
	max-width : 포함된 text(content)길이에 따라 조절을 하되 최소 크기만 제한
	
	white-space: nowrap;
	최대한 width보다 text가 더 많더라도
	자동으로 줄바꿈하지 않기 
	*/
}

.underline {
	text-decoration: 2px underline red dashed;
}

.text-throth {
	text-decoration: 3px line-through red wavy;
}

@media screen and (max-width:400px){
	h1, form.doit, table.td_list {
		width: 95%;
		margin: 5px auto;
	}
	
}
</style>
<script>
// scripot가 어디에 위치하든 상관없이
// 이후의 다른 Event가 정상적으로 설정될 수 있도록 선언
// 화면에 DOM 요소가 모두 완전하게 나타나면 
// 내부의 코드를 실행하라
	document.addEventListener("DOMContentLoaded", ()=>{
		// ()=>{ } : 화살표 함수
		// function() {} 와 같다
		document.querySelector("table.td_list")
		.addEventListener("dblclick", (ev)=>{
			// table의 TD 항목이 클릭되었을 때만 반응하기 위해서
			let tagName = ev.target.tagName
			if(tagName == "TD"){
				// 방금 더블클릭된 TD를 감싸고 있는 TR의
				let seq = ev.target.closest("TR")
						.dataset.seq;
				let edate = ev.target.closest("TR")
						.dataset.edate;
				let msg = edate ? "TODO 완료를 취소합니다"
						: "TODO를 완료처리 합니다"
			
				if(confirm(msg)){
					location.href="${rootPath}/sub/expire?seq=" + seq;
				}	
			}
			
			
		})
	})
</script>
</head>
<body>
	<h1>TO DO List</h1>
	<form class="doit" method="POST" action="sub/insert">
		<input name="td_doit" placeholder="할일을 입력한 후 Enter">
	</form>
	<table class="td_list">
		<c:forEach items="${TDLIST}" var="TD">
			<tr data-seq="${TD.td_seq }" data-edate="${TD.td_edate}">
				<td class="sdate ${empty TD.td_edate ? '' :'underline'}">${TD.td_sdate }<br />${TD.td_stime}</td>
				<td class="doit ${empty TD.td_edate ? '' :'text-throth'}">${TD.td_doit }<br /></td>
				<td class="edate">${TD.td_edate }<br />${TD.td_etime}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>