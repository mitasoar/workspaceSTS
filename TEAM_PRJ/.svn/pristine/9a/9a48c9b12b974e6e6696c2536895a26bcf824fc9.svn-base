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
.tableDiv {
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
					<th>학적변동일시</th>
					<th>취소</th>
				</tr>
			</thead>
			<tbody id="listTbody">
			 	<c:choose>
					<c:when test="${empty applyList}">
						<tr>
							<td colspan="10" align="center">학적변동 내역이 존재하지 않습니다.</td>
						</tr>
					</c:when>
					<c:otherwise>
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
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
	</div>
</div>

<div class="container">
	<div class="subtitleDiv">휴/복학 신청</div>
	<form action="/stu/academicApp" method="post" id="formTag">
		<div class="tableDiv">
			<table class="table applyTable">
				<colgroup>
					<col width="15%">
					<col width="40%">
					<col width="15%">
					<col width="30%">
				</colgroup>
				<tr>
					<td align="center">신청내용</td>
					<td colspan="3">
						<c:choose>
							<c:when test="${sessionScope.stuInfo.stuStatus ne '제적'}">
								<div class="row">
									<div class="col-5" id="categoryDiv">
										<select class="form-select" onchange="typeChange();" id="category">
											<option value="신청유형">신청유형</option>
											<option value="휴학">휴학</option>
											<option value="복학">복학</option>
										</select>
									</div>
									<div class="col-5" id="subCategoryDiv">
										<select class="form-select" name="applyType" id="applyType">
											<option value="">신청유형을 선택하세요</option>
										</select>
									</div>
									<div class="col-2 btnDiv">
										<input type="button" class="btn btn-primary applyBtn" value="신청" onclick="apply();">
									</div>
								</div>
							</c:when>
							<c:otherwise>
								<div>현재 제적상태입니다.</div>
							</c:otherwise>
						</c:choose>
					</td>
					<!-- <td align="center">휴학기간</td>
					<td>
						<div class="row">
							<div class="col-4">
								<input type="number" class="form-control" id="applyDate" value="1" min="1" max="3" onchange="">
							</div>
							<div class="col-4">학기</div>				
						</div>
					</td> -->
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
<script type="text/javascript" src="/resources/js/stu/academic.js?ver=101"></script>
</body>
</html>