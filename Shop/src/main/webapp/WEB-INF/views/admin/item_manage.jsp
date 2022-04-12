<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="row row-cols-1 row-cols-md-5 g-4">
		<c:forEach items="${itemList}" var="item">
			<div class="col">
				<div class="card h-100">
					<img src='/resources/images/<c:if test="${empty item.attachedImgName}">no_image.jpg</c:if>
					<c:if test="${not empty item.attachedImgName}">${item.attachedImgName}</c:if>' class="card-img-top h-250" alt="${item.itemName}">
					<div class="card-body">
						<h5 class="card-title text-center">${item.itemName}</h5>
						<p class="card-text">${item.itemDetail}</p>
					</div>
					 <div class="card-footer text-end">
				        <small class="text-muted"><fmt:formatNumber value="${item.itemPrice}" type="currency" /></small>
				     </div>
				</div>
			</div>
		</c:forEach>
	</div>
</body>
</html>