<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구매 목록 페이지</title>
</head>
<body>
	<div>
		<form action="/admin/buyList" method="get">
			<table class="table align-middle searchTable bg-light text-center">
				<tbody>
					<tr>
						<td class="col-1">주문번호</td>
						<td class="col-3"><input type="text" class="form-control" name="orderNum" value="${buyItem.orderNum}"></td>
						<td class="col-1">구매자</td>
						<td class="col-2"><input type="text" class="form-control" name="memId" value="${buyItem.memId}"></td>
						<td class="col-1">구매일시</td>
						<td class="col-4">
							<div class="row">
								<input type="date" class="form-control w-35" name="beforeDate" value="${buyItem.beforeDate}">
								<span class="align-self-center col-1">~</span>
								<input type="date" class="form-control w-35" name="afterDate" value="${buyItem.afterDate}">
								<button class="btn btn-secondary w-15 mg-left-10px">검색</button>
							</div>
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
	<div>
		<table class="table text-center table-hover">
			<thead>
				<tr>
					<th scope="col" class="w-5">No</th>
					<th scope="col" class="w-40">주문번호</th>
					<th scope="col" class="w-25">구매자ID(구매자명)</th>
					<th scope="col" class="w-30">구매일시</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${empty buyList}">
					<tr>
						<td colspan="4" class="text-center">구매목록이 없습니다.</td>
					</tr>
				</c:if>
				<c:if test="${not empty buyList}">
					<c:forEach items="${buyList}" var="item">
						<tr>
							<td>${item.rn}</td>
							<td><span role="button" data-bs-toggle="modal" data-bs-target="#buyInfoModal" onclick="buyOrderInfo('${item.orderNum}');">${item.orderNum}</span></td>
							<td>${item.memId}(${item.member.memName})</td>
							<td>${item.buyDate}</td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
		<nav aria-label="Page navigation example">
		  <ul class="pagination  justify-content-center">
		  	<c:if test="${buyItem.paging.startPage != 1}">
			    <li class="page-item">
			      <a class="page-link link-secondary" href="/admin/buyList?nowPage=${buyItem.paging.startPage - 1}&orderNum=${buyItem.orderNum}&memId=${buyItem.memId}&beforeDate=${buyItem.beforeDate}&afterDate=${buyItem.afterDate}" aria-label="Previous">
			        <span aria-hidden="true">&laquo;</span>
			      </a>
			    </li>
		    </c:if>
		    <c:forEach begin="${buyItem.paging.startPage }" end="${buyItem.paging.endPage }" var="p">
		   		<li class="page-item <c:if test="${p == buyItem.paging.nowPage}">active</c:if>" aria-current="page">
	      			<a class="page-link link-secondary" href="/admin/buyList?nowPage=${p}&orderNum=${buyItem.orderNum}&memId=${buyItem.memId}&beforeDate=${buyItem.beforeDate}&afterDate=${buyItem.afterDate}">${p }</a>
	    		</li>
			</c:forEach>
		    <c:if test="${buyItem.paging.endPage != buyItem.paging.lastPage}">
			    <li class="page-item">
			      <a class="page-link link-secondary" href="/admin/buyList?nowPage=${buyItem.paging.endPage + 1}&orderNum=${buyItem.orderNum}&memId=${buyItem.memId}&beforeDate=${buyItem.beforeDate}&afterDate=${buyItem.afterDate}" aria-label="Next">
			        <span aria-hidden="true">&raquo;</span>
			      </a>
			    </li>
		    </c:if>
		  </ul>
		</nav>
	</div>
	
<!-- Modal -->
<div class="modal fade" id="buyInfoModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="staticBackdropLabel">주문 상세 목록 (<span id="showOrderNum"></span>)</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <div class="row">
            <div class="col text-center">
               <table class="table table-striped table-hover align-middle">
	              <thead>
	                <tr>
	                  <th scope="col" class="col-1">No</th>
	                  <th scope="col" class="col-3">상품이미지</th>
	                  <th scope="col" class="col-3">상품명</th>
	                  <th scope="col" class="col-1">수량</th>
	                  <th scope="col" class="col-2">구매가격</th>
	                  <th scope="col" class="col-2">구매자</th>
	                </tr>
	              </thead>
	              <tbody id="orderList">
	              </tbody>
            	</table>
            </div>
         </div>
      </div>
      <div class="modal-footer">
      	<div class="col-6 text-end me-3" id="orderTotalPrice"></div>
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
      </div>
    </div>
  </div>
</div>
<script type="text/javascript" src="/resources/js/admin/buy_list.js"></script>
</body>
</html>