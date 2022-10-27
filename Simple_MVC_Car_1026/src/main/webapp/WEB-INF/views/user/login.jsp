<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <title>자동차 관리 사이트</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

	<h1>로그인 화면</h1>
	
	<form action="${pageContext.request.contextPath}/user/login"
		method="post">
		<div class="form-group">
			<label for="id">아이디</label> <input type="text"
				class="form-control" name="id" id="id">
		</div>
		<div class="form-group">
			<label for="pwd">비밀번호</label> <input type="password" class="form-control"
				name="pwd" id="pwd">
		</div>
		<button type="submit" class="btn btn-primary">로그인</button>
	</form>

</body>
</html>