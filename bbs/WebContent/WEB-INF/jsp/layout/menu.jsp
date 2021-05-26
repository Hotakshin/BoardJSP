<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	<a class="navbar-brand" href="main.do">Navbar</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#collapsibleNavbar">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="collapsibleNavbar">
		<ul class="navbar-nav">

			<li class="nav-item"><a class="nav-link" href="noticeListPaging.do">공지사항</a>
			</li>

			<li class="nav-item"><a class="nav-link" href="bulletinList.do">자유게시판</a></li>

			<li class="nav-item"><a class="nav-link" href="#">소개하는 글</a></li>

			<c:if test="${not empty id }">
				<li class="nav-item"><a class="nav-link"
					href="memberLoginOut.do">로그아웃</a></li>
			</c:if>

			<c:if test="${empty id }">
				<li class="nav-item"><a class="nav-link"
					href="memberLoginForm.do">로그인</a></li>
				<li class="nav-item"><a class="nav-link"
					href="memberJoinForm.do">회원가입</a></li>
			</c:if>
			<c:if test="${empty id }">
				<li class="nav-item">Guest</li>
			</c:if>
			<c:if test="${!empty id }">
				<li class="nav-item">${id }</li>
			</c:if>

		</ul>
	</div>
</nav>