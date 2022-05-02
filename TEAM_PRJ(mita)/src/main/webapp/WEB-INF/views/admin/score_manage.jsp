<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.container{
	text-align: center;
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
				<td>
					<select name="collNo" class="form-select">
						<option>option1</option>
						<option>option2</option>
						<option>option3</option>
						<option>option4</option>
					</select>
				</td>
				<td>학과명</td>
				<td>
					<select name="collNo" class="form-select">
						<option>option1</option>
						<option>option2</option>
						<option>option3</option>
						<option>option4</option>
					</select>
				</td>
				<td>강의명</td>
				<td>
					<input type="text" placeholder="강의명" name="memName" class="form-control">
				</td>
				<td>
					<input type="button" class="btn btn-primary" value="검색" onclick="aaa();">
				</td>
			</tr>
		</thead>
	</table>
	<div class="contentDiv">강의를 검색하세요</div>
</div>
<script type="text/javascript" src="/resources/js/admin/score_manage.js"></script>
</body>
</html>