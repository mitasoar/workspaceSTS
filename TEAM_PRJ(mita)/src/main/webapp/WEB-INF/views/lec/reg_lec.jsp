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
<form action="/pro/regLec" method="post">
	<table>
		<tr>
			<td>강의 명</td>
			<td>
				<input type="text" name="lecName">
			</td>
			<td>학점</td>
			<td><input type="text" name="lecScore"></td>
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
			<td><input type="text" name="maxNum"></td>
			<td>메모</td>
			<td><input type="text" name="lecMemo"></td>
		</tr>
		<tr>
			<td>날짜</td>
			<td>
				<input type="text" name="lecDate">
			</td>
		</tr>
		<tr>
			<td colspan="4">
				<button type="submit">등록</button>
			</td>
		</tr>
	</table>
</form>

<script type="text/javascript" src="/resources/js/lec/reg_lec.js?ver=3"></script>
</body>
</html>