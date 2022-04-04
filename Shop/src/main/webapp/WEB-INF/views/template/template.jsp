<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><tiles:insertAttribute name="title" /></title>
<!-- 부트스트랩 css -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<!-- 전체 css -->
<link href="/resources/css/common/common.css" rel="stylesheet">
<!-- 부트스트랩 js -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous">
</script>
<!-- JQuery js -->
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col">
				<tiles:insertAttribute name="menu" />
			</div>
		</div>
		<div class="row mg-top-15">
			<c:choose>
				<c:when test="${cateType eq 'admin' and login.isAdmin eq 'Y'}">
					<div class="col-2">
						<tiles:insertAttribute name="side"/>
					</div>
					<div class="col-10">
						<tiles:insertAttribute name="body"/>
					</div>
				</c:when>
				<c:otherwise>
					<div class="col">
						<tiles:insertAttribute name="body" />
					</div>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</body>
</html>