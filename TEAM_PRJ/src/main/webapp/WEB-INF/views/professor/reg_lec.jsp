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
강의 등록 페이지입니다
<form action="/pro/regLec" method="post" id="regLecForm">
	<table id="lecTable">
		<tr>
			<td>강의 명</td>
			<td>
				<input type="text" name="lecName">
			</td>
			<td>학점</td>
			<td>
				<select name="lecScore">
					<option>1</option>
					<option>2</option>
					<option>3</option>
					<option>4</option>
					<option>5</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>단과대</td>
			<td>
				<select onchange="searchDept();" id="selectColl" name="collNo" required>
					<option>선택</option>
					<c:forEach items="${collList }" var="coll">
						<option value="${coll.collNo }">${coll.collName }</option>
					</c:forEach>
				</select>
			</td>
			<td>과</td>
			<td>
				<select id="selectDept" name="deptNo" required>
					<option>선택</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>최대 인원</td>
			<td><input type="number" name="maxNum" max="60" min="1"></td>
			<td>학기</td>
			<td>
				<input type="hidden" value="${sem.semNo }" name="semVO.semNo">
				<input type="text" value="${sem.semName }" name="232" readonly>
			</td>
		</tr>
		<tr>
			<td>요일</td>
			<td>
				<!-- <select name="timeList[0].day" class="test1"> -->
				<select name="time0" class="test1">
					<option>월</option>
					<option>화</option>
					<option>수</option>
					<option>목</option>
					<option>금</option>
				</select>
			</td>
			<td>시간</td>
			<td>
 				<select name="timeList[0].firstTime">
					<option>1</option>
					<option>2</option>
					<option>3</option>
					<option>4</option>
					<option>5</option>
					<option>6</option>
					<option>7</option>
					<option>8</option>
				</select>
				교시 ~
				<select name="timeList[0].lastTime">
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
				<span id="addButton"><button type="button" onclick="addTime(0);">추가</button></span>
				<span id="removeButton"></span>
			</td>
		</tr>
	</table>
	<div>
		<button type="submit">등록</button>
	</div>
</form>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<script type="text/javascript" src="/resources/js/professor/reg_lec.js?ver=40"></script>
</body>
</html>