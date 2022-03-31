<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니 화면</title>
</head>
<body>
	${login.memName}님의 장바구니 화면입니다.      
	<table class="table text-center align-middle">
		<thead>
			<tr>
				<th scope="col" class="w-5"><input class="form-check-input" type="checkbox" id="checkAll" onchange="selectAll(this);" checked></th>
				<th scope="col" class="w-5">No</th>
				<th scope="col" class="w-20">상품이미지</th>
				<th scope="col" class="w-15">상품명</th>
				<th scope="col" class="w-15">상품금액</th>
				<th scope="col" class="w-15">수량</th>
				<th scope="col" class="w-15">주문금액</th>
				<th scope="col" class="w-10"></th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${empty cartList}">
				<tr>
					<td colspan="8" scope="row" class="text-center">장바구니가 비었습니다.</td>
				</tr>
			</c:if>
			<c:if test="${not empty cartList}">
				<c:forEach items="${cartList}" var="cart" varStatus="status">
					<tr>
						<td scope="row"><input class="form-check-input chk" type="checkbox" name="checkCart" onchange="unCheck(this);" value="${cart.cartNum}"></td>
						<td scope="row">${status.count}<input type="hidden" id="itemCode${cart.cartNum}" value="${cart.item.itemCode}"></td>
							<td>
								<img class="w-100px h-150px" alt="${cart.item.itemName}" src="/resources/images/
									<c:if test="${not empty cart.item.attachedImgName}">${cart.item.attachedImgName}</c:if>
									<c:if test="${empty cart.item.attachedImgName}">no_image.jpg</c:if>
								">
							</td>
						<td>${cart.item.itemName}</td>
						<td><fmt:formatNumber type="currency" value="${cart.item.itemPrice}"/></td>
						<td>
							<input type="number" class="form-control d-inline w-50" id="itemCnt${cart.cartNum}" value="${cart.itemCnt}" min="1" onchange="changeCnt(this, ${status.count}, ${cart.item.itemPrice});">
							<input type="hidden" id="beforeCnt${status.count}" value="${cart.itemCnt}">
							<button type="button" class="form-control d-inline w-30" onclick="updateCart('${cart.cartNum}');">변경</button>
						</td>
						<td><span id="viewTotalPrice${status.count}"><fmt:formatNumber type="currency" value="${cart.totalPrice}"/></span><input type="hidden" id="totalPrice${cart.cartNum}" value="${cart.totalPrice}"></td>
						<td><button type="button" class="form-control d-inline w-50" onclick="deleteCart(${cart.cartNum});">삭제</button></td>
					</tr>
					<c:set var="allPrice" value="${allPrice + cart.totalPrice}"/>
				</c:forEach>
			</c:if>
		</tbody>
		<c:if test="${not empty cartList}">
		<tfoot>
			<tr>
				<td scope="row"></td>
				<td scope="row"></td>
				<td scope="row"></td>
				<td scope="row"></td>
				<td scope="row" class="text-end">총 주문금액</td>
				<td scope="row"><span id="viewAllPrice"><fmt:formatNumber type="currency" value="${allPrice}"/></span><input type="hidden" id="allPrice" value="${allPice}"></td>
				<td colspan="2" scope="row">
					<button type="button" class="form-control d-inline w-40" onclick="buyAll();">선택구매</button>
					<button type="button" class="form-control d-inline w-40" onclick="deleteAll();">선택삭제</button>
				</td>
			</tr>
		</tfoot>
		</c:if>
	</table>
<script type="text/javascript" src="/resources/js/cart/cart_list.js"></script>
</body>
</html>