function buyOrderInfo(orderNum) {
	$.ajax({
		url: "/admin/buyOrderInfo",
		type: "GET",
		data: {orderNum: orderNum},
		success: function(data) {
			document.getElementById('showOrderNum').innerText = orderNum;
			
			let orderList = "";
			let totalPrice = 0;
			
			for (let i = 0; i < data.length; i++) {
				orderList += "<tr>";
				orderList += "<td>" + (i + 1) + "</td>";
				orderList += "<td>" + "<img width='100px' height='150px' alt='" + data[i].cart.item.itemName + "' src='/resources/images/" + data[i].cart.item.attachedImgName + "'>" + "</td>";
				orderList += "<td>" + data[i].cart.item.itemName + "</td>";
				orderList += "<td>" + data[i].itemCnt + "</td>";
				orderList += "<td>" + "￦" + Number(data[i].cart.totalPrice).toLocaleString() + "</td>";
				orderList += "<td>" + data[i].member.memName + "</td>";
				orderList += "</tr>";
				
				totalPrice += Number(data[i].cart.totalPrice);
			}
			
			document.getElementById('orderList').innerHTML = orderList;
			document.getElementById('orderTotalPrice').innerText = "총 구매금액 : ￦" + totalPrice.toLocaleString();
			
		},
		error: function() {
			alert("구매목록 상세조회 오류.. 다시 확인해주세요.");
		}
	})
}