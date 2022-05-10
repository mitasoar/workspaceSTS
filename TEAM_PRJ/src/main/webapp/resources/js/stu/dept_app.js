//신청내용 변경 시
function typeChange(){
	var applyType = document.getElementById('category').value;
	var stuStatus = document.getElementById('stuStatusHidden').value;
	
	var str = '';
	//신청유형(빈값) 선택 시
	if(applyType == '신청유형'){
		str = '<option value="신청유형을 선택하세요">신청유형을 선택하세요</option>';
	}
	//휴학 선택 시
	if(applyType == '휴학'){
		if(stuStatus == '재학'){
			//신청타입 옵션 변경
			str = '<option value="일반휴학">일반휴학</option>';
			str += '<option value="군휴학">군휴학</option>';
			str += '<option value="가사휴학">가사휴학</option>';
		}
		else if(stuStatus == '휴학'){
			alert('휴학중에는 휴학신청이 불가합니다.');
			
			str = '<select class="form-select" onchange="typeChange();" id="category">';
			str += '<option value="신청유형">신청유형</option>';
			str += '<option value="휴학">휴학</option>';
			str += '<option value="복학">복학</option>';
			str += '</select>';
			
			document.getElementById('categoryDiv').innerHTML = str;
			
			var str = '<select class="form-select" name="applyType" id="applyType">';
			str += '<option value="">신청유형을 선택하세요</option>';
			str += '</select>';
			
			document.getElementById('subCategoryDiv').innerHTML = str;
		}
		else{
			alert('현재 제적상태입니다.');
	/*
			str = '<select class="form-select" onchange="typeChange();" id="category">';
			str += '<option value="신청유형">신청유형</option>';
			str += '<option value="휴학">휴학</option>';
			str += '<option value="복학">복학</option>';
			str += '</select>';
			
			document.getElementById('categoryDiv').innerHTML = str;
			
			var str = '<select class="form-select" name="applyType" id="applyType">';
			str += '<option value="">신청유형을 선택하세요</option>';
			str += '</select>';
			
			document.getElementById('subCategoryDiv').innerHTML = str;*/
		}
	}
	//복학 선택 시
	if(applyType == '복학'){
		if(stuStatus == '휴학'){
			str = '<option value="복학">복학</option>';
		}
		else if(stuStatus == '재학'){
			alert('재학중에는 복학신청이 불가합니다.');
			
			str = '<select class="form-select" onchange="typeChange();" id="category">';
			str += '<option value="신청유형">신청유형</option>';
			str += '<option value="휴학">휴학</option>';
			str += '<option value="복학">복학</option>';
			str += '</select>';
			
			document.getElementById('categoryDiv').innerHTML = str;
			
			var str = '<select class="form-select" name="applyType" id="applyType">';
			str += '<option value="">신청유형을 선택하세요</option>';
			str += '</select>';
			
			document.getElementById('subCategoryDiv').innerHTML = str;
		}
		else{
			alert('현재 제적상태입니다.');
			/*
			str = '<select class="form-select" onchange="typeChange();" id="category">';
			str += '<option value="신청유형">신청유형</option>';
			str += '<option value="휴학">휴학</option>';
			str += '<option value="복학">복학</option>';
			str += '</select>';
			
			document.getElementById('categoryDiv').innerHTML = str;
			
			var str = '<select class="form-select" name="applyType" id="applyType">';
			str += '<option value="">신청유형을 선택하세요</option>';
			str += '</select>';
			
			document.getElementById('subCategoryDiv').innerHTML = str;*/
		}
	}
/*	else{
		alert('현재 제적상태입니다.');
	}*/
	
	document.getElementById('applyType').innerHTML = str;
}

function dateChange(){
	var applyDate = new Date(document.getElementById('applyDate').value);
	var nowDate = new Date();
	
	if(applyDate < nowDate){
		alert('날짜를 확인하세요')
		document.getElementById('applyDate').value = null;
	}
}

