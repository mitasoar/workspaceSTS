<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글쓰기 화면</title>
</head>
<body>
	<form action="#" id="boardForm" onsubmit="return writeBoard();">
		<select class="form-select mt-4 mb-2" name="cateNo" aria-label="Default select example">
			<c:forEach items="${categoryList}" var="category">
		  		<option value="${category.cateNo}">${category.cateName}</option>
			</c:forEach>
		</select>
		<input type="text" name="boardTitle" class="form-control mb-2" placeholder="제목을 입력해주세요." required>
		<div class="form-group mb-2">
			<textarea class="form-control" rows="10" name="boardContent" placeholder="내용을 입력해주세요" required></textarea>
		</div>
		<div class="col-12 text-center mb-4">
			<button type="submit" class="btn btn-secondary mb-3">글쓰기</button>
		</div>
	</form>
<script type="text/javascript" src="/resources/js/board/write.js"></script>
</body>
</html>