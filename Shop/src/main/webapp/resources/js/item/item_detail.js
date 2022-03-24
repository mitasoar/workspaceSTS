function changeQty() {
	let totalPrice = document.querySelector('#totalPrice');
	totalPrice.dataset.price *= document.querySelector('#itemQty').value;
	totalPrice.innerHTML = Number(totalPrice.dataset.price).toLocaleString("ko-KR", {style:'currency', currency:'KRW'});
}