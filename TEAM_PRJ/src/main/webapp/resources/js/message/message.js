function writeMsg() {
	let htmlCode = '<form class="w-75 mx-auto" action="#" id="msgForm" onsubmit="return sendMsg();">';
	htmlCode += '<div class="mt-3 mb-3">';
	htmlCode += '<label for="toUser" class="form-label">받는사람</label>';
	htmlCode += '<input type="text" class="form-control" id="toUser" name="toUser" placeholder="받는사람" autocomplete="off" onkeyup="searchMember(this);" onfocus="searchMember(this);" onblur="emptySearchList();" required>';
	htmlCode += '<div class="position-absolute">';
	htmlCode += '<ul class="list-group" id="searchList"></ul>';
	htmlCode += '</div>';
	htmlCode += '</div>';
	htmlCode += '<div class="mb-3">';
	htmlCode += '<label for="content" class="form-label">쪽지 내용</label>';
	htmlCode += '<textarea class="form-control" placeholder="쪽지 내용" maxlength="200" id="content" name="content" style="height: 200px; resize: none;" required></textarea>';
	htmlCode += '</div>';
	htmlCode += '<div class="text-center">';
	htmlCode += '<button class="btn btn-primary w-25">보내기</button>';
	htmlCode += '</div>';
	htmlCode += '</form>';
	
	document.getElementById('msgDiv').style.display = "none";
	document.getElementById('chatDiv').style.display = "block";
	document.getElementById('chatDiv').style.margin = "auto";
	document.getElementById('chatDiv').innerHTML = htmlCode;
}

function searchMember(name) {
	name.dataset.memNo = '';
	$.ajax({
		url: "/member/list",
		type: "GET",
		data: {name: name.value},
		success: function(data) {
			$('#searchList').empty();
			data.forEach((e, i) => {
				let code = "<li class='list-group-item li-hover position-relative' role='button' onmouseDown='selectMember(this);' onmouseover='viewMemberImg(this, \"" + e.memImage + "\");' onmouseout='removeImg(this);' memNo='" + e.memNo + "'>" + e.memName + "(";
				if (e.memGender == 'male') {
					code += "남, ";
				} else {
					code += "여, ";
				}
				if (e.memType == 'stu') {
					code += "학생";
				} else {
					code += "교직원";
				}
				$('#searchList').append(
					code + ", " + e.memNo + ")</li>"
				);
			});
		},
		error: function() {
		}
	});
}

function selectMember(member) {
	document.getElementById('toUser').value = member.innerText.split('(')[0];
	document.getElementById('toUser').dataset.memNo = member.getAttribute('memNo');
	emptySearchList();
}

function emptySearchList() {
	$('#searchList').empty();
}

function viewMemberImg(list, memImage) {
	let img = document.createElement("img");
	img.src = "/resources/images/" + memImage;
	img.width = 200;
	img.height = 200;
	img.style.border = '1px solid #EEEEEE';
	img.style.position = 'absolute';
	img.style.top = '0';
	img.style.left = '-202px';
	
	list.appendChild(img);
}

function removeImg(list) {
	list.removeChild(list.children[0]);
}

function sendMsg(toUser, toUserName) {
	let boolChat = false; // 메세지 목록창에서 보내는지 확인 여부
	if (toUser == null || toUser == undefined) { // 메세지 보내기에서 전송
		toUser = document.getElementById('toUser').dataset.memNo;
		if (toUser.length == 0) { // 받는사람 미입력
			alert('쪽지 받는사람이 존재하지 않습니다.. 다시 확인해주세요!');
			
			return false;
		}
	} else { // 메세지 목록에서 전송
		boolChat = true;
	}
	
	$.ajax({
		url: "/message/sendMsg",
		type: "POST",
		data: {
			toUser : toUser
			, content : document.getElementById('content').value
		},
		success: function() {
			if (boolChat) { // 메세지 목록에서 전송
				fromMsgList();
				chatMsgList(toUser, toUserName);
			} else { // 메세지 보내기에서 전송
				document.getElementById('toUser').dataset.memNo = '';
				document.getElementById('toUser').value = '';
				document.getElementById('content').value = '';
				alert('쪽지가 전송되었습니다.');
			}
		},
		error: function() {
			alert('쪽지 전송이 실패하였습니다.. 다시 확인해주세요.');
		}
	})

	return false;
}

