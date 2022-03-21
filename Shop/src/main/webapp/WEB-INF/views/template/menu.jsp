<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="row">
		<div class="col text-end">
			<c:choose>
				<c:when test="${empty login}">
					<button type="button" class="btn btn-light" data-bs-toggle="modal" data-bs-target="#loginModal">로그인</button> 
					<button type="button" class="btn btn-light" data-bs-toggle="modal" data-bs-target="#joinModal">회원가입</button> 
				</c:when>
				<c:otherwise>
					<span class="loginSpan">${login.memName}님 반갑습니다 ^_^</span>
					<button type="button" class="btn btn-light" data-bs-toggle="modal" data-bs-target="#editModal">회원정보</button> 
					<button type="button" class="btn btn-light" onclick="logout();">로그아웃</button> 
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	<div class="row">
		<div class="col text-center">
			<h2>BOOK SHOP</h2>
		</div>
	</div>
	<div class="row">
		<div class="col">
			<nav class="navbar navbar-expand-lg navbar-light bg-light">
				<div class="container-fluid">
					<div class="collapse navbar-collapse" id="navbarNav">
						<ul class="navbar-nav me-auto mb-2 mb-lg-0">
							<li class="nav-item">
								<a class="nav-link <c:if test="${empty cateType}">active</c:if>" href="/item/itemList">전체상품</a>
							</li>
							<c:forEach items="${categoryList}" var="category">
								<li class="nav-item">
									<a class="nav-link <c:if test="${cateType eq category.cateCode}">active</c:if>" href="/item/itemList?cateType=${category.cateCode}">${category.cateName}</a>
								</li>
							</c:forEach>
						</ul>
						<c:if test="${login.isAdmin eq 'Y'}">
							<div class="navbar-nav nav-item">
								<a class="nav-link <c:if test="${cateType eq 'admin'}">active</c:if>" href="/admin/regItem?cateType=admin">관리자메뉴</a>
							</div>
						</c:if>
					</div>
				</div>
			</nav>
		</div>
	</div>
	
<!-- Login Modal -->
<div class="modal fade modalEvent" id="loginModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="staticBackdropLabel">로그인</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
      	<div class="mb-3">
      		<input class="form-control" type="text" name="memId" id="loginId" placeholder="아이디를 입력해주세요" aria-label="default input example" required>
      	</div>
       	<div class="mb-3">
      		<input class="form-control" type="password" name="memPw" id="loginPw" placeholder="비밀번호를 입력해주세요" aria-label="default input example" required>
      	</div>
      	<div class="mb-3 text-end">
	      	<button type="button" class="btn btn-dark" data-bs-toggle="modal" data-bs-target="#joinModal">회원가입</button> 
	        <button type="button" class="btn btn-dark" data-bs-dismiss="modal">취소</button>
	        <button type="button" class="btn btn-dark" onclick="login();">로그인</button>
        </div>
      </div>
    </div>
  </div>
</div>
	
<!-- Join Modal -->
<div class="modal fade modalEvent" id="joinModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="staticBackdropLabel">회원가입</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <form class="row g-3" action="/member/join" method="post">
		  <div class="col-9">
		    <label for="inputId" class="form-label">아이디</label>
		    <input type="text" class="form-control" id="inputId" name="memId" maxlength="15" required>
		  </div>
		  <div class="col-3 d-grid">
		    	<label for="" class="form-label">&nbsp;</label>
		    	<button type="button" class="btn btn-dark" id="idCheckBtn" onclick="checkId();">중복체크</button>
		  </div>
		  <div class="col-12">
		    <label for="inputPassword" class="form-label">비밀번호</label>
		    <input type="password" class="form-control" id="inputPassword" name="memPw" maxlength="16" required>
		  </div>
		  <div class="col-12">
		    <label for="inputPasswordCheck" class="form-label">비밀번호확인</label>
		    <input type="password" class="form-control" id="inputPasswordCheck" name="memPwCheck" maxlength="16" required>
		  </div>
		  <div class="col-md-4">
		    <label for="inputName" class="form-label">이름</label>
		    <input type="text" class="form-control" id="inputName" name="memName" required>
		  </div>
		  <div class="col-md-8">
		    <label for="inputEmail" class="form-label">이메일</label>
		    <input type="email" class="form-control" id="inputEmail" name="memEmail" required>
		  </div>
		  <div class="col-md-4">
		    <label for="inputState" class="form-label">연락처</label>
		     <select id="inputState" class="form-select" name="memPhone">
		      <option value="010" selected>010</option>
		      <option value="011">011</option>
		    </select>
		  </div>
		  <div class="col-md-4">
		  <label for="" class="form-label">&nbsp;</label>
		   <input type="text" class="form-control" name="memPhone" maxlength="4" required>
		  </div>
		  <div class="col-4 d-grid">
		  <label for="" class="form-label">&nbsp;</label>
		   <input type="text" class="form-control" name="memPhone" maxlength="4" required>
		  </div>
		  <div class="col-8">
		    <label for="inputAddress" class="form-label">주소</label>
		    <input type="text" class="form-control bg-white" id="addr" onclick="execDaumPostcode();" placeholder="도로명주소" name="memAddress" readonly required>
		  </div>
		  <div class="col-4 d-grid">
		  	<label for="" class="form-label">&nbsp;</label>
		    <button type="button" class="btn btn-dark" onclick="execDaumPostcode();">우편번호</button>
		  </div>
		  <div class="col-12">
		    <input type="text" class="form-control" id="inputAddress" placeholder="상세주소" name="memAddress" required>
		  </div>
		  <div class="col-12 text-end">
		  	<button type="button" class="btn btn-dark" data-bs-dismiss="modal">취소</button>
		    <button type="submit" class="btn btn-dark">회원가입</button>
		  </div>
		</form>
      </div>
    </div>
  </div>
