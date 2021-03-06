<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
table{
	text-align: center;
}
.table thead tr:hover {
	background-color: white;
}
.applyTable tr:hover{
	background-color: white;
}
td {
	vertical-align: middle;
}
.btnDiv{
	text-align: center;
}
.applyBtn{
	width: 100px;
	background-color:  #214099;
	border: 1px solid ##214099;
}
</style>
</head>
<body>
<div class="container">
	<div class="subtitleDiv">
		학적변동 내역
	</div>
	<!-- 학적관리 테이블을 학생번호로 조회 -->
	<div class="tableDiv">
		<table class="table">
			<thead>
				<tr align="center">
					<th>순번</th>
					<th>연도</th>
					<th>학기</th>
					<th>학적변동내용</th>
					<th>신청일자</th>
					<th>담당교수승인</th>
					<th>교수승인일자</th>
					<th>최종승인</th>
					<th>학적변동일자</th>
					<th>취소</th>
				</tr>
			</thead>
			<tbody id="listTbody">
				<c:if test="${empty applyList}">
					<tr>
						<td colspan="10" align="center">학적변동 내역이 존재하지 않습니다.</td>
					</tr>
				</c:if>
				<c:forEach items="${applyList }" var="apply" varStatus="status">
					<tr align="center">
						<td>${fn:length(applyList) - status.index }</td>
						<td>${apply.semesterVO.year }</td>
						<td>${apply.semesterVO.semester }</td>
						<td>${apply.applyType }</td>
						<td>${apply.applyDate }</td>
						<td>${apply.profProcessStatus }</td>
						<c:choose>
							<c:when test="${empty apply.profProcessDate }">
								<td>-</td>
							</c:when>
							<c:otherwise>
								<td>${apply.profProcessDate }</td>
							</c:otherwise>
						</c:choose>
						<td><b><i>${apply.adminProcessStatus }</i></b></td>
						<c:choose>
							<c:when test="${empty apply.adminProcessDate }">
								<td>-</td>
							</c:when>
							<c:otherwise>
								<td>${apply.adminProcessDate }</td>
							</c:otherwise>
						</c:choose>
						<td>
							<c:choose>
								<%-- 최종미승인 시 취소 가능 --%>
								<c:when test="${apply.adminProcessStatus eq '미승인' }">
									<input type="button" onclick="deleteAcademicAppAjax('${apply.appNo}', '${apply.stuNo }');" value="취소" class="btn btn-secondary btn-sm">
								</c:when>
								<%-- 최종승인 시 취소 불가능(비활성화 버튼) --%>
								<c:otherwise>
									<button type="button" class="btn btn-secondary btn-sm" disabled>불가</button>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<div class="container">
	<div class="subtitleDiv">
		자퇴 신청
	</div>
	<form action="/stu/academicApp" method="post" id="formTag">
		<div class="tableDiv">
			<table class="table applyTable">
				<colgroup>
					<col width="15%">
					<col width="70%">
					<col width="15%">
				</colgroup>
				<tr>
					<td align="center">신청내용</td>
					<td>
						<c:choose>
							<c:when test="${sessionScope.stuInfo.stuStatus ne '제적'}">
								<select class="form-select" onchange="typeChange();" id="applyType">
									<option value="">신청유형</option>
									<option value="자퇴">자퇴</option>
								</select>
							</c:when>
							<c:otherwise>
								<div>현재 제적상태입니다.</div>
							</c:otherwise>
						</c:choose>
					</td>
					<td>
						<input type="button" class="btn btn-primary applyBtn" value="신청" onclick="apply();">
					</td>
				</tr>
			</table>
		</div>
		<!-- 신청에 필요한 stuNo -->
		<input type="hidden" name="stuNo" id="stuNo" value="${sessionScope.stuInfo.stuNo }">
		<!-- 유효성 검사에 필요한 appNo -->
		<div id="lastAppNoDiv">
			<input type="hidden" name="lastAppNo" id="lastAppNo" value="${applyList[0].appNo }">
		</div>
	</form>
</div>
<div><input type="hidden" id="stuStatusHidden" value="${sessionScope.stuInfo.stuStatus }"></input></div>
<script type="text/javascript" src="/resources/js/stu/academic.js?ver=100"></script>
</body>
</html>