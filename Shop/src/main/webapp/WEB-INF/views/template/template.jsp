<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><tiles:insertAttribute name="title" /></title>
</head>
<body>
	<div>
		<tiles:insertAttribute name="menu"/>
	</div>
	<div>
		<tiles:insertAttribute name="body"/>
	</div>
</body>
</html>