<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 화면</title>
<style type="text/css">
.page-centered {
    width: 30%;
    height: 30%;
    position: absolute;
    top: 40%;
    left: 50%;
  font-family: sans-serif;
    -ms-transform: translateX(-50%) translateY(-50%);
    -webkit-transform: translate(-50%,-50%);
    transform: translate(-50%,-50%);
}
.login-h1 {
    font-weight: 100;
    font-size: 1.8em;
  font-weight: 100;
    text-align: center;
  font-family: sans-serif;
    margin-bottom: 30px;
}
.form-input {
  width:100%;
  margin-bottom: 10px;
    font-size: 0.85em;
    font-weight: 100;
    border-radius: 0px !important;
    padding: 10px 20px;
}
input, textarea, button, button:focus {
    outline: none;
    box-shadow:none !important;
}
.logo {
    margin: 0 auto;
    width: 100px;
    height: 100px;
    color: white;
    border-radius: 50%;
    background-color: #8CC3A9;
    margin-bottom: 30px;
}
.logo p {
    position: relative;
    top: 50%;
    text-align: center;
    transform: translate(-1%,-50%);
    -ms-transform: translateX(-1%) translateY(-50%);
    -webkit-transform: translate(-1%,-50%);
    font-size: 1.5em;
    font-weight: 100;
    text-transform: uppercase;
}
.form-submit {
    background-color: #8CC3A9;
    border: none;
    font-weight: 100;
    font-size: 1em;
    color: white;
    padding: 10px 30px;
    cursor: pointer;
}
</style>
</head>
<body>
	<div class="page-centered">
        <div class="logo">
            <p>KH</p>
        </div>
        <form action="#" id="loginForm" onsubmit="return login();">
            <div class="form-group">
               <input class="form-control form-input" type="text" name="memId" placeholder="아이디를 입력해주세요" autocomplete="none" required>
			</div>
            <div class="form-group">
                <input class="form-control form-input" type="password" name="memPw" placeholder="비밀번호를 입력해주세요" required>
			</div>
            <div class="text-center mb-3">
            	<button type="submit" class="form-submit btn">로그인</button>
            </div>
            <div class="text-center">
           		<button type="button" class="form-submit btn" onclick="findId();">아이디찾기</button>
				<button type="button" class="form-submit btn" onclick="findPw();">비밀번호찾기</button>
            </div>
        </form>
    </div>
    
    <!-- Modal -->
		<div class="modal fade" id="findModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="findModalTitle" aria-hidden="true">
		  <div class="modal-dialog modal-dialog-centered w-25">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="findModalTitle"></h5>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <div class="modal-body text-center" id="findModalBody">
		        <button type="button" class="btn btn-success opacity-50 me-2" id="findEmail">이메일로 찾기</button>
		        <button type="button" class="btn btn-success opacity-50 ms-2" id="findPhone">연락처로 찾기</button>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-success opacity-50" data-bs-dismiss="modal">닫기</button>
		      </div>
		    </div>
		  </div>
		</div>
<script type="text/javascript" src="/resources/js/member/login.js"></script>
</body>
</html>