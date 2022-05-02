function sendEmail(btn) {
	btn.remove();
	document.getElementById('loadingBtn').style.opacity = "100";
	
	$.ajax({
		url: "/member/findPw",
		type: "POST",
		data: {memId : document.getElementById('findId').value},
		success: function() {
			alert("메일이 전송되었습니다. 확인해주세요!")
			location.href = '/member/findPw';
		},
		error: function() {
			alert("메일전송 오류.. 다시 확인해주세요.");
			location.reload();
		}
	})
}