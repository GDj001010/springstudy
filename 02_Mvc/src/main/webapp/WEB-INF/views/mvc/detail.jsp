<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>이름 ${name }</h1>
	<h1>나이 ${age }</h1>

	<hr>

	<h1>이름 ${person.name }</h1>
	<h1>나이 ${person.age }</h1>

</body>
</html>