function apply(){
	var applyType = document.getElementById('applyType').value;
	var stuNo = document.getElementById('stuNo').value;
	var lastAppNo = document.getElementById('lastAppNo').value;
	
	if(applyType == ''){
		alert('신청유형을 확인하세요');
	}
	else{
		if(confirm(applyType + '신청하시겠습니까?')){
			$.ajax({
				url: '/stu/academicAppAjax',
				type: 'post',
				data: {'applyType': applyType,
					   'stuNo': stuNo}, 
				success: function(result) {
					if(result[0].appNo == lastAppNo){
						alert('이전의 신청이 승인대기 중입니다.');
					}
					else{
						var str = '';				
						for (var i = 0; i < result.length; i++) {
							str += '<tr align="center">';
							str += '<td>' + (result.length - i) + '</td>';
							str += '<td>' + result[i].semesterVO.year + '</td>';
							str += '<td>' + result[i].semesterVO.semester + '</td>';
							str += '<td>' + result[i].applyType + '</td>';
							str += '<td>' + result[i].applyDate + '</td>';
							str += '<td>' + result[i].profProcessStatus + '</td>';
							//date값 null을 문자열 '-'로 변경 
							if(result[i].profProcessDate == null){
								result[i].profProcessDate = '-';
							}
							str += '<td>' + result[i].profProcessDate + '</td>';
							str += '<td><b>' + result[i].adminProcessStatus + '</b></td>';
							//date값 null을 문자열 '-'로 변경
							if(result[i].adminProcessDate == null){
								result[i].adminProcessDate = '-';
							}
							str += '<td>' + result[i].adminProcessDate + '</td>';
							
							str += '<td>';
							
							if (result[i].adminProcessStatus == '미승인') {
								str += '<input type="button" onclick="deleteAcademicAppAjax(\'' + result[i].appNo + '\', \'' + result[i].stuNo + '\');" value="취소" class="btn btn-secondary btn-sm">';
							}
							else {
								str += '<button type="button" class="btn btn-secondary btn-sm" disabled>불가</button>';
							}
							
							str += '</td>';
							str += '</tr>';
							
						}
						document.getElementById('listTbody').innerHTML = str;
						document.getElementById('lastAppNo').value = result[0].appNo;
						alert('신청이 완료되었습니다');
					}
				},
				error: function() {
					alert('실패');
				}
			});
		}
	}
}

function deleteAcademicAppAjax(appNo, stuNo){
	
	if (confirm('휴/복학 신청을 취소하시겠습니까?')) {
		$.ajax({
			url: '/stu/deleteAcademicAppAjax',
			type: 'post',
			data: {'appNo': appNo,
					'stuNo': stuNo
					}, 
			success: function(result) {
				var str = '';

				if (result[0] == null) {
					str += '<tr>';
					str += '<td colspan="10" align="center">휴학 및 복학신청 내역이 존재하지 않습니다.</td>';
					str += '</tr>';
				}
				else {
					for (var i = 0; i < result.length; i++) {
												
						str += '<tr align="center">';
						str += '<td>' + (result.length - i) + '</td>';
						str += '<td>' + result[i].semesterVO.year + '</td>';
						str += '<td>' + result[i].semesterVO.semester + '</td>';
						str += '<td>' + result[i].applyType + '</td>';
						str += '<td>' + result[i].applyDate + '</td>';
						str += '<td>' + result[i].profProcessStatus + '</td>';
						//date값 null을 문자열 '-'로 변경 
						if(result[i].profProcessDate == null){
							result[i].profProcessDate = '-';
						}
						str += '<td>' + result[i].profProcessDate + '</td>';
						str += '<td><b>' + result[i].adminProcessStatus + '</b></td>';
						//date값 null을 문자열 '-'로 변경
						if(result[i].adminProcessDate == null){
							result[i].adminProcessDate = '-';
						}
						str += '<td>' + result[i].adminProcessDate + '</td>';
						
						str += '<td>';
						
						if (result[i].adminProcessStatus == '미승인') {
							str += '<input type="button" onclick="deleteAcademicAppAjax(\'' + result[i].appNo + '\', \'' + result[i].stuNo + '\');" value="취소" class="btn btn-secondary btn-sm">';
						}
						else {
							str += '<button type="button" class="btn btn-secondary btn-sm" disabled>불가</button>';
						}
						
						str += '</td>';
						str += '</tr>';
						
					}
				}
				document.getElementById('listTbody').innerHTML = str;
				document.getElementById('lastAppNo').value = result[0].appNo;
				alert('신청이 취소되었습니다.');
			},
			error: function() {
				alert('실패');
			}
		});
	}
}