function searchMember(name) {
	name.dataset.memNo = '';
	$.ajax({
		url: "/member/list",
		type: "GET",
		data: {name: name.value},
		success: function(data) {
			$('#searchList').empty();
			data.forEach((e, i) => {
				$('#searchList').append(
					"<li class='list-group-item' role='button' onclick='selectMember(this);' memNo='" + e.memNo + "'>" + e.memName + "</li>"
				);
			});
		},
		error: function() {
		}
	})
}

function selectMember(member) {
	document.getElementById('toUser').value = member.innerText;
	document.getElementById('toUser').dataset.memNo = member.getAttribute('memNo');
	$('#searchList').empty();
}

function sendMsg() {
	if (document.getElementById('toUser').dataset.memNo.length == 0) {
		alert('쪽지 받는사람이 존재하지 않습니다.. 다시 확인해주세요!');
	} else {
		$.ajax({
			url: "/message/sendMsg",
			type: "POST",
			data: {
				toUser : document.getElementById('toUser').dataset.memNo
				, content : document.getElementById('content').value
			},
			success: function() {
				alert('쪽지가 전송되었습니다.');
			},
			error: function() {
				alert('쪽지 전송이 실패하였습니다.. 다시 확인해주세요.');
			}
		})
	}

	return false;
}

function writeMsg() {
	let htmlCode = '<form action="#" id="msgForm" onsubmit="return sendMsg();">';
	htmlCode += '<div class="mb-3">';
	htmlCode += '<label for="toUser" class="form-label">받는사람</label>';
	htmlCode += '<input type="text" class="form-control" id="toUser" name="toUser" placeholder="받는사람" autocomplete="off" onkeyup="searchMember(this);" required>';
	htmlCode += '<div class="position-absolute">';
	htmlCode += '<ul class="list-group" id="searchList"></ul>';
	htmlCode += '</div>';
	htmlCode += '</div>';
	htmlCode += '<div class="mb-3">';
	htmlCode += '<label for="content" class="form-label">쪽지 내용</label>';
	htmlCode += '<textarea class="form-control" placeholder="쪽지 내용" id="content" name="content" style="height: 200px; resize: none;" required></textarea>';
	htmlCode += '</div>';
	htmlCode += '<button class="btn btn-warning">보내기</button>';
	htmlCode += '</form>';
			
	document.getElementById('msgDiv').innerHTML = htmlCode;
}

function fromMsgList() {
	document.getElementById('msgDiv').innerHTML = '';
	let user = document.getElementById('memNo').value; // 나
	let msgUserId = ''; // 대화 상대 아이디
	let msgUserName = ''; // 대화 상대 이름
	
	$.ajax({
		url: "/message/chatList",
		type: "GET",
		data: {},
		success: function(data) {
			data.forEach((e, i) => {
				if (e.toUser == user) { // 받는사람이 나
					msgUserId = e.fromUser;
					msgUserName = e.fromUserName;
				} else { // 보내는 사람이 나
					msgUserId = e.toUser;
					msgUserName = e.toUserName;
				}
				let htmlCode = '<div class="card" role="button" onclick="chatMsgList(\'' + msgUserId + '\')">';
				htmlCode += '<div class="card-body">';
				htmlCode += '<div class="row">';
				htmlCode += '<h5 class="card-title fw-bold col-md-6">' + msgUserName + '</h5>';
				htmlCode += '<span class="col-md-6 text-end">' + e.sendTime + '</span>';
				htmlCode += '</div>';
				htmlCode += '<div class="row">';
				htmlCode += '<p class="card-text col-md-10">' + e.content + '</p>';
				htmlCode += '<div class="col-md-2"></div>';
				htmlCode += '</div></div></div>';
				
				document.getElementById('msgDiv').innerHTML += htmlCode;
			});
		},
		error: function() {
		}
	})
}

function chatMsgList(user) {
	$.ajax({
		url: "/message/chatMsgList",
		type: "GET",
		data: {
			toUser : user
			, fromUser : document.getElementById('memNo').value
		},
		success: function(data) {
			debugger;
			/*data.forEach((e, i) => {
				let htmlCode = '<div class="card w-25" role="button" onclick="chatMsg(' + e.msgNo + ')">';
				htmlCode += '<div class="card-body">';
				htmlCode += '<div class="row">';
				if (e.toUser == user) {
					htmlCode += '<h5 class="card-title fw-bold col-md-6">' + e.fromUserName + '</h5>';
				} else {
					htmlCode += '<h5 class="card-title fw-bold col-md-6">' + e.toUserName + '</h5>';
				}
				htmlCode += '<span class="col-md-6 text-end">' + e.sendTime + '</span>';
				htmlCode += '</div>';
				htmlCode += '<div class="row">';
				htmlCode += '<p class="card-text col-md-10">' + e.content + '</p>';
				htmlCode += '<div class="col-md-2"></div>';
				htmlCode += '</div></div></div>';
				
				document.getElementById('msgDiv').innerHTML += htmlCode;
			});*/
		},
		error: function() {
		}
	});
}

$(document).ready(function(){
	fromMsgList();
});