function fromMsgList() {
	document.getElementById('msgDiv').style.display = "block";
	document.getElementById('msgDiv').innerHTML = '';
	document.getElementById('chatDiv').innerHTML = '';
	document.getElementById('chatDiv').style.display = 'none';
	
	let user = document.getElementById('memNo').value; // 나
	let msgUserId = ''; // 대화 상대 아이디
	let msgUserName = ''; // 대화 상대 이름

	let today = new Date();
	
	let year = today.getFullYear();
	let month = ('0' + (today.getMonth() + 1)).slice(-2);
	let day = ('0' + today.getDate()).slice(-2);
	
	let todayStr = year + '-' + month  + '-' + day;
	
	$.ajax({
		url: "/message/chatList",
		type: "GET",
		data: {},
		success: function(data) {
			if (data.length == 0) {
				document.getElementById('msgDiv').innerHTML = '<div class="ms-3 mt-3">메세지가 없습니다.. 불쌍해..</div>'
			} else {
				data.forEach((e, i) => {
				let sendTime = e.sendTime.split(' ');
				if (e.toUser == user) { // 받는사람이 나
					msgUserId = e.fromUser;
					msgUserName = e.fromUserName;
				} else { // 보내는 사람이 나
					msgUserId = e.toUser;
					msgUserName = e.toUserName;
				}
				let htmlCode = '<div class="card" role="button" onclick="chatMsgList(\'' + msgUserId + '\', \'' + msgUserName + '\', this)">';
				htmlCode += '<div class="card-body">';
				htmlCode += '<div class="row">';
				htmlCode += '<h5 class="card-title fw-bold col-md-8">' + msgUserName;
				if (msgUserId == user) {
					htmlCode += '(나)';
				}
				htmlCode += '</h5>';
				if (sendTime[0] == todayStr) { // 오늘
					htmlCode += '<span class="col-md-4 text-end">' + sendTime[1] + '</span>';
				} else { // 이전
					htmlCode += '<span class="col-md-4 text-end">' + sendTime[0].slice(5, 7) + '월 ' + sendTime[0].slice(8) + '일' + '</span>';
				}
				htmlCode += '</div>';
				htmlCode += '<div class="row">';
				htmlCode += '<p class="card-text col-md-10">' + e.content + '</p>';
				htmlCode += '<div class="col-md-2">';
				if (e.fromUser != user && e.toUser == user && e.readTime == null) { // 내가 받은 메세지 중 읽지 않은 메세지인 경우
					htmlCode += '<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-chat-dots text-primary" viewBox="0 0 16 16">';
					htmlCode += '<path d="M5 8a1 1 0 1 1-2 0 1 1 0 0 1 2 0zm4 0a1 1 0 1 1-2 0 1 1 0 0 1 2 0zm3 1a1 1 0 1 0 0-2 1 1 0 0 0 0 2z"/>';
					htmlCode += '<path d="m2.165 15.803.02-.004c1.83-.363 2.948-.842 3.468-1.105A9.06 9.06 0 0 0 8 15c4.418 0 8-3.134 8-7s-3.582-7-8-7-8 3.134-8 7c0 1.76.743 3.37 1.97 4.6a10.437 10.437 0 0 1-.524 2.318l-.003.011a10.722 10.722 0 0 1-.244.637c-.079.186.074.394.273.362a21.673 21.673 0 0 0 .693-.125zm.8-3.108a1 1 0 0 0-.287-.801C1.618 10.83 1 9.468 1 8c0-3.192 3.004-6 7-6s7 2.808 7 6c0 3.193-3.004 6-7 6a8.06 8.06 0 0 1-2.088-.272 1 1 0 0 0-.711.074c-.387.196-1.24.57-2.634.893a10.97 10.97 0 0 0 .398-2z"/>';
					htmlCode += '</svg>';
				}
				htmlCode += '</div></div></div></div>';
				
				document.getElementById('msgDiv').innerHTML += htmlCode;
			});
			}
		},
		error: function() {
		}
	})
}

