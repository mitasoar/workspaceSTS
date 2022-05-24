function writeBoard() {
	$.ajax({ // 글쓰기 ajax
		url: "/board/boardWrite",
		type: "POST",
		data: new FormData(document.querySelector('#boardForm')),
		processData: false,
		contentType: false,
		enctype: "multipart/form-data",
		success: function(boardNo) {
			alert('게시글이 등록되었습니다.');
			location.href = '/board/boardContent?boardNo=' + boardNo;
		},
		error: function() {
			alert('게시글 등록이 실패하였습니다.. 다시 확인해주세요.');
		}
	})

	return false;
}

$(document).ready(function() {
	$("a[name='file-delete']").on("click", function(e) {
		e.preventDefault();
		deleteFile($(this));
	});
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