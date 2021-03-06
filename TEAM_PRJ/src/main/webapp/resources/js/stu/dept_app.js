//단대 변경 시 ajax
function collChangeAjax() {
	var collNo = document.getElementById('coll').value;

	$.ajax({
		url: '/admin/collChangeAjax', 
		type: 'get',
		data: { 'collNo': collNo }, 
		success: function(result) {
			document.getElementById('dept').innerHTML = '';

			var str = '<option value="">학과</option>';
			for (var i = 0; i < result.length; i++) {
				str += '<option value="' + result[i].deptNo + '">' + result[i].deptName + '</option>';
			}

			document.getElementById('dept').innerHTML = str;
		},
		error: function(request, error) {
			alert('실패');
			alert('code:' + request.status + '\n' + 'message:' + request.responseText + '\n' + 'error:' + error);
		}
	});
}

function dateChange(){
	var applyDate = new Date(document.getElementById('applyDate').value);
	var nowDate = new Date();
	
	if(applyDate < nowDate){
		alert('날짜를 확인하세요')
		document.getElementById('applyDate').value = null;
	}
}

//신청버튼 클릭 시
function apply(){
	var applyType = document.getElementById('applyType').value;
	var stuNo = document.getElementById('stuNo').value;
	var deptNo = document.getElementById('dept').value;
	var listLength = document.getElementById('listLength').value;
	//신청내용이 없을 시
	if(applyType == ''){
		alert('신청유형을 확인하세요');
	}
	else{
		//신청학과가 없을 시
		if(deptNo == ''){
			alert('학과를 선택하세요');
		}
		else {
			//현재과에 지원하는 지를 검사하기 위해 학생정보 불러오기
			$.ajax({
				url: '/stu/stuDetailAjax', 
				type: 'post',
				data: {'stuNo': stuNo}, 
				success: function(student) {
					if (confirm(applyType + '신청하시겠습니까?')) {
						//현재 학과로 신청했을 시
						if(student.deptNo != deptNo){
							if (student.doubleNo != deptNo) {
								$.ajax({
									url: '/stu/deptAppAjax',
									type: 'post',
									data: {
										'applyType': applyType,
										'stuNo': stuNo,
										'applyDept': deptNo
									},
									success: function(result) {
										var str = '';
										for (var i = 0; i < result.length; i++) {

											str += '<tr align="center">';
											str += '<td>' + (result.length - i) + '</td>';
											str += '<td>' + result[i].semesterVO.year + '</td>';
											str += '<td>' + result[i].semesterVO.semester + '</td>';
											str += '<td>' + result[i].applyType + '</td>';
											str += '<td>' + result[i].applyCollName + ' ' + result[i].applyDeptName + '</td>';
											str += '<td>' + result[i].applyDate + '</td>';
											//기존학과처리일이 null일 시
											if (!result[i].oriDeptProcessDate) {
												str += '<td>' + result[i].oriDeptProcessStatus + '</td>';
											}
											else {
												str += '<td>' + result[i].oriDeptProcessDate + ' ' + result[i].oriDeptProcessStatus + '</td>';
											}
											//신청학과처리일이 null일 시
											if (!result[i].appDeptProcessDate) {
												str += '<td>' + result[i].appDeptProcessStatus + '</td>';
											}
											else {
												str += '<td>' + result[i].appDeptProcessDate + ' ' + result[i].appDeptProcessStatus + '</td>';
											}
											//기존학과, 신청학과의 처리상태가 하나라도 미승인일 시 취소가능
											if (result[i].oriDeptProcessStatus == '미승인' || result[i].appDeptProcessStatus == '미승인') {
												str += '<td>';
												str += '<b>승인대기</b>';
												str += '</td>';
												str += '<td>';
												str += '<input type="button" onclick="deleteDeptAppAjax(\'' + result[i].deptAppNo + '\', \'' + result[i].stuNo + '\');" value="취소" class="btn btn-secondary btn-sm">';
												str += '</td>';
											}
											else {
												str += '<td><b>승인완료</b></td>';
												str += '<td>';
												str += '<button type="button" class="btn btn-secondary btn-sm" disabled>불가</button>';
												str += '</td>';
												str += '</tr>';
											}
										}
										//신청 전 목록의 길이와 신청 후 목록의 길이가 같을 시(컨트롤러에서 insert안함)
										if (result.length == listLength) {
											//기신청학과에 다시 신청한 경우
											var sameDeptRequest = false;
											for (var i = 0; i < result.length; i++) {
												if (result[i].applyDept == deptNo) {
													sameDeptRequest = true;
												}
											}
											if (sameDeptRequest) {
												alert('동일한 학과에 중복신청이 불가합니다.')
											}
											else {
												alert(applyType + '신청이 이미 존재합니다');
											}
										}
										else {
											alert(applyType + '신청이 완료되었습니다');
										}
										document.getElementById('listTbody').innerHTML = str;
										document.getElementById('listLength').value = result.length;
									},
									error: function() {
										alert('실패');
									}
								});
							}
							else{
								alert('현재 복수전공 학과로는 신청이 불가합니다.');
							}
						}
						else {
							alert('현재 학과로는 신청이 불가합니다');
						}
					}
				},
				error: function() {
					alert('실패');
				}
			});
		}
	}
}

