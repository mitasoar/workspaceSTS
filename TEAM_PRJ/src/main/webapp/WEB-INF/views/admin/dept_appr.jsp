<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
전과/복수전공 조회화면
<div class="container">
	<!-- 학적변동신청목록 -->
	<table class="table">
		<colgroup>	
			<col width="%">
			<col width="%">
			<col width="%">
			<col width="%">
			<col width="%">
			<col width="%">
			<col width="%">
			<col width="%">
			<col width="%">
			<col width="%">
		</colgroup>
		<thead align="center">
			<tr>
				<th>No</th>
				<th>신청번호</th>
				<th>학번</th>
				<th>이름</th>
				<th>기존학과</th>
				<th>신청내용</th>	
				<th>신청일자</th>
				<th>신청학과</th>	
				<th>기존학과승인</th>
				<th>신청학과승인</th>
				<th>최종승인</th>
			</tr>
		</thead>
		<tbody align="center">
			<c:forEach items="${deptAppList }" var="app" varStatus="status">
				<tr>
					<td id="indexTd">${fn:length(deptAppList) - status.index }</td>
					<td>${app.deptAppNo }</td>
					<td>${app.stuNo }</td>
					<td>${app.studentVO.memberVO.memName }</td>
					<td>${app.studentVO.deptVO.collVO.collName} ${app.studentVO.deptVO.deptName }</td>
					<td>${app.applyType }</td>	
					<td>${app.applyDate }</td>
					<td>${app.applyCollName } ${app.applyDeptName }</td>
					<c:choose>
						<c:when test="${not empty app.oriDeptProcessDate }">
							<td>${app.oriDeptProcessDate }</td>
						</c:when>
						<c:otherwise>
							<td>-</td>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${not empty app.appDeptProcessDate }">
							<td id="adminProcessDateTd">${app.appDeptProcessDate }</td>
						</c:when>
						<c:otherwise>
							<td id="adminProcessDateTd${status.index }">-</td>
						</c:otherwise>
					</c:choose>
					<td>
						<c:choose>
							<c:when test="${app.oriDeptProcessStatus eq '승인' and app.appDeptProcessStatus eq '승인' }">
								승인완료	
							</c:when>
							<c:otherwise>
								승인대기
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<script type="text/javascript" src="/resources/js/admin/dept_appr.js"></script>
</body>
</html>