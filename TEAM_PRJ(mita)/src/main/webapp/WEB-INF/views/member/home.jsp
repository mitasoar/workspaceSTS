<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="/board/boardWrite">게시판 쓰기</a>
	<a href="/board/boardList">게시판 목록</a>
	
	<c:if test="${empty loginInfo}">
		<a href="/member/login">로그인</a>
	</c:if>
	
	<c:if test="${not empty loginInfo}">
		<a href="/member/logout">로그아웃</a>
		
		<c:if test="${loginInfo.memType eq 'emp'}">
			<a href="/member/join?joinType=1">학생등록</a>
			<a href="/member/join?joinType=2">직원등록</a>
		</c:if>
		
		<c:if test="${loginInfo.memType eq 'admin'}">
			<a href="/member/join?joinType=1">학생등록</a>
			<a href="/member/join?joinType=2">직원등록</a>
			<a href="/member/join?joinType=3">관리자등록</a>
		</c:if>
	</c:if>
</body>
</html>