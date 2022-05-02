<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록 화면</title>
</head>
<body>
	<table class="table table-hover text-center table-bordered">
		<thead>
			<tr>
				<th scope="col" class="col-1">No</th>
				<th scope="col" class="col-6">제목</th>
				<th scope="col" class="col-2">글쓴이</th>
				<th scope="col" class="col-2">작성일</th>
				<th scope="col" class="col-1">조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${empty boardList}">
				<tr>
					<td colspan="5" class="text-center">게시판 글이 없습니다.</td>
				</tr>
			</c:if>
			<c:if test="${not empty boardList}">
				<c:forEach items="${boardList}" var="board" varStatus="status">
					<tr>
						<td>${status.count}</td>
						<td scope="row" class="text-start">
							<a class="text-reset" href="/board/boardContent?boardNo=${board.boardNo}">${board.boardTitle}</a>
						</td>
						<td>${board.boardWriter}</td>
						<td>${board.createDate}</td>
						<td>${board.readCnt}</td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>
	<nav aria-label="Page navigation example">
	  <ul class="pagination  justify-content-center">
	  	<c:if test="${boardPage.paging.startPage != 1}">
		    <li class="page-item">
		      <a class="page-link link-secondary" href="/board/boardList?nowPage=${boardPage.paging.startPage - 1}&cateNo=${boardPage.cateNo}" aria-label="Previous">
		        <span aria-hidden="true">&laquo;</span>
		      </a>
		    </li>
	    </c:if>
	    <c:forEach begin="${boardPage.paging.startPage }" end="${boardPage.paging.endPage }" var="p">
	   		<li class="page-item <c:if test="${p == boardPage.paging.nowPage}">active</c:if>" aria-current="page">
      			<a class="page-link link-secondary" href="/board/boardList?nowPage=${p}&cateNo=${boardPage.cateNo}">${p}</a>
    		</li>
		</c:forEach>
	    <c:if test="${boardPage.paging.endPage != boardPage.paging.lastPage}">
		    <li class="page-item">
		      <a class="page-link link-secondary" href="/board/boardList?nowPage=${boardPage.paging.endPage + 1}&cateNo=${boardPage.cateNo}" aria-label="Next">
		        <span aria-hidden="true">&raquo;</span>
		      </a>
		    </li>
	    </c:if>
	  </ul>
	</nav>
</body>
</html>