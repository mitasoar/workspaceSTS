<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.container{
	text-align: center;
}
.lecNameSpan{
	cursor: pointer;
}
</style>
</head>
<body>
<div style="text-align: left;">성적관리화면</div>
<div class="container">
	<table class="table">
		<colgroup>
			<col>
			<col>
			<col>
			<col>
			<col>
			<col>
			<col>
		</colgroup>
		<thead>
			<tr>
				<td>단과대학명</td>
				<td><select name="collNo" id="coll" class="form-select"
					onchange="collChangeAjax()">
						<option value="">전체</option>
						<c:forEach items="${collList }" var="collInfo">
							<option value="${collInfo.collNo }">${collInfo.collName }</option>
						</c:forEach>
				</select></td>
				<td>학과명</td>
				<td><select name="deptNo" id="dept" class="form-select">
						<option value="">전체</option>
						<c:forEach items="${deptList }" var="deptInfo">
							<option value="${deptInfo.deptNo }">${deptInfo.deptName }</option>
						</c:forEach>
				</select></td>
				<td onclick="">강의명</td>
				<td><input type="text" id="lecName" placeholder="강의명" name="lecName" class="form-control" onkeyup="enterkey();">
				</td>
				<td><input type="button" class="btn btn-primary" value="검색" onclick="searchLecAjax();"></td>
			</tr>
		</thead>
	</table>
		<!-- 검색 시 테이블과 모달이 들어올 div -->
	<div id="listDiv">
		<div class="contentDiv">강의를 검색하세요</div>
	</div>
</div>
<script type="text/javascript" src="/resources/js/admin/score_manage.js?ver=102"></script>
</body>
</html>