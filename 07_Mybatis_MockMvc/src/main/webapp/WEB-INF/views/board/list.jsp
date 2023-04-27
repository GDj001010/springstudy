<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${contextPath }/resources/js/lib/jquery-3.6.4.min.js"></script>
<script src="${contextPath }/resources/summernote-0.8.18-dist/summernote-lite.min.js"></script>
<script src="${contextPath }/resources/summernote-0.8.18-dist/lang/summernote-ko-KR.min.js"></script>
<link rel="stylesheet" href="${contextPath }/resources/summernote-0.8.18-dist/summernote-lite.min.css">
<style>
	tr:hover{
		background-color: red;
		cursor: pointer;
	}
</style>
<script>
	function fnDetail(n){
		location.href = '${contextPath}/board/detail.do?boardNo=' + n;
	}
	$(function(){
		/*
			let addResult = '1';  삽입 성공
			let addResult = '0';  삽입 실패
			let addResult = '';	  삽입과 상관 없음
		*/
		let addResult = '${addResult}';		// 값이 전달되지 않았을 때를 대비해서 문자열로 묶어준다.
		if(addResult != ''){
			if(addResult == '1'){
				alert('게시글이 등록되었습니다.');
			} else{
				alert('게시글 등록에 실패하였습니다.');
			}
		}
		let removeResult = '${removeResult}';		// 값이 전달되지 않았을 때를 대비해서 문자열로 묶어준다.
		if(removeResult != ''){
			if(removeResult == '1'){
				alert('게시글이 삭제되었습니다.');
			} else{
				alert('게시글 삭제에 실패하였습니다.');
			}
		}
		
		
	})
</script>
</head>
<body>

	<a href="${contextPath }/board/write.do">새글작성하기</a>
	<div>
		<table border="1">
			<thead>
				<tr>
					<td>제목</td>
					<td>작성자</td>
					<td>작성일자</td>
				</tr>
			</thead>
			<tbody>
				<c:if test="${empty boardList }">
					<tr>
						<td colspan="3">개시글이 없습니다.</td>
					</tr>
				</c:if>
				<c:if test="${not empty boardList }">
					<c:forEach items="${boardList }" var="b">
						<tr onclick="fnDetail(${b.boardNo})">
							<td>${b.title }</td>
							<td>${b.writer }</td>
							<td>${b.createdAt }</td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
	</div>

</body>
</html>