const btnPw = document.getElementById('btnPw'); // 비밀번호 변경 버튼
btnPw.disabled = true; // 버튼 비활성화

const joinPw = document.getElementById('inputPassword'); // 새 비밀번호

// 비밀번호 체크
function checkPw() { 
	const joinPwCheck = document.getElementById('inputPasswordCheck'); // 새 비밀번호 확인
	
	if (joinPw.value == joinPwCheck.value) { // 비밀번호와 2차 비밀번호가 같을 경우
		joinPwCheck.style.borderColor = '#ced4da'; // border 원색으로 변경
		btnPw.disabled = false; // 버튼 활성화
	} else { // 비밀번호와 2차 비밀번호가 다른 경우
		joinPwCheck.style.borderColor = 'red'; // border 빨간색으로 변경
		btnPw.disabled = true; // 버튼 비활성화
	}
}

// 비밀번호 변경 버튼
function editPw() {
	const checkPw = document.getElementById('checkPassword'); // 입력한 현재 비밀번호
	
	$.ajax({
		url: "/member/checkPw",
		type: "GET",
		data: {memPw: checkPw.value},
		success: function(data){
			if (data == 'ok') { // 입력한 현재 비밀번호가 맞을 경우
				$.ajax({
					url: "/member/editPw",
					type: "POST",
					data: {memPw: joinPw.value},
					success: function() {
						alert("비밀번호가 변경되었습니다.");
						location.href="/member/home";
					},
					error: function() {
						alert("비밀번호 변경 실패.. 다시 확인해주세요");
					}
				})
			} else { // 입력한 현재 비밀번호가 틀린 경우
				alert('현재 비밀번호가 틀립니다.. 다시 확인해주세요');
			}
		},
		error: function() {
			alert("비밀번호 변경 실패.. 다시 확인해주세요");
		}
	})
	
	return false;
}