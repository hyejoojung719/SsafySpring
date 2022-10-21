<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <%@ page session="false" %> --%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>홈페이지</h1>
	<c:choose>
		<c:when test="${userInfo eq null}">
			<a href="${pageContext.request.contextPath}/user/login">로그인</a>
		</c:when>
		<c:otherwise>
			<a href="${pageContext.request.contextPath}/user/logout">로그아웃</a>
		</c:otherwise>
	</c:choose>

	<br>
	<a href="${pageContext.request.contextPath}/book/list">책 목록 조회</a>
	<a href="${pageContext.request.contextPath}/book/list2">책 목록
		조회-리다이렉트</a>
	<br>
	<a href="${pageContext.request.contextPath}/book/insert">책 등록 페이지</a>
	
</body>
</html>