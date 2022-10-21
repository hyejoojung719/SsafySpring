<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	홈페이지  
</h1>
<a href="${pageContext.request.contextPath}/book/list">책 목록 조회</a>
<a href="${pageContext.request.contextPath}/book/list2">책 목록 조회-리다이렉트</a>
</body>
</html>
