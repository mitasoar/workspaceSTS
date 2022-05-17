<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
학사경고
<div class="container">
	<!-- 학생 검색 기능 -->
	<table class="table" style="text-align: center;">
		<colgroup>
			<col width="13%">
			<col width="30%">
			<col width="13%">
			<col width="30%">
			<col width="14%">
		</colgroup>
		<tr>
			<td>대학</td>
			<td>
				<select name="collNo" id="coll" class="form-select" onchange="collChangeAjax();">
					<option value="">전체</option>
					<c:forEach items="${collList }" var="collInfo">
						<option value="${collInfo.collNo }">${collInfo.collName }</option>
					</c:forEach>
				</select>
			</td>
			<td>학년</td>
			<td>
				<select name="stuYear" id="stuYear" class="form-select">
					<option value="0">전체</option>
					<option value="1">1학년</option>
					<option value="2">2학년</option>
					<option value="3">3학년</option>
					<option value="4">4학년</option>
					<option value="5">5학년</option>
					<option value="6">6학년</option>
					<option value="7">7학년</option>
				</select>
			</td>
			<td rowspan="3">
				<input type="button" class="btn btn-primary" value="검색" onclick="searchStudentAjax();">
			</td>
		</tr>
		<tr>
			<td>전공</td>
			<td>
				<select name="deptNo" id="dept" class="form-select">
					<option value="">전체</option>
					<c:forEach items="${deptList }" var="deptInfo">
						<option value="${deptInfo.deptNo }">${deptInfo.deptName }</option>
					</c:forEach>
				</select>
			</td>
			<td>성명</td>
			<td><input type="text" placeholder="이름" name="memName" id="memName" class="form-control" onkeyup="enterkey();"></td>
		</tr>
	</table>
	<!-- 검색된 학생리스트가 표시될 div -->
	<div id="listDiv">
		<div style="text-align: center;">학생을 검색하세요</div>
	</div>

	<!-- 학생 이름 클릭 시 실행되는 modal -->
	<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
		<div class="modal-dialog" id="modalDialog">
		</div>
	</div>
</div>
<script type="text/javascript" src="/resources/js/admin/probation.js"></script>
</body>
</html>