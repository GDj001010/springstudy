<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${contextPath }/resources/js/lib/jquery-3.6.4.min.js"></script>
<script>
	$(function(){
	
		// C:\GDJ61\images 디렉터리에 저장된 flower1~5.jpg 화면에 표시하기
		// 경로(path)와 파일명(filename)을 전달하면 해당 이미지를 화면에 출력하는 연습
		
		// Java에서 이미지를 byte 배열로 저장해서 Jsp로 보내면 이미지가 나타난다.
		
		for(let n = 1; n < 6; n++){
			let path = encodeURIComponent('C:\\GDJ61\\images');
			let filename = 'flower' + n + '.jpg';
			let str = '<div>';
			str += '<img src="${contextPath}/image/display?path=' + path + '&filename=' + filename + '" width="300px">'; 
			$('#result').append(str);	// html 을 사용할시 계속해서 덮어쓰기가 되서 마지막 5번째만 남게 된다
										// append를 사용해줌으로 하나 하나 더 추가를 시켜줘야 된다.
		}
		
	})
	
</script>
</head>
<body>

	<div id="result"></div>

</body>
</html>