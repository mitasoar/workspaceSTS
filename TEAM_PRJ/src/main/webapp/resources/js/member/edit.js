//이미지 객체 타입으로 이미지 확장자 밸리데이션
function validateType(img) {
  return (['image/jpeg','image/jpg','image/png'].indexOf(img.type) > -1);
}

let elem = document.getElementById('formFile'); //파일 선택 필드 요소 얻기

// 파일 선택 필드에 이벤트 리스너 등록
elem.addEventListener('change', function(e){

  if(validateType(elem.files[0])){

      let preview = document.querySelector('.thumb');

      preview.src = URL.createObjectURL(elem.files[0]); //파일 객체에서 이미지 데이터 가져옴.

      document.querySelector('.dellink').style.display = 'inline-block'; // 이미지 삭제 링크 표시

      preview.onload = function() {

          URL.revokeObjectURL(preview.src); //URL 객체 해제

      }

  } else {

	document.getElementById('formFile').value = '';
	 
    alert('이미지 파일이 아닙니다');

  }

});

document.querySelector('.dellink').addEventListener('click', function(e){

  let dellink = e.target;

  let preview = dellink.previousElementSibling;

  preview.src = ''; // 썸네일 이미지 src 데이터 해제

  document.querySelector('.dellink').style.display = 'none';

});

// 우편번호 검색 API
function execDaumPostcode() {
	new daum.Postcode({
		oncomplete: function(data) {
			// 우편번호와 주소 정보를 해당 필드에 넣는다.
			document.getElementById("addr").value = data.roadAddress;
		}
	}).open();
}

// 회원수정 버튼 비활성화
const editTarget = document.querySelector('#editForm button[type=submit]'); // 등록 버튼

let emailCheck = true; // 이메일 체크 여부
let phoneCheck = true; // 연락처 체크 여부
let checkCode = ''; // 확인을 위한 임시 코드
let modalType = ''; // 모달창 구분을 위한 변수

// 이메일 변경 체크
function emailCheckReset() {
	emailCheck = false; // 이메일 체크 여부 미완료
	$("#emailDiv").css('opacity', '0'); // 체크버튼 숨김
	isConfirm(); // 회원수정 버튼 활성화/비활성화
}

// 이메일 중복 체크
function checkEmail() {
	const joinEmail = document.getElementById('inputEmail'); // 이메일
	
	if (email_check(joinEmail.value)) { // 이메일에 입력 값이 없을 경우
		$.ajax({
			url: "/member/checkEmail",
			type: "POST",
			data: {email : joinEmail.value},
			success: function(data) { // data = 인증코드
				if (data == 'fail') { // 중복되는 이메일 주소인 경우
					alert("이메일 중복입니다.. 이메일 주소를 다시 확인해주세요");
				} else { // 중복되지 않는 이메일 주소인 경우
					alert('메일이 전송되었습니다');
					$("#checkCodeModal").modal('show'); // 모달 창 띄움
					modalType = 'email'; // 이메일 모달
					checkCode = data; // 인증코드 값을 저장
				}
			},
		});
	} else { // 있을 경우
		alert('이메일 주소를 확인해주세요');
	}
}

//이메일 정규식 체크
function email_check(email) {

	let reg = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;

	return reg.test(email);

}

// 연락처 변경 체크
function phoneCheckReset() {
	phoneCheck = false; // 연락처 체크 여부 미완료
	$("#phoneDiv").css('opacity', '0'); // 체크버튼 숨김
	isConfirm(); // 회원수정 버튼 활성화/비활성화
}

// 연락처 중복 체크
function checkPhone() {
	const joinPhone = document.getElementById('inputPhone1').value + '-' + 
	document.getElementById('inputPhone2').value + '-' + document.getElementById('inputPhone3').value; // 연락처
	
	if (joinPhone.length < 12) { // 번호가 '-' 포함 12자리 미만인 경우
		alert('휴대폰 번호를 확인해주세요');
	} else { // 번호가 정상적으로 입력된 경우
		$.ajax({ // 번호 체크 ajax
			url: "/member/checkPhone",
			type: "POST",
			data: {phone : joinPhone},
			success: function(data) { // data = 인증 코드 번호
				if (data == 'fail') { // 연락처가 중복인 경우
					alert("연락처 중복입니다.. 휴대폰 번호를 다시 확인해주세요");
				} else { // 없는 연락처로 등록한 경우
					alert('문자가 전송되었습니다');
					$("#checkCodeModal").modal('show'); // 모달 창 띄움
					modalType = 'phone'; // 이메일 모달
					checkCode = data; // 인증코드 값을 저장
				}
			},
		})
	}
}

// 인증 코드 확인
function fnCheckCode() {
	const checkInputCode = document.getElementById('checkCode'); // 인증 코드 입력 값
	
	if (checkCode == checkInputCode.value) { // 인증 코드 값이 같을 경우
		alert('인증되었습니다');
		$("#checkCodeModal").modal('hide'); // 모달 창 숨김
		
		if (modalType == 'email') { // 이메일 인증인 경우
			$("#emailDiv").css('opacity', '100'); // 체크표시 설정
			emailCheck = true; // 이메일 체크 여부 완료
		} else if (modalType == 'phone') { // 연락처 인증인 경우
			$("#phoneDiv").css('opacity', '100'); // 체크표시 설정
			phoneCheck = true; // 연락처 체크 여부 완료
		}
		
		checkInputCode.value = ''; // 인증값 리셋
		isConfirm(); // 회원수정 버튼 활성화/비활성화
	} else { // 인증코드 값이 다른 경우
		alert('코드가 일치하지 않습니다.. 확인해주세요');
	}
}

// 회원가입 버튼 활성화/비활성화
function isConfirm() {
	if (emailCheck && phoneCheck) { // 비밀번호, 이메일, 연락처가 체크 된 경우
		editTarget.disabled = false; // 등록버튼 활성화
	} else { // 체크 안된 경우
		editTarget.disabled = true; // 등록버튼 비활성화
	}
}

// 회원정보수정 ajax
function editMember() {
	$.ajax({
		url: "/member/edit",
		type: "POST",
		data: new FormData(document.querySelector('#editForm')),
		processData: false,
		contentType: false,
		success: function() {
			alert('회원정보 수정이 완료되었습니다');
			location.href = '/main/main';
		},
		error: function() {
			alert('회원정보 수정이 실패하였습니다.. 다시 확인해주세요');
		}
	})
	
	return false;
}
