<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath }" var="rootPath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${rootPath}/static/css/home.css?ver2021-05-20" rel="stylesheet" />
<style>
	table#gblist tr:hover {
		cursor: pointer;
		background-color: #ddd;
	}
</style>
<script>
document.addEventListener("DOMContentLoaded",function(){
	document.querySelector("table#gblist")
	.addEventListener("click",function(ev){
		// 가장 안쪽 tag (TD)의 이름을 가져와라
		let tag_name = ev.target.tagName;
		// alert(tag_name)
		if(tag_name == "TD"){
			let gb_seq = ev.target.closest("TR").dataset.seq
			document.location.href="${rootPath}/guest/view?gb_seq=" + gb_seq
		}
	})
	
})
</script>

</head>
<body>
	<%@ include file="/WEB-INF/views/include_nav.jsp" %>
	<%--
		메뉴를 설정할 때 사용하는 tag
		div 라는 tag를 사용하여 layout을 설정했는데
		HTML5 에서는  Symatec(의미있는 이름으로) tag를 
		사용하는 것을 권장한다
	 --%>
	
	<table id="gblist">
		<tr>
			<th>작성일</th>
			<th>작성시각</th>
			<th>작성자(email)</th>
		</tr>
		<c:forEach items="${GBLIST }" var="GB">
			<tr data-seq="${GB.gb_seq }">
				<td>${GB.gb_date }</td>
				<td>${GB.gb_time }</td>
				<td>${GB.gb_writer}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>