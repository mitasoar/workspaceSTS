<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="w-50 mx-auto text-center mt-3">
		<div id="one" class="mb-3">
			<input type="text" class="form-control w-50 d-inline-block" id="nickname" placeholder="닉네임" /> 
			<button type="button" class="btn btn-success mb-1" id="enter">입장</button>
			<button type="button" class="btn btn-danger mb-1" style="display: none;" id="exit">퇴장</button>
		</div>
		<div id="two" class="mt-3 mb-3" style="display: none">
			<div id="chatarea" style="width: 500px; height: 600px; border: 1px solid black; margin: auto; margin-bottom: 15px; padding: 5px 10px; text-align: left; overflow: auto;"></div>
			<input type="text" id="message" class="form-control w-50 d-inline-block" onkeyup="enterkey();" /> 
			<button type="button" id="send" class="btn btn-warning mb-1">보내기</button>
		</div>
		<input type="hidden" id="ip" value="${ip}">
	</div>
<script type="text/javascript" src="/resources/js/message/chat.js"></script>
</body>
</html>