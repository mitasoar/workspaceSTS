<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 정보 화면</title>
</head>
<body>
	<div class="table-responsive w-50 mx-auto">
		<table class="table align-middle">
			<thead>
				<tr>
					<th class="col-6 text-center">상품이미지</th>
					<th class="col-6 text-center">상품정보</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td class="text-center">
						<img class="w-200 h-250" alt="${item.itemName}" src="/resources/images/
							<c:forEach items="${item.imageList}" var="image">
								<c:if test="${empty image.isMain}">
									no_image.jpg
								</c:if>
								<c:if test="${image.isMain eq 'Y'}">
									${image.attachedImgName}
								</c:if>
							</c:forEach>
						">
					</td>
					<td>
						<p>상품명 : ${item.itemName}</p>
						<p>가격 : <input type="hidden" id="itemPrice" value="${item.itemPrice}"><fmt:formatNumber type="currency" value="${item.itemPrice}"/></p>
						<p>수량 : 
							<select id="itemQty" name="itemQty" class="form-control w-25 d-inline" onchange="changeQty();">
								<c:forEach begin="1" end="${item.itemStock}" var="cnt">
									<option value="${cnt}">${cnt}</option>
								</c:forEach>
							</select>
						</p>
						<p>총가격 : <span id="totalPrice" data-price="${item.itemPrice}"><fmt:formatNumber type="currency" value="${item.itemPrice}"/></span></p>
						<p>
							<button class="form-control d-inline w-40" onclick="insertCart('${login.memId}', '${item.itemCode}');">
								<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-cart" viewBox="0 0 16 16">
								  <path d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .491.592l-1.5 8A.5.5 0 0 1 13 12H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM3.102 4l1.313 7h8.17l1.313-7H3.102zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 1 0 2 1 1 0 0 1 0-2zm7 0a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"/>
								</svg>
								<span>&nbsp;장바구니</span>
							</button>
							<button class="form-control d-inline w-40" onclick="buyItem('${login.memId}', '${item.itemCode}');">
								<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-check2" viewBox="0 0 16 16">
								  <path d="M13.854 3.646a.5.5 0 0 1 0 .708l-7 7a.5.5 0 0 1-.708 0l-3.5-3.5a.5.5 0 1 1 .708-.708L6.5 10.293l6.646-6.647a.5.5 0 0 1 .708 0z"/>
								</svg>
								<span>&nbsp;바로구매</span>
							</button>
						</p>
					</td>
				</tr>
				<tr>
					<td colspan="2" class="text-center">${item.itemDetail}</td>
				</tr>
				<tr>
					<td colspan="2" class="text-center">
						<c:forEach items="${item.imageList}" var="image">
							<c:if test="${empty image.attachedImgName}">
								<img class="w-200 h-250" alt="${item.itemName}" src="/resources/images/no_image.jpg">
							</c:if>
							<c:if test="${not empty image.attachedImgName and image.isMain eq 'N'}">
								<img class="w-200 h-250" alt="${item.itemName}" src="/resources/images/${image.attachedImgName}">
							</c:if>
						</c:forEach>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
<script src="/resources/js/item/item_detail.js" type="text/javascript"></script>
</body>
</html>