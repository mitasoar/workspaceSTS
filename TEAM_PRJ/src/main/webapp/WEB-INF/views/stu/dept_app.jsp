<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
전공신청 내역
<div class="" id="">
	<!-- 학적관리 테이블을 학생번호로 조회 -->
	<table class="table">
		<colgroup>
			<col width="4%">
			<col width="4%">
			<col width="4%">
			<col width="6%">
			<col width="20%">
			<col width="8%">
			<col width="18%">
			<col width="18%">
			<col width="6%">
			<col width="5%">
		</colgroup>
		<tr align="center">
			<td>순번</td>
			<td>연도</td>
			<td>학기</td>
			<td>신청내용</td>
			<td>신청학과</td>
			<td>신청일자</td>
			<td>기존학과교수승인</td>
			<td>신청학과교수승인</td>
			<td>최종상태</td>
			<td>취소</td>
		</tr>
		<tbody id="listTbody">
		 	<c:choose>
				<c:when test="${empty applyList}">
					<tr>
						<td colspan="10" align="center">전과 및 복수전공 신청 내역이 존재하지 않습니다.</td>
					</tr>
				</c:when>
				<c:otherwise>
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
										<b>승인대기</b>
									</td>
									<td>
										<input type="button" onclick="deleteDeptAppAjax('${apply.deptAppNo}', '${apply.stuNo }');" value="취소" class="btn btn-secondary btn-sm">
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<b>승인완료</b>
									</td>
									<td>
										<button type="button" class="btn btn-secondary btn-sm" disabled>불가</button>
									</td>
								</c:otherwise>
							</c:choose>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
</div>
전과/복수전공 신청
<div>
	<form action="/stu/deptApp" method="post" id="formTag">
		<table class="table">
			<colgroup>
				<col width="10%">
				<col width="20%">
				<col width="10%">
				<col width="30%">
				<col width="30%">
			</colgroup>
			<tr>
				<td align="center">신청내용</td>
				<td>
					<c:choose>
						<c:when test="${sessionScope.loginInfo.stuStatus ne '제적'}">
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
			</tr>
		</table>
		<!-- 신청에 필요한 stuNo -->
		<input type="hidden" name="stuNo" id="stuNo" value="${sessionScope.loginInfo.stuNo }">
		<!-- 유효성 검사에 필요한 deptAppNo -->
		<input type="hidden" id="listLength" value="${fn:length(applyList) }">
		<div align="right" id="btnDiv">
			<input type="button" class="btn btn-primary" value="신청" onclick="apply();">
		</div>
	</form>
</div>
<div><input type="hidden" id="stuStatusHidden" value="${sessionScope.loginInfo.stuStatus }"></input></div>
<script type="text/javascript" src="/resources/js/stu/dept_app.js?ver=101"></script>
</body>
</html>