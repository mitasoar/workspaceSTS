<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table class="table">
	<thead>
		<tr>
			<th scope="col">#</th>
			<th scope="col">강의명</th>
			<th scope="col">학기</th>
			<th scope="col">성적</th>
			<th scope="col">학점</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${gradeList }" var="grade">
			<tr>
				<th scope="row">1</th>
				<td>${grade.lecName }</td>
				<td>${grade.semVO.semName }</td>
				<td>${grade.gradeVO.grade }</td>
				<td>${grade.gradeVO.score }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>