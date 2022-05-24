function enterkey(){
	//엔터키를 눌렀을 때
	if (window.event.keyCode == 13) {
		searchStudentAjax();
	}
}

function collChangeAjax() {
	var collNo = document.getElementById('coll').value;

	$.ajax({
		url: '/admin/collChangeAjax', //요청경로
		type: 'get',
		data: { 'collNo': collNo }, //필요한 데이터 '데이터이름':값
		success: function(result) {
			//조회된 데이터를 화면을 뿌려준다.
			//테이블의 내용 삭제
			document.getElementById('dept').innerHTML = '';

			//태그에 다시 추가할 태그 생성
			var str = '<option value="">전체</option>';
			for (var i = 0; i < result.length; i++) {
				str += '<option value="' + result[i].deptNo + '">' + result[i].deptName + '</option>';
			}

			document.getElementById('dept').innerHTML = str;
		},
		error: function(request, error) {
			//ajax 실행 실패 시 실행되는 구간
			alert('실패');
			//error 발생 이유
			alert('code:' + request.status + '\n' + 'message:' + request.responseText + '\n' + 'error:' + error);
		}
	});
}

function searchStudentAjax(){
	var collNo = document.getElementById('coll').value;
	var deptNo = document.getElementById('dept').value;
	var stuStatus = document.getElementById('stuStatus').value;
	var stuYear = document.getElementById('stuYear').value;
	var memName = document.getElementById('memName').value;
	
	$.ajax({
		url: '/admin/searchStudentAjax', //요청경로
		type: 'get',
		data: { 'collNo': collNo,
				'deptNo': deptNo, 
				'stuStatus': stuStatus, 
				'stuYear': stuYear, 
				'memberVO.memName': memName }, //필요한 데이터 '데이터이름':값
				
		success: function(result) {
			//조회된 데이터를 화면을 뿌려준다.
			//테이블의 내용 삭제
			document.getElementById('listDiv').innerHTML = '';

			//태그에 다시 추가할 태그 생성
			var str = '';
			str += '<div class="subtitleDiv">학생 목록</div>';
			str += '<table class="table" style="text-align: center;">';
			str += '<thead>';
			str += '<tr>';
			str += '<th>학번</th>';
			str += '<th>학년</th>';
			str += '<th>이름</th>';
			str += '<th>소속 대학</th>';
			str += '<th>전공</th>';
			str += '<th>학적 상태</th>';
			str += '<th>경고 횟수</th>';
			str += '<th>제적</th>';
			str += '</tr>';
			str += '</thead>';
			str += '<tbody>';
			
			for (var i = 0; i < result.length; i++) {
				str += '<tr>';
				str += '<td style="cursor:pointer;"data-bs-toggle="modal" data-bs-target="#staticBackdrop" onclick="stuDetail(\'' + result[i].stuNo + '\');">' + result[i].stuNo + '</td>';
				str += '<td style="cursor:pointer;"data-bs-toggle="modal" data-bs-target="#staticBackdrop" onclick="stuDetail(\'' + result[i].stuNo + '\');">' + result[i].stuYear + '</td>';
				str += '<td style="cursor:pointer;"data-bs-toggle="modal" data-bs-target="#staticBackdrop" onclick="stuDetail(\'' + result[i].stuNo + '\');">' + result[i].memberVO.memName + '</td>';
				str += '<td style="cursor:pointer;"data-bs-toggle="modal" data-bs-target="#staticBackdrop" onclick="stuDetail(\'' + result[i].stuNo + '\');">' + result[i].deptVO.collVO.collName + '</td>';
				str += '<td style="cursor:pointer;"data-bs-toggle="modal" data-bs-target="#staticBackdrop" onclick="stuDetail(\'' + result[i].stuNo + '\');">' + result[i].deptVO.deptName + '</td>';
				if(result[i].stuStatus == '제적'){
					str += '<td style="cursor:pointer;"data-bs-toggle="modal" data-bs-target="#staticBackdrop" onclick="stuDetail(\'' + result[i].stuNo + '\');"><b><i>' + result[i].stuStatus + '<i><b></td>';
				}
				else{
					str += '<td style="cursor:pointer;"data-bs-toggle="modal" data-bs-target="#staticBackdrop" onclick="stuDetail(\'' + result[i].stuNo + '\');">' + result[i].stuStatus + '</td>';
				}
				str += '<td style="cursor:pointer;"data-bs-toggle="modal" data-bs-target="#staticBackdrop" onclick="stuDetail(\'' + result[i].stuNo + '\');">' + result[i].probCnt + '</td>';
				//학사경고 횟수가 3회 이상일 때 제적처리 가능
				if(result[i].probCnt >= 3 && result[i].stuStatus != '제적'){
					str += '<td><input type="button" value="제적가능" class="btn btn-secondary" onclick="expel(\'' + result[i].stuNo + '\');"></td>';
				}
				else{
					str += '<td><input type="button" value="제적불가" class="btn btn-secondary" disabled="disabled"></td>'
				}
				str += '</tr>';
			}
			
			str += '</tbody>';
			str += '</table>';

			document.getElementById('listDiv').innerHTML = str;
		},
		error: function(request, error) {
			//ajax 실행 실패 시 실행되는 구간
			//error 발생 이유
			alert('code:' + request.status + '\n' + 'message:' + request.responseText + '\n' + 'error:' + error);
		}
	});
}

