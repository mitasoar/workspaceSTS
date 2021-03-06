// 페이지 로드 시 작동하는 함수
$(function(){
	let saveId = getCookie("saveId"); // 쿠키에 저장된 아이디 값 가져오기
	
	if (saveId.length > 0) { // 쿠키에 저장된 아이디가 있는 경우
		$("input[name='memId']").val(saveId); // 저장된 아이디 값 input 세팅
		$("#chkSaveId").attr("checked", true); // 아이디 저장 체크값에 체크하기
	}
});

function login() {
	$.ajax({ // 로그인 ajax
		url: "/member/login",
		type: "POST",
		data: new FormData(document.querySelector('#loginForm')),
		dataType: "text",
		processData: false,
		contentType: false,
		success: function(data) {
			if (data == 'ok') { // 로그인 성공
				alert('로그인 되었습니다.'); // 로그인 알림창
			 	
			 	deleteCookie("saveId"); // 쿠키 삭제
			 	
			 	if($("#chkSaveId").is(":checked")){ // 아이디 저장 체크 시
					setCookie("saveId", $("input[name='memId']").val(), 30); // 쿠키 저장
			 	}
				
				location.href = '/main/main'; // 화면 이동
			} else { // 로그인 실패
				alert('로그인이 실패하였습니다.. 다시 확인해주세요.');
			}
		}
	})
	
	return false; // action 태그를 막기위한 false
}

// 아이디 찾기
function findId() {
	document.querySelector('#findModalTitle').innerText = '아이디 찾기';
	document.querySelector('#findEmail').onclick = findIdFromEmail;
	document.querySelector('#findPhone').onclick = findIdFromPhone;
	$('#findModal').modal('show');
}

// 비밀번호 찾기
function findPw() {
	document.querySelector('#findModalTitle').innerText = '비밀번호 찾기';
	document.querySelector('#findEmail').onclick = findPwFromEmail;
	document.querySelector('#findPhone').onclick = findPwFromPhone;
	$('#findModal').modal('show');
}

// 아이디 찾기(이메일)
function findIdFromEmail() {
	document.querySelector('#findModalTitle').innerText = '아이디 찾기(이메일)';
	let bodyCode = '<form action="#" onsubmit="return sendIdFromEmail();">';
	bodyCode += '<input type="email" class="form-control d-inline-block w-75" id="findEmail" name="findEmail" placeholder="이메일을 입력해주세요" autocomplete="off" required>';
	bodyCode += '<button type="submit" class="btn ms-1 mb-1" id="btnSend">전송</button>';
	bodyCode += '<button class="btn" type="button" id="loadingBtn" disabled="disabled">';
	bodyCode += '<span class="spinner-border spinner-border-sm" role="status" aria-hidden="true"></span>';
	bodyCode += '<span class="visually-hidden">전송중...</span>';
	bodyCode += '</button></form>';
	document.querySelector('#findModalBody').innerHTML = bodyCode;
	$('#loadingBtn').hide();
}

// 비밀번호 찾기(이메일)
function findPwFromEmail() {
	document.querySelector('#findModalTitle').innerText = '비밀번호 찾기(이메일)';
	let bodyCode = '<form action="#" onsubmit="return sendPwFromEmail();">';
	bodyCode += '<input type="email" class="form-control d-inline-block w-75" id="findEmail" name="findEmail" placeholder="이메일을 입력해주세요" autocomplete="off" required>';
	bodyCode += '<button type="submit" class="btn ms-1 mb-1" id="btnSend">전송</button>';
	bodyCode += '<button class="btn" type="button" id="loadingBtn" disabled="disabled">';
	bodyCode += '<span class="spinner-border spinner-border-sm" role="status" aria-hidden="true"></span>';
	bodyCode += '<span class="visually-hidden">전송중...</span>';
	bodyCode += '</button></form>';
	document.querySelector('#findModalBody').innerHTML = bodyCode;
	$('#loadingBtn').hide();
}

// 아이디 찾기(연락처)
function findIdFromPhone() {
	document.querySelector('#findModalTitle').innerText = '아이디 찾기(연락처)';
	let bodyCode = '<form action="#" onsubmit="return sendIdFromPhone();">';
	bodyCode += '<input type="text" class="form-control d-inline-block w-75" id="findPhone" name="findPhone" placeholder="연락처 번호만 입력해주세요 ex)01012345678" autocomplete="off" minlength="10" maxlength="11" pattern="^[0-9]+$" required>';
	bodyCode += '<button type="submit" class="btn ms-1 mb-1" id="btnSend">전송</button>';
	bodyCode += '<button class="btn" type="button" id="loadingBtn" disabled="disabled">';
	bodyCode += '<span class="spinner-border spinner-border-sm" role="status" aria-hidden="true"></span>';
	bodyCode += '<span class="visually-hidden">전송중...</span>';
	bodyCode += '</button></form>';
	document.querySelector('#findModalBody').innerHTML = bodyCode;
	$('#loadingBtn').hide();
}

