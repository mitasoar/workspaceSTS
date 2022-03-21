function addItem() {
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