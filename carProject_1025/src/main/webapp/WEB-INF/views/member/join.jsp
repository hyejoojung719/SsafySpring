<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> 회원 가입 페이지 입니다!!!!!!!</h1>
	<form action="${pageContext.request.contextPath}/member/join" method="post">
		<div class="mb-3 mt-3">
			<label for="id" class="form-label">ID :</label> <input
				type="text" class="form-control" id="id"
				placeholder="Enter id" name="id">
		</div>
		<div class="mb-3">
			<label for="pwd" class="form-label">Password: </label> <input
				type="password" class="form-control" id="pwd"
				placeholder="Enter password" name="pwd">
		</div>
		<button type="submit" class="btn btn-primary">회원가입</button>
		<button type="button" id="cancel" class="btn btn-primary">회원가입 취소</button>
	</form>
	
	<script type="text/javascript">
	document.querySelector("#cancel").addEventListener("click", function () {
    	location.href="${pageContext.request.contextPath}";
      });
	</script>
</body>
</html>