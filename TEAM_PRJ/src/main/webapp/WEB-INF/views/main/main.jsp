<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#slider {
	margin: 0;
	padding: 0;
	list-style: none;
}

#slider-wrap {
    width: 100%;
    height: 400px;
    position: relative;
    overflow: hidden;
}

#slider-wrap ul#slider {
    height: 100%;
    position: absolute;
    top: 0;
    left: 0;
}

#slider-wrap ul#slider li {
    float: left;
    position: relative;
    width: 600px;
    height: 400px;
}

#slider-wrap ul#slider li>div {
    position: absolute;
    top: 20px;
    left: 35px;
}

#slider-wrap ul#slider li>div h3 {
	color: #555555;
    font-size: 36px;
    text-transform: uppercase;
}

#slider-wrap ul#slider li>div span {
	color: #555555;
    font-size: 21px;
}

#slider-wrap ul#slider li img {
    display: block;
    width: 100%;
    height: 100%;
}

/*btns*/
.slider-btns {
    position: absolute;
    width: 50px;
    height: 60px;
    top: 50%;
    margin-top: -25px;
    line-height: 57px;
    text-align: center;
    cursor: pointer;
    background: rgba(0, 0, 0, 0.1);
    z-index: 100;
    -webkit-user-select: none;
    -moz-user-select: none;
    -khtml-user-select: none;
    -ms-user-select: none;
    -webkit-transition: all 0.1s ease;
    -o-transition: all 0.1s ease;
    transition: all 0.1s ease;
}

.slider-btns:hover {
    background: rgba(0, 0, 0, 0.3);
}

#next {
    right: -50px;
    border-radius: 7px 0px 0px 7px;
    color: #eee;
}

#previous {
    left: -50px;
    border-radius: 0px 7px 7px 7px;
    color: #eee;
}

#slider-wrap.active #next {
    right: 0px;
}

#slider-wrap.active #previous {
    left: 0px;
}

/*bar*/
#slider-pagination-wrap {
    min-width: 20px;
    margin-top: 350px;
    margin-left: auto;
    margin-right: auto;
    height: 15px;
    position: relative;
    text-align: center;
}

#slider-pagination-wrap ul {
    width: 100%;
}

#slider-pagination-wrap ul li {
    margin: 0 4px;
    display: inline-block;
    width: 5px;
    height: 5px;
    border-radius: 50%;
    background: #fff;
    opacity: 0.5;
    position: relative;
    top: 0;
}

#slider-pagination-wrap ul li.active {
    width: 12px;
    height: 12px;
    top: 3px;
    opacity: 1;
    -webkit-box-shadow: rgba(0, 0, 0, 0.1) 1px 1px 0px;
    box-shadow: rgba(0, 0, 0, 0.1) 1px 1px 0px;
}

/*ANIMATION*/
#slider-wrap ul,
#slider-pagination-wrap ul li {
    -webkit-transition: all 0.3s cubic-bezier(1, .01, .32, 1);
    -o-transition: all 0.3s cubic-bezier(1, .01, .32, 1);
    transition: all 0.3s cubic-bezier(1, .01, .32, 1);
}
</style>
</head>
<body>
	<div id="slider-wrap">
	    <ul id="slider">
	        <li>
	            <div>
	                <h3>#팀프로젝트</h3>
	                <span>우리의 처음이자 마지막 팀프로젝트!</span>
	            </div>
	            <img src="/resources/images/BACK_IMG_1.jpg">
	        </li>
	
	        <li>
	            <div>
	                <h3>#학사홈페이지</h3>
	                <span>우리가 만든 홈페이지는 학사홈페이지!</span>
	            </div>
	            <img src="/resources/images/BACK_IMG_2.jpg">
	        </li>
	
	        <li>
	            <div>
	                <h3>#팀프로젝트원</h3>
	                <span>우미타, 배도훈, 이강국</span>
	            </div>
	            <img src="/resources/images/BACK_IMG_3.jpg">
	        </li>
	
	        <li>
	            <div>
	                <h3>#마무리</h3>
	                <span>홈페이지 만드느라 고생하셨습니다!</span>
	            </div>
	            <img src="/resources/images/BACK_IMG_4.jpg">
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