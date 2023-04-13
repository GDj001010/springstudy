<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 사실상 urlMapping으로 인식되어야 하지만 servlet-context.xml로 인해 resources가 들어간 경로는 resources폴더를 열어 찾아준다. -->
<script src="${contextPath }/resources/js/lib/jquery-3.6.4.min.js"></script>
<script>
	function fn1(){
		$('#result').empty();	// 결과창 초기화
	
	
		$.ajax({
			// 요청
			type: 'get',
			url: '${contextPath}/first/ajax1',
			data: 'name=' + $('#name').val() + '&age=' + $('#age').val(),
			//응답
			dataType: 'json',
			success: function(resData){	// resData = {"name": "민경태", "age": 46}
				let str = '<ul>';
				str += '<li>' + resData.name + '</li>';
				str += '<li>' + resData.age + '</li>';
				str += '</ul>';
				$('#result').append(str);	// ul태그를 id가 result인 div 태그 밑에 추가한다.
			}
		})
	
	}
</script>
</head>
<body>

	<div>
		<form id="frm">
			<label for="name">이름</label>
			<input id="name" name="name">
		</form>
	</div>
	<div>
		<form id="frm">
			<label for="age">나이</label>
			<input id="age" name="age">
		</form>
	</div>
	<div>
		<input type="button" value="전송1" onclick="fn1()">
		<input type="button" value="전송2" onclick="fn2()">
	</div>
	
	<hr>
	
	<div id="result"></div>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

</body>
</html>