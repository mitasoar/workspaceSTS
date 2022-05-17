function stuInfoAjax(){
	
	var memImage = document.getElementById('memImage').value;
	var memName = document.getElementById('memName').value;
	var stuNo = document.getElementById('stuNo').value;
	var memGender = document.getElementById('memGender').value;
	var stuYear = document.getElementById('stuYear').value;
	var stuStatus = document.getElementById('stuStatus').value;
	var collName = document.getElementById('collName').value;
	var deptName = document.getElementById('deptName').value;
	var memBirth = document.getElementById('memBirth').value;
	var memAddr = document.getElementById('memAddr').value;
	var memPhone = document.getElementById('memPhone').value;
	
	$.ajax({
		url: '/stu/stuInfoAjax',
		type: 'get',
		data: {},
		success: function(result) {
			alert('학생정보를 변경합니다.');
			var str = '<table class="table">';
			str += '<colgroup>';
			str += '<col width="25%">';
			str += '<col width="75%">';
			str += '</colgroup>';
			str += '<tr>';
			str += '<td rowspan="2"><img width="30%" alt="이미지없음" src="/resources/images/' + memImage + '"></td>';
			str += '<td>' + memName + ' [' + stuNo + '] ' + memGender + '</td>';
			str += '</tr>';
			str += '<tr>';
			str += '<td>' + stuYear + '학년' + stuStatus + '</td>';
			str += '</tr>';
			str += '<tr>';
			str += '<td>소속</td>';
			str += '<td>' + collName + ' ' + deptName + '</td>';
			str += '</tr>';
			str += '<tr>';
			str += '<td>복수전공</td>';
			str += '<td>' + result.doubleNo + '</td>';
			str += '</tr>';
			str += '<tr>';
			str += '<td>생년월일</td>';
			str += '<td>' + memBirth + '</td>';
			str += '</tr>';
			str += '<tr>';
			str += '<td>연락처</td>';
			str += '<td><input type="text" id="memPhoneInput" value="' + memPhone + '"></td>';
			str += '</tr>';
			str += '<tr>';
			str += '<td>주소</td>';
			str += '<td><input type="text" id="memAddrInput" value="' + memAddr + '"></td>';
			str += '</tr>';
			str += '<tr>';
			str += '<td colspan="2"></td>';
			str += '</tr>';
			str += '</table>';
			str += '<input type="hidden" id="stuNoInput" value="' + stuNo + '">'
			
			document.getElementById('tableDiv').innerHTML = str;

			document.getElementById('btnDiv').innerHTML = '<input type="button" class="btn btn-primary" id="btn" value="저장" onclick="updateStuInfo();">';
			
					
		},
		error: function() {
			alert('실패');
		}
	});
}

function updateStuInfo() {
	var memPhone = document.getElementById('memPhoneInput').value;
	var memAddr = document.getElementById('memAddrInput').value;
	var stuNo = document.getElementById('stuNo').value;
	
	$.ajax({
		url: '/stu/updateStuInfo', 
		type: 'get',
		data: { 'stuNo': stuNo,
				'memberVO.memPhone': memPhone,
				'memberVO.memAddr': memAddr},
		success: function(result) {
			alert('정보가 변경되었습니다.');
			location.href="/stu/stuInfo"
		},
		error: function() {
			alert('정보변경에 실패하였습니다.');
		}
	});
}