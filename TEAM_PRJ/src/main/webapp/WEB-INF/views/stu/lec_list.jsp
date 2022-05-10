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
<!-- collName으로 할건지 collNo으로 할건지 정하고 stuDate로 합칠지 stuDate, stuTime 으로 나눌지 정하기 -->
<c:forEach items="${stuList }" var="stu">
	${stu.stuName }<br>
	${stu.stuScore }<br>
	${stu.collNo }<br>
	${stu.deptNo }<br>
	${stu.stuPr }<br>
	${stu.createDate }<br>
	${stu.stuName }<br>
	${stu.maxNum }<br>
	${stu.nowNum }<br>
	${stu.stuDate }<br>
	${stu.stuMemo }<br>
</c:forEach>
</body>
</html>