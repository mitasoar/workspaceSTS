one = document.getElementById("one");
two = document.getElementById("two");
document.getElementById("enter").addEventListener("click", function() {
	//웹 소켓 연결해주는 함수 호출
	connect();
});
document.getElementById("exit").addEventListener("click", function() {
	//연결을 해제해주는 함수 호출
	disconnect();
});
document.getElementById("send").addEventListener("click", function() {
	//연결을 해제해주는 함수 호출
	send();
});

function enterkey() {
	if (window.event.keyCode == 13) {
		send();
	}
}

var websocket;
var host = document.getElementById('ip').value;
//입장 버튼을 눌렀을 때 호출되는 함수
function connect() {
	websocket = new WebSocket("ws://" + host + ":8081/chat-ws");
	//웹 소켓에 이벤트가 발생했을 때 호출될 함수 등록
	websocket.onopen = onOpen;
	websocket.onmessage = onMessage;
	websocket.onclose = onClose;
	document.getElementById("enter").style.display = 'none';
	document.getElementById("nickname").disabled = true;
	document.getElementById("exit").style.display = 'inline-block';
	document.getElementById("send").disabled = false;
}
//퇴장 버튼을 눌렀을 때 호출되는 함수
function disconnect() {
	websocket.send(nickname + "님이 퇴장하셨습니다.");
	websocket.close();
	document.getElementById("enter").style.display = 'inline-block';
	document.getElementById("nickname").disabled = false;
	document.getElementById("exit").style.display = 'none';
	document.getElementById("send").disabled = true;
}
//보내기 버튼을 눌렀을 때 호출될 함수
function send() {
	nickname = document.getElementById("nickname").value;
	msg = document.getElementById("message").value;
	websocket.send(nickname + " : " + msg);
	document.getElementById("message").value = "";
}
//웹 소켓에 연결되었을 때 호출될 함수
function onOpen() {
	nickname = document.getElementById("nickname").value;
	two = document.getElementById("two");
	two.style.display = 'block';
	websocket.send(nickname + "님이 입장하셨습니다.");
}
//웹 소켓에서 데이터를 받아올 때 호출될 함수
function onMessage(evt) {
	data = evt.data;
	chatarea = document.getElementById("chatarea");
	chatarea.innerHTML = data + "<br/>" + chatarea.innerHTML;
}
//웹 소켓에서 연결이 해제 되었을 때 호출될 함수
function onClose() {
	msg = document.getElementById("nickname").value;
	data = ":" + msg + "님이 퇴장하셨습니다";
	chatarea = document.getElementById("chatarea");
	chatarea.innerHTML = data + "<br/>" + chatarea.innerHTML;
}


