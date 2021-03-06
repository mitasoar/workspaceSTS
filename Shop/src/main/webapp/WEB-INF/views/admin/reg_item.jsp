<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책 등록 화면</title>
</head>
<body>
	<div class="row text-center mg-left-15">
		<div class="col-7">
			<h4>책 등록</h4>
		</div>
	</div>
	<div class="row mg-left-20 mg-bot-30px">
		<div class="col-6 bg-light pd-15 bd-rd-15">
			<form class="row g-3" id="itemForm" action="/admin/insertItem" method="post" enctype="multipart/form-data">
				<div class="col-12">
					<label for="categorySelector" class="form-label">카테고리</label>
					<select class="form-select" id="categorySeletor" name="cateCode">
						<c:forEach items="${categoryList}" var="category">
							<option value="${category.cateCode}">${category.cateName}</option>
						</c:forEach>
					</select>
				</div>
				<div class="col-12">
					<label for="bookName" class="form-label">도서명</label>
					<input type="text" class="form-control" id="bookName" name="itemName" required>	
				</div>
				<div class="col-12">
					<label for="bookPrice" class="form-label">도서가격</label>
					<input type="number" class="form-control" id="bookPrice" name="itemPrice" min="1" required>	
				</div>
				<div class="col-12">
					<label for="bookIntro" class="form-label">도서소개</label>
					<textarea rows="3" class="form-control" id="bookIntro" name="itemDetail"></textarea>
				</div>
				<div class="col-12">
					<label for="img" class="form-label">대표이미지</label>
					<input type="file" class="form-control" id="img" name="mainImg">
				</div>
				<div class="col-12">
					<label for="subImg" class="form-label">추가이미지</label>
					<input type="file" class="form-control" id="subImg" name="subImg" multiple>
				</div>
				<div class="col-12 d-grid gap-2">
                  <button type="button" class="btn btn-secondary" onclick="addItem();">도서등록</button>
               </div>
			</form>
		</div>
	</div>
<script src="/resources/js/admin/reg_item.js" type="text/javascript"></script>
</body>
</html>