function stuDetail(stuNo){
	//학사경고리스트를 가져오는 ajax
	$.ajax({
		url: '/admin/probationList', //요청경로
		type: 'get',
		data: {'stuNo':stuNo}, //필요한 데이터 '데이터이름':값
		success: function(probationList) {
			
			//상세정보 화면 ajax
			$.ajax({
				url: '/admin/selectStudentDetailAjax', //요청경로
				type: 'get',
				data: {'stuNo':stuNo}, //필요한 데이터 '데이터이름':값
				success: function(result) {
					var str = '';
					
					str += '<div class="modal-content">';
					str += '<div class="modal-header">';
					str += '<h5 class="modal-title" id="staticBackdropLabel">학생 상세 정보</h5>';
					str += '<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>';
					str += '</div>';
					str += '<div class="modal-body">';
					str += '<table class="table modalTable">';
					str += '<colgroup>';
					str += '<col width="25%">';
					str += '<col width="75%">';
					str += '</colgroup>';
					str += '<tr>';
					str += '<td rowspan="2" style="font-weight:normal;"><img width="100%" alt="이미지없음" src="/resources/images/'+ result.memberVO.memImage +'"></td>';
					str += '<td>' + result.memberVO.memName + ' [' + result.stuNo + '] '
					
					if(result.memberVO.memGender == 'male'){
						str += '남성';
					}
					else if (result.memberVO.memGender == 'female'){
						str += '여성';
					}	
					
					str += '</td>';
					str += '</tr>';
					str += '<tr>';
					str += '<td style="font-weight:normal;">' + result.stuYear + '학년 ' + result.stuStatus + '</td>';
					str += '</tr>';
					str += '<tr>';
					str += '<td>소속</td>';
					str += '<td>' + result.deptVO.collVO.collName + ' ' + result.deptVO.deptName + '</td>';
					str += '</tr>';
					str += '<tr>';
					str += '<td>생년월일</td>';
					str += '<td>' + result.memberVO.memBirth + '</td>';
					str += '</tr>';
					str += '<tr>';
					str += '<td>연락처</td>';
					str += '<td>' + result.memberVO.memPhone + '</td>';
					str += '</tr>';
					str += '<tr>';
					str += '<td>주소</td>';
					str += '<td>' + result.memberVO.memAddr + '</td>';
					str += '</tr>';
					str += '<tr>';
					str += '<tr>';
					str += '<td colspan="2">';
					str += '</td>';
					str += '</tr>';
					str += '<tr>';
					str += '<td>경고학기</td>';
					str += '<td><div class="row">'
					str += '<div class="col-4"><input type="number" class="form-control" id="year" name="year" value="2022"></div><div class="col-2">년도</div>'
					str += '<div class="col-4"><select class="form-select" id="semester" name="semester">'
					str += '<option value="1">1</option>'
					str += '<option value="2">2</option>'
					str += '</select>';
					str += '</div><div class="col-2">학기</div></td>'
					str += '</tr>';
					str += '<tr>';
					str += '<td>경고사유</td>';
					str += '<td><select class="form-select" name="probReason" id="probReason">';
					str += '<option value="이수학점 미달">이수학점 미달</option>';
					str += '<option value="평균학점 미달">평균학점 미달</option>';
					str += '<option value="학칙 위반">학칙 위반</option>';
					str += '<option value="부정행위">부정행위</option>';
					str += '<option value="수강신청 미시행">수강신청 미시행</option>';
					str += '<option value="등록금 미납">등록금 미납</option>';
					str += '</select></td>';
					str += '</tr>';
					str += '</table>';
					str += '<div id="probationList">';
					str += '<div style="border-bottom: 1px solid #DEE2E6; font-weight:bold; padding-left: 6px; padding-bottom: 12px;">누적 경고 내역</div>';
					str += '<div> </div>';
		
					for(var i = 0; i < probationList.length; i++){
						str += '<div class="row">';
						str += '<div class="col-4">' + probationList[i].probDate + '</div>';
						str += '<div class="col-8">' + probationList[i].probReason + '</div>';
						str += '</div>';
					};
					if(probationList[0] == null){
						str += '<div style="text-align:center;">학사경고 내역 없음</div>';
					}
					
					str += '</div>';
					str += '<div class="modal-footer">';
					str += '<button type="button" class="btn btn-secondary" data-bs-dismiss="modal" onclick="searchStudentAjax();">닫기</button>';
					str += '<button type="button" class="btn btn-primary" onclick="probate();">입력</button>';
					str += '</div>';
					str += '</div>';
					str += '</div>';
					
					str += '<input type="hidden" value="' + result.stuNo + '" id="stuNo">';
					
					document.getElementById('modalDialog').innerHTML = str;			
				},
				error: function() {
					//ajax 실행 실패 시 실행되는 구간
					alert('실패');
				}
			});
		},
		error: function() {
			alert('학사경고목록을 불러오지 못했습니다.');
		}
	});
	
	
}

function probate(){
	var stuNo = document.getElementById('stuNo').value;
	var probReason = document.getElementById('probReason').value;
	var year = document.getElementById('year').value;
	var semester = document.getElementById('semester').value;

	$.ajax({
		url: '/admin/insertProbation',
		type: 'get',
		data: {'stuNo':stuNo,
				'probReason':probReason,
				'year':year,
				'semester':semester},
		success: function(result) {
			alert('학사경고가 입력되었습니다.');
			//학생상세정보를 다시 불러와서 새로 입력된 학사경고내용을 확인
			stuDetail(stuNo);
		},
		error: function() {
			alert('학사경고 입력에 실패했습니다.');
		}
	});
}

function expel(stuNo){
	if(confirm('제적처리하시겠습니까?')){
		$.ajax({
			url: '/admin/expel', 
			type: 'post',
			data: {'stuNo': stuNo},
			success: function(result) {
				alert('성공');
				searchStudentAjax();
			},
			error: function() {
				alert('실패');
			}
		});
	}
}