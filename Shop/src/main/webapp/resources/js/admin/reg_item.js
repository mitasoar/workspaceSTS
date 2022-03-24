function addItem() {
	if (document.querySelector('#bookName').value.length < 1) {
		alert('도서명을 입력해주세요.');
	} else if (document.querySelector('#bookPrice').value.length < 1) {
		alert('도서가격을 입력해주세요.');
	} else if (document.querySelector('#img').value.length < 1 && document.querySelector('#subImg').value.length > 0) {
		alert('대표이미지가 없이 추가이미지 등록은 안됩니다.')
	} else {
		$.ajax({
			url: "/admin/insertItem",
			type: "POST",
			data: new FormData(document.querySelector("#itemForm")),
			processData: false,
			contentType: false,
			success: function() {
				alert("상품이 정상적으로 등록되었습니다.")
				location.href = '/admin/regItem';
			},
			error: function() {
				alert("상품등록 오류.. 다시 확인해주세요.");
			}
		})
	}
}
