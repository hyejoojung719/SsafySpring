<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Bootstrap Example</title>
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

	<form action="${pageContext.request.contextPath}/car/regiCar" method="post">
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
		<button type="submit" class="btn btn-primary">등록</button>
	</form>
</body>
</html>