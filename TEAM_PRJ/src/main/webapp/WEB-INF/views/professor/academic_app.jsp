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
	width: 1200px;
}
.container > table{
	text-align: center;
}
</style>
</head>
<body>
<div class="container">
	<div>
		<h1 style="border-bottom: 1px solid #C9D6DF; width: 200px; padding-bottom: 5px; margin-bottom: 20px;">학적 변동</h1>
	</div>
	<table class="table">
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
			<tr style="background-color: #CCCCCC">
				<th>
					<input id="check" type="checkbox" class="form-check-input" onclick="checkAll();">
				</th>
				<th>No</th>
				<th>학번</th>
				<th>학기</th>
				<th>이름</th>
				<th>변경신청</th>	
				<th>신청일</th>
				<th>승인상태</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${appList }" var="app">
				<tr>
					<td>
						<input type="checkbox" class="form-check-input chk" value="${app.appNo }">
					</td>
					<td>${app.appNo }</td>
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
			<button type="button" class="btn btn-secondary" onclick="apprs('승인거절');">일괄거절</button>
			<button type="button" class="btn btn-secondary" onclick="apprs('승인완료');">일괄승인</button>
		</div>
	</c:if>
</div>
<script type="text/javascript" src="/resources/js/professor/academic_app.js?ver=20"></script>
</body>
</html>