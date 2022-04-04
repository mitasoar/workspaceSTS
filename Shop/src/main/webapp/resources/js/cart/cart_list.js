function deleteCart(cartNum) { // 장바구니 삭제 버튼
	if (confirm('해당 장바구니 상품을 삭제하시겠습니까?')) {
		$.ajax({
			url: "/cart/deleteCart",
			type: "POST",
			data: {cartNum: cartNum},
			success: function() {
				alert("장바구니 상품이 정상적으로 삭제되었습니다.");
				location.reload();
			},
			error: function() {
				alert("장바구니 상품 삭제 오류.. 다시 시도해주세요.");
			}
		})
	}
}

function updateCart(cartNum) { // 장바구니 변경 버튼
	if (confirm('해당 장바구니 상품 수량을 변경하시겠습니까?')) {
		$.ajax({
			url: "/cart/updateCart",
			type: "POST",
			data: {cartNum: cartNum, itemCnt: document.getElementById('itemCnt'+cartNum).value},
			success: function() {
				alert("상품 수량이 정상적으로 변경되었습니다.");
				location.reload();
			},
			error: function() {
				alert("상품 수량 변경 오류.. 다시 확인해주세요.");
			}
		})
	}
}

function selectAll(selectAll)  { // 전체 체크박스 선택, 해제
  const checkboxes = document.getElementsByName('checkCart');
  
  checkboxes.forEach((checkbox) => {
    checkbox.checked = selectAll.checked;
  })
  
  if (checkboxes.length > 0) setAllPrice();
}

selectAll(document.getElementById('checkAll'));

function unCheck(chk) { // 체크박스 전체 선택 시, 아닐 시
	if (chk.checked) {
		if (document.querySelectorAll('.chk:checked').length == document.querySelectorAll('.chk').length) {
			document.getElementById('checkAll').checked = chk.checked;
		}
	} else {
		document.getElementById('checkAll').checked = chk.checked;
	}
	setAllPrice();
}

function deleteAll() { // 선택삭제 버튼
	if (document.querySelectorAll('.chk:checked').length > 0) {
		const checkboxes = document.getElementsByName('checkCart');
		let deleteList = [];
		
		checkboxes.forEach((checkbox) => {
	    	if (checkbox.checked) {
				deleteList.push(checkbox.value);
			}
		})
		
		if (confirm('선택하신 ' + deleteList.length + '개의 상품을 장바구니에서 삭제하시겠습니까?')) {
			$.ajax({
				url: "/cart/deleteCartList",
				type: "POST",
				data: {deleteList: deleteList},
				traditional : true,
				success: function() {
					alert("장바구니 상품이 정상적으로 삭제되었습니다.");
					location.reload();
				},
				error: function() {
					alert("장바구니 상품 삭제 오류.. 다시 시도해주세요.");
				}
			})
		}
	} else {
		alert('선택한 장바구니 상품이 없습니다.');
	}
}

function setAllPrice() { // 총 주문금액 셋팅
	const checkboxes = document.querySelectorAll('.chk:checked');
  	let allPrice = 0;
  
  	checkboxes.forEach((checkbox) => {
    	allPrice += Number(document.getElementById('totalPrice' + checkbox.value).value);
  	})
  	
  	document.getElementById('allPrice').value = allPrice;
  	document.getElementById('viewAllPrice').innerText = '￦' + allPrice.toLocaleString();
}

let changeCntCheck = false; // 수량 변경 여부 체크

function changeCnt(itemCnt, statusCnt, itemPrice) { // 수량 변경 시
	document.getElementById('viewTotalPrice'+statusCnt).innerText = '￦' + Number(itemCnt.value * itemPrice).toLocaleString();
	if (itemCnt.value == document.getElementById('beforeCnt'+statusCnt).value) {
		itemCnt.style.borderColor = '#ced4da';
		changeCntCheck = false;
	} else {
		itemCnt.style.borderColor = 'red';
		changeCntCheck = true;
	}
}

function buyAll() {
	if (changeCntCheck) {
		alert('장바구니 상품 중 수량 변경이 완료되지 않은 상품이 있습니다.\n새로고침하거나 수량변경 후 다시 구매버튼을 눌러주세요.');
	} else {
		const checkboxes = document.querySelectorAll('.chk:checked');
		if (confirm('선택한 ' + checkboxes.length + '개의 장바구니 상품을 구매하시겠습니까?')) {
			let buyItemList = [];
		
			checkboxes.forEach((checkbox) => {
		    	buyItemList.push(
					{ cartNum: checkbox.value
					  , itemCode: document.getElementById('itemCode' + checkbox.value).value
					  , itemCnt: document.getElementById('itemCnt' + checkbox.value).value
					  , buyPrice: document.getElementById('totalPrice' + checkbox.value).value
					}
				);
		  	})
		  	
		  	$.ajax({
		      method: 'POST',
		      url: '/cart/buyItemList',
		      contentType:'application/json; charset=UTF-8',
		      data: JSON.stringify(buyItemList),
		      success: function () {
		        alert("선택하신 상품이 정상적으로 구매되었습니다.");
		        location.reload();
		      },
		      error: function () {
				alert("상품 구매 오류.. 다시 확인해주세요.");
			  }
		    });
		}
	}
}