<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="row">
		<div class="col text-end">
			<!-- Button trigger modal -->
			<button type="button" class="btn btn-light" data-bs-toggle="modal" data-bs-target="#loginModal">Login</button> 
			<button type="button" class="btn btn-light" data-bs-toggle="modal" data-bs-target="#joinModal">Join</button> 
		</div>
	</div>
	<div class="row">
		<div class="col text-center">
			<h2>BOOK SHOP</h2>
		</div>
	</div>
	<div class="row">
		<div class="col">
			<nav class="navbar navbar-expand-lg navbar-light bg-light">
				<div class="container-fluid">
					<a class="navbar-brand" href="#">Navbar</a>
					<button class="navbar-toggler" type="button"
						data-bs-toggle="collapse" data-bs-target="#navbarNav"
						aria-controls="navbarNav" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>
					<div class="collapse navbar-collapse" id="navbarNav">
						<ul class="navbar-nav">
							<li class="nav-item">
								<a class="nav-link active" aria-current="page" href="#">Home</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" href="#">IT/인터넷</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" href="#">사회/과학</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" href="#">소설</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" href="#">에세이</a>
							</li>
							<li class="nav-item">
								<a class="nav-link disabled">Disabled</a>
							</li>
						</ul>
					</div>
				</div>
			</nav>
		</div>
	</div>
	
<!-- Login Modal -->
<div class="modal fade modalEvent" id="loginModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="staticBackdropLabel">로그인</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <form action="#" method="post">
      	<div class="mb-3">
      		<input class="form-control" type="text" name="memId" placeholder="아이디를 입력해주세요" aria-label="default input example">
      	</div>
       	<div class="mb-3">
      		<input class="form-control" type="password" name="memPw" placeholder="비밀번호를 입력해주세요" aria-label="default input example">
      	</div>
      	<div class="mb-3 text-end">
	      	<button type="button" class="btn btn-dark" data-bs-toggle="modal" data-bs-target="#joinModal">회원가입</button> 
	        <button type="button" class="btn btn-dark" data-bs-dismiss="modal">취소</button>
	        <button type="submit" class="btn btn-dark">로그인</button>
        </div>
      	</form>
      </div>
    </div>
  </div>
</div>
	
<!-- Join Modal -->
<div class="modal fade modalEvent" id="joinModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="staticBackdropLabel">회원가입</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <form class="row g-3" action="/member/join" method="post">
		  <div class="col-12">
		    <label for="inputId" class="form-label">아이디</label>
		    <input type="text" class="form-control" id="inputId" name="memId" maxlength="15" required>
		  </div>
		  <div class="col-12">
		    <label for="inputPassword" class="form-label">비밀번호</label>
		    <input type="password" class="form-control" id="inputPassword" name="memPw" maxlength="16" required>
		  </div>
		  <div class="col-12">
		    <label for="inputPasswordCheck" class="form-label">비밀번호확인</label>
		    <input type="password" class="form-control" id="inputPasswordCheck" name="memPwCheck" maxlength="16" required>
		  </div>
		  <div class="col-md-4">
		    <label for="inputName" class="form-label">이름</label>
		    <input type="text" class="form-control" id="inputName" name="memName" required>
		  </div>
		  <div class="col-md-8">
		    <label for="inputEmail" class="form-label">이메일</label>
		    <input type="email" class="form-control" id="inputEmail" name="memEmail" required>
		  </div>
		  <div class="col-md-4">
		    <label for="inputCity" class="form-label">연락처</label>
		     <select id="inputState" class="form-select" name="memPhone">
		      <option value="010" selected>010</option>
		      <option value="011">011</option>
		    </select>
		  </div>
		  <div class="col-md-4">
		  <label for="" class="form-label">&nbsp;</label>
		   <input type="text" class="form-control" name="memPhone" maxlength="4" required>
		  </div>
		  <div class="col-4 d-grid">
		  <label for="" class="form-label">&nbsp;</label>
		   <input type="text" class="form-control" name="memPhone" maxlength="4" required>
		  </div>
		  <div class="col-8">
		    <label for="inputAddress" class="form-label">주소</label>
		    <input type="text" class="form-control" id="addr" onclick="execDaumPostcode();" placeholder="도로명주소" name="memAddress" readonly required>
		  </div>
		  <div class="col-4 d-grid">
		  	<label for="" class="form-label">&nbsp;</label>
		    <button type="button" class="btn btn-dark" onclick="execDaumPostcode();">우편번호</button>
		  </div>
		  <div class="col-12">
		    <input type="text" class="form-control" id="inputAddress" placeholder="상세주소" name="memAddress" required>
		  </div>
		  <div class="col-12">
		    <div class="form-check">
		      <input class="form-check-input" type="checkbox" id="gridCheck">
		      <label class="form-check-label" for="gridCheck">
		        Check me out
		      </label>
		    </div>
		  </div>
		  <div class="col-12 text-end">
		  	<button type="button" class="btn btn-dark" data-bs-dismiss="modal">취소</button>
		    <button type="submit" class="btn btn-dark">회원가입</button>
		  </div>
		</form>
      </div>
    </div>
  </div>
</div>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript">
	// 모달 창 종료 시 데이터 리셋
	const loginModalEl = document.getElementById('loginModal');
	loginModalEl.addEventListener('hidden.bs.modal', function (event) {
	  const tags = document.querySelectorAll('#loginModal input');
	  for (let i = 0; i < tags.length; i++) {
		  tags[i].value = '';
	  }
	})
	
	const joinModalEl = document.getElementById('joinModal');
	joinModalEl.addEventListener('hidden.bs.modal', function (event) {
		const tags = document.querySelectorAll('#joinModal input');
		for (let i = 0; i < tags.length; i++) {
			tags[i].value = '';
		}	
	})
	
	// 우편번호 검색 API
	function execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById("addr").value = data.roadAddress;
            }
        }).open();
    }
</script>
</body>
</html>