<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.container{
	widtd: 1200px;
}
.container > table{
	text-align: center;
}
</style>
</head>
<body>
<div class="container">
	<div>
		<h1 style="border-bottom: 1px solid #C9D6DF; widtd: 200px; padding-bottom: 5px; margin-bottom: 20px;">학적 변동</h1>
	</div>
	<table class="table" style="text-align: center">
		<colgroup>
			<col width="5%">
			<col width="7%">
			<col width="13%">
			<col width="10%">
			<col width="10%">
			<col width="10%">
			<col width="20%">
			<col width="10%">
			<col width="15%">
		</colgroup>
		<thead>
			<tr style="background-color: #214099; color: white;">
				<td>
					<input id="check" type="checkbox" class="form-check-input" onclick="checkAll();">
				</td>
				<td>No</td>
				<td>학번</td>
				<td>학기</td>
				<td>이름</td>
				<td>변경신청</td>	
				<td>신청일</td>
				<td>승인상태</td>
				<td>승인</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${appList }" var="app" varStatus="var">
				<tr>
					<td>
						<input type="checkbox" class="form-check-input chk" value="${app.appNo }" onclick="unCheck(this);">
					</td>
					<td>${var.index + 1 }</td>
					<td>${app.semesterVO.semName }</td>
					<td>${app.stuNo }</td>
					<td>${app.studentVO.memberVO.memName }</td>
					<td>${app.applyType }</td>
					<td>${app.applyDate }</td>
					<td>${app.profProcessStatus }</td>
					<td>
						<form action="/pro/updateApp" method="post">
							<input type="hidden" value="${app.appNo }" name="appNo">
							<input type="radio" name="profProcessStatus" value="승인거절" onclick="reject(this);"> 승인거절
							<input type="radio" name="profProcessStatus" value="승인완료" onclick="appr(this);"> 승인완료
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:if test="${not empty appList }">
		<div style="text-align: right;">
			<button type="button" class="btn btn-outline-danger" onclick="apprs('승인거절');">일괄거절</button>
			<button type="button" class="btn btn-outline-success" onclick="apprs('승인완료');">일괄승인</button>
		</div>
	</c:if>
</div>
<script type="text/javascript" src="/resources/js/professor/academic_app.js?ver=20"></script>
</body>
</html>