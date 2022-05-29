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

function checkUtil(){
	var isChecked = document.getElementById('totalChk').checked;
	var totalChk = document.getElementById('totalChk');
	var checkboxes = document.getElementsByClassName('chk');

	//체크된박스배열
	var checkedboxes = [];
	for(var i = 0; i < checkboxes.length; i++){
		if(checkboxes[i].checked){
			checkedboxes.push(checkboxes[i]);
		}
	}
	var abledBox = []; 
	//disabled가 아닌 박스들을 모두 배열에 추가
	for(var i = 0; i < checkboxes.length; i++){
		if(!checkboxes[i].disabled){
			abledBox.push(checkboxes[i]);
		}
	}
	
	if(abledBox.length == checkedboxes.length){
		totalChk.checked = true;
	}
	else{
		totalChk.checked = false;
	}
	
	
}

function approve(appNo, applyType, stuNo, index, adminProcessStatus, profProcessStatus){
	if(profProcessStatus != '미승인'){
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
	//선택된 체크박스
	var chkboxes = document.querySelectorAll('.chk:checked');
	
	if(chkboxes.length == 0){
		alert('승인할 신청을 선택하세요.');
		return;
	}
	
	//선택한 신청의 신청번호를 저장할 배열
	var appNoArr = [];
	
	for(var i = 0; i < chkboxes.length; i++){
		appNoArr[i] = chkboxes[i].value;
	}
	
	$.ajax({
		url: '/admin/multiApprove',
		type: 'post',
		data: {'appNoArr': appNoArr},
		success: function(result) {
			alert('일괄승인되었습니다.');
			var str = '';
			for(var i = 0; i < result.length; i++){
				str += '<tr>';
				str += '<td><input type="checkbox" class="form-check-input chk" id="chk' + (result.length - i) + '" value="' + result[i].appNo + '"';
				if(result[i].adminProcessStatus == '승인완료' || result[i].profProcessStatus == '미승인'){
					str += 'disabled="disabled"';
				}
				str += '></td>';
				str += '<td id="indexTd">' + (result.length - i) + '</td>';
				str += '<td id=appNoTd"' + (result.length - (i + 1)) + '">' + result[i].appNo + '</td>';
				str += '<td id="stuNoTd' + (result.length - (i + 1)) + '">' + result[i].stuNo + '</td>';
				str += '<td>' + result[i].memberVO.memName + '</td>';
				str += '<td id="applyTypeTd' + (result.length - (i + 1)) + '">' + result[i].applyType + '</td>';
				str += '<td>' + result[i].applyDate + '</td>';
				if(result[i].profProcessDate != null){
					str += '<td>' + result[i].profProcessDate + '</td>';
				}
				else{
					str += '<td>-</td>';
				}
				if(result[i].adminProcessDate != null){
					str += '<td id="adminProcessDateTd">' + result[i].adminProcessDate + '</td>';
				}
				else{
					str += '<td id="adminProcessDateTd">-</td>';
				}
				str += '<td id="radioTd' + i + '">';
				str += '<input type="radio" class="form-check-input"';
				if(result[i].adminProcessStatus == '미승인'){
					str += 'checked';
				}
				else if(result[i].adminProcessStatus == '승인완료'){
					str += 'disabled';
				}
				str += '> 승인대기';
				str += '<input type="radio" class="form-check-input" onclick="approve(\'' + result[i].appNo + '\', \'' + result[i].applyType + '\', \'' + result[i].stuNo + '\', \'' + i + '\', \'' + result[i].adminProcessStatus + '\', \'' + result[i].profProcessStatus + '\');"';
				if(result[i].adminProcessStatus == '승인완료'){
					str += 'checked disabled';
				}
				str += '> 승인완료';
				str += '</td>';
				str += '</tr>';
			}
			
			document.getElementById('tbody').innerHTML = str;
			
			//상단 체크박스 체크 해제
			document.getElementById('totalChk').checked = false;
		},
		error: function() {
			alert('실패');
		}
	});
}



/////////////////////////////////////////////////////////////////////////////////////////////////
function test(){
	//선택된 체크박스
	var chkboxes = document.querySelectorAll('.chk:checked');

	if(chkboxes.length == 0){
		alert('승인할 신청을 선택하세요.');
		return;
	}
	
	//선택한 신청의 신청번호를 저장할 배열
	var appNoArr = [];
	for(var i = 0; i < chkboxes.length; i++){
		var obj = new Object();
		
		obj.appNo = chkboxes[i].value;
		obj.stuNo = chkboxes[i].nextElementSibling.nextElementSibling.nextElementSibling.innerHTML;
		obj.stuNo = chkboxes[i].nextElementSibling.nextElementSibling.nextElementSibling.nextElementSibling.innerHTML;
	
		objArr[i] = obj;
	}
	
	$.ajax({
		url: '/admin/multiApprove',
		type: 'post',
		data: {'appNoArr': appNoArr},
		success: function(result) {
			alert('일괄승인되었습니다.');
			var str = '';
			for(var i = 0; i < result.length; i++){
				str += '<tr>';
				str += '<td><input type="checkbox" class="form-check-input chk" id="chk' + (result.length - i) + '" value="' + result[i].appNo + '"';
				if(result[i].adminProcessStatus == '승인완료' || result[i].profProcessStatus == '미승인'){
					str += 'disabled="disabled"';
				}
				str += '></td>';
				str += '<td id="indexTd">' + (result.length - i) + '</td>';
				str += '<td id=appNoTd"' + (result.length - (i + 1)) + '">' + result[i].appNo + '</td>';
				str += '<td id="stuNoTd' + (result.length - (i + 1)) + '">' + result[i].stuNo + '</td>';
				str += '<td>' + result[i].memberVO.memName + '</td>';
				str += '<td id="applyTypeTd' + (result.length - (i + 1)) + '">' + result[i].applyType + '</td>';
				str += '<td>' + result[i].applyDate + '</td>';
				if(result[i].profProcessDate != null){
					str += '<td>' + result[i].profProcessDate + '</td>';
				}
				else{
					str += '<td>-</td>';
				}
				if(result[i].adminProcessDate != null){
					str += '<td id="adminProcessDateTd">' + result[i].adminProcessDate + '</td>';
				}
				else{
					str += '<td id="adminProcessDateTd">-</td>';
				}
				str += '<td id="radioTd' + i + '">';
				str += '<input type="radio" class="form-check-input"';
				if(result[i].adminProcessStatus == '미승인'){
					str += 'checked';
				}
				else if(result[i].adminProcessStatus == '승인완료'){
					str += 'disabled';
				}
				str += '> 승인대기';
				str += '<input type="radio" class="form-check-input" onclick="approve(\'' + result[i].appNo + '\', \'' + result[i].applyType + '\', \'' + result[i].stuNo + '\', \'' + i + '\', \'' + result[i].adminProcessStatus + '\', \'' + result[i].profProcessStatus + '\');"';
				if(result[i].adminProcessStatus == '승인완료'){
					str += 'checked disabled';
				}
				str += '> 승인완료';
				str += '</td>';
				str += '</tr>';
			}
			
			document.getElementById('tbody').innerHTML = str;
		},
		error: function() {
			alert('실패');
		}
	});
}




