<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 변경 화면</title>
</head>
<body>
	<div class="col-12"><h5>ID : ${loginInfo.memNo}</h5></div>
	<form action="#" onsubmit="return editPw();">
		<div class="col-12">
			<label for="checkPassword" class="form-label">현재 비밀번호</label> <input
				type="password" class="form-control" id="checkPassword"
				placeholder="현재 비밀번호를 입력해주세요"
				required>
		</div>
		<div class="col-12">
			<label for="inputPassword" class="form-label">새 비밀번호</label> <input
				type="password" class="form-control" id="inputPassword" name="memPw"
				minlength="8" maxlength="16"
				placeholder="영어, 숫자, 특수문자를 각각 하나 이상 포함하여 8자 이상 16자 이하"
				oninput="checkPw();"
				pattern="^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,16}$"
				required>
		</div>
		<div class="col-12">
			<label for="inputPasswordCheck" class="form-label">새 비밀번호 확인</label> <input
				type="password" class="form-control" id="inputPasswordCheck"
				name="memPwCheck" minlength="8" maxlength="16"
				placeholder="영어, 숫자, 특수문자를 각각 하나 이상 포함하여 8자 이상 16자 이하"
				oninput="checkPw();"
				pattern="^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,16}$"
				required>
		</div>
		<button type="submit" class="btn btn-dark" id="btnPw">비밀번호 변경</button>
	</form>
	<script type="text/javascript" src="/resources/js/member/editPw.js"></script>
</body>
</html>