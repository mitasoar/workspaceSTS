<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.outDiv{
	margin-bottom: 15px;
}
</style>
</head>
<body>

<div class="outDiv" style="margin-top: 10px;">
	<h1 style="border-bottom: 1px solid #C9D6DF; width: 200px; padding-bottom: 5px; ">수강 신청</h1>
</div>	
<div class="row outDiv">
	<div class="col-3">
		<select onchange="searchDept();" id="selectColl" name="collNo" class="form-select" required>
			<option value="">전체</option>
			<c:forEach items="${collList }" var="coll">
				<option value="${coll.collNo }">${coll.collName }</option>
			</c:forEach>
		</select>
	</div>
	<div class="col-3">
		<select class="form-select" id="selectDept">
			<option value="">전체</option>
		</select>
	</div>
	<div class="col-6">
		<div class="input-group mb-3">
			<input type="text" class="form-control" placeholder="검색" id="searchName">
			<button class="btn btn-outline-secondary" type="button" id="button-addon2" onclick="searchLec();">검색</button>
		</div>
	</div>
</div>
<div class="row">
	<div class="col">
		<table class="table">
			<thead>
				<tr style="background-color: #CCCCCC">
					<th scope="col">#</th>
					<th scope="col">강의명</th>
					<th scope="col">학점</th>
					<th scope="col">단대명</th>
					<th scope="col">학과명</th>
					<th scope="col">담당교수</th>
					<th scope="col">최대인원</th>
					<th scope="col">현재인원</th>
					<th scope="col">날짜</th>
					<th scope="col">신청</th>
				</tr>
			</thead>
			<tbody id="lecTable">
				<c:forEach items="${lecList }" var="lec">
					<tr>
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
								${time.day } / 
								<c:choose>
									<c:when test="${time.firstTime eq time.lastTime}">
										${time.firstTime } 교시
									</c:when>
									<c:otherwise>
										${time.firstTime } ~ ${time.lastTime } 교시
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</td>
						<td>
							<c:set var="result" value="true"/>
							<c:choose>
								<c:when test="${lec.maxNum == lec.nowNum }">
									<button type="button" class="btn btn-secondary">수강 마감</button>
								</c:when>
								<c:when test="${not empty regLecList }">
									<c:forEach items="${regLecList }" var="regLec">
										<c:if test="${regLec.lecNo eq lec.lecNo }">
											<button type="button" class="btn btn-primary">신청 완료</button>
											<c:set var="result" value="false"/>
										</c:if>
									</c:forEach>
									<c:if test="${result }">
										<button type="button" class="btn btn-dark" onclick="regClass('${lec.lecNo}');">수강 신청</button>
									</c:if>
								</c:when>
								<c:otherwise>
									<button type="button" class="btn btn-dark" onclick="regClass('${lec.lecNo}');">수강 신청</button>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<script type="text/javascript" src="/resources/js/stu/reg_class.js?ver=31"></script>
</body>
</html>