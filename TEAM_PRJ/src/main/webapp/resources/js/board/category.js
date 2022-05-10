function changeCate() { // 카테고리 선택 시
	// input 값에 선택한 카테고리명 삽입
	document.querySelector('input[name=cateName]').value = document.querySelector('select[name=cateNo]').selectedOptions[0].label;
	
	if (document.querySelector('select[name=cateNo]').selectedOptions[0].text == 'N') { // 선택한 카테고리가 사용중이지 않을 때
		document.querySelector('select[name=isUse]').options[1].selected = true; // 사용안함 으로 변경
	} else { // 사용중일 때
		document.querySelector('select[name=isUse]').options[0].selected = true; // 사용 으로 변경
	}
}

function updateCate() { // 카테고리 변경
	if (document.querySelector('input[name=cateName]').value.trim().length == 0) { // 변경하려는 카테고리명이 없을 시
		alert('카테고리명을 입력해주세요');
	} else { // 있을 시
		$.ajax({ // 카테고리 수정 ajax
			url: "/board/editCategory",
			type: "POST",
			data: {
				cateNo : document.querySelector('select[name=cateNo]').value
				, cateName : document.querySelector('input[name=cateName]').value
				, isUse : document.querySelector('select[name=isUse]').value
			},
			success: function() {
				alert('카테고리가 수정되었습니다.');
				location.reload();
			},
			error: function() {
				alert('카테고리 수정이 실패하였습니다.. 다시 확인해주세요.');
			}
		})
	}
}

function insertCate() { // 카테고리 추가
	if (document.querySelector('input[name=newCate]').value.trim().length == 0) { // 추가하려는 카테고리명이 없을 시
		alert('카테고리명을 입력해주세요');
	} else { // 있을 시
		$.ajax({ // 카테고리 추가 ajax
			url: "/board/insertCategory",
			type: "POST",
			data: {
				cateName : document.querySelector('input[name=newCate]').value
			},
			success: function() {
				alert('카테고리가 추가되었습니다.');
				location.reload();
			},
			error: function() {
				alert('카테고리 추가가 실패하였습니다.. 다시 확인해주세요.');
			}
		})
	}
}

$(document).ready(function() {
	changeCate();
})
