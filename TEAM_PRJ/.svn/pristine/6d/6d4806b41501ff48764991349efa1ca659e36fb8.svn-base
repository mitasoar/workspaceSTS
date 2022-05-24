<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
</style>
</head>
<body>
<div class="container">
	<div>
		<h1 style="border-bottom: 1px solid #C9D6DF; width: 200px; padding-bottom: 5px; margin-bottom: 20px;">학과 변동</h1>
	</div>
	<table class="table" style="text-align: center;">
		<thead>
			<tr style="background-color: #214099; color: white;">
				<td>
					<input id="check" type="checkbox" class="form-check-input" onclick="checkAll();">
				</td>
				<td>No</td>
				<td>학기</td>
				<td>학번</td>
				<td>이름</td>
				<td>신청</td>
				<td>신청일</td>
				<td>기존학과</td>
				<td>변경학과</td>
				<td>기존학과 승인</td>
				<td>변경학과 승인</td>
				<td>승인</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${deptAppList }" var="deptApp" varStatus="var">
				<tr>
					<td>
						<input type="checkbox" class="form-check-input chk" value="${deptApp.deptAppNo }" onclick="unCheck(this);">
						<input type="hidden" value="${deptApp.originalDept }">
					</td>
					<td>${var.index + 1}</td>
					<td>학기</td>
					<td>${deptApp.stuNo }</td>
					<td>${deptApp.studentVO.memberVO.memName }</td>
					<td>${deptApp.applyType }</td>
					<td>${deptApp.applyDate }</td>
					<td>${deptApp.originalDeptName }</td>
					<td>${deptApp.applyDeptName }</td>
					<td>${deptApp.oriDeptProcessStatus }</td>
					<td>${deptApp.appDeptProcessStatus }</td>
					<td>
						<form action="/pro/updateDeptApp" method="post">
							<input type="hidden" value="${deptApp.deptAppNo }" name="deptAppNo">
							<c:choose>
								<c:when test="${deptApp.originalDept eq empVO.deptNo }"> <!-- 기존학과와 로그인한 dpetNo가 같을시 -->
									<input type="hidden" value="${deptApp.originalDept }" name="originalDept" id="oriDept">
									<input type="radio" name="oriDeptProcessStatus" value="승인거절" onclick="reject(this);"> 승인거절
									<input type="radio" name="oriDeptProcessStatus" value="승인완료" onclick="appr(this);"> 승인완료
								</c:when>
								<c:otherwise>
									<input type="hidden" value="${deptApp.applyDept }" name="applyDept" id="appDept">
									<input type="radio" name="appDeptProcessStatus" value="승인거절" onclick="reject(this);"> 승인거절
									<input type="radio" name="appDeptProcessStatus" value="승인완료" onclick="appr(this);"> 승인완료
								</c:otherwise>
							</c:choose>
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:if test="${not empty deptAppList }">
		<div style="text-align: right;">	
			<button type="button" class="btn btn-outline-danger" onclick="apprs('승인거절');">일괄거절</button>
			<button type="button" class="btn btn-outline-success" onclick="apprs('승인완료');">일괄승인</button>
		</div>
	</c:if>
</div>
<script type="text/javascript" src="/resources/js/professor/dept_app.js?ver=25"></script>
</body>
</html>