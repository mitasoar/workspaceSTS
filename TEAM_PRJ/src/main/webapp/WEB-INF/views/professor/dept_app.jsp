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
<div class="container">
		<table class="table">
			<thead>
				<tr>
					<th>
						<input id="check" type="checkbox" class="form-check-input" onclick="checkAll();">
					</th>
					<th>No</th>
					<th>학번</th>
					<th>이름</th>
					<th>신청</th>
					<th>신청일</th>
					<th>기존학과</th>
					<th>기존학과 승인</th>
					<th>기존학과 승인일</th>
					<th>변경학과</th>	
					<th>변경학과 승인</th>	
					<th>변경학과 승인일</th>	
					<th>승인상태</th>
				</tr>
			</thead>
			<tbody>
				<%-- <c:forEach items="${appList }" var="app">
					<tr>
						<td>
							<input type="checkbox" class="form-check-input chk" value="${app.appNo }">
						</td>
						<td>1</td>
						<td>${app.stuNo }</td>
						<td>${app.studentVO.memberVO.memName }</td>
						<td>${app.studentVO.stuStatus }</td>
						<td>${app.applyType }</td>	
						<td>${app.applyDate }</td>
						<td></td>
						<td>
							<form action="/pro/updateApp" method="post">
								<input type="hidden" value="${app.appNo }" name="appNo">
								<input type="radio" name="profProcessStatus" value="승인거절" onclick="reject(this);"> 승인거절
								<input type="radio" name="profProcessStatus" value="승인완료" onclick="appr(this);"> 승인완료
							</form>
						</td>
					</tr>
				</c:forEach> --%>
				
				<tr>
					<td>
						<input id="check" type="checkbox" class="form-check-input">
					</td>
					<td>No</td>
					<td>학번</td>
					<td>이름</td>
					<td>신청</td>
					<td>신청일</td>
					<td>기존학과</td>
					<td>기존학과 승인</td>
					<td>기존학과 승인일</td>
					<td>변경학과</td>	
					<td>변경학과 승인</td>	
					<td>변경학과 승인일</td>	
					<td>승인상태</td>
				</tr>
			</tbody>
		</table>
	<button type="button" onclick="#">일괄거절</button>
	<button type="button" onclick="#">일괄승인</button>
</div>
<script type="text/javascript" src="/resources/js/professor/dept_app.js?ver=1"></script>
</body>
</html>