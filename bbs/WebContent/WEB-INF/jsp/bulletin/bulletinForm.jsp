<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bulletinForm.jsp</title>

<!-- 파일 업로드 하는 자바스크립트 라이브러리 -->
<script src="//cdn.ckeditor.com/4.16.1/standard/ckeditor.js"></script>
<!-- J쿼리 라이브러리 -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
	$(function() {
		CKEDITOR.replace('content',{
			filebrowserUploadUrl: '${pageContext.request.contextPath }/fileUpload',
			height: '600px',
			width: '900px'
		});
	});
	function formCheck(){
			if(frm.title.value == ""){
				alert("제목을 입력하세요.")
				frm.title.focus();
				return false;
			}
			frm.submit();
	}
</script>
</head>
<body>
	<div align="center">
		<div>
			<h1>등록</h1>
		</div>
		<div>
			<form id="frm" action="bulletinInsert.do" method="post">
				<input type="hidden" id="id" name="id" value="${id }">
				<div>
					<table border="1">
						<tr>
							<th width="150">제목</th>
							<td width="300"><input type="text" id="title"
								name="title"></td>
						</tr>
						<tr>
							<th width="150">내용</th>
							<td width="300"><textarea id="content" name="content"></textarea></td>
						</tr>
					</table>
				</div>
				<div>
					<button type="button" onclick="formCheck()">글등록</button>
					<button type="reset">취소</button>
					<button type="button" onclick="location.href='main.do'">메인으로</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>