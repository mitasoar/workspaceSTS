function searchBoard() {
	let searchType = document.getElementById('searchType').value; // 검색 유형
	let searchInput = document.getElementById('searchInput').value; // 검색 내용
	let searchHref = '/board/boardList?cateNo=' + document.getElementById('cateNo').value; // 검색 주소 값
	
	if (searchType == 'title&content') { // 제목 + 내용
		searchHref += '&boardTitle=' + searchInput + '&boardContent=' + searchInput;
	} else if (searchType == 'title') { // 제목
		searchHref += '&boardTitle=' + searchInput;
	} else if (searchType == 'content') { // 내용
		searchHref += '&boardContent=' + searchInput;
	} else if (searchType == 'writer') { // 작성자
		searchHref += '&boardWriter=' + searchInput;
	} else if (searchType == 'replyContent') { // 댓글내용
		searchHref += '&replyContent=' + searchInput;
	} else if (searchType == 'replyWriter') { // 댓글작성자
		searchHref += '&replyWriter=' + searchInput;
	}
	
	if (document.getElementById('isSecret').checked) { // 비밀글 제외
		searchHref += '&isSecret=' + document.getElementById('isSecret').value;
	}
	
	location.href = searchHref;
	
	return false;
}