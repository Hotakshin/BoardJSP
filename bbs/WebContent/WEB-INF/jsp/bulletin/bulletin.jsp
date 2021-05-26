<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${title }</title>
<!-- 파일 업로드 하는 자바스크립트 라이브러리 -->
<script src="//cdn.ckeditor.com/4.16.1/standard/ckeditor.js"></script>
<!-- J쿼리 라이브러리 -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
	$(function() {
		CKEDITOR
				.replace(
						'content',
						{
							filebrowserUploadUrl : '${pageContext.request.contextPath }/fileUpload',
							height : '600px',
							width : '900px'
						});
	});
</script>
</head>
<body>
	<div align="center">
		<h3>게시글 내용보기</h3>
		<form id="frm" action="bulletinUpdate.do" method="post" >
		
			<input type="hidden" name="id" id="id" value="${bulletin.id }">

			<table border="1">
				<tr>
					<th>순번</th>
					<td id="cid">${bulletin.id }</td>
					<th>작성일자</th>
					<td>${bulletin.regDate }</td>
					<th>작성자</th>
					<td>${bulletin.writer }</td>
					<th>조회수</th>
					<td>${bulletin.hit }</td>
				</tr>
				<tr>
					<th>제목</th>
					<td colspan="7">
					<c:if test="${id eq bulletin.writer}">
						<input id="title" name="title" rows="6" cols="90" value="${bulletin.title }"></c:if> 
						<c:if test="${id ne bulletin.writer}">
         				 <input type="text" value="${bulletin.title }"> 
          				 </c:if>
          			 </td>
				</tr>
				<tr>
					<th>내용</th>
					<td colspan="7">
					<c:if test="${id eq bulletin.writer}">
							<textarea id="content" name="content" rows="6" cols="90">${bulletin.content }</textarea>
						</c:if> 
						<c:if test="${id ne bulletin.writer}">
               ${bulletin.content }
           		 </c:if></td>
				</tr>
			</table>
			<div>
				<button type="button" onclick="location.href='bulletinList.do'">목록보기</button>
				<c:if test="${id eq bulletin.writer }">
					<button type="submit">수정</button>
					<button type="button" onclick="location.href='bulletinDelete.do?id=${bulletin.id }'">삭제</button>
				</c:if>
			</div>
		</form>
	</div>
</body>
</html>