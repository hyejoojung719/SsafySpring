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
	<h1>차 상세 조회 화면</h1>

	<table class="table table-striped">
		<thead>
			<tr>
				<th>차 고유번호</th>
				<th>모델명</th>
				<th>가격</th>
				<th>브랜드명</th>
				<th>파일명</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${car.number }</td>
				<td>${car.model }</td>
				<td>${car.price }</td>
				<td>${car.brand }</td>
				<td>${car.fileInfo.originFile }</td>
			</tr>
		</tbody>
	</table>
	<button type="button" id="tolist" class="btn btn-primary">목록으로</button>

	<script type="text/javascript">
	document.querySelector("#tolist").addEventListener("click", function () {
    	location.href="${pageContext.request.contextPath}/car/list";
      });
	</script>
</body>
</html>