// 우편번호 검색 API
function execDaumPostcode() {
	new daum.Postcode({
		oncomplete: function(data) {
			// 우편번호와 주소 정보를 해당 필드에 넣는다.
			document.getElementById("addr").value = data.roadAddress;
		}
	}).open();
}

// 날짜 입력을 위한 달력 API
$('#datePicker').datepicker({
	format: 'yyyy-mm-dd', //데이터 포맷 형식(yyyy : 년 mm : 월 dd : 일 )
	autoclose: true, //사용자가 날짜를 클릭하면 자동 캘린더가 닫히는 옵션
	calendarWeeks: false, //캘린더 옆에 몇 주차인지 보여주는 옵션 기본값 false 보여주려면 true
	clearBtn: false, //날짜 선택한 값 초기화 해주는 버튼 보여주는 옵션 기본값 false 보여주려면 true
	datesDisabled: [], //선택 불가능한 일 설정 하는 배열 위에 있는 format 과 형식이 같아야함.
	daysOfWeekDisabled: [], //선택 불가능한 요일 설정 0 : 일요일 ~ 6 : 토요일
	daysOfWeekHighlighted: [], //강조 되어야 하는 요일 설정
	disableTouchKeyboard: false, //모바일에서 플러그인 작동 여부 기본값 false 가 작동 true가 작동 안함.
	immediateUpdates: false, //사용자가 보는 화면으로 바로바로 날짜를 변경할지 여부 기본값 :false
	multidate: false, //여러 날짜 선택할 수 있게 하는 옵션 기본값 :false
	multidateSeparator: ',', //여러 날짜를 선택했을 때 사이에 나타나는 글짜 2019-05-01, 2019-06-01
	templates: {
		leftArrow: '&laquo;',
		rightArrow: '&raquo;',
	}, //다음달 이전달로 넘어가는 화살표 모양 커스텀 마이징
	showWeekDays: true, // 위에 요일 보여주는 옵션 기본값 : true
	title: '', //캘린더 상단에 보여주는 타이틀
	todayHighlight: true, //오늘 날짜에 하이라이팅 기능 기본값 :false
	toggleActive: false, //이미 선택된 날짜 선택하면 기본값 : false인경우 그대로 유지 true인 경우 날짜 삭제
	weekStart: 0, //달력 시작 요일 선택하는 것 기본값은 0인 일요일
	language: 'kr', //달력의 언어 선택, 그에 맞는 js로 교체해줘야한다.
});

// 회원가입 버튼 비활성화
const joinTarget = document.querySelector('#joinForm button[type=submit]'); // 등록 버튼
joinTarget.disabled = true; // 등록 버튼 비활성화

let pwCheck = false; // 비밀번호 체크 여부
let emailCheck = false; // 이메일 체크 여부
let phoneCheck = false; // 연락처 체크 여부
let checkCode = ''; // 확인을 위한 임시 코드
let modalType = ''; // 모달창 구분을 위한 변수

// 비밀번호 체크
function checkPw() { 
	const joinPw = document.getElementById('inputPassword'); // 비밀번호
	const joinPwCheck = document.getElementById('inputPasswordCheck'); // 2차 비밀번호
	
	if (joinPw.value == joinPwCheck.value) { // 비밀번호와 2차 비밀번호가 같을 경우
		joinPwCheck.style.borderColor = '#ced4da'; // border 원색으로 변경
		pwCheck = true; // 비밀번호 체크 완료
	} else { // 비밀번호와 2차 비밀번호가 다른 경우
		joinPwCheck.style.borderColor = 'red'; // border 빨간색으로 변경
		pwCheck = false; // 비밀번호 체크 미완료
	}
	
	isConfirm(); // 회원가입 버튼 활성화/비활성화
}

// 이메일 변경 체크
function emailCheckReset() {
	emailCheck = false; // 이메일 체크 여부 미완료
	$("#emailDiv").css('opacity', '0'); // 체크버튼 숨김
	isConfirm(); // 회원가입 버튼 활성화/비활성화
}

