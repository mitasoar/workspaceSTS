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
				<th scope="col">No</th>
				<th scope="col">상품이미지</th>
				<th scope="col">상품명</th>
				<th scope="col">가격</th>
				<th scope="col">수량</th>
				<th scope="col">총가격</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${cartList}" var="cart" varStatus="status">
				<tr>
					<th scope="row">${status.count}</th>
						<td>
							<img class="w-100px h-150px" alt="${cart.item.itemName}" src="/resources/images/
								<c:if test="${not empty cart.item.attachedImgName}">${cart.item.attachedImgName}</c:if>
								<c:if test="${empty cart.item.attachedImgName}">no_image.jpg</c:if>
							">
						</td>
					<td>${cart.item.itemName}</td>
					<td><fmt:formatNumber type="currency" value="${cart.item.itemPrice}"/></td>
					<td>${cart.itemCnt}</td>
					<td><fmt:formatNumber type="currency" value="${cart.totalPrice}"/></td>
				</tr>
			</c:forEach>
		</tbody>
		<!-- <tfoot>
			<tr>
				<th scope="row">1</th>
				<td>Mark</td>
				<td>Otto</td>
				<td>@mdo</td>
				<td>@mdo</td>
				<td>@mdo</td>
			</tr>
		</tfoot> -->
	</table>
</body>
</html>