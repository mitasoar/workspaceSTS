<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메뉴 화면</title>
</head>
<body>
	<div class="row">
		<div class="col-6 mx-auto">
			<ul class="nav justify-content-end">
			<c:if test="${empty loginInfo}">
			  	<li class="nav-item">
			  		<a class="nav-link text-dark" href="/member/login">로그인</a>
			  	</li>
			</c:if>
			<c:if test="${not empty loginInfo}">
				<c:if test="${loginInfo.memType ne 'stu'}">
					<li class="nav-item">
				  		<a class="nav-link text-dark" href="/member/join?joinType=1">학생등록</a>
				  	</li>
					<li class="nav-item">
				  		<a class="nav-link text-dark" href="/member/join?joinType=2">직원등록</a>
				  	</li>
				</c:if>
				
				<c:if test="${loginInfo.memType eq 'admin'}">
					<li class="nav-item">
				  		<a class="nav-link text-dark" href="/member/join?joinType=3">관리자등록</a>
				  	</li>
					<li class="nav-item">
				  		<a class="nav-link text-dark" href="/board/category">카테고리 관리</a>
				  	</li>
				</c:if>
				<li class="nav-item">
			  		<a class="nav-link text-dark" href="/message/message">쪽지기능</a>
			  	</li>
				<li class="nav-item">
			  		<a class="nav-link text-dark" href="/member/edit">회원정보수정</a>
			  	</li>
				<li class="nav-item">
			  		<a class="nav-link text-dark" href="/member/editPw">비밀번호수정</a>
			  	</li>
				<li class="nav-item">
			  		<a class="nav-link text-dark" href="/member/logout">로그아웃</a>
			  	</li>
			</c:if>
				<li class="nav-item">
					<a class="nav-link text-dark" href="/main/main">홈화면</a>
				</li>
			</ul>
		</div>
	</div>
	<div class="row bg-success bg-opacity-50">
		<div class="col-9 mx-auto">
			<nav class="navbar navbar-expand-lg navbar-sucess">
			  <div class="container-fluid">
			   	<a class="navbar-brand me-5" href="/main/main"> 
					<img alt="홈페이지 로고이미지" src="/resources/images/LOGO.png" width="333">
				</a>
			    <div class="collapse navbar-collapse ms-5" id="navbarNav">
			      <ul class="navbar-nav">
			        <li class="nav-item dropdown ms-5">
			          <a class="nav-link text-dark" href="#" id="navbarDropdown1" role="button" data-bs-toggle="dropdown" aria-expanded="false">
			            이강국
			          </a>
			          <ul class="dropdown-menu" aria-labelledby="navbarDropdown1">
			            <li><a class="nav-link text-dark" href="/pro/home">이강국</a></li>
			            <li><a class="nav-link text-dark" href="/pro/home">이강국</a></li>
			          </ul>
			        </li>
			        <li class="nav-item dropdown ms-5">
			          <a class="nav-link text-dark" href="#" id="navbarDropdown2" role="button" data-bs-toggle="dropdown" aria-expanded="false">
			            배도훈
			          </a>
			          <ul class="dropdown-menu" aria-labelledby="navbarDropdown2">
			            <li><a class="nav-link text-dark" href="/admin/home">배도훈</a></li>
			            <li><a class="nav-link text-dark" href="/admin/home">배도훈</a></li>
			          </ul>
			        </li>
			        <li class="nav-item dropdown ms-5">
			          <a class="nav-link text-dark" href="#" id="navbarDropdown1" role="button" data-bs-toggle="dropdown" aria-expanded="false">
			            송모세
			          </a>
			          <ul class="dropdown-menu" aria-labelledby="navbarDropdown1">
			            <li><a class="nav-link text-dark" href="/stu/home">송모세</a></li>
			            <li><a class="nav-link text-dark" href="/stu/home">송모세</a></li>
			          </ul>
			        </li>
			        <li class="nav-item dropdown ms-5">
			          <a class="nav-link text-dark" href="#" id="navbarDropdown1" role="button" data-bs-toggle="dropdown" aria-expanded="false">
			            우미타
			          </a>
			          <ul class="dropdown-menu" aria-labelledby="navbarDropdown1">
			            <li><a class="nav-link text-dark" href="/member/home">우미타</a></li>
			            <li><a class="nav-link text-dark" href="/main/remember">기억력게임</a></li>
			            <li><a class="nav-link text-dark" href="/main/random">랜덤타자게임</a></li>
			            <li><a class="nav-link text-dark" href="/main/click">클릭게임</a></li>
			          </ul>
			        </li>
			      </ul>
			    </div>
			  </div>
			</nav>
		</div>
	</div>
</body>
</html>