// 이메일 중복 체크
function checkEmail() {
	const joinEmail = document.getElementById('inputEmail'); // 이메일
	
	if (joinEmail.value.length == 0) { // 이메일에 입력 값이 없을 경우
		alert('이메일 주소를 입력해주세요..');
	} else { // 있을 경우
		$.ajax({
			url: "/member/checkEmail",
			type: "POST",
			data: {email : joinEmail.value},
			success: function(data) { // data = 인증코드
				if (data == 'fail') { // 중복되는 이메일 주소인 경우
					alert("이메일 중복입니다.. 이메일 주소를 다시 확인해주세요.");
				} else { // 중복되지 않는 이메일 주소인 경우
					alert('메일이 전송되었습니다.');
					$("#checkCodeModal").modal('show'); // 모달 창 띄움
					modalType = 'email'; // 이메일 모달
					checkCode = data; // 인증코드 값을 저장
				}
			},
		})
	}
}

// 연락처 변경 체크
function phoneCheckReset() {
	phoneCheck = false; // 연락처 체크 여부 미완료
	$("#phoneDiv").css('opacity', '0'); // 체크버튼 숨김
	isConfirm(); // 회원가입 버튼 활성화/비활성화
}

// 연락처 중복 체크
function checkPhone() {
	const joinPhone = document.getElementById('inputPhone1').value + '-' + 
	document.getElementById('inputPhone2').value + '-' + document.getElementById('inputPhone3').value; // 연락처
	
	if (joinPhone.length < 12) { // 번호가 '-' 포함 12자리 미만인 경우
		alert('휴대폰 번호를 확인해주세요..');
	} else { // 번호가 정상적으로 입력된 경우
		$.ajax({ // 번호 체크 ajax
			url: "/member/checkPhone",
			type: "POST",
			data: {phone : joinPhone},
			success: function(data) { // data = 인증 코드 번호
				if (data == 'fail') { // 연락처가 중복인 경우
					alert("연락처 중복입니다.. 휴대폰 번호를 다시 확인해주세요.");
				} else { // 없는 연락처로 등록한 경우
					alert('문자가 전송되었습니다.');
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
	const checkInputCode = document.getElementById('checkCode'); // 이메일 인증 코드 입력 값
	
	if (checkCode == checkInputCode.value) { // 인증 코드 값이 같을 경우
		alert('인증되었습니다');
		$("#checkCodeModal").modal('hide'); // 모달 창 숨김
		
		if (modalType == 'email') { // 이메일 인증인 경우
			$("#emailDiv").css('opacity', '100'); // 체크표시 설정
			emailCheck = true; // 이메일 체크 여부 완료
		} else if (modalType == 'phone') { // 연락처 인증인 경우
			$("#phoneDiv").css('opacity', '100'); // 체크표시 설정
			phoneCheck = true; // 이메일 체크 여부 완료
		}
		
		checkInputCode.value = ''; // 인증값 리셋
		isConfirm(); // 회원가입 버튼 활성화/비활성화
	} else { // 인증코드 값이 다른 경우
		alert('코드가 일치하지 않습니다.. 확인해주세요');
	}
}

// 회원가입 버튼 활성화/비활성화
function isConfirm() {
	if (pwCheck && emailCheck && phoneCheck) { // 비밀번호, 이메일, 연락처가 체크 된 경우
		joinTarget.disabled = false; // 등록버튼 활성화
	} else { // 체크 안된 경우
		joinTarget.disabled = true; // 등록버튼 비활성화
	}
}

// 회원가입 ajax
function joinMember() {
	$.ajax({
		url: "/member/join",
		type: "POST",
		data: new FormData(document.querySelector('#joinForm')),
		processData: false,
		contentType: false,
		success: function() {
			alert('회원등록이 완료되었습니다.');
			location.href = '/member/home';
		},
		error: function() {
			alert('회원등록이 실패하였습니다.. 다시 확인해주세요.');
		}
	})
	
	return false;
}
	
// 페이지 로드 시 동작하는 함수
window.onload = function() {

	if (document.getElementById('nonType') != null) { // 회원 등록 시 지정된 경로로 진입하지 않은 경우
		alert('잘못된 접근입니다..'); // 경고 알림창
		location.href = '/sample/sample'; // 다시 메인화면으로 이동
	}

}