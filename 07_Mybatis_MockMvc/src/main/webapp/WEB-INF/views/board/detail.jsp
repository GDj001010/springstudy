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
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<script>
	function fnList(){
		location.href = '${contextPath}/board/list.do';
	}
	
	function fnRemove(){
		if(confirm('삭제할까요?')){
			$('#frm_remove').submit();
		}
	}
	
	
	
	function fnEdit(){
		$('#edit_screen').show();
		$('#detail_screen').hide();
	}
	
	$(function(){
		$('#content').summernote({
			width: 640,
			height: 480,
			lang: 'ko-KR',
			toolbar: [
		      ['style', ['bold', 'italic', 'underline', 'clear']],
		      ['font', ['strikethrough', 'superscript', 'subscript']],
			  ['fontname', ['fontname']],
			  ['color', ['color']],
			  ['para', ['ul', 'ol', 'paragraph']],
			  ['table', ['table']],
			  ['insert', ['link', 'picture', 'video']],
			  ['view', ['fullscreen', 'codeview', 'help']]
			]
		})
		$('#edit_screen').hide();
		let modifyResult = '${modifyResult}';
		if(modifyResult != ''){
			if(modifyResult == 1){
				alert('게시글이 수정되었습니다.');
			} else{
				alert('게시글 수정에 실패했습니다.');
			}
		}
	})
</script>
</head>
<body>
	<div id="detail_screen">
		<h1>${board.boardNo }번 게시글 상세정보보기</h1>
		<div>제목 : ${board.title }</div>
		<div>작성자 : ${board.writer }</div>
		<div>작성일 : ${board.createdAt }</div>
		<div>작성일 : ${board.modifiedAt }</div>
		<div>${board.content }</div>
		<form id="frm_remove" action="${contextPath }/board/remove.do" method="post">
			<input type="hidden" value="${board.boardNo }" name="boardNo">
		</form>
		<div>
			<input type="button" value="편집" onclick="fnEdit()">
			<input type="button" value="삭제" onclick="fnRemove()">
			<input type="button" value="목록" onclick="fnList()">
		</div>
	</div>
	
	<div id="edit_screen">
	<div style="cursor: pointer;" onclick="fnBack()"><i class="fa-solid fa-arrow-left"></i> 뒤로 가기</div>
	
		<h1>편집화면</h1>
		<form action="${contextPath }/board/modify.do" method="post">
			<div>
				<label for="title">제목</label>
				<input type="text" value="${board.title }" id="title" name="title">
			</div>
			<div>
				<input type="hidden" value="${board.boardNo }" name="boardNo">
				<div><label for="content">내용</label></div>
				<textarea id="content" name="content">${board.content }</textarea>
			</div>
			<div>
				<button>수정완료</button>
				<input type="button" value="목록" onclick="fnList()">
			</div>
		</form>
	</div>

</body>
</html>