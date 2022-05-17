/////////////////////////////신청목록 및 승인////////////////////////////
function checkAll(){
	var isChecked = document.getElementById('totalChk').checked;
	var checkboxes = document.getElementsByClassName('chk');
	
	//제목줄의 체크박스가 체크되었을 때
	for(var i = 0; i < checkboxes.length; i++){
		if(isChecked && !checkboxes[i].disabled){
			checkboxes[i].checked = true;
		}
		else{
			checkboxes[i].checked = false;
		}
	}
}

function approve(appNo, applyType, stuNo, index, adminProcessStatus, profProcessStatus){
	if(profProcessStatus == '승인'){
		if (applyType == '일반휴학' || applyType == '군휴학' || applyType == '가사휴학') {
			applyType = '휴학';
		}

		if (confirm(applyType + '신청을 승인하시겠습니까?')) {
			if (applyType == '복학') {
				applyType = '재학';
			}
			$.ajax({
				url: '/admin/approveApply',
				type: 'post',
				data: {'appNo': appNo,
					   'applyType': applyType,
					   'stuNo': stuNo},
				success: function(result) {
					alert('최종승인되었습니다.');
					var str = ' ';
					str += '<input type="radio" class="form-check-input" disabled> 승인대기';
					str += ' <input type="radio" class="form-check-input" checked disabled> 승인완료';

					document.getElementById('radioTd' + index).innerHTML = str;
					document.getElementById('adminProcessDateTd' + index).innerHTML = result.adminProcessDate;
					document.getElementById('chk' + index).disabled = true;
				},
				error: function() {
					alert('실패');
				}
			});
		} else {
			var str = ' ';
			str += '<input type="radio" class="form-check-input"';
			if (adminProcessStatus == '미승인') {
				str += 'checked';
			}
			str += '> 승인대기 ';

			str += '<input type="radio" class="form-check-input" onclick="approve(\'' + appNo + '\', \'' + applyType + '\', \'' + stuNo + '\', \'' + index + '\', \'' + adminProcessStatus + '\', \'' + profProcessStatus + '\');"';
			if (adminProcessStatus == '승인완료') {
				str += 'checked';
			}
			str += '> 승인완료';

			document.getElementById('radioTd' + index).innerHTML = str;
		}
	}
	else{
		alert('교수승인이 필요합니다.');
		document.getElementById('radioTd' + index).innerHTML = '';
		
		var str = ' ';
		str += '<input type="radio" class="form-check-input" checked> 승인대기';
		str += ' <input type="radio" class="form-check-input" onclick="approve(\'' + appNo + '\', \'' + applyType + '\', \'' + stuNo + '\', \'' + index + '\', \'' + adminProcessStatus + '\', \'' + profProcessStatus + '\');"> 승인완료';
			
		document.getElementById('radioTd' + index).innerHTML = str;
	}
}

function multiApprove(){
	var chkboxes = document.querySelectorAll('.chk:checked');
	var appNoArr = [];
	
	for(var i = 0; i < chkboxes.length; i++){
		appNoArr[i] = chkboxes[i].value;
	}
	
	$.ajax({
		url: '/admin/multiApprove',
		type: 'post',
		data: {'appNoArr': appNoArr},
		success: function(result) {
			alert('성공');
		},
		error: function() {
			alert('실패');
		}
	});
	
}




