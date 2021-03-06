<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#lecTable tr td:nth-child(odd){
	text-align: center;
}
#lecTable tr td{
	margin-bottom: 50px;
	line-height: 3rem;
}
#lecTable{
	margin-bottom: 30px;
}
.outDiv{
	width: 900px;
	margin: 0 auto;
}
.outDiv:last-child button {
	width: 100px;
	background-color: #214099;
}
</style>
</head>
<body>
<div class="outDiv">
	<h1 style="border-bottom: 1px solid #C9D6DF; width: 200px; margin-bottom: 15px; padding-bottom: 5px;">강의 등록</h1>
</div>
<div >
	<form action="/pro/regLec" method="post" id="regLecForm">
		<table id="lecTable" class="outDiv">
			<colgroup>
				<col width="10%">
				<col width="40%">
				<col width="10%">
				<col width="40%">
			</colgroup>
			<tr style="margin-bottom: 20px;">
				<td >강의명</td>
				<td>
					<input type="text" class="form-control" name="lecName" autocomplete="off">
				</td>
			</tr>
			<tr>
				<td>단과대</td>
				<td>
					<select onchange="searchDept();" class="form-select" id="selectColl" name="collNo" required>
						<c:forEach items="${collList }" var="coll">
							<option value="${coll.collNo }">${coll.collName }</option> 
						</c:forEach>
					</select>
				</td>
				<td>학과</td>
				<td>
					<select id="selectDept" name="deptNo" class="form-select" required>
					</select>
				</td>
			</tr>
			<tr>
				<td>학기</td>
				<td>
					<input type="hidden" value="${sem.semNo }" name="semVO.semNo">
					${sem.semName }<br> 
				</td>
			</tr>
			<tr>
				<td>최대 인원</td>
				<td><input type="number" name="maxNum" max="60" min="1" class="form-control" value="1"></td>
			</tr>
			<tr>
				<td>학점</td>
				<td>
					<select class="form-select" name="lecScore">
							<option>1</option>
							<option>2</option>
							<option>3</option>
							<option>4</option>
							<option>5</option>
					</select> 
				</td>
			</tr>
			<tr>
				<td>요일</td>
				<td>
					<!-- <select name="timeList[0].day" class="test1"> -->
					<select name="time0" class="test1 form-select">
						<option>월</option>
						<option>화</option>
						<option>수</option>
						<option>목</option>
						<option>금</option>
					</select>
				</td>
				<td>시간</td>
				<td>
	 				<select name="timeList[0].firstTime" class="form-select" style="width: 60px; display: inline;" onchange="selectTime(this);">
						<option>1</option>
						<option>2</option>
						<option>3</option>
						<option>4</option>
						<option>5</option>
						<option>6</option>
						<option>7</option>
						<option>8</option>
					</select> 교시 ~
					<select name="timeList[0].lastTime" class="form-select" style="width: 60px; display: inline;">
						<option>1</option>
						<option>2</option>
						<option>3</option>
						<option>4</option>
						<option>5</option>
						<option>6</option>
						<option>7</option>
						<option>8</option>
					</select>
					교시
					<span id="addButton"><button type="button" class="btn btn-secondary" onclick="addTime(0);">추가</button></span>
					<span id="removeButton"></span>
				</td>
			</tr>
		</table>
		<div class="outDiv" style="text-align: center; margin-top: 10px;">
			<button type="submit" class="btn btn-dark outDiv">등록</button>
		</div>
	</form>
</div>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<script type="text/javascript" src="/resources/js/professor/reg_lec.js?ver=47"></script>
</body>
</html>