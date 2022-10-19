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
<a href="${pageContext.request.contextPath}/car/list">차 목록 조회</a>
<br>
<a href="${pageContext.request.contextPath}/car/goRegi">차 정보 등록</a>
</body>
</html>
