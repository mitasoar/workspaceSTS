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
학생조회화면
<!-- 학생 검색 기능 -->
<div class="container">
<table class="table">
	<colgroup>
		<col>
		<col>
		<col>
		<col>
		<col>
	</colgroup>
	<tr>
		<td>대학</td>
		<td>
			<select name="college" class="form-select">
				<option>option1</option>
				<option>option2</option>
			</select>
		</td>
		<td>학년</td>
		<td>
			<select name="collNo" class="form-select">
				<option>option1</option>
				<option>option2</option>
			</select>
		</td>
		<td rowspan="3">
			<input type="submit" class="btn btn-primary" value="검색">
		</td>
	</tr>
	<tr>
		<td>전공</td>
		<td>
			<select name="majorCode" class="form-select">
				<option>option1</option>
				<option>option2</option>
			</select>
		</td>
		<td>학적</td>
		<td>
			<select name="stuStatus" class="form-select">
				<option>option1</option>
				<option>option2</option>
			</select>
		</td>
	</tr>
	<tr>
		<td>성명</td>
		<td colspan="3"><input type="text" placeholder="이름" name="memName" class="form-control"></td>
	</tr>
</table>
<!-- 학생 목록 -->
<table class="table">
	<colgroup>
		<col>
		<col>
		<col>
		<col>
		<col>
		<col>
	</colgroup>
	<thead>
		<tr>
			<td>학번</td>
			<td>학년</td>
			<td>이름</td>
			<td>소속 대학</td>
			<td>전공</td>
			<td>학적 상태</td>
		</tr>
	</thead>	
	<tbody>
		<c:forEach items="${studentList }" var="studentInfo">
			<tr>
				<td>${studentInfo.stuNo }</td>
				<td>${studentInfo.stuYear }</td>
				<td></td>
				<td>${studentInfo.collNo }번대학</td>
				<td>${studentInfo.majorCode }</td>
				<td>${studentInfo.stuStatus }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</div>
</body>
</html>