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
학적변동승인화면
<div class="container">
	<table class="table">
		<colgroup>
			<col width="">
			<col width="">
			<col width="">
			<col width="">
			<col width="">
			<col width="">
		</colgroup>
		<thead>
			<tr>
				<td>기존학적</td>
				<td>
					<select name="stuStatus" id="fromStuStatus" class="form-select">
						<option value="재학">재학</option>
						<option value="휴학">휴학</option>
						<option value="제적">제적</option>
					</select>
				</td>
				<td>신청학적</td>
				<td>
					<select name="stuStatus" id="toStuStatus" class="form-select">
						<option value="휴학">휴학</option>
						<option value="복학">복학</option>
						<option value="자퇴">자퇴</option>
					</select>
				</td>
				<td rowspan="2">
					<input type="button" class="btn btn-primary" value="검색" onclick="search();">
				</td>
			</tr>
			<tr>
				<td>신청기간</td>
				<td colspan="3">
					<div class="input-group">
						<input type="date" class="form-control" id="fromDate" style="margin-right: 10px;"> - <input type="date" class="form-control" id="toDate" style="margin-left: 10px;">
					</div>
				</td>
			</tr>
		</thead>
	</table>
	<!-- 학적변동신청목록 -->
	<table class="table">
		<colgroup>	
			<col width="3%">
			<col width="4%">
			<col width="9%">
			<col width="8%">
			<col width="10%">
			<col width="7%">
			<col width="7%">
			<col width="10%">
			<col width="10%">
			<col width="15%">
			<col width="17%">
		</colgroup>
		<thead align="center">
			<tr>
				<th><input type="checkbox" id="totalChk" class="form-check-input" onclick="checkAll();"></th>
				<th>No</th>
				<th>신청번호</th>
				<th>학번</th>
				<th>이름</th>
				<th>기존학적</th>
				<th>신청내용</th>	
				<th>신청일자</th>
				<th>교수승인일자</th>
				<th>최종승인일시</th>
				<th>최종승인상태</th>
			</tr>
		</thead>
		<tbody align="center">
			<c:forEach items="${academicAppList }" var="app" varStatus="status">
				<c:if test="${app.applyType ne '자퇴' }">
					<tr>
						<td><input type="checkbox" class="form-check-input chk"></td>
						<td id="indexTd">${fn:length(academicAppList) - status.index }</td>
						<td>${app.appNo }</td>
						<td>${app.stuNo }</td>
						<td>${app.memberVO.memName }</td>
						<td>${app.studentVO.stuStatus }</td>
						<td>${app.applyType }</td>	
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
								<td id="adminProcessDateTd${status.index }">-</td>
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
				</c:if>
			</c:forEach>
		</tbody>
	</table>
	<input type="button" class="btn btn-primary" value="일괄승인">
</div>
<script type="text/javascript" src="/resources/js/admin/academic_appr.js"></script>
</body>
</html>