<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<h1>차 등록 화면</h1>
	
	<!-- form 태그의 enctype 속성 multipart/form-data로 변경 -->
	<form action="${pageContext.request.contextPath}/car/insert"
		method="post" enctype="multipart/form-data">
		<div class="form-group">
			<label for="number">차량번호</label>
			<input type="text"	class="form-control" name="number" id="number">
		</div>
		<div class="form-group">
			<label for="model">모델</label>
			<input type="text" class="form-control"	name="model" id="model">
		</div>
		<div class="form-group">
			<label for="price">가격</label>
			<input type="number" class="form-control" name="price" id="price">
		</div>
		<div class="form-group">
			<label for="brand">브랜드</label>
			<input type="text"	class="form-control" name="brand" id="brand">
		</div>
		<!-- 파일 업로드 start -->
		<div class="form-group">
			<label for="file">이미지 파일: </label>
			<input type="file"	class="form-control-file" name="file" id="file">
		</div>
		<!-- 파일 업로드 추가 end -->
		<button type="submit" class="btn btn-primary">등록하기</button>
	</form>

</body>
</html>