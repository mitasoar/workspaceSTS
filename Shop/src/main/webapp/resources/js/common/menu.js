// 모달 창 종료 시 데이터 리셋
const loginModalEl = document.getElementById('loginModal');
loginModalEl.addEventListener('hidden.bs.modal', function(event) {
	const tags = document.querySelectorAll('#loginModal input');
	for (let i = 0; i < tags.length; i++) {
		tags[i].value = '';
	}
})

const joinModalEl = document.getElementById('joinModal');
joinModalEl.addEventListener('hidden.bs.modal', function(event) {
	const tags = document.querySelectorAll('#joinModal input');
	for (let i = 0; i < tags.length; i++) {
		tags[i].value = '';
	}
})

// 우편번호 검색 API
function execDaumPostcode() {
	new daum.Postcode({
		oncomplete: function(data) {
			// 우편번호와 주소 정보를 해당 필드에 넣는다.
			document.getElementById("addr").value = data.roadAddress;
		}
	}).open();
}

// 회원정보수정 버튼 비활성화
const editTarget = document.querySelector('#editBtn');
editTarget.disabled = true;

// 회원정보수정 버튼 활성화
// 비밀번호 체크
const editPw1 = document.getElementById('editPassword');
const editPw2 = document.getElementById('editPasswordCheck');

editPw1.addEventListener('keyup', function(event) {
	if (editPw1.value == editPw2.value) {
		editPw2.style.borderColor = '#ced4da';
		editTarget.disabled = false;
	} else {
		editPw2.style.borderColor = 'red';
		editTarget.disabled = true;
	}
})

editPw2.addEventListener('keyup', function(event) {
	if (editPw1.value == editPw2.value) {
		editPw2.style.borderColor = '#ced4da';
		editTarget.disabled = false;
	} else {
		editPw2.style.borderColor = 'red';
		editTarget.disabled = true;
	}
})

// 회원정보수정 ajax
function editMember() {
	$.ajax({
		url: "/member/edit",
		type: "POST",
		data: new FormData(document.querySelector('#editForm')),
		processData: false,
		contentType: false,
		success: function() {
			alert("회원정보가 정상적으로 수정되었습니다.");
			location.href = '/item/itemList';
		},
		error: function() {
			alert("회원정보수정 실패.. 다시 확인해주세요.");
		}
	})
}

// 회원가입 버튼 비활성화
const joinTarget = document.querySelector('#joinModal button[type=submit]');
joinTarget.disabled = true;

// 회원가입 버튼 활성화
// 비밀번호 체크
let pwCheck = false;
const joinPw1 = document.getElementById('inputPassword');
const joinPw2 = document.getElementById('inputPasswordCheck');

joinPw1.addEventListener('keyup', function(event) {
	if (joinPw1.value == joinPw2.value) {
		joinPw2.style.borderColor = '#ced4da';
		pwCheck = true;
		if (pwCheck && idCheck) {
			joinTarget.disabled = false;
		}
	} else {
		joinPw2.style.borderColor = 'red';
		pwCheck = false;
		joinTarget.disabled = true;
	}
})

joinPw2.addEventListener('keyup', function(event) {
	if (joinPw1.value == joinPw2.value) {
		joinPw2.style.borderColor = '#ced4da';
		pwCheck = true;
		if (pwCheck && idCheck) {
			joinTarget.disabled = false;
		}
	} else {
		joinPw2.style.borderColor = 'red';
		pwCheck = false;
		joinTarget.disabled = true;
	}
})


// 회원가입 ajax
function joinMember() {
	$.ajax({
		url: "/member/join",
		type: "POST",
		data: new FormData(document.querySelector('#joinForm')),
		processData: false,
		contentType: false,
		success: function(data) {
			if (data == 'ok') {
				location.href = '/item/itemList';
			} else {
				alert("로그인 실패.. 아이디와 비밀번호를 다시 확인해주세요.");
			}
		},
	})
}

// 아이디 체크
let idCheck = false;
const id = document.getElementById('inputId');
const idCheckBtn = document.getElementById('idCheckBtn');
idCheckBtn.disabled = true;

id.addEventListener('keyup', function(event) {
	if (id.value.length == 0) {
		idCheckBtn.disabled = true;
	} else {
		idCheckBtn.disabled = false;
	}
	idCheck = false;
	joinTarget.disabled = true;
})

// 아이디 중복체크 ajax
function checkId() {
	$.ajax({
		url: "/member/idCheck",
		type: "POST",
		data: {
			id: $("#inputId").val()
		},
		success: function(data) {
			if (data == 'ok') {
				alert("사용가능한 ID입니다.");
				idCheck = true;
				if (pwCheck && idCheck) {
					joinTarget.disabled = false;
				}
			} else {
				alert("중복되는 ID입니다.");
				idCheck = false;
				joinTarget.disabled = true;
			}
		},
		/*
		error: function() {
			alert("중복되는 ID입니다.");
			idCheck = false;
			joinTarget.disabled = true;
		}
		*/
	})
}

// 로그인 ajax
function login() {
	$.ajax({
		url: "/member/login",
		type: "POST",
		data: {
			memId: $("#loginId").val(),
			memPw: $("#loginPw").val()
		},
		success: function(data) {
			if (data == 'ok') {
				location.href = '/item/itemList';
			} else {
				alert("로그인 실패.. 아이디와 비밀번호를 다시 확인해주세요.");
			}
		},
	})
}

// 로그아웃
function logout() {
	if (confirm('로그아웃 하시겠습니까?')) {
		alert("로그아웃 되었습니다.");
		location.href = '/member/logout';
	}
}
