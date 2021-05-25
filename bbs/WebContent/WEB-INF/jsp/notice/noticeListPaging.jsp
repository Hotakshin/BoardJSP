<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.pagination {
  display: inline-block;
}

.pagination a {
  color: black;
  float: left;
  padding: 8px 16px;
  text-decoration: none;
}

.pagination a.active {
  background-color: #4CAF50;
  color: white;
}

.pagination a:hover:not(.active) {background-color: #ddd;}
</style>
<script>
	function formSubmit(id) {
		frm.id.value = id;
		frm.submit();
	}
	function goPage(page) {
		location.href = "noticeListPaging.do?page=" + page;
	}
</script>
</head>
<body>
	<form id="frm" action="notice.do" method="post">
		<input type="hidden" id="id" name="id">

	</form>
	<div align="center">
		<div style="width: 90%">
			<table class="table" border="1">
				<tr>
					<th width="100">순번</th>
					<th width="200">제목</th>
					<th width="150">작성일자</th>
					<th width="100">조회수</th>
				</tr>
				<c:forEach items="${noticeList }" var="vo">
					<tr onclick="formSubmit(${vo.id })">
						<td>${vo.id }</td>
						<td>${vo.title }</td>
						<td>${vo.regDate }</td>
						<td>${vo.hit }</td>
					</tr>
				</c:forEach>
			</table>
			<div>
				<button type="button" onclick="location.href='main.do'">첫
					페이지</button>
				<c:if test="${id eq 'admin' }">
					<button type="button" onclick="location.href='noticeForm.do'">등록</button>
				</c:if>
			</div>
			<div class="pagination">
				<a href="javascript:goPage(${paging.firstPageNo})" class="first">처음
					페이지</a> <a href="javascript:goPage(${paging.prevPageNo})" class="prev">이전
					페이지</a> <span> <c:forEach var="i" begin="${paging.startPageNo}"
						end="${paging.endPageNo}" step="1">
						<c:choose>
							<c:when test="${i eq paging.pageNo}">
								<a href="javascript:goPage(${i})" class="active">${i}</a>
							</c:when>
							<c:otherwise>
								<a href="javascript:goPage(${i})">${i}</a>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</span> <a href="javascript:goPage(${paging.nextPageNo})" class="next">다음
					페이지</a> <a href="javascript:goPage(${paging.finalPageNo})" class="last">마지막
					페이지</a>
			</div>
		</div>
	</div>
</body>
</html>