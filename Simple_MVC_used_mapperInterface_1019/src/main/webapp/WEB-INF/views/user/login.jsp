<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/user/login" method="post">
		<div class="mb-3 mt-3">
			<label for="id" class="form-label">id:</label> <input
				type="text" class="form-control" id="id"
				placeholder="Enter id" name="id">
		</div>
		<div class="mb-3">
			<label for="pwd" class="form-label">Password:</label> <input
				type="password" class="form-control" id="pwd"
				placeholder="Enter password" name="pwd">
		</div>
		<button type="submit" class="btn btn-primary">로그인</button>
	</form>
</body>
</html>