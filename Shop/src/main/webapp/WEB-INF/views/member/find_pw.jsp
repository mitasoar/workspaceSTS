<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/member/findPw" method="post">
		ID <input type="text" name="memId" id="findId">
		<button type="button" class="btn btn-warning" onclick="sendEmail(this);">찾기</button>
		<button class="btn btn-warning" type="button" id="loadingBtn" style="opacity: 0;" disabled="disabled">
		  <span class="spinner-border spinner-border-sm" role="status" aria-hidden="true"></span>
		  <span class="visually-hidden">Loading...</span>
		</button>
	</form>
</body>
<script type="text/javascript" src="/resources/js/member/find_pw.js"></script>
</html>