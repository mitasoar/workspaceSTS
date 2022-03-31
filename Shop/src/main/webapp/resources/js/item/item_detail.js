// 수량 변경 시
function changeQty() {
	let totalPrice = document.querySelector('#totalPrice');
	totalPrice.dataset.price = document.getElementById('itemPrice').value * document.querySelector('#itemQty').value;
	totalPrice.innerHTML = Number(totalPrice.dataset.price).toLocaleString("ko-KR", {style:'currency', currency:'KRW'});
}

// 장바구니 등록
function insertCart(memId, itemCode) {
	if (memId.length < 1) {
		alert("로그인이 필요합니다.");
	} else {
		$.ajax({
			url: "/cart/insertCart",
			type: "POST",
			data: {
				memId: memId
				, itemCode: itemCode
				, itemCnt: $("#itemQty").val()
			},
			success: function() {
				if (confirm("장바구니에 상품을 추가했습니다. 장바구니 화면으로 가시겠습니까?")) {
					location.href='/cart/cartList';
				}
			},
			error: function() {
				alert("장바구니 상품 추가 실패.. 다시 확인해주세요.");
			}
		})
	}
}

// 바로구매
function buyItem(memId, itemCode) {
	if (memId.length < 1) {
		alert("로그인이 필요합니다.");
	} else {
		$.ajax({
			url: "/cart/buyItem",
			type: "POST",
			data: {
				memId: memId
				, itemCode: itemCode
				, itemCnt: $("#itemQty").val()
				, buyPrice: $("#totalPrice").data("price")
			},
			success: function() {
				alert("상품을 구매했습니다.");
			},
			error: function() {
				alert("상품 구매 실패.. 다시 확인해주세요.");
			}
		})
	}
}