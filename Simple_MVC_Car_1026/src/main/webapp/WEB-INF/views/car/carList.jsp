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
  <script>
  	function detailCar(number){
  		location.href="${pageContext.request.contextPath}/car/detail?number="+number;
  	}
  </script>
</head>
<body>
	<h1>차 목록 조회 화면</h1>
	<a class="btn btn-primary" href="${pageContext.request.contextPath}">홈 화면</a>
	<table class="table table-bordered table-hover">
    <thead>
      <tr class="hover">
        <th>차량 번호</th>
        <th>모델</th>
        <th>가격</th>
        <th>브랜드</th>
      </tr>
    </thead>
    <tbody>
		<c:forEach items="${carList}" var="car">
			<tr onclick="detailCar(${car.number})">
				<td>${car.number}</td>
				<td>${car.model}</td>
				<td>${car.price}</td>
				<td>${car.brand}</td>
			</tr>
		</c:forEach>
    </tbody>
  </table>
</body>
</html>