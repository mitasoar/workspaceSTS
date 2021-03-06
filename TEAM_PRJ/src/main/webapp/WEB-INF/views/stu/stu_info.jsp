<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.tableDiv{
	margin-top: 10px;
	text-align: center;
}
.subtitleDiv{
	margin-top: 10px;
	font-size: large;
	text-align: left;
	color: #214099;
	font-weight: bold;
}
.table tr:hover {
	background-color: white;
}
table{
	border-top: 1px solid #DEE2E6;
	height: 160%;
}
td{
	vertical-align: middle;
}
#profileImg {
	width: 100%;
	height: 90%;
}
</style>
</head>
<body>
<div class="row">
	<div class="col-3"></div>
	<div class="col-6 subtitleDiv">내 정보 조회</div>
	<div class="col-3"></div>
</div>
<div class="tableDiv row" id="tableDiv">
	<div class="col-3"></div>
	<div class="col-6">
		<table class="table">
			<colgroup>
				<col width="20%">
				<col width="80%">
			</colgroup>
			<tr>
				<td rowspan="2"><img id="profileImg" alt="이미지없음" src="/resources/images/${sessionScope.stuInfo.memberVO.memImage }"></td>
				<td>${sessionScope.loginInfo.memName} [${sessionScope.stuInfo.stuNo }]
					<c:if test="${sessionScope.loginInfo.memGender eq 'M'}">
						남
					</c:if>
					<c:if test="${sessionScope.loginInfo.memGender eq 'F'}">
						여
					</c:if>
				</td>
			</tr>
			<tr>
				<td>${sessionScope.stuInfo.stuYear}학년 (${sessionScope.stuInfo.stuStatus })</td>
			</tr>
			<tr>
				<td>소속</td>
				<td>${sessionScope.stuInfo.deptVO.collVO.collName } ${sessionScope.stuInfo.deptVO.deptName }</td>
			</tr>
			<tr>
				<td>복수전공</td>
				<c:choose>
					<c:when test="${not empty sessionScope.doubleDeptInfo.deptName }">
						<td>${sessionScope.doubleDeptInfo.collVO.collName} ${sessionScope.doubleDeptInfo.deptName }</td>
					</c:when>
					<c:otherwise>
						<td>없음</td>
					</c:otherwise>
				</c:choose>
			</tr>
			<tr>
				<td>생년월일</td>
				<td>${sessionScope.stuInfo.memberVO.memBirth }</td>
			</tr>
			<tr>
				<td>연락처</td>
				<td>${sessionScope.stuInfo.memberVO.memPhone }</td>
			</tr>
			<tr>
				<td>주소</td>
				<td>${sessionScope.stuInfo.memberVO.memAddr }</td>
			</tr>
		</table>
	</div>
	<div class="col-3"></div>
</div>
<script type="text/javascript" src="/resources/js/stu/stu_info.js?ver=2"></script>
</body>
</html>