<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<title>자동차 관리 사이트</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<h1>홈 화면</h1>

	<div class="list-group">
		<a href="${root}/car/list"
			class="list-group-item list-group-item-action">자동차 목록 조회</a> <a
			href="${root}/car/insert"
			class="list-group-item list-group-item-action">자동차 등록</a>
	</div>
	<br>
	<c:choose>
		<c:when test="${empty userInfo}">
			<div class="list-group">
				<a href="${root}/user/signup" class="list-group-item list-group-item-action">회원가입</a>
				<a href="${root}/user/login" class="list-group-item list-group-item-action">로그인</a>
			</div>
		</c:when>
		<c:otherwise>
			<div class="list-group">
				<a href="${root}/user/logout" class="list-group-item list-group-item-action">로그아웃</a>
			</div>
		</c:otherwise>
	</c:choose>
</body>
</html>
