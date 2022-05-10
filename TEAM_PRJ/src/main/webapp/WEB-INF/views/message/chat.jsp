<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="one">
		<input type="text" id="nickname" placeholder="닉네임" /> <input type="button" id="enter" value="입장" />
	</div>
	<div id="two" style="display: none">
		<input type="button" id="exit" value="퇴장"/><br/>
		<div id="chatarea" style="width: 400px; height: 600px; border: 1px solid;"></div>
		<input type="text" id="message" onkeyup="enterkey();" /> 
		<input type="button" id="send" value="보내기" />
	</div>
<script type="text/javascript" src="/resources/js/message/chat.js"></script>
</body>
</html>