function chatMsgList(userId, userName, chatDiv) {
	if (chatDiv != null && chatDiv != undefined && chatDiv.children[0].children[1].children[1].children[0] != undefined) { // 아이콘이 있을 시
		chatDiv.children[0].children[1].children[1].removeChild(chatDiv.children[0].children[1].children[1].children[0]); // 확인 아이콘 지우기
	}
	
	let myId = document.getElementById('memNo').value;
	
	let code = '<div class="card">';
	code += '<div class="card-header fw-bold fs-4" id="msgHeader"></div>';
	code += '<div class="card-body" id="msgBody"></div>';
	code += '<div class="card-footer text-muted text-center">';
	code += '<form href="#"  onsubmit="return sendMsg(\'' + userId + '\', \'' + userName + '\');">';
	code += '<input type="text" class="form-control w-75 d-inline-block" id="content" name="content" maxlength="200" autocomplete="off" required>';
	code += '<button class="btn btn-warning mb-1">전송</button>';
	code += '</form></div></div>';
	document.getElementById('chatDiv').innerHTML = code;
	document.getElementById('chatDiv').style.display = 'block';
	document.getElementById('msgHeader').innerText = userName;
	if (userId == myId) {
		document.getElementById('msgHeader').innerText += '(나)';
	}
	
	let today = new Date();
	
	let year = today.getFullYear();
	let month = ('0' + (today.getMonth() + 1)).slice(-2);
	let day = ('0' + today.getDate()).slice(-2);
	
	let todayStr = year + '-' + month  + '-' + day;
	
	$.ajax({
		url: "/message/chatMsgList",
		type: "GET",
		data: {
			toUser : myId
			, fromUser : userId
		},
		success: function(data) {
			document.getElementById('msgBody').innerHTML = '';
			let changeDay = false;
			data.forEach((e, i) => {
				let code = '';
				let time = '';
				let sendTime = e.sendTime.split(' ');
				if (todayStr == sendTime[0]) { // 오늘 날짜
					time = sendTime[1]; // 시간 표시
					if (!changeDay) {
						code += '<div class="text-center mt-1 mb-1"><hr/><span class="fw-bold">Today</span><hr/></div>'
						changeDay = true;
					}
				} else { // 이전 날짜
					time = sendTime[0].slice(5, 7) + '월 ' + sendTime[0].slice(8) + '일'; // 날짜 표시
				}
				
				if (e.fromUser == myId) { // 내가 보낸 메세지
					code += '<div class="text-end mb-1"><span class="me-2">';
					if (e.readTime == null) { // 상대가 읽지 않은경우
						code += '<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-chat-dots pb-1 me-1 text-success" viewBox="0 0 16 16">';
						code += '<path d="M5 8a1 1 0 1 1-2 0 1 1 0 0 1 2 0zm4 0a1 1 0 1 1-2 0 1 1 0 0 1 2 0zm3 1a1 1 0 1 0 0-2 1 1 0 0 0 0 2z"/>';
						code += '<path d="m2.165 15.803.02-.004c1.83-.363 2.948-.842 3.468-1.105A9.06 9.06 0 0 0 8 15c4.418 0 8-3.134 8-7s-3.582-7-8-7-8 3.134-8 7c0 1.76.743 3.37 1.97 4.6a10.437 10.437 0 0 1-.524 2.318l-.003.011a10.722 10.722 0 0 1-.244.637c-.079.186.074.394.273.362a21.673 21.673 0 0 0 .693-.125zm.8-3.108a1 1 0 0 0-.287-.801C1.618 10.83 1 9.468 1 8c0-3.192 3.004-6 7-6s7 2.808 7 6c0 3.193-3.004 6-7 6a8.06 8.06 0 0 1-2.088-.272 1 1 0 0 0-.711.074c-.387.196-1.24.57-2.634.893a10.97 10.97 0 0 0 .398-2z"/>';
						code += '</svg>';
					}
					code += time + '</span><span class="card-text d-inline-block p-2 max-w-75 bg-myTalk">' + e.content + '</span></div>';
				} else { // 내가 받은 메세지
					code += '<div class="mb-1"><span class="card-text d-inline-block p-2 max-w-75 bg-yourTalk">' + e.content + '</span><span class="ms-2">' + time + '</span></div>';
				}
				document.getElementById('msgBody').innerHTML += code;
			});
			$("#msgBody").scrollTop($("#msgBody")[0].scrollHeight);
			inFocus();
		},
		error: function() {
		}
	});
}

function inFocus() {
	document.getElementById('content').focus();
}

$(document).ready(function(){
	fromMsgList();
});
