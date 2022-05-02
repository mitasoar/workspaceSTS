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
				location.href = '/member/home'; // 화면 이동
			} else { // 로그인 실패
				alert('로그인이 실패하였습니다.. 다시 확인해주세요.');
			}
		}
	})
	
	return false; // action 태그를 막기위한 false
}