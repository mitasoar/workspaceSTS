<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 변경 화면</title>
</head>
<body>
	<div class="w-50 mx-auto">
		<form class="row" action="#" onsubmit="return editPw();">
			<div class="col-12 mt-4 mb-3 text-center">
				<h5>
					ID : ${loginInfo.memNo}
					<c:if test="${not empty loginInfo.stuNo}">
						(${loginInfo.stuNo})
					</c:if>
					<c:if test="${not empty loginInfo.empNo}">
						(${loginInfo.empNo})
					</c:if>
				</h5>
			</div>
			<div class="col-10 mx-auto mb-2">
				<label for="checkPassword" class="form-label">현재 비밀번호</label> <input
					type="password" class="form-control" id="checkPassword"
					placeholder="현재 비밀번호를 입력해주세요"
					required>
			</div>
			<div class="col-10 mx-auto mb-2">
				<label for="inputPassword" class="form-label">새 비밀번호</label> <input
					type="password" class="form-control" id="inputPassword" name="memPw"
					minlength="8" maxlength="16"
					placeholder="영어, 숫자, 특수문자를 각각 하나 이상 포함하여 8자 이상 16자 이하"
					oninput="checkPw();"
					pattern="^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,16}$"
					required>
			</div>
			<div class="col-10 mx-auto mb-2">
				<label for="inputPasswordCheck" class="form-label">새 비밀번호 확인</label> <input
					type="password" class="form-control" id="inputPasswordCheck"
					name="memPwCheck" minlength="8" maxlength="16"
					placeholder="영어, 숫자, 특수문자를 각각 하나 이상 포함하여 8자 이상 16자 이하"
					oninput="checkPw();"
					pattern="^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,16}$"
					required>
			</div>
			<div class="col-3 mx-auto mt-4 mb-2">
				<button type="submit" class="btn btn-primary w-100" id="btnPw">비밀번호 변경</button>
			</div>
		</form>
	</div>
	<script type="text/javascript" src="/resources/js/member/editPw.js"></script>
</body>
</html>