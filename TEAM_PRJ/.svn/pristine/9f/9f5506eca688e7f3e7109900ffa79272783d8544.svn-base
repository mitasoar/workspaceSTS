let isLogout = true; // 로그아웃 확인 여부

setTimeout(function() {
	isLogout = confirm('페이지 이동없이 50분이 지났습니다.\n10분후 자동 로그아웃 됩니다. 로그아웃 하시겠습니까?');
	if (isLogout) {
		setTimeout(function() {
			location.href = "/member/logout";
		}, 10 * 60 * 1000)
	}
}, 50 * 60 * 1000);