</div>

<!-- Edit Modal -->
<div class="modal fade modalEvent" id="editModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="staticBackdropLabel">회원정보</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <form class="row g-3" action="/member/edit" method="post" id="editForm">
		  <div class="col-12">
		    <label for="editId" class="form-label">아이디</label>
		    <input type="text" class="form-control" id="editId" name="memId" value="${login.memId}" maxlength="15" readonly required>
		  </div>
		  <div class="col-12">
		    <label for="editPassword" class="form-label">비밀번호</label>
		    <input type="password" class="form-control" id="editPassword" name="memPw" maxlength="16" required>
		  </div>
		  <div class="col-12">
		    <label for="inputPasswordCheck" class="form-label">비밀번호확인</label>
		    <input type="password" class="form-control" id="editPasswordCheck" name="memPwCheck" maxlength="16" required>
		  </div>
		  <div class="col-md-4">
		    <label for="editName" class="form-label">이름</label>
		    <input type="text" class="form-control" id="editName" name="memName" value="${login.memName}" required>
		  </div>
		  <div class="col-md-8">
		    <label for="editEmail" class="form-label">이메일</label>
		    <input type="email" class="form-control" id="editEmail" name="memEmail" value="${login.memEmail}" required>
		  </div>
		  <div class="col-md-4">
		    <label for="editState" class="form-label">연락처</label>
		     <select id="editState" class="form-select" name="memPhone">
		     <c:set var="phone" value="${login.memPhone}"></c:set>
		      <c:choose>
		      	<c:when test="${fn:substring(phone,0,3) eq 010}">
		      		 <option value="010" selected>010</option>
		     		 <option value="011">011</option>
		      	</c:when>
		      	<c:otherwise>
		      	 	<option value="010">010</option>
		     		<option value="011" selected>011</option>
		      	</c:otherwise>
		      </c:choose>
		    </select>
		  </div>
		  <div class="col-md-4">
		  <label for="" class="form-label">&nbsp;</label>
		   <input type="text" class="form-control" name="memPhone" maxlength="4" value="${fn:substring(phone,4,8)}" required>
		  </div>
		  <div class="col-4 d-grid">
		  <label for="" class="form-label">&nbsp;</label>
		   <input type="text" class="form-control" name="memPhone" maxlength="4" value="${fn:substring(phone,9,13)}" required>
		  </div>
		  <div class="col-8">
		  	<c:set var="addr" value="${login.memAddress}"></c:set>
		    <label for="inputAddress" class="form-label">주소</label>
		    <input type="text" class="form-control bg-white" id="addr" onclick="execDaumPostcode();" placeholder="도로명주소" name="memAddress" value="${fn:split(addr, '/')[0]}" readonly required>
		  </div>
		  <div class="col-4 d-grid">
		  	<label for="" class="form-label">&nbsp;</label>
		    <button type="button" class="btn btn-dark" onclick="execDaumPostcode();">우편번호</button>
		  </div>
		  <div class="col-12">
		    <input type="text" class="form-control" id="inputAddress" placeholder="상세주소" name="memAddress" value="${fn:split(addr, '/')[1]}" required>
		  </div>
		  <div class="col-12 text-end">
		  	<button type="button" class="btn btn-dark" data-bs-dismiss="modal">취소</button>
		    <button type="button" class="btn btn-dark" onclick="editMember();" id="editBtn">회원정보수정</button>
		  </div>
		</form>
      </div>
    </div>
  </div>
</div>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="/resources/js/common/menu.js" type="text/javascript"></script>
</body>
</html>