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
학사경고
<div class="container">
	<!-- 학생 검색 기능 -->
	<table class="table">
		<colgroup>
			<col width="13%">
			<col width="30%">
			<col width="13%">
			<col width="30%">
			<col width="14%">
		</colgroup>
		<tr>
			<td>대학</td>
			<td>
				<select name="collNo" id="coll" class="form-select" onchange="collChangeAjax();">
					<option value="">전체</option>
					<c:forEach items="${collList }" var="collInfo">
						<option value="${collInfo.collNo }">${collInfo.collName }</option>
					</c:forEach>
				</select>
			</td>
			<td>학년</td>
			<td>
				<select name="stuYear" id="stuYear" class="form-select">
					<option value="0">전체</option>
					<option value="1">1학년</option>
					<option value="2">2학년</option>
					<option value="3">3학년</option>
					<option value="4">4학년</option>
					<option value="5">5학년</option>
					<option value="6">6학년</option>
					<option value="7">7학년</option>
				</select>
			</td>
			<td rowspan="3">
				<input type="button" class="btn btn-primary" value="검색" onclick="searchStudentAjax();">
			</td>
		</tr>
		<tr>
			<td>전공</td>
			<td>
				<select name="deptNo" id="dept" class="form-select">
					<option value="">전체</option>
					<c:forEach items="${deptList }" var="deptInfo">
						<option value="${deptInfo.deptNo }">${deptInfo.deptName }</option>
					</c:forEach>
				</select>
			</td>
			<td>학적</td>
			<td>
				<select name="stuStatus" id="stuStatus" class="form-select">
					<option value="">전체</option>
					<option value="재학">재학</option>
					<option value="휴학">휴학</option>
					<option value="제적">제적</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>학사경고유형</td>
			<td>
				<select class="form-select" name="scholType">
					<option value="">전체</option>
					<option value="이수학점 미달">이수학점 미달</option>
					<option value="평균학점 미달">평균학점 미달</option>
					<option value="학칙 위반">학칙 위반</option>
					<option value="부정행위">부정행위</option>
					<option value="수강신청 미시행">수강신청 미시행</option>
					<option value="등록금 미납">등록금 미납</option>
				</select>
			</td>
			<td>성명</td>
			<td><input type="text" placeholder="이름" name="memName" id="memName" class="form-control" onkeyup="enterkey();"></td>
		</tr>
	</table>
	<!-- 검색된 학생리스트가 표시될 div -->
	<div id="listDiv">
		<div style="text-align: center;">학생을 검색하세요</div>
	</div>

	<!-- 학생 이름 클릭 시 실행되는 modal -->
	<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
		<div class="modal-dialog" id="modalDialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="staticBackdropLabel">Modal title</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<table class="table">
						<colgroup>
							<col width="25%">
							<col width="75%">
						</colgroup>
						<tr>
							<td rowspan="2">사진</td>
							<td>배도훈[32161989] 성별</td>
						</tr>
						<tr>
							<td>학년 학적</td>
						</tr>
						<tr>
							<td>소속</td>
							<td>스포츠과학대학 생활체육학과</td>
						</tr>
						<tr>
							<td>복수전공</td>
							<td>자연과학대학 식품영양학과</td>
						</tr>
						<tr>
							<td>생년월일</td>
							<td>960301</td>
						</tr>
						<tr>
							<td>연락처</td>
							<td>010-0000-0000</td>
						</tr>
						<tr>
							<td>주소</td>
							<td>울산광역시 남구 신정동</td>
						</tr>
						<tr>
							<td colspan="2">누적 경고</td>
						</tr>
						<tr>
							<td colspan="2">경고1 : 사유 20022-03-20</td>
						</tr>
						<tr>
							<td colspan="2">경고2 : 사유 20022-05-20</td>
						</tr>
						<tr>
							<td colspan="2">등등</td>
						</tr>
					</table>
					<div style="text-align: center;">
						<input type="checkbox"> 학생에게 안내 메일 전송
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
					<button type="button" class="btn btn-primary">저장</button>
				</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript" src="/resources/js/admin/probation.js"></script>
</body>
</html>