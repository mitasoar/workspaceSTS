function editBoard(boardNo) {
	$.ajax({ // 글수정 ajax
		url: "/board/editBoard",
		type: "POST",
		data: new FormData(document.querySelector('#editForm')),
		processData: false,
		contentType: false,
		enctype: "multipart/form-data",
		success: function() {
			alert('게시글이 수정되었습니다.');
			location.href = '/board/boardContent?boardNo='+boardNo;
		},
		error: function() {
			alert('게시글 수정이 실패하였습니다.. 다시 확인해주세요.');
		}
	})
	
	return false;
}

$(document).ready(function() {
	$("a[name='file-delete']").on("click", function(e) {
		e.preventDefault();
		deleteFile($(this));
	});
	
	changeNotice(document.getElementById('isNotice'));
})

function addFile() {
	var str = "<div class='file-group'><input class='form-control d-inline-block w-94 me-2' type='file' name='files'><a href='#this' class='link-danger text-decoration-none' name='file-delete'>삭제</a></div>";
	$("#file-list").append(str);
	$("a[name='file-delete']").on("click", function(e) {
		e.preventDefault();
		deleteFile($(this));
	});
}

function deleteFile(obj) {
	obj.parent().remove();
}

function changeNotice(noticeChk) { // 공지사항 체크/미체크 시
	if (noticeChk.checked == true) { // 공지사항 체크 시
		document.getElementById('isSecret').disabled = true; // 비밀글 기능 닫기
		document.getElementById('isSecret').checked = false; // 비밀글 기능 닫기
	} else { // 공지사항 미체크 시
		document.getElementById('isSecret').disabled = false; // 비밀글 기능 열기
	}
}