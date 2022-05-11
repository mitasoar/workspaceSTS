<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#msgDiv .card:hover {
	background-color: #EEEEEE;
}

#msgDiv {
	height: 660px;
	overflow: auto;
}

#msgBody {
	height: 500px;
	overflow: auto;
}

#searchList {
	max-height: 50px;
	max-width: 400px;
}

.card-header, .card-footer {
	background-color: white;
}

.card-body {
	padding-bottom: 2%;
}

.max-w-75 {
	max-width: 75%;
}

.bg-myTalk {
	background-color: #FFEB33; 
}

.bg-yourTalk {
	background-color: #E9EFC0; 
}
</style>
</head>
<body>
	<input type="hidden" id="memNo" value="${memNo}">
	<div class="w-75 mx-auto">
		<ul class="nav nav-tabs" id="myTab" role="tablist">
		  <li class="nav-item" role="presentation">
		    <button class="nav-link active" id="home-tab" data-bs-toggle="tab" data-bs-target="#home" type="button" role="tab" aria-controls="home" aria-selected="true" onclick="fromMsgList();">메세지목록</button>
		  </li>
		  <li class="nav-item" role="presentation">
		    <button class="nav-link" id="profile-tab" data-bs-toggle="tab" data-bs-target="#profile" type="button" role="tab" aria-controls="profile" aria-selected="false" onclick="writeMsg();">메세지보내기</button>
		  </li>
		</ul>
		<div class="tab-content row">
			<div class="col-md-4" id="msgDiv"></div>
			<div class="col-md-8" id="chatDiv">
				<div class="card">
				  <div class="card-header fw-bold fs-4" id="msgHeader"></div>
				  <div class="card-body" id="msgBody"></div>
				  <div class="card-footer text-muted text-center">
				    <input type="text" class="form-control w-75 d-inline-block" id="content" name="content">
				    <button class="btn btn-primary">전송</button>
				  </div>
				</div>
			</div>
		</div>
	</div>
<script type="text/javascript" src="/resources/js/message/message.js"></script>
</body>
</html>