function enterkey(){
	//엔터키를 눌렀을 때
	if (window.event.keyCode == 13) {
		searchLecAjax();
	}
}

function collChangeAjax(){
	var collNo = document.getElementById('coll').value;
	
	$.ajax({
		url: '/admin/collChangeAjax', //요청경로
		type: 'get',
		data:{'collNo':collNo}, //필요한 데이터 '데이터이름':값
		success: function(result) {
		 	//조회된 데이터를 화면을 뿌려준다.
			//테이블의 내용 삭제
			document.getElementById('dept').innerHTML = '';
																				
			//태그에 다시 추가할 태그 생성
			var str = '<option value="">전체</option>';
			for(var i = 0; i < result.length; i++ ){
				str += '<option value="' + result[i].deptNo + '">' + result[i].deptName + '</option>';
			}
			
			document.getElementById('dept').innerHTML = str;
		},
		error: function(result) {
			//ajax 실행 실패 시 실행되는 구간
			alert('실패');
			//error 발생 이유
			alert('code:' + request.status + '\n' + 'message:' + request.responseText + '\n' + 'error:' + error);
		}
	});
}

function searchLecAjax(){

	var collNo = document.getElementById('coll').value;
	var deptNo = document.getElementById('dept').value;
	var lecName = document.getElementById('lecName').value;
	
	$.ajax({
		url: '/admin/searchLecAjax', //요청경로
		type: 'get',
		data:{'collNo':collNo,
			  'deptNo':deptNo,
			  'lecName':lecName}, //필요한 데이터 '데이터이름':값
		success: function(result) {
		 	//조회된 데이터를 화면을 뿌려준다.
			//테이블의 내용 삭제
			document.getElementById('listDiv').innerHTML = '';
			//태그에 다시 추가할 태그 생성
			var str = '<table class="table">';
			str += '<colgroup>';
			str += '<col>';
			str += '<col>';
			str += '<col>';
			str += '<col>';
			str += '<col>';
			str += '<col>';
			str += '</colgroup>';
			str += '<thead>';
			str += '<tr>';
			str += '<td>강의번호</td>';
			str += '<td>강의명</td>';
			str += '<td>담당교수</td>';
			str += '<td>대학</td>';
			str += '<td>전공</td>';
			str += '<td>학점</td>';
			str += '<td>최대인원</td>';
			str += '</tr>';
			str += '</thead>';
			str += '<tbody>';
			for(var i = 0; i < result.length; i++){
				str += '<tr>';
				str += '<td id="lecNoDataTd" + ' + i + '>' + result[i].lecNo + '</td>';
				//강의명 클릭 시 모달 실행
				str += '<td><span class="lecNameSpan" data-bs-toggle="modal" data-bs-target="#staticBackdrop" onclick="lecDetail(\'' + result[i].lecNo + '\');">' + result[i].lecName + '</span></td>';
				str += '<td>' + 'prof.' + '</td>';
				str += '<td>' + result[i].collNo + '</td>';
				str += '<td>' + result[i].deptNo + '</td>';
				str += '<td>' + result[i].lecScore + '</td>';
				str += '<td>' + result[i].maxNum + '</td>';
				str += '</tr>';
			}
			str += '</tbody>';
			str += '</table>';
			//강의명 클릭 시 실행되는 모달
			str += '<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">';
			str += '<div class="modal-dialog modal-lg">';
			str += '<div class="modal-content">';
			str += '<div class="modal-header">';
			str += '<h5 class="modal-title" id="staticBackdropLabel">강의명</h5>';
			str += '<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>';
			str += '</div>';
			str += '<div class="modal-body">';
			str += '<table class="table">';
			str += '<colgroup>';
			str += '<col>';
			str += '<col>';
			str += '<col>';
			str += '<col>';
			str += '<col>';
			str += '<col>';
			str += '</colgroup>';
			str += '<thead>';
			str += '<tr>';
			str += '<td>학번</td>';
			str += '<td>대학</td>';
			str += '<td>전공</td>';
			str += '<td>이름</td>';
			str += '<td>성적</td>';
			str += '<td></td>';
			str += '</tr>';
			str += '</thead>';
			str += '<tbody id="modalTbody">';
			
			
			str += '<tr>';
			str += '<td class="stuNoTd">stu1</td>';
			str += '<td class="collNameTd">자바대학</td>';
			str += '<td class="deptNameTd">자바학과</td>';
			str += '<td class="stuNameTd">김자반</td>';
			str += '<td>';
			str += '<select class="form-select">';
			str += '<option value="미입력">미입력</option>';
			str += '<option value="A">A</option>';
			str += '<option value="B">B</option>';
			str += '<option value="C">C</option>';
			str += '<option value="D">D</option>';
			str += '<option value="F">F</option>';
			str += '</select>';
			str += '</td>';
			str += '<td><input type="button" value="성적입력"></td>';
			str += '</tr>';
		
		
			str += '</tbody>';
			str += '</table>';
			str += '</div>';
			str += '</div>';
			str += '</div>';
			str += '</div>';
			
			document.getElementById('listDiv').innerHTML = str;
		},
		error: function(request, error) {
			//ajax 실행 실패 시 실행되는 구간
			alert('fail');
			//error 발생 이유
			alert('code:' + request.status + '\n' + 'message:' + request.responseText + '\n' + 'error:' + error);
		}
	});
}

function lecDetail(lecNo) {
	debugger;
	$.ajax({
		url: '/admin/lecDetailAjax', //요청경로
		type: 'get',
		data: {'lecNo': lecNo}, //필요한 데이터 '데이터이름':값
		success: function(result) {
			debugger;
			//ajax 실행 성공 후 실행할 코드 작성
			var str = '';
			
			for(var i = 0; i < result.length; i++){
				str += '<tr>';
				str += '<td class="stuNoTd">' + result[i].stuNo + '</td>';
				str += '<td class="collNameTd">' + result[i].deptVO.collVO.collName + '</td>';
				str += '<td class="deptNameTd">' + result[i].deptVO.deptName + '</td>';
				str += '<td class="stuNameTd">' + result[i].memberVO.memName + '</td>';
				str += '<td class="stuNameTd">' + result[i].gradeList[0].grade + '</td>';
				str += '<td>';
				str += '<select class="form-select">';
				str += '<option value="미입력">미입력</option>';
				str += '<option value="A">A</option>';
				str += '<option value="B">B</option>';
				str += '<option value="C">C</option>';
				str += '<option value="D">D</option>';
				str += '<option value="F">F</option>';
				str += '</select>';
				str += '</td>';
				str += '<td><input type="button" value="성적입력"></td>';
				str += '</tr>';
			}
			
			document.getElementById('modalTbody').innerHTML = str;
		},
		error: function() {
			//ajax 실행 실패 시 실행되는 구간
			alert('실패');
		}
	});
}