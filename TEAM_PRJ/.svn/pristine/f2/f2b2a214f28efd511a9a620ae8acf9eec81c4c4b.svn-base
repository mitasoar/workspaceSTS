<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.subtitleDiv{
	font-size: large;
	text-align: left;
	border-bottom: 1px solid #DEE2E6;
	color: #214099;
	font-weight: bold;
	padding-top: 10px;
	padding-bottom: 10px;
}
.tableDiv .listDiv{
	width: 90%;
	margin: 0 auto;
}
table{
	text-align: center;
}
.table thead tr:hover {
	background-color: white;
}
td {
	vertical-align: middle;
}
.searchBtn{
	width: 100px;
	height: 50px;
	background-color:  #214099;
	border: 1px solid ##214099;
}
</style>
</head>
<body>
<!-- 학생 검색 기능 -->
<div class="container">
	<div class="tableDiv">
		<div class="subtitleDiv">학생 조회</div>
		<table class="table table-light">
			<colgroup>
				<col width="11%">
				<col width="11%">
				<col width="11%">
				<col width="11%">
				<col width="11%">
				<col width="33%">
				<col width="12%">
			</colgroup>
			<tr>
				<td>대학</td>
				<td colspan="3">
					<select name="collNo" id="coll" class="form-select" onchange="collChangeAjax();">
						<option value="">전체</option>
						<c:forEach items="${collList }" var="collInfo">
							<option value="${collInfo.collNo }">${collInfo.collName }</option>
						</c:forEach>
					</select>
				</td>
				<td>전공</td>
				<td>
					<select name="deptNo" id="dept" class="form-select">
						<option value="">전체</option>
						<c:forEach items="${deptList }" var="deptInfo">
							<option value="${deptInfo.deptNo }">${deptInfo.deptName }</option>
						</c:forEach>
					</select>
				</td>
				<td rowspan="2">
					<input type="button" class="btn btn-primary searchBtn" value="검색" onclick="searchStudentAjax();">
				</td>
			</tr>
			<tr>
				
				<td>학적</td>
				<td>
					<select name="stuStatus" id="stuStatus" class="form-select">
						<option value="">전체</option>
						<option value="재학">재학</option>
						<option value="휴학">휴학</option>
						<option value="제적">제적</option>
						<option value="자퇴">자퇴</option>
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
				<td>성명</td>
				<td><input type="text" placeholder="이름" name="memName" id="memName" class="form-control" onkeyup="enterkey();"></td>
			</tr>
		</table>
	</div>
	
	<!-- 검색된 학생리스트가 표시될 div -->
	<div id="listDiv">
		<div style="text-align: center;">학생을 검색하세요</div>
	</div>
</div>
<script type="text/javascript" src="/resources/js/admin/student_list.js"></script>
</body>
</html>