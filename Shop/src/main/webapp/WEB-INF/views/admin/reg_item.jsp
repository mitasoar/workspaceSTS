<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="row justify-content-center">
		<div class="col-7">
			<h4>책 등록</h4>
		</div>
	</div>
	<div class="row">
		<div class="col-6 bg-light pd-15 bd-rd-15">
			<form class="row g-3" action="/item/insertItem" method="post">
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
					<input type="text" class="form-control" id="bookPrice" name="itemPrice" required>	
				</div>
				<div class="col-12">
					<label for="bookIntro" class="form-label">도서소개</label>
					<textarea rows="3" class="form-control" id="bookIntro" name="itemDetail"></textarea>
				</div>
				<div class="col-12 d-grid gap-2">
                  <button class="btn btn-primary">도서등록</button>
               </div>
			</form>
		</div>
	</div>
</body>
</html>