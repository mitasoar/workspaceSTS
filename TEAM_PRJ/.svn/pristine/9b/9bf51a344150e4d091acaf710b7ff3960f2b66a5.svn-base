function searchMember() {
	let memType = document.getElementById('searchMemType').value; // 회원 유형
	let searchType = document.getElementById('searchType').value; // 검색 유형
	let searchInput = document.getElementById('searchInput').value; // 검색 내용
	let searchHref = '/member/memList'; // 검색 주소 값
	
	searchHref += '?isJoin=' + document.getElementById('isJoin').value; // 가입 여부
	searchHref += '&memGender=' + document.getElementById('searchGender').value; // 가입 여부
	
	if (memType == 'stu' || memType == 'admin') { // 학생, 관리자
		searchHref += '&memType=' + memType;
	} else if (memType == 'pro' || memType == 'emp') { // 교수, 학사팀
		searchHref += '&empType=' + memType;
	}
	
	if (searchType == 'name') { // 이름
		searchHref += '&memName=' + searchInput;
	} else if (searchType == 'email') { // 메일
		searchHref += '&memEmail=' + searchInput;
	} else if (searchType == 'addr') { // 주소
		searchHref += '&memAddr=' + searchInput;
	} else if (searchType == 'phone') { // 연락처
		searchHref += '&memPhone=' + searchInput;
	}
	
	location.href = searchHref;
	
	return false;
}

function selectMemberDetail(memNo) {
	document.getElementById('memberModalTitle').innerHTML = '회원정보 (' + memNo + ')';
	
	$.ajax({ // 삭제 ajax
		url: "/member/memDetail",
		type: "POST",
		data: {memNo: memNo.split('(')[0]},
		success: function(data) {
			let img = '<img alt="' + data.memName + '" src="/resources/images/' + data.memImage + '" class="memImg">';
			
			document.getElementById('memImage').innerHTML = img; // 회원번호(아이디)
			document.getElementById('memNo').innerHTML = data.memNo; // 회원번호(아이디)
			document.getElementById('memName').innerHTML = data.memName; // 이름
			document.getElementById('memEmail').innerHTML = data.memEmail; // 이메일
			document.getElementById('memAddr').innerHTML = data.memAddr; // 주소
			document.getElementById('memPhone').innerHTML = data.memPhone; // 연락처
			document.getElementById('memGender').innerHTML = data.memGender; // 성별
			document.getElementById('memBirth').innerHTML = data.memBirth; // 생일
			document.getElementById('memType').innerHTML = data.memType; // 직책
			document.getElementById('createDate').innerHTML = data.createDate; // 가입날짜
			document.getElementById('withdrawDate').innerHTML = data.withdrawDate; // 탈퇴날짜
		},
		error: function() {
			alert('회원정보 조회를 실패하였습니다.. 확인 후 다시 시도해주세요');
		}
	});
}


function selectAll(chkAll)  { // 전체 체크박스 선택, 해제
  document.getElementsByName('chkUser').forEach((checkbox) => {
    checkbox.checked = chkAll.checked;
  })
}

function unCheck(chk) { // 체크박스 전체 선택 시, 아닐 시
	if (chk.checked) {
		if (document.querySelectorAll('input[name=chkUser]:checked').length == document.querySelectorAll('input[name=chkUser]').length) {
			document.querySelector('input[name=chkAll]').checked = chk.checked;
		}
	} else {
		document.querySelector('input[name=chkAll]').checked = chk.checked;
	}
}

function withdraw() { // 탈퇴처리 버튼
	if (document.querySelectorAll('input[name=chkUser]:checked').length > 0) {
		let withdrawList = [];
		
		document.getElementsByName('chkUser').forEach((checkbox) => {
	    	if (checkbox.checked) {
				withdrawList.push(checkbox.value);
			}
		});
		
		if (confirm('선택하신 ' + withdrawList.length + '명의 회원들을 가입 탈퇴 처리하겠습니까?')) {
			$.ajax({
				url: "/member/withdraw",
				type: "POST",
				data: {withdrawList: withdrawList},
				traditional : true,
				success: function() {
					alert("선택한 회원들을 정상적으로 가입 탈퇴 처리하였습니다");
					location.reload();
				},
				error: function() {
					alert("회원 가입 탈퇴 처리 오류.. 확인 후 다시 시도해주세요");
				}
			});
		}
	} else {
		alert('가입 탈퇴 처리할 회원을 선택해주세요');
	}
}

function rejoin() { // 재가입처리 버튼
	if (document.querySelectorAll('input[name=chkUser]:checked').length > 0) {
		let rejoinList = [];
		
		document.getElementsByName('chkUser').forEach((checkbox) => {
	    	if (checkbox.checked) {
				rejoinList.push(checkbox.value);
			}
		});
		
		if (confirm('선택하신 ' + rejoinList.length + '명의 회원들을 재가입 처리하겠습니까?')) {
			$.ajax({
				url: "/member/rejoin",
				type: "POST",
				data: {rejoinList: rejoinList},
				traditional : true,
				success: function() {
					alert("선택한 회원들을 정상적으로 재가입 처리하였습니다");
					location.reload();
				},
				error: function() {
					alert("회원 재가입 처리 오류.. 확인 후 다시 시도해주세요");
				}
			});
		}
	} else {
		alert('재가입 처리할 회원을 선택해주세요');
	}
}