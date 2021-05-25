<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- 제목, 내용, submit -> noticeInsert.do  --%>
<div align="center">
	<div>
		<h1>글 쓰 기</h1>
	</div>
	<form id="frm" action="noticeInsert.do" method="post">
		<div>
			<table>
				<tr>
					<th> 제목 </th>
					<td> <input type="text" id="title" name="title"></td>
				</tr>
				<tr>
					<th> 내용 </th>
					<td> <input type="text" id="contents" name="contents"></td>
				</tr>
			</table>
			<button type="button" onclick = "formCheck()">글쓰기</button>
			<button type="reset">초기화</button>
			<button type="button" onclick = "location.href='noticeListPaging.do'"></button>
		</div>

	</form>

</div>