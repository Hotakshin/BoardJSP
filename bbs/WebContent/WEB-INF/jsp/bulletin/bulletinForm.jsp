<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bulletinForm.jsp</title>

<!-- ���� ���ε� �ϴ� �ڹٽ�ũ��Ʈ ���̺귯�� -->
<script src="//cdn.ckeditor.com/4.16.1/standard/ckeditor.js"></script>
<!-- J���� ���̺귯�� -->
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
				alert("������ �Է��ϼ���.")
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
			<h1>���</h1>
		</div>
		<div>
			<form id="frm" action="bulletinInsert.do" method="post">
				<input type="hidden" id="id" name="id" value="${id }">
				<div>
					<table border="1">
						<tr>
							<th width="150">����</th>
							<td width="300"><input type="text" id="title"
								name="title"></td>
						</tr>
						<tr>
							<th width="150">����</th>
							<td width="300"><textarea id="content" name="content"></textarea></td>
						</tr>
					</table>
				</div>
				<div>
					<button type="button" onclick="formCheck()">�۵��</button>
					<button type="reset">���</button>
					<button type="button" onclick="location.href='main.do'">��������</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>