function writeBoard() {
	$.ajax({ // 글쓰기 ajax
		url: "/board/boardWrite",
		type: "POST",
		data: new FormData(document.querySelector('#boardForm')),
		dataType: "text",
		processData: false,
		contentType: false,
		success: function() {
			alert('게시글이 등록되었습니다.');
			location.href = '/board/boardList';
		},
		error: function() {
			alert('게시글 등록이 실패하였습니다.. 다시 확인해주세요.');
		}
	})
	
	return false;
}