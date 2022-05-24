<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 관리 화면</title>
<style type="text/css">
.memImg {
	height: 180px;
	width: 180px;
	max-height: 180px;
	max-width: 180px;
}
</style>
</head>
<body>
	<div class="w-50 mx-auto mt-3 mb-3 pt-3 pb-3">
		<div class="text-center">
			<h5>회원 목록</h5>
			<div class="text-end">
				<button type="button" class="btn btn-outline-success" onclick="rejoin();">재가입처리</button>
				<button type="button" class="btn btn-outline-danger" onclick="withdraw();">탈퇴처리</button>
			</div>
			<table class="table">
				<thead>
					<tr>
						<th scope="col" class="col-1"><input type="checkbox" class="form-check-input" name="chkAll" onclick="selectAll(this);"></th>
						<th scope="col" class="col-4">아이디</th>
						<th scope="col" class="col-3">이름</th>
						<th scope="col" class="col-2">직책</th>
						<th scope="col" class="col-2">가입여부</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${memList}" var="member">
						<tr>
							<td scope="row"><input type="checkbox" class="form-check-input" name="chkUser" value="${member.memNo}" onclick="unCheck(this);"></td>
							<td role="button" data-bs-toggle="modal" data-bs-target="#memberDetailModal" onclick="selectMemberDetail('${member.memNo}');">${member.memNo}</td>
							<td role="button" data-bs-toggle="modal" data-bs-target="#memberDetailModal" onclick="selectMemberDetail('${member.memNo}');">${member.memName}</td>
							<td role="button" data-bs-toggle="modal" data-bs-target="#memberDetailModal" onclick="selectMemberDetail('${member.memNo}');">${member.memType}</td>
							<td role="button" data-bs-toggle="modal" data-bs-target="#memberDetailModal" onclick="selectMemberDetail('${member.memNo}');">${member.isJoin}</td>
						</tr>					
					</c:forEach>
				</tbody>
			</table>
			
			<nav aria-label="Page navigation example">
			  <ul class="pagination  justify-content-center">
			  	<c:if test="${memPage.paging.startPage != 1}">
				    <li class="page-item">
				      <a class="page-link link-secondary" href="/member/memList?nowPage=${memPage.paging.startPage - 1}&isJoin=${memPage.isJoin}&memType=${memPage.memType}&empType=${memPage.empType}&memName=${memPage.memName}" aria-label="Previous">
				        <span aria-hidden="true">&laquo;</span>
				      </a>
				    </li>
			    </c:if>
			    <c:forEach begin="${memPage.paging.startPage }" end="${memPage.paging.endPage }" var="p">
			   		<li class="page-item <c:if test="${p == memPage.paging.nowPage}">active</c:if>" aria-current="page">
		      			<a class="page-link link-secondary" href="/member/memList?nowPage=${p}&isJoin=${memPage.isJoin}&memType=${memPage.memType}&empType=${memPage.empType}&memName=${memPage.memName}">${p}</a>
		    		</li>
				</c:forEach>
			    <c:if test="${memPage.paging.endPage != memPage.paging.lastPage}">
				    <li class="page-item">
				      <a class="page-link link-secondary" href="/member/memList?nowPage=${memPage.paging.endPage + 1}&isJoin=${memPage.isJoin}&memType=${memPage.memType}&empType=${memPage.empType}&memName=${memPage.memName}" aria-label="Next">
				        <span aria-hidden="true">&raquo;</span>
				      </a>
				    </li>
			    </c:if>
			  </ul>
			</nav>
			<nav class="navbar navbar-light">
			  <div class="col-12">
			    <form class="d-flex pe-4 me-5" id="searchForm" action="#" onsubmit="return searchMember();">
			    	<div class="form-check form-check-inline col-3 m-0 p-0 me-1">
				   		<select class="form-select" aria-label="Default select example" name="isJoin" id="isJoin">
						  <option value="">전체회원</option>
						  <option value="Y" <c:if test="${memPage.isJoin eq 'Y'}">selected</c:if>>가입회원만</option>
						  <option value="N" <c:if test="${memPage.isJoin eq 'N'}">selected</c:if>>탈퇴회원만</option>
						</select>
			   		</div>
			   		<div class="form-check form-check-inline col-2 m-0 p-0 me-1">
				   		<select class="form-select" aria-label="Default select example" name="searchMemType" id="searchMemType">
						  <option value="">직책</option>
						  <option value="stu" <c:if test="${memPage.memType eq 'stu'}">selected</c:if>>학생</option>
						  <option value="pro" <c:if test="${memPage.empType eq 'pro'}">selected</c:if>>교수</option>
						  <option value="emp" <c:if test="${memPage.empType eq 'emp'}">selected</c:if>>학사팀</option>
						  <option value="admin" <c:if test="${memPage.memType eq 'admin'}">selected</c:if>>관리자</option>
						</select>
					</div>
			   		<div class="form-check form-check-inline m-0 p-0 col-2 me-1">
				   		<select class="form-select" aria-label="Default select example" name="searchGender" id="searchGender">
						  <option value="">성별</option>
						  <option value="male" <c:if test="${memPage.memGender eq 'male'}">selected</c:if>>남자</option>
						  <option value="female" <c:if test="${memPage.memGender eq 'female'}">selected</c:if>>여자</option>
						</select>
					</div>
			   		<div class="form-check form-check-inline m-0 p-0 col-2 me-1">
				   		<select class="form-select" aria-label="Default select example" name="searchType" id="searchType">
						  <option value="name" <c:if test="${not empty memPage.memName}">selected</c:if>>이름</option>
						  <option value="email" <c:if test="${not empty memPage.memEmail}">selected</c:if>>메일</option>
						  <option value="addr" <c:if test="${not empty memPage.memAddr}">selected</c:if>>주소</option>
						  <option value="phone" <c:if test="${not empty memPage.memPhone}">selected</c:if>>연락처</option>
						</select>
					</div>
					<div class="form-check form-check-inline m-0 p-0 col-4 me-1">
			      		<input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="searchInput" id="searchInput" 
	      				<c:if test="${not empty memPage.memName}">
      						value="${memPage.memName}"
      					</c:if>
	      				<c:if test="${not empty memPage.memEmail}">
      						value="${memPage.memEmail}"
      					</c:if>
	      				<c:if test="${not empty memPage.memAddr}">
      						value="${memPage.memAddr}"
      					</c:if>
	      				<c:if test="${not empty memPage.memPhone}">
      						value="${memPage.memPhone}"
      					</c:if>>
			      	</div>
		      		<div class="form-check form-check-inline m-0 p-0 col-2 text-start">
			      		<button class="btn btn-outline-primary">검색</button>
			      	</div>
			    </form>
			  </div>
			</nav>
		</div>
	</div>
	
	<!-- Modal -->
	<div class="modal fade" id="memberDetailModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="memberModalTitle" aria-hidden="true">
	  <div class="modal-dialog modal-dialog-centered">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="memberModalTitle"></h5>
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      <div class="modal-body">
	      	<table class="table text-center">
	      		<tbody>
	      			<tr>
	      				<td colspan="4" rowspan="4" id="memImage"></td>
	      				<td class="fw-bold" scope="col" colspan="3">아이디</td>
	      				<td class="fw-bold" scope="col" colspan="1">직책</td>
	      			</tr>
	      			<tr>
	      				<td colspan="3" id="memNo"></td>
	      				<td colspan="1" id="memType"></td>
	      			</tr>
	      			<tr>
	      				<td class="fw-bold" scope="col" colspan="3">이름</td>
	      				<td class="fw-bold" scope="col" colspan="1">성별</td>
	      			</tr>
	      			<tr>
	      				<td colspan="3" id="memName"></td>
	      				<td colspan="1" id="memGender"></td>
	      			</tr>
	      			<tr>
	      				<td class="fw-bold" scope="col" colspan="4">이메일</td>
	      				<td class="fw-bold" scope="col" colspan="2">연락처</td>
	      				<td class="fw-bold" scope="col" colspan="2">생일</td>
	      			</tr>
	      			<tr>
	      				<td colspan="4" id="memEmail"></td>
	      				<td colspan="2" id="memPhone"></td>
	      				<td colspan="2" id="memBirth"></td>
	      			</tr>
	      			<tr>
	      				<td class="fw-bold" scope="col" colspan="8">주소</td>
	      			</tr>
	      			<tr>
	      				<td colspan="8" id="memAddr"></td>
	      			</tr>
	      			<tr>
	      				<td class="fw-bold" scope="col" colspan="4">가입날짜</td>
	      				<td class="fw-bold" scope="col" colspan="4">탈퇴날짜</td>
	      			</tr>
	      			<tr>
	      				<td colspan="4" id="createDate"></td>
	      				<td colspan="4" id="withdrawDate"></td>
	      			</tr>
	      		</tbody>
	      	</table>
	      </div>
	    </div>
	  </div>
	</div>
<script type="text/javascript" src="/resources/js/member/memList.js"></script>
</body>
</html>