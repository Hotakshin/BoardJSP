<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${title }</title>
<!-- ���� ���ε� �ϴ� �ڹٽ�ũ��Ʈ ���̺귯�� -->
<script src="//cdn.ckeditor.com/4.16.1/standard/ckeditor.js"></script>
<!-- J���� ���̺귯�� -->
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
		<h3>�Խñ� ���뺸��</h3>
		<form id="frm" action="bulletinUpdate.do" method="post" >
		
			<input type="hidden" name="id" id="id" value="${bulletin.id }">

			<table border="1">
				<tr>
					<th>����</th>
					<td id="cid">${bulletin.id }</td>
					<th>�ۼ�����</th>
					<td>${bulletin.regDate }</td>
					<th>�ۼ���</th>
					<td>${bulletin.writer }</td>
					<th>��ȸ��</th>
					<td>${bulletin.hit }</td>
				</tr>
				<tr>
					<th>����</th>
					<td colspan="7">
					<c:if test="${id eq bulletin.writer}">
						<input id="title" name="title" rows="6" cols="90" value="${bulletin.title }"></c:if> 
						<c:if test="${id ne bulletin.writer}">
         				 <input type="text" value="${bulletin.title }"> 
          				 </c:if>
          			 </td>
				</tr>
				<tr>
					<th>����</th>
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
				<button type="button" onclick="location.href='bulletinList.do'">��Ϻ���</button>
				<c:if test="${id eq bulletin.writer }">
					<button type="submit">����</button>
					<button type="button" onclick="location.href='bulletinDelete.do?id=${bulletin.id }'">����</button>
				</c:if>
			</div>
		</form>
	</div>
</body>
</html>