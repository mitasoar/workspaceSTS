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
<a href="/stu/stuInfo">내 정보 조회 및 수정</a><br>
<a href="/stu/myClass">내 시간표 확인</a><br>
<a href="/stu/myScore">내 성적 확인</a><br>
<a href="/stu/academic">휴학 / 복학 신청</a><br>
<a href="/stu/dropOut">자퇴 신청</a><br>
<a href="/stu/deptApp">전과 / 복수 전공 신청</a><br>
<a href="/stu/regClassForm">수강 신청</a><br>
로그인 학번 : ${sessionScope.loginInfo.stuNo}
</body>
</html>