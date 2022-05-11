<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/css/main/main.css">
</head>
<body>
	<div id="slider-wrap">
	    <ul id="slider">
	        <li>
	            <div>
	                <h3>#팀프로젝트</h3>
	                <span>우리의 처음이자 마지막 팀프로젝트!</span>
	            </div>
	            <img src="/resources/images/banner1.jpg">
	        </li>
	        
	        <li>
	            <div>
	                <h3>#팀프로젝트원</h3>
	                <span>우미타, 배도훈, 이강국</span>
	            </div>
	            <img src="/resources/images/banner2.jpg">
	        </li>
	
	        <li>
	            <div>
	                <h3>#어떤거?</h3>
	                <span>우리가 만든건 학사홈페이지!</span>
	            </div>
	            <img src="/resources/images/banner3.jpg">
	        </li>
	
	        <li>
	            <div>
	                <h3>#마무리</h3>
	                <span>팀프로젝트 모두 고생하셨습니다!</span>
	            </div>
	            <img src="/resources/images/banner4.jpg">
	        </li>
	    </ul>
	
	    <div class="slider-btns" id="next"><span>▶</span></div>
	    <div class="slider-btns" id="previous"><span>◀</span></div>
	
	    <div id="slider-pagination-wrap">
	        <ul>
	        </ul>
	    </div>
	</div>
	<div class="row ms-5 mt-3 mb-3">
		<div class="col-10 ms-3 mb-3 pb-1 border-bottom" id="cateDiv">
		</div>
		<ul id="viewBoard">
		</ul>
	</div>
<script type="text/javascript" src="/resources/js/main/main.js"></script>
</body>
</html>