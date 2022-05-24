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
	<div class="subtitleDiv">전공신청 내역</div>
	<!-- 학적관리 테이블을 학생번호로 조회 -->
	<table class="table">
		<thead>
			<tr align="center">
				<th>순번</th>
				<th>연도</th>
				<th>학기</th>
				<th>신청내용</th>
				<th>신청학과</th>
				<th>신청일자</th>
				<th>기존학과교수승인</th>
				<th>신청학과교수승인</th>
				<th>최종상태</th>
				<th>취소</th>
			</tr>
		</thead>
		<tbody id="listTbody">
			<c:if test="${empty applyList}">
				<tr>
					<td colspan="10" align="center">전과 및 복수전공 신청 내역이 존재하지 않습니다.</td>
				</tr>
			</c:if>
			<c:forEach items="${applyList }" var="apply" varStatus="status">
				<tr align="center">
					<td>${fn:length(applyList) - status.index }</td>
					<td>${apply.semesterVO.year }</td>
					<td>${apply.semesterVO.semester }</td>
					<td>${apply.applyType }</td>
					<td>${apply.applyCollName} ${apply.applyDeptName }</td>
					<td>${apply.applyDate }</td>
					<td>${apply.oriDeptProcessDate } ${apply.oriDeptProcessStatus }</td>
					<td>${apply.appDeptProcessDate } ${apply.appDeptProcessStatus }</td>
					<c:choose>
						<c:when test="${apply.oriDeptProcessStatus eq '미승인' or apply.appDeptProcessStatus eq '미승인'}">
							<td>
								<b><i>승인대기</i></b>
							</td>
							<td>
								<input type="button" onclick="deleteDeptAppAjax('${apply.deptAppNo}', '${apply.stuNo }');" value="취소" class="btn btn-secondary btn-sm">
							</td>
						</c:when>
						<c:otherwise>
							<td>
								<b><i>승인완료</i></b>
							</td>
							<td>
								<button type="button" class="btn btn-secondary btn-sm" disabled>불가</button>
							</td>
						</c:otherwise>
					</c:choose>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<div class="container">
	<div class="subtitleDiv">전과/복수전공 신청</div>
	<form action="/stu/deptApp" method="post" id="formTag">
		<table class="table applyTable">
			<colgroup>
				<col width="15%">
				<col width="15%">
				<col width="15%">
				<col width="20%">
				<col width="20%">
				<col width="15%">
			</colgroup>
			<tr>
				<td align="center">신청내용</td>
				<td>
					<c:choose>
						<c:when test="${sessionScope.stuInfo.stuStatus ne '제적'}">
							<div class="row">
								<div class="col-10" id="categoryDiv">
									<select class="form-select" id="applyType">
										<option value="">선택</option>
										<option value="전과">전과</option>
										<option value="복수전공">복수전공</option>
									</select>
								</div>
							</div>
						</c:when>
						<c:otherwise>
							<div>현재 제적상태입니다.</div>
						</c:otherwise>
					</c:choose>
				</td>
				<td align="center">신청학과</td>
				<td>
					<select class="form-select" onchange="collChangeAjax();" id="coll">
						<option value="">단과대학</option>
						<c:forEach items="${collList }" var="coll">
							<option value="${coll.collNo }">${coll.collName }</option>
						</c:forEach>
					</select>
				</td>
				<td>
					<select class="form-select" id="dept">
						<option value="">학과</option>
						<c:forEach items="${deptList }" var="dept">
							<option value="${dept.deptNo }">${dept.deptName }</option>
						</c:forEach>
					</select>
				</td>
				<td>
					<input type="button" class="btn btn-primary applyBtn" value="신청" onclick="apply();">
				</td>
			</tr>
		</table>
		<!-- 신청에 필요한 stuNo -->
		<input type="hidden" name="stuNo" id="stuNo" value="${sessionScope.stuInfo.stuNo }">
		<!-- 유효성 검사에 필요한 deptAppNo -->
		<input type="hidden" id="listLength" value="${fn:length(applyList) }">
	</form>
</div>
<div><input type="hidden" id="stuStatusHidden" value="${sessionScope.stuInfo.stuStatus }"></input></div>
<script type="text/javascript" src="/resources/js/stu/dept_app.js?ver=101"></script>
</body>
</html>