function deleteDeptAppAjax(deptAppNo, stuNo){
	if (confirm('신청을 취소하시겠습니까?')) {
		$.ajax({
			url: '/stu/deleteDeptAppAjax',
			type: 'post',
			data: {'deptAppNo': deptAppNo,
					'stuNo': stuNo
					}, 
			success: function(result) {
				var str = '';

				if (result[0] == null) {
					str += '<tr>';
					str += '<td colspan="10" align="center">전과 및 복수전공 신청 내역이 존재하지 않습니다.</td>';
					str += '</tr>';
				}
				else {
					for (var i = 0; i < result.length; i++) {
												
						str += '<tr align="center">';
						str += '<td>' + (result.length - i) + '</td>';
						str += '<td>' + result[i].semesterVO.year + '</td>';
						str += '<td>' + result[i].semesterVO.semester + '</td>';
						str += '<td>' + result[i].applyType + '</td>';
						str += '<td>' + result[i].applyCollName + ' ' + result[i].applyDeptName + '</td>';
						str += '<td>' + result[i].applyDate + '</td>';
						if(!result[i].oriDeptProcessDate){
							str += '<td>' + result[i].oriDeptProcessStatus + '</td>';
						}
						else{
							str += '<td>' + result[i].oriDeptProcessDate + ' ' + result[i].oriDeptProcessStatus + '</td>';
						}
						if(!result[i].appDeptProcessDate){
							str += '<td>' + result[i].appDeptProcessStatus + '</td>';
						}
						else{
							str += '<td>' + result[i].appDeptProcessDate + ' ' + result[i].appDeptProcessStatus + '</td>';
						}
						
						if(result[i].oriDeptProcessStatus == '미승인' || result[i].appDeptProcessStatus == '미승인'){
							str += '<td>';
							str += '<b>승인대기</b>';
							str += '</td>';
							str += '<td>';
							str += '<input type="button" onclick="deleteDeptAppAjax(\'' + result.deptAppNo + '\', \'' + result.stuNo + '\');" value="취소" class="btn btn-secondary btn-sm">';
							str += '</td>';
						}
						else{
							str += '<td><b>승인완료</b></td>';
							str += '<td>';
							str += '<button type="button" class="btn btn-secondary btn-sm" disabled>불가</button>';
							str += '</td>';
							str += '</tr>';
						}
					}
				}
				document.getElementById('listLength').value = result.length;
				document.getElementById('listTbody').innerHTML = str;
				alert('신청이 취소되었습니다.');
			},
			error: function() {
				alert('실패');
			}
		});
	}
}