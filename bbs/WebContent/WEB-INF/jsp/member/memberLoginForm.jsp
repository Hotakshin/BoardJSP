<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
	function formCheck(){
		if(frm.memberId.value==""){
			alert("아이디를 입력하세요");
			frm.memberId.focus();
			return false;
		}
		if(frm.memberPwd.value==""){
			alert("비밀번호를 입력하세요");
			frm.memberPwd.focus();
			return false;
		}
		frm.submit();
	}
</script>
</head>
<body>
	<div align="center">
	<h1>로그인</h1>
		<div>
			<form id="frm" action="memberLogin.do" method="post">
				<div>
					<table border="1">
						<tr>
							<th>아이디</th>
							<td><input type="text" id="memberId" name="memberId"></td>
						</tr>
						<tr>
							<th>비밀번호</th>
							<td><input type="password" id="memberPwd" name="memberPwd"></td>
						</tr>
					</table>
				</div>
				<div>
				<br>
					<button type="button" onclick="formCheck()">로그인</button>
					<button type="reset">취소</button>
					<button type="button" onclick="location.href='main.do'">첫 페이지</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>