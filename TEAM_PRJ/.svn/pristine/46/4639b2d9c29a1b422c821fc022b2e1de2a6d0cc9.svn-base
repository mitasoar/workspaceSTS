<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 화면</title>
<link rel="stylesheet" href="/resources/css/member/login.css">
</head>
<body>
	<div class="page-centered">
        <div class="logo">
            <p>KH</p>
        </div>
        <form action="#" id="loginForm" class="w-75 mx-auto" onsubmit="return login();">
        <div class="form-check text-end">
			<input class="form-check-input float-none" type="checkbox" id="chkSaveId">
			<label class="form-check-label" for="saveId" data-bs-toggle="tooltip" data-bs-placement="right" title="아이디 저장 유지기간은 한달(30일)동안 유지됩니다">아이디 저장</label>
		</div>
            <div class="form-group">
               <input class="form-control form-input" type="text" name="memId" placeholder="아이디를 입력해주세요" autocomplete="off" required>
			</div>
            <div class="form-group">
                <input class="form-control form-input" type="password" name="memPw" placeholder="비밀번호를 입력해주세요" required>
			</div>
            <div class="text-center mb-3">
            	<button type="submit" class="form-submit btn">로그인</button>
            </div>
            <div class="text-center">
           		<button type="button" class="form-submit btn mb-3" onclick="findId();">아이디찾기</button>
				<button type="button" class="form-submit btn mb-3" onclick="findPw();">비밀번호찾기</button>
            </div>
        </form>
    </div>
    
    <!-- Modal -->
		<div class="modal fade" id="findModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="findModalTitle" aria-hidden="true">
		  <div class="modal-dialog modal-dialog-centered w-25">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="findModalTitle"></h5>
		      </div>
		      <div class="modal-body text-center" id="findModalBody">
		        <button type="button" class="btn me-2" id="findEmail">이메일로 찾기</button>
		        <button type="button" class="btn ms-2" id="findPhone">연락처로 찾기</button>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn" data-bs-dismiss="modal">닫기</button>
		      </div>
		    </div>
		  </div>
		</div>
<script type="text/javascript" src="/resources/js/member/login.js"></script>
</body>
</html>