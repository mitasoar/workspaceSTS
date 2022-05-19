<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.container{
	text-align: center;
}
.lecNameSpan{
	cursor: pointer;
}
.subtitleDiv{
	font-size: large;
	text-align: left;
	border-bottom: 1px solid #DEE2E6;
	color: #214099;
	font-weight: bold;
	padding-top: 10px;
	padding-bottom: 10px;
}
table{
	text-align: center;
}
td {
	vertical-align: middle;
}
.approveBtn{
	background-color:  #214099;
	border: 1px solid ##214099;
}
</style>
</head>
<body>
<div class="container">
	<div class="subtitleDiv">학적변동신청목록</div>
	<!-- 학적변동신청목록 -->
	<table class="table">
		<thead align="center">
			<tr>
				<th><input type="checkbox" id="totalChk" class="form-check-input" onclick="checkAll();"></th>
				<th>No</th>
				<th>신청번호</th>
				<th>학번</th>
				<th>이름</th>
				<th>신청내용</th>	
				<th>신청일자</th>
				<th>교수승인일자</th>
				<th>최종승인일시</th>
				<th>최종승인상태</th>
			</tr>
		</thead>
		<tbody align="center" id="tbody">
			<c:if test="${empty academicAppList }">
				<tr><td colspan="10">신청내역이 존재하지 않습니다.</td></tr>
			</c:if>
			<c:forEach items="${academicAppList }" var="app" varStatus="status">
				<tr>
					<td><input type="checkbox" class="form-check-input chk" id="chk${fn:length(academicAppList) - status.index }" value="${app.appNo }" 
						<c:if test="${app.adminProcessStatus eq '승인완료' or app.profProcessStatus eq '미승인'}">
							disabled="disabled"
						</c:if>
					></td>
					<td id="indexTd">${fn:length(academicAppList) - status.index }</td>
					<td id="appNoTd${fn:length(academicAppList) - status.count }">${app.appNo }</td>
					<td id="stuNoTd${fn:length(academicAppList) - status.count }">${app.stuNo }</td>
					<td>${app.memberVO.memName }</td>
					<td id="applyTypeTd${fn:length(academicAppList) - status.count }">${app.applyType }</td>	
					<td>${app.applyDate }</td>
					<c:choose>
						<c:when test="${not empty app.profProcessDate }">
							<td>${app.profProcessDate }</td>
						</c:when>
						<c:otherwise>
							<td>-</td>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${not empty app.adminProcessDate }">
							<td id="adminProcessDateTd">${app.adminProcessDate }</td>
						</c:when>
						<c:otherwise>
							<td id="adminProcessDateTd">-</td>
						</c:otherwise>
					</c:choose>
					<td id="radioTd${status.index }">
						<input type="radio" class="form-check-input"
						<c:if test="${app.adminProcessStatus eq '미승인' }">
							checked
						</c:if>
						<c:if test="${app.adminProcessStatus eq '승인완료' }">
							disabled
						</c:if> > 승인대기
						<input type="radio" class="form-check-input" onclick="approve('${app.appNo}', '${app.applyType }', '${app.stuNo }', '${status.index }', '${app.adminProcessStatus }', '${app.profProcessStatus }');"
						<c:if test="${app.adminProcessStatus eq '승인완료' }">
							checked disabled
						</c:if>	> 승인완료
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<input type="button" class="btn btn-primary approveBtn" value="일괄승인" onclick="test();">
</div>
<script type="text/javascript" src="/resources/js/admin/academic_appr.js?ver=1"></script>
</body>
</html>