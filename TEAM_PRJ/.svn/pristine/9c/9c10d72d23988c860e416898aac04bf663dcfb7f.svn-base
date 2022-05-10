<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:if test="${empty member}">
	<title>회원가입 화면</title>
</c:if>
<c:if test="${not empty member}">
	<title>회원 상세정보 화면</title>
</c:if>
</head>
<body>
	<c:if test="${empty member}">
		<div class="row">
	 		<form class="row g-3" action="#" id="joinForm" onsubmit="return joinMember();">
				<c:choose>
					<c:when test="${joinType eq '1'}">
						<div class="col-12 text-center">학생 등록</div>
						<input type="hidden" name="memType" value="stu">
					</c:when>
					<c:when test="${joinType eq '2'}">
						<div class="col-12 text-center">직원 등록</div>
						<input type="hidden" name="memType" value="emp">
					</c:when>
					<c:when test="${joinType eq '3'}">
						<div class="col-12 text-center">관리자 등록</div>
						<input type="hidden" name="memType" value="admin">
					</c:when>
					<c:otherwise>
						<input type="hidden" id="nonType">
					</c:otherwise>
				</c:choose>
				
				<div class="col-12">
					<label for="inputPassword" class="form-label">비밀번호</label> 
					<input type="password" class="form-control" id="inputPassword" name="memPw" minlength="8" maxlength="16"
						placeholder="영어, 숫자, 특수문자를 각각 하나 이상 포함하여 8자 이상 16자 이하"
						oninput="checkPw();" pattern="^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,16}$" required>
				</div>
				<div class="col-12">
					<label for="inputPasswordCheck" class="form-label">비밀번호 확인</label> 
					<input type="password" class="form-control" id="inputPasswordCheck" name="memPwCheck" minlength="8" maxlength="16"
						placeholder="영어, 숫자, 특수문자를 각각 하나 이상 포함하여 8자 이상 16자 이하" 
						oninput="checkPw();" pattern="^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,16}$" required>
				</div>
				<div class="col-md-3">
					<label for="inputName" class="form-label">이름</label>
					<input type="text" class="form-control" id="inputName" name="memName" placeholder="이름" autocomplete="none" pattern="^[가-힣a-zA-Z]+$" required>
				</div>
				<div class="col-md-6">
					<label for="inputEmail" class="form-label">이메일</label> 
					<input type="email" class="form-control" id="inputEmail" name="memEmail" placeholder="id@email.com" autocomplete="none" oninput="emailCheckReset();" required>
				</div>
				<div class="col-md-2">
					<label for="" class="form-label">&nbsp;</label> 
					<button type="button" class="btn btn-dark form-control" onclick="checkEmail();">메일인증</button>
				</div>
				<div class="col-md-1">
					<label for="" class="form-label">&nbsp;</label> 
					<div id="emailDiv" style="opacity: 0;">
						<svg xmlns="http://www.w3.org/2000/svg" width="32" height="32" fill="currentColor" class="bi bi-check-circle text-success" viewBox="0 0 16 16">
						  <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
						  <path d="M10.97 4.97a.235.235 0 0 0-.02.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-1.071-1.05z"/>
						</svg>
					</div>
				</div>
				<div class="col-md-3">
					<label for="inputPhone1" class="form-label">연락처</label> 
					<select id="inputPhone1" class="form-select" name="memPhone" onchange="phoneCheckReset();">
						<option value="010" selected>010</option>
						<option value="011">011</option>
					</select>
				</div>
				<div class="col-md-3">
					<label for="" class="form-label">&nbsp;</label> 
					<input type="text" class="form-control" name="memPhone" id="inputPhone2" maxlength="4" pattern="^[0-9]+$" autocomplete="none" oninput="phoneCheckReset();" required>
				</div>
				<div class="col-md-3">
					<label for="" class="form-label">&nbsp;</label> 
					<input type="text" class="form-control" name="memPhone" id="inputPhone3" maxlength="4" pattern="^[0-9]+$" autocomplete="none" oninput="phoneCheckReset();" required>
				</div>
				<div class="col-md-2">
					<label for="" class="form-label">&nbsp;</label> 
					<button type="button" class="btn btn-dark form-control" onclick="checkPhone();">번호인증</button>
				</div>
				<div class="col-md-1">
					<label for="" class="form-label">&nbsp;</label> 
					<div id="phoneDiv" style="opacity: 0;">
						<svg xmlns="http://www.w3.org/2000/svg" width="32" height="32" fill="currentColor" class="bi bi-check-circle text-success" viewBox="0 0 16 16">
						  <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
						  <path d="M10.97 4.97a.235.235 0 0 0-.02.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-1.071-1.05z"/>
						</svg>
					</div>
				</div>
				<div class="col-8">
					<label for="inputAddress" class="form-label">주소</label> 
					<input type="text" class="form-control bg-white" id="addr" onclick="execDaumPostcode();" 
							placeholder="도로명주소" name="memAddr" readonly required>
				</div>
				<div class="col-4 d-grid">
					<label for="" class="form-label">&nbsp;</label>
					<button type="button" class="btn btn-dark" onclick="execDaumPostcode();">우편번호</button>
				</div>
				<div class="col-12">
					<input type="text" class="form-control" id="inputAddress" placeholder="상세주소" autocomplete="none" name="memAddr" required>
				</div>
				<div class="col-md-4">
					<label for="inputGender" class="form-label">성별</label>
					<div class="form-control border-0">
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio" name="memGender" id="flexRadioDefault1" value="male" checked>
							<label class="form-check-label" for="flexRadioDefault1">남자</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio" name="memGender" id="flexRadioDefault2" value="female">
						 	<label class="form-check-label" for="flexRadioDefault2">여자</label>
					 	</div>
				 	</div>
				</div>
				<div class="col-md-8">
					<label for="inputBirth" class="form-label">생일</label> 
					<input type="date" id="inputBirth" class="form-control" name="memBirth" required/>
				</div>
				<div class="mb-3">
					<label for="formFile" class="form-label">사진</label>
					<input class="form-control" type="file" id="formFile" name="imageFile" accept="image/jpeg, image/jpg, image/png">
					<img src="" class="thumb" width="200"/>
					<a href="javascript:void(0);" class="dellink" style="display: none;">썸네일삭제</a>
				</div>
				<div class="col-12 text-end">
					<button type="submit" class="btn btn-dark">회원등록</button>
				</div>
			</form>
		</div>
	<!-- 외부 script -->
	<script type="text/javascript" src="/resources/js/member/join.js"></script>
	</c:if>
	
	<c:if test="${not empty member}">
		<div class="row">
	 		<form class="row g-3" action="#" id="editForm" onsubmit="return editMember();">
				<div class="col-12 text-center">${member.memName}님의 회원정보</div>
				<input type="hidden" name="memNo" value="${member.memNo}">
				
				<div class="col-md-3">
					<label for="inputName" class="form-label">이름</label>
					<input type="text" class="form-control" id="inputName" name="memName" placeholder="이름" autocomplete="none" pattern="^[가-힣a-zA-Z]+$" value="${member.memName}" readonly required>
				</div>
				<div class="col-md-6">
					<label for="inputEmail" class="form-label">이메일</label> 
					<input type="email" class="form-control" id="inputEmail" name="memEmail" placeholder="id@email.com" autocomplete="none" oninput="emailCheckReset();" value="${member.memEmail}" required>
				</div>
				<div class="col-md-2">
					<label for="" class="form-label">&nbsp;</label> 
					<button type="button" class="btn btn-dark form-control" onclick="checkEmail();">메일인증</button>
				</div>
				<div class="col-md-1">
					<label for="" class="form-label">&nbsp;</label> 
					<div id="emailDiv">
						<svg xmlns="http://www.w3.org/2000/svg" width="32" height="32" fill="currentColor" class="bi bi-check-circle text-success" viewBox="0 0 16 16">
						  <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
						  <path d="M10.97 4.97a.235.235 0 0 0-.02.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-1.071-1.05z"/>
						</svg>
					</div>
				</div>
				<div class="col-md-3">
					<label for="inputPhone1" class="form-label">연락처</label> 
					<select id="inputPhone1" class="form-select" name="memPhone" onchange="phoneCheckReset();">
						<c:if test="${fn:split(member.memPhone, '-')[0] eq '010'}">
							<option value="010" selected>010</option>
							<option value="011">011</option>
						</c:if>
						<c:if test="${fn:split(member.memPhone, '-')[0] eq '011'}">
							<option value="010">010</option>
							<option value="011" selected>011</option>
						</c:if>
					</select>
				</div>
				<div class="col-md-3">
					<label for="" class="form-label">&nbsp;</label> 
					<input type="text" class="form-control" name="memPhone" id="inputPhone2" value="${fn:split(member.memPhone, '-')[1]}" maxlength="4" pattern="^[0-9]+$" autocomplete="none" oninput="phoneCheckReset();" required>
				</div>
				<div class="col-md-3">
					<label for="" class="form-label">&nbsp;</label> 
					<input type="text" class="form-control" name="memPhone" id="inputPhone3" value="${fn:split(member.memPhone, '-')[2]}"  maxlength="4" pattern="^[0-9]+$" autocomplete="none" oninput="phoneCheckReset();" required>
				</div>
				<div class="col-md-2">
					<label for="" class="form-label">&nbsp;</label> 
					<button type="button" class="btn btn-dark form-control" onclick="checkPhone();">번호인증</button>
				</div>
				<div class="col-md-1">
					<label for="" class="form-label">&nbsp;</label> 
					<div id="phoneDiv">
						<svg xmlns="http://www.w3.org/2000/svg" width="32" height="32" fill="currentColor" class="bi bi-check-circle text-success" viewBox="0 0 16 16">
						  <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
						  <path d="M10.97 4.97a.235.235 0 0 0-.02.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-1.071-1.05z"/>
						</svg>
					</div>
				</div>
				<div class="col-8">
					<label for="inputAddress" class="form-label">주소</label> 
					<input type="text" class="form-control bg-white" id="addr" onclick="execDaumPostcode();" 
							placeholder="도로명주소" name="memAddr" value="${fn:split(member.memAddr, '/')[0]}" readonly required>
				</div>
				<div class="col-4 d-grid">
					<label for="" class="form-label">&nbsp;</label>
					<button type="button" class="btn btn-dark" onclick="execDaumPostcode();">우편번호</button>
				</div>
				<div class="col-12">
					<input type="text" class="form-control" id="inputAddress" value="${fn:split(member.memAddr, '/')[1]}" placeholder="상세주소" autocomplete="none" name="memAddr" required>
				</div>
				<div class="col-md-4">
					<label for="inputGender" class="form-label">성별</label>
					<div class="form-control border-0">
						<c:if test="${member.memGender eq 'male'}">
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="radio" name="memGender" id="flexRadioDefault1" value="male" checked>
								<label class="form-check-label" for="flexRadioDefault1">남자</label>
							</div>
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="radio" name="memGender" id="flexRadioDefault2" value="female">
							 	<label class="form-check-label" for="flexRadioDefault2">여자</label>
						 	</div>
					 	</c:if>
						<c:if test="${member.memGender eq 'female'}">
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="radio" name="memGender" id="flexRadioDefault1" value="male">
								<label class="form-check-label" for="flexRadioDefault1">남자</label>
							</div>
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="radio" name="memGender" id="flexRadioDefault2" value="female" checked>
							 	<label class="form-check-label" for="flexRadioDefault2">여자</label>
						 	</div>
					 	</c:if>
				 	</div>
				</div>
				<div class="col-md-8">
					<label for="inputBirth" class="form-label">생일</label> 
					<input type="date" id="inputBirth" class="form-control" name="memBirth" value="${member.memBirth}" required/>
				</div>
				<div class="mb-3">
					<label for="formFile" class="form-label">사진</label>
					<input class="form-control" type="file" id="formFile" name="imageFile" accept="image/jpeg, image/jpg, image/png">
					<img src="" class="thumb" width="200"/>
					<a href="javascript:void(0);" class="dellink" style="display: none;">썸네일삭제</a>
				</div>
				<div class="col-12 text-end">
					<button type="submit" class="btn btn-dark">회원수정</button>
				</div>
			</form>
		</div>
	<!-- 외부 script -->
	<script type="text/javascript" src="/resources/js/member/edit.js"></script>		
	</c:if>
	
	<!-- Modal -->
	<div class="modal fade" id="checkCodeModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
	  <div class="modal-dialog modal-dialog-centered">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="staticBackdropLabel">전달받은 코드번호를 입력해주세요</h5>
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      <div class="modal-body">
	        <input type="text" class="form-control" id="checkCode">
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-primary" onclick="fnCheckCode();">확인</button>
	      </div>
	    </div>
	  </div>
	</div>
<!-- 다음 주소 api  -->
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script> 
</body>
</html>