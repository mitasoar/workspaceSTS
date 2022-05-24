<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카테고리 관리 화면</title>
</head>
<body>
	<div class="w-50 mx-auto mt-3 mb-3 pt-3 pb-3">
		<div class="mb-3 text-center">
			<h5 class="mb-3">게시판 카테고리 수정</h5>
			<select name="cateNo" class="form-select  d-inline-block w-auto" onchange="changeCate();">
				<c:forEach items="${cateList}" var="category">
					<option value="${category.cateNo}" label="${category.cateName}">${category.isUse}</option>
				</c:forEach>
			</select>
			<input type="text" name="cateName" class="form-control d-inline-block w-50" >
			<select name="isUse" class="form-select  d-inline-block w-auto">
				<option value="Y">사용</option>
				<option value="N">사용안함</option>
			</select>
			<button type="button" class="btn btn-primary" onclick="updateCate();">변경</button>
		</div>
		<div class="mb-3 text-center">
			<h5 class="mb-3">게시판 카테고리 추가</h5>
			<input type="text" name="newCate" class="form-control d-inline-block w-75" placeholder="카테고리 이름을 입력하세요">
			<button type="button" class="btn btn-primary" onclick="insertCate();">추가</button>
		</div>
		<div class="text-center">
			<h5 class="mb-3">게시판 카테고리 목록</h5>
			<table class="table">
				<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">게시판번호</th>
						<th scope="col">게시판이름</th>
						<th scope="col">사용여부</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${cateList}" var="category" varStatus="status">
						<tr>
							<td scope="row">${status.count}</td>
							<td>${category.cateNo}</td>
							<td>${category.cateName}</td>
							<td>${category.isUse}</td>
						</tr>					
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
<script type="text/javascript" src="/resources/js/board/category.js"></script>
</body>
</html>