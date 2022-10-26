<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>차 등록 화면</h1>

	<form action="${pageContext.request.contextPath}/car/regist"
		method="post" enctype="multipart/form-data">
		<div class="mb-3 mt-3">
			<label for="number" class="form-label">Number:</label> <input
				type="text" class="form-control" id="number"
				placeholder="Enter number" name="number">
		</div>
		<div class="mb-3 mt-3">
			<label for="model" class="form-label">Model:</label> <input
				type="text" class="form-control" id="model"
				placeholder="Enter model" name="model">
		</div>
		<div class="mb-3 mt-3">
			<label for="price" class="form-label">Price:</label> <input
				type="text" class="form-control" id="price"
				placeholder="Enter price" name="price">
		</div>
		<div class="mb-3 mt-3">
			<label for="brand" class="form-label">Brand:</label> <input
				type="text" class="form-control" id="brand"
				placeholder="Enter brand" name="brand">
		</div>
		<div class="form-group" align="left">
			<label for="upfile">파일:</label> <input type="file"
				class="form-control border" name="upfile" multiple="multiple">
		</div>
		<button type="submit" class="btn btn-primary">등록</button>
	</form>
</body>
</html>