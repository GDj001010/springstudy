<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${contextPath}/resources/js/lib/jquery-3.6.4.min.js"></script>
<link rel="stylesheet" href="${contextPath}/resources/css/init.css" />
<script>
	$(function(){
		$('#title').text('Hello World');
	})
	function fn1(){
		$('#frm').empty();
		
		$.ajax({
			type: 'get',
			url: '${contextPath}/test/person',
			data: $('#frm').serialize(),
			dataType: 'json',
			success: function(resData){
				$('#box1').text(resData.name);
				$('#box2').text(resData.age);
			}
		})
	}
</script>
</head>
<body>


	<h1 id="title"></h1>
	<div>
		<img src="${contextPath }/resources/images/animal1.jpg" width="300px">
	</div>
	
	<a href="${contextPath }/list.do">목록보기</a>
	
	<hr>
	
	<h1>요청 파라미터1</h1>
	<div><a href="${contextPath }/detail.do">상세보기1</a></div>
	<div><a href="${contextPath }/detail.do?name=한글">상세보기2</a></div>
	<div><a href="${contextPath }/detail.do?age=24">상세보기3</a></div>
	<div><a href="${contextPath }/detail.do?name=한글&age=24">상세보기4</a></div>

	<hr>
	
	<div>
		<form id="frm">
			<div>
				<label for="name">이름</label>
				<input id="name" name="name">
			</div>
			<div>
				<label for="age">나이</label>
				<input id="age" name="age">
			</div>
			<div>
				<input type="button" value="전송" onclick="fn1()">
			</div>
		</form>
	</div>

	<div id="box1"></div>
	<div id="box2"></div>


















</body>
</html>