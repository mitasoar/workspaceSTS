<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 목록 화면</title>
</head>
<body>
	<div class="row row-cols-1 row-cols-md-6 g-4">
		<c:if test="${empty itemList}">
			<div class="w-100 text-center">해당 상품이 없습니다.</div>
		</c:if>
		<c:if test="${not empty itemList}">
			<c:forEach items="${itemList}" var="item">
				<div class="col">
					<div class="card h-100 over-hidden">
						<img src='/resources/images/<c:if test="${empty item.attachedImgName}">no_image.jpg</c:if>
						<c:if test="${not empty item.attachedImgName}">${item.attachedImgName}</c:if>' class="card-img-top h-250 selectImg" alt="${item.itemName}" onclick="location.href='/item/itemDetail?itemCode=${item.itemCode}'">
						<div class="card-body h-150 over-hidden">
							<h5 class="card-title text-center">${item.itemName}</h5>
							<p class="card-text">${item.itemDetail}</p>
						</div>
						 <div class="card-footer text-end">
					        <small class="text-muted"><fmt:formatNumber value="${item.itemPrice}" type="currency" /></small>
					     </div>
					</div>
				</div>
			</c:forEach>
		</c:if>
		<div class="col-md-12">
			<nav aria-label="Page navigation example">
			  <ul class="pagination  justify-content-center">
			  	<c:if test="${paging.startPage != 1}">
				    <li class="page-item">
				      <a class="page-link link-secondary" href="/item/itemList?nowPage=${paging.startPage - 1 }" aria-label="Previous">
				        <span aria-hidden="true">&laquo;</span>
				      </a>
				    </li>
			    </c:if>
			    <c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="p">
			   		<li class="page-item <c:if test="${p == paging.nowPage }">active</c:if>" aria-current="page">
		      			<a class="page-link link-secondary" href="/item/itemList?nowPage=${p }">${p }</a>
			    	</li>
				</c:forEach>
			    <c:if test="${paging.endPage != paging.lastPage}">
				    <li class="page-item">
				      <a class="page-link link-secondary" href="/item/itemList?nowPage=${paging.endPage+1 }" aria-label="Next">
				        <span aria-hidden="true">&raquo;</span>
				      </a>
				    </li>
			    </c:if>
			  </ul>
			</nav>
		</div>
	</div>
</body>
</html>