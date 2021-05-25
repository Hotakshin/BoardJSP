<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${empty member }">
<h1>Welcome to Home Guest</h1>
</c:if>
<c:if test="${not empty member }">
<h1>Welcome to Home ${member.name }</h1>
</c:if>