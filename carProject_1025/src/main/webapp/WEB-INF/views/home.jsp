<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>자동차 세상</h1>

	<!-- 회원가입 / 로그인 / 로그아웃 -->
	<c:choose>
		<c:when test="${memberInfo eq null}">
			<a href="${pageContext.request.contextPath}/member/join">회원가입</a>
			<a href="${pageContext.request.contextPath}/member/login">로그인</a>
		</c:when>
		<c:otherwise>
			<a href="${pageContext.request.contextPath}/member/logout">로그아웃</a>
		</c:otherwise>
	</c:choose>

	<!--  자동차 목록 -->
	<!--  자동차 등록 -->
	<br>
	<c:if test="${memberInfo ne null}">
			<a href="${pageContext.request.contextPath}/car/regist">차 등록 페이지</a>
	</c:if>
	<a href="${pageContext.request.contextPath}/car/list">차 목록 조회</a>
	

</body>
</html>
