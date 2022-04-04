<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="list-group">
		<a href="/admin/regItem" class="list-group-item list-group-item-action" aria-current="true">상품등록</a>
		<a href="/admin/editItem" class="list-group-item list-group-item-action">상품관리</a>
		<a href="/admin/buyList" class="list-group-item list-group-item-action">구매상품 목록 조회</a>
		<a href="/admin/editCate" class="list-group-item list-group-item-action">카테고리관리</a>
		<a href="/admin/editMember" class="list-group-item list-group-item-action">회원관리</a>
		<div class="btn-group dropend">
			<button type="button" class="btn btn-light dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
			    상품관리
			</button>
			<ul class="dropdown-menu">
			  <li><a class="dropdown-item" href="/admin/regItem">상품등록</a></li>
			  <li><a class="dropdown-item" href="/admin/editItem">상품관리</a></li>
			  <li><a class="dropdown-item" href="/admin/buyList">구매상품 목록 조회</a></li>
			  <li><a class="dropdown-item" href="/admin/editCate">카테고리관리</a></li>
			</ul>
		</div>
	  	<div class="btn-group dropend">
			<button type="button" class="btn btn-light dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
			    회원관리
			</button>
			<ul class="dropdown-menu">
			  <li><a class="dropdown-item" href="/admin/editMember">회원관리</a></li>
			</ul>
		</div>
	</div>
</body>
</html>