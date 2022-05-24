<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.table{
	text-align: center;
}
.container{
	margin-top: 20px;
}
.outTable{
	width: 1200px;
	margin-bottom: 20px;
}
.outTable tr td:first-child, .outTable tr td:last-child {
	text-align: center;
}
</style>
</head>
<body>
<div>
	<h1 style="border-bottom: 1px solid #C9D6DF; width: 200px; margin-bottom: 15px; padding-bottom: 5px;">강의 목록</h1>
</div>
<table class="outTable">
	<colgroup>
		<col width="20%">
		<col width="30%%">
		<col width="40%">
		<col width="10%">
	</colgroup>
	<tr>
		<td>
			<input class="form-check-input radiobox" type="radio" name="lecClose" id="flexRadioDefault1" value="" checked> 
			<label class="form-check-label" for="flexRadioDefault1"> 전체 </label>
			<input class="form-check-input radiobox" type="radio" name="lecClose" id="flexRadioDefault2" value="N"> 
			<label class="form-check-label" for="flexRadioDefault2"> 강의 </label>
			<input class="form-check-input radiobox" type="radio" name="lecClose" id="flexRadioDefault3" value="Y"> 
			<label class="form-check-label" for="flexRadioDefault3"> 폐강 </label>
		</td>
		<td>
			<select class="form-select" id="selectSem">
				<option value="">전체</option>
				<c:forEach items="${semList }" var="sem">
					<option value="${sem.semNo }">${sem.semName }</option>
				</c:forEach>
			</select>
		</td>
		<td>
			<input type="text" style="margin-left: 3px;" class="form-control" placeholder="검색" id="searchName">	
		</td>
		<td>
			<button class="btn btn-outline-dark" type="button" style="width: 100px; margin-top: 4px;" onclick="searchLec();">검색</button>
		</td>
	</tr>
</table>
<table class="table outTable">
	<colgroup>
		<col width="6%">
		<col width="9%">
		<col width="6%">
		<col width="12%">
		<col width="12%">
		<col width="8%">
		<col width="7%">
		<col width="7%">
		<col width="16%">
		<col width="8%">
		<col width="9%">
	</colgroup>
	<thead>
		<tr style="background-color: #214099; color: white;">
			<td scope="col">#</td>
			<td scope="col">강의명</td>
			<td scope="col">학점</td>
			<td scope="col">단대명</td>
			<td scope="col">학과명</td>
			<td scope="col">담당교수</td>
			<td scope="col">최대인원</td>
			<td scope="col">현재인원</td>
			<td scope="col">날짜</td>
			<td scope="col">강의상태</td>
			<td scope="col">폐강</td>
		</tr>
	</thead>
	<tbody id="lecTable">
		<c:forEach items="${lecList }" var="lec">
			<tr style="vertical-align: middle;" onclick="searchStu('${lec.lecNo}');" role="button">
				<th scope="row">${lec.lecNo }</th>
				<td>${lec.lecName }</td>
				<td>${lec.lecScore }</td>
				<td>${lec.deptVO.collVO.collName }</td>
				<td>${lec.deptVO.deptName }</td>
				<td>${lec.empVO.memberVO.memName }</td>
				<td>${lec.maxNum }</td>
				<td>${lec.nowNum }</td>
				<td>
					<c:forEach items="${lec.timeList }" var="time">
						<div>
							${time.day } / 
							<c:choose>
								<c:when test="${time.firstTime eq time.lastTime}">
									${time.firstTime } 교시
								</c:when>
								<c:otherwise>
									${time.firstTime } ~ ${time.lastTime } 교시
								</c:otherwise>
							</c:choose>
						</div>
					</c:forEach>
				</td>
				<td>
					<c:choose>
						<c:when test="${lec.lecClose eq 'N' }">
							강의중
						</c:when>
						<c:otherwise>
							폐강
						</c:otherwise>
					</c:choose>
				</td>
				<td onclick="event.cancelBubble=true"><button type="button" class="btn btn-outline-danger" onclick="lecClose('${lec.lecNo}');" >폐강</button></td>
			</tr>
		</c:forEach>
	</tbody>
</table>



<!-- Modal -->
<div class="modal fade" id="lecStuModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">학생 목록</h5>
				<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			</div>
			<div class="modal-body">
				<table class="table">
					<thead>
						<tr style="background-color: #214099; color: white;">
							<th scope="col">학번</th>
							<th scope="col">이름</th>
							<th scope="col">단대명</th>
							<th scope="col">학과명</th>
							<th scope="col">학년</th>
							<th scope="col">성적</th>
							<th scope="col">변경</th>
							<th scope="col"></th>
						</tr>
					</thead>
					<tbody id="lecStuTbody">
						
					</tbody>
				</table>
			</div>

		</div>
	</div>
</div>

<script type="text/javascript" src="/resources/js/professor/lec_list.js?ver=38"></script>
</body>
</html>