<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>차 목록 조회 화면</h1>
	
	<table class="table table-striped">
    <thead>
      <tr>
        <th>차 고유번호</th>
        <th>모델명</th>
        <th>가격</th>
        <th>브랜드명</th>
      </tr>
    </thead>
    <tbody>
		<c:forEach items="${requestScope.list}" var="car">
			<tr>
				<td>${car.number }</td>
				<td>${car.model }</td>
				<td>${car.price }</td>
				<td>${car.brand }</td>
			</tr>
		</c:forEach>
    </tbody>
  </table>
</body>
</html>