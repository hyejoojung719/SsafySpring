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
	<h1>차 상세 조회 화면</h1>
	<a class="btn btn-primary" href="${pageContext.request.contextPath}/car/list">목록으로</a>

	<table class="table table-bordered">
		<thead>
			<tr>
				<th>차량 번호</th>
				<th>모델</th>
				<th>가격</th>
				<th>브랜드</th>
				<th>이미지 파일</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${car.number}</td>
				<td>${car.model}</td>
				<td>${car.price}</td>
				<td>${car.brand}</td>
				<td> <a 
                    href="${pageContext.request.contextPath}/car/download?saveFolder=${car.fileInfo.saveFolder}&saveFile=${car.fileInfo.saveFile}&originFile=${car.fileInfo.originFile}">
                    ${car.fileInfo.originFile}</a>
				</td>
			</tr>
		</tbody>
	</table>
	<c:if test="${!empty car.fileInfo}">
		<img alt="이미지 찾지 못함"
			src="${pageContext.request.contextPath}/img/${car.fileInfo.saveFolder}/${car.fileInfo.saveFile}">
	</c:if>
</body>
</html>