<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세 화면</title>
<style type="text/css">
.board-container {
	height: 300px;
	margin-bottom: 10px;
}
.list-container h5, .list-container p {
	margin-bottom: 0;
	height: 30px;
	line-height: normal;
}
.btn-white:hover {
	background-color: #EEEEEE;
}
</style>
</head>
<body>
	<div class="container px-4 px-lg-5 col-8 mx-auto">
		<div class="row gx-4 gx-lg-5 justify-content-center">
			<div class="container list-container">
				<div class="mt-1 header">
					<div class="row border-bottom pt-2 pb-2">
						<input type="hidden" id="boardNo" value="${board.boardNo}"/>
						<input type="hidden" id="boardWriter" value="${board.boardWriter}"/>
						<input type="hidden" id="loginId" value="${loginInfo.memNo}"/>
						<input type="hidden" id="loginType" value="${loginInfo.memType}"/>
					
						<h5 class="col-7">${board.cateName}</h5>
						<p class="col-3 text-end">작성자 : ${board.member.memName}</p>
						<p class="col-2 text-end">조회수 : ${board.readCnt}</p>
					</div>
					<div class="row border-bottom pt-2 pb-2">
						<h5 class="col-8 board-title" style="word-break: break-all;">${board.boardTitle}</h5>
						<c:if test="${empty board.updateDate}">
							<p class="col-4 text-end">${board.createDate}</p>
						</c:if>
						<c:if test="${not empty board.updateDate}">
							<p class="col-4 text-end">${board.updateDate}</p>
						</c:if>
					</div>
				</div>
				<div class="board-container border-bottom p-1">
					<p class="content" style="word-break: break-all;">${board.boardContent}</p>
				</div>
				
				<c:forEach items="${boardPage.fileInfos}" var="file">
                    <div>
                     	<c:set var="fileType" value="${fn:split(file.saveFile, '.')[1]}" />
	                    <c:if test="${fileType eq 'jpg' or fileType eq 'jpeg' or fileType eq 'png'}">
	                    	<img alt="${file.originFile}" src="/resources/upload/${file.saveFolder}/${file.saveFile}" width="100">
	                    </c:if>
	                    <c:if test="${fileType ne 'jpg' and fileType ne 'jpeg' and fileType ne 'png'}">
	                    	<img alt="${file.originFile}" src="/resources/images/no_image.jpg" width="100">
	                    </c:if>
                    	<span>${file.originFile}</span>
	                    <a href="#" class="filedown" sfolder="${file.saveFolder}" sfile="${file.saveFile}" ofile="${file.originFile}">[다운로드]</a>
                    </div>
                </c:forEach>
                
                <form action="#" id="downform">
                	<input type="hidden" name="sfolder">
                	<input type="hidden" name="ofile">
                	<input type="hidden" name="sfile">
                </form>

				<div class="board-footer text-end">
					<c:if test="${board.boardWriter eq loginInfo.memNo or loginInfo.memType eq 'admin'}">
						<button type="button" class="btn btn-white update-btn" onclick="location.href='/board/editBoard?boardNo=${board.boardNo}'">수정</button>
						<button type="button" class="btn btn-white delete-btn" onclick="deleteBoard('${board.boardNo}');">삭제</button>
					</c:if>
					<button type="button" class="btn btn-white list-btn" onclick="location.href='/board/boardList?cateNo=${board.cateNo}'">목록</button>
				</div>
			</div>
		</div>
	</div>
	
	<c:if test="${not empty loginInfo}">
		<!--  댓글  -->
	    <div class="container col-8 mx-auto">
	        <label for="content" class="p-2">댓글</label>
	        <form name="commentInsertForm">
	            <div class="input-group">
	               <input type="hidden" name="boardNo" value="${board.boardNo}"/>
	               <input type="hidden" name="replyWriter" id="replyWriter" value="${loginInfo.memNo}"/>
	               <div class="form-check form-switch pt-1">
					  <input class="form-check-input" type="checkbox" role="switch" id="isSecret" name="isSecret" value="Y">
					  <label class="form-check-label me-2" for="isSecret">비밀댓글</label>
					</div>
	               <input type="text" class="form-control me-1" id="content" name="replyContent" placeholder="댓글을 입력하세요.">
	               <span class="input-group-btn">
	                    <button class="btn btn-white" type="button" name="commentInsertBtn">등록</button>
	               </span>
	              </div>
	        </form>
	    </div>
    </c:if>
    
    <div class="container col-8 mx-auto">
        <div class="commentList"></div>
        <nav aria-label="Page navigation example">
		  <ul class="pagination  justify-content-center">
		  	<c:if test="${boardPage.paging.startPage != 1}">
			    <li class="page-item">
			      <a class="page-link link-secondary" href="/board/boardContent?nowPage=${boardPage.paging.startPage - 1}&boardNo=${boardPage.boardNo}" aria-label="Previous">
			        <span aria-hidden="true">&laquo;</span>
			      </a>
			    </li>
		    </c:if>
		    <c:forEach begin="${boardPage.paging.startPage }" end="${boardPage.paging.endPage }" var="p">
		   		<c:if test="${p == boardPage.paging.nowPage}">
		   			<input type="hidden" id="nowPage" value="${p}">
			   		<li class="page-item active" aria-current="page">
	    		</c:if>
		   		<c:if test="${p != boardPage.paging.nowPage}">
			   		<li class="page-item" aria-current="page">
	    		</c:if>
	    				<a class="page-link link-secondary" href="/board/boardContent?nowPage=${p}&boardNo=${boardPage.boardNo}">${p}</a>
		    		</li>
			</c:forEach>
		    <c:if test="${boardPage.paging.endPage != boardPage.paging.lastPage}">
			    <li class="page-item">
			      <a class="page-link link-secondary" href="/board/boardContent?nowPage=${boardPage.paging.endPage + 1}&boardNo=${boardPage.boardNo}" aria-label="Next">
			        <span aria-hidden="true">&raquo;</span>
			      </a>
			    </li>
		    </c:if>
		  </ul>
		</nav>
    </div>

<script type="text/javascript" src="/resources/js/board/content.js"></script>
</body>
</html>