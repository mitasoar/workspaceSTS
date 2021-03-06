<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.outDiv{
	width: 1000px;
	margin: 0 auto;
	margin-bottom: 20px;
}
.table{
	text-align: center;
}
</style>
</head>
<body>
<div class="outDiv">
	<h1 style="border-bottom: 1px solid #C9D6DF; width: 200px; margin-bottom: 15px; padding-bottom: 5px;">성적 조회</h1>
</div>
<div class="row outDiv">
	<div class="col-1">
		<h5 style="margin-top: 5px;">학기</h5>
	</div>
	<div class="col-9">
	<select class="form-select" id="semSelectBox" aria-label="검색">
		<option value="" selected>전체</option>
		<c:forEach items="${semList }" var="sem">
			<option value="${sem.semNo }">${sem.semName }</option>
		</c:forEach>
	</select>
	</div>
	<div class="col-2">
		<button type="button" class="btn btn-secondary" onclick="searchSem();" style="width: 150px; ">검색</button>
	</div>
</div>

<table class="table outDiv">
	<thead>
		<tr style="background-color: #214099; color: white;">
			<th scope="col">#</th>
			<th scope="col">강의명</th>
			<th scope="col">학기</th>
			<th scope="col">성적</th>
			<th scope="col">학점</th>
		</tr>
	</thead>
	<tbody id="gradeTbody">
		<c:forEach items="${gradeList }" var="grade" varStatus="var">
			<tr>
				<th scope="row">${var.index + 1 }</th>
				<td>${grade.lecName }</td>
				<td>${grade.semVO.semName }</td>
				<td>${grade.gradeVO.grade }</td>
				<td>${grade.gradeVO.score }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<script type="text/javascript" src="/resources/js/stu/my_score.js?ver=3"></script>
</body>
</html>