// 비밀번호 찾기(연락처)
function findPwFromPhone() {
	document.querySelector('#findModalTitle').innerText = '비밀번호 찾기(연락처)';
	let bodyCode = '<form action="#" onsubmit="return sendPwFromPhone();">';
	bodyCode += '<input type="text" class="form-control d-inline-block w-75" id="findPhone" name="findPhone" placeholder="연락처 번호만 입력해주세요 ex)01012345678" autocomplete="off" minlength="10" maxlength="11" pattern="^[0-9]+$" required>';
	bodyCode += '<button type="submit" class="btn ms-1 mb-1" id="btnSend">전송</button>';
	bodyCode += '<button class="btn" type="button" id="loadingBtn" disabled="disabled">';
	bodyCode += '<span class="spinner-border spinner-border-sm" role="status" aria-hidden="true"></span>';
	bodyCode += '<span class="visually-hidden">전송중...</span>';
	bodyCode += '</button></form>';
	document.querySelector('#findModalBody').innerHTML = bodyCode;
	$('#loadingBtn').hide();
}

// 아이디 전송(이메일)
function sendIdFromEmail() {
	$('#btnSend').hide();
	$('#loadingBtn').show();
	
	$.ajax({
		url: "/member/sendIdFromEmail",
		type: "POST",
		data: {email : $('#findEmail').val()},
		success: function(data) {
			if (data == 'ok') {
				$('#findModal').modal('hide');
				alert("메일이 발송되었습니다. 확인해주세요!");
			} else {
				alert("해당하는 이메일로 가입된 정보가 없습니다.. 다시 확인해주세요.");
				$('#btnSend').show();
				$('#loadingBtn').hide();
			}
		},
		error: function() {
			alert("메일 발송 오류.. 다시 확인해주세요.");
		}
	})
	
	return false;
}

// 비밀번호 전송(이메일)
function sendPwFromEmail() {
	$('#btnSend').hide();
	$('#loadingBtn').show();
	
	$.ajax({
		url: "/member/sendPwFromEmail",
		type: "POST",
		data: {email : $('#findEmail').val()},
		success: function(data) {
			if (data == 'ok') {
				$('#findModal').modal('hide');
				alert("메일이 발송되었습니다. 확인해주세요!");
			} else {
				alert("해당하는 이메일로 가입된 정보가 없습니다.. 다시 확인해주세요.");
				$('#btnSend').show();
				$('#loadingBtn').hide();
			}
		},
		error: function() {
			alert("메일 발송 오류.. 다시 확인해주세요.");
		}
	})
	
	return false;
}

// 아이디 전송(연락처)
function sendIdFromPhone() {
	$('#btnSend').hide();
	$('#loadingBtn').show();
	
	$.ajax({
		url: "/member/sendIdFromPhone",
		type: "POST",
		data: {phone : $('#findPhone').val()},
		success: function(data) {
			if (data == 'ok') {
				$('#findModal').modal('hide');
				alert("문자가 발송되었습니다. 확인해주세요!");
			} else {
				alert("해당하는 연락처로 가입된 정보가 없습니다.. 다시 확인해주세요.");
				$('#btnSend').show();
				$('#loadingBtn').hide();
			}
		},
		error: function() {
			alert("문자 발송 오류.. 다시 확인해주세요.");
		}
	})
	
	return false;
}

// 비밀번호 전송(연락처)
function sendPwFromPhone() {
	$('#btnSend').hide();
	$('#loadingBtn').show();
	
	$.ajax({
		url: "/member/sendPwFromPhone",
		type: "POST",
		data: {phone : $('#findPhone').val()},
		success: function(data) {
			if (data == 'ok') {
				$('#findModal').modal('hide');
				alert("문자가 발송되었습니다. 확인해주세요!");
			} else {
				alert("해당하는 연락처로 가입된 정보가 없습니다.. 다시 확인해주세요.");
				$('#btnSend').show();
				$('#loadingBtn').hide();
			}
		},
		error: function() {
			alert("문자 발송 오류.. 다시 확인해주세요.");
		}
	})
	
	return false;
}

// modal 종료 시, 이벤트 처리
$('#findModal').on('hidden.bs.modal', function() {
	let bodyCode = '<button type="button" class="btn me-2" id="findEmail">이메일로 찾기</button>';
	bodyCode += '<button type="button" class="btn ms-2" id="findPhone">연락처로 찾기</button>';
	document.querySelector('#findModalBody').innerHTML = bodyCode;
});

// 툴팁 띄우기
var tooltipTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="tooltip"]'))
var tooltipList = tooltipTriggerList.map(function (tooltipTriggerEl) {
  return new bootstrap.Tooltip(tooltipTriggerEl);
});

// 쿠키 저장
function setCookie(cookieName, value, exdays){
    var exdate = new Date();
    exdate.setDate(exdate.getDate() + exdays);
    var cookieValue = escape(value) + ((exdays==null) ? "" : "; expires=" + exdate.toGMTString());
    document.cookie = cookieName + "=" + cookieValue;
}

// 쿠키 삭제
function deleteCookie(cookieName){
    var expireDate = new Date();
    expireDate.setDate(expireDate.getDate() - 1);
    document.cookie = cookieName + "= " + "; expires=" + expireDate.toGMTString();
}

// 쿠키 가져오기
function getCookie(cookieName) {
    cookieName = cookieName + '=';
    var cookieData = document.cookie;
    var start = cookieData.indexOf(cookieName);
    var cookieValue = '';
    if(start != -1){
        start += cookieName.length;
        var end = cookieData.indexOf(';', start);
        if(end == -1)end = cookieData.length;
        cookieValue = cookieData.substring(start, end);
    }
    return unescape(cookieValue);
}
