function appr(tag, num){
	var result = confirm('승인 하시겠습니까?');
	if(result){
		tag.parentNode.submit();
	}
	else{
		var result = '';
		if(num == 'ori'){
			result += '<input type="hidden" value="${deptApp.originalDept }" name="originalDept" id="oriDept">';
			result += '<input type="radio" name="oriDeptProcessStatus" value="승인거절" onclick="reject(this, ' + num + ');"> 승인거절';
			result += '<input type="radio" name="oriDeptProcessStatus" value="승인완료" onclick="appr(this, ' + num +');"> 승인완료'
									
		}
		else{
			result += '<input type="hidden" value="${deptApp.applyDept }" name="applyDept" id="appDept">';
			result += '<input type="radio" name="appDeptProcessStatus" value="승인거절" onclick="reject(this, ' + num + ');"> 승인거절';
			result += '<input type="radio" name="appDeptProcessStatus" value="승인완료" onclick="appr(this, ' + num +');"> 승인완료 '
			//+ '\'' + lecNo +'\'' +
		}
		document.getElementById('appBtn').innerHTML = result;
		
									
									
	}
}
function reject(tag){
	var result = confirm('거절 하시겠습니까?');
	if(result){
		tag.parentNode.submit();
		
	}
}
//체크박스 전체선택, 전체해제
function checkAll(){
	var isChecked = document.getElementById('check').checked;
	var checkboxes = document.getElementsByClassName('chk');
	
	//제목줄의 체그박스가 체그 되었을떄...
	if(isChecked){
		
		for(var i = 0 ; i < checkboxes.length ; i++){
			checkboxes[i].checked = true;
		}
	}
	else{
		for(var i = 0 ; i < checkboxes.length ; i++){
			checkboxes[i].checked = false;
		}
	}
}



//일괄 승인
function apprs(app){
	//필요한 데이터를 가져온다(appNo)
	var checkboxes = document.querySelectorAll('.chk:checked');
	debugger;
	
	
	var objArr = [];
	var deptArr = [];
	for(var i = 0 ; i < checkboxes.length ; i++){
		objArr[i] = checkboxes[i].value;
		deptArr[i] = checkboxes[i].parentNode.childNodes[3].value;
	}
	
	$.ajax({
		url: '/pro/updateDeptApps', //요청경로
		type: 'post',
		data: {'objArr':objArr,'deptArr':deptArr, 'app':app}, //필요한 데이터 '데이터이름':값
		success: function() {
			alert('일괄 처리 되었습니다');
			
			location.href = '/pro/deptAppForm';
		},
		error: function() {
			alert('실패');
		}
	});
	
	
}