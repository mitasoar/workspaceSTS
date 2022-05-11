<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="text-center">
		<div id="one" class="mb-3">
			<input type="text" id="nickname" placeholder="닉네임" /> <input type="button" id="enter" value="입장" /><input type="button" style="display: none;" id="exit" value="퇴장"/>
		</div>
		<div id="two" class="mt-3 mb-3" style="display: none">
			<div id="chatarea" style="width: 500px; height: 600px; border: 1px solid black; margin: auto; margin-bottom: 15px; text-align: left;"></div>
			<input type="text" id="message" style="width: 400px;" onkeyup="enterkey();" /> 
			<input type="button" id="send" value="보내기" />
		</div>
	</div>
<script type="text/javascript" src="/resources/js/message/chat.js"></script>
</body>
</html>