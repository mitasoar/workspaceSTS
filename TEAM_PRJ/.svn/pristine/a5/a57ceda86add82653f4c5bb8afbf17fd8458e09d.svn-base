//학생 목록
function searchStu(lecNo) {
	$.ajax({
		url: '/pro/lecStuList', //요청경로
		type: 'post',
		data: { 'gradeList[0].lecNo': lecNo }, //필요한 데이터 '데이터이름':값
		success: function(result) {

			//result의 데이터로 모달창 화면을 구성한다.
			var str = '';
			for (var i = 0; i < result.length; i++) {
				str += '<tr style="vertical-align: middle;">';
				str += '<th scope="row" id="stuNo' + i +'">' + result[i].stuNo + '</th>';
				str += '<td>' + result[i].memberVO.memName + '</td>';
				str += '<td>' + result[i].deptVO.collVO.collName + '</td>';
				str += '<td>' + result[i].deptVO.deptName + '</td>';
				str += '<td>' + result[i].stuYear + '</td>';
				str += '<td>' + result[i].gradeList[0].grade + '</td>';
				str += '<td><select class="form-select" id="' + ('selectGrade' + i) + '">'
				str += '<option>미선택</option>'
				str += '<option>A</option>'
				str += '<option>B</option>'
				str += '<option>C</option>'
				str += '<option>D</option>'
				str += '<option>F</option>'
				str += '</select></td>'
				str += '<td><button type="button" class="btn btn-primary" onclick="regGrade(' + i + ', ' + '\'' + lecNo +'\'' + ');">성적 변경</button></td>'
				str += '</tr>';
			}

			//document.getElementById('modalTbody').innerHTML = str;
			document.getElementById('lecStuTbody').innerHTML = str;

		},
		error: function() {
			//ajax 실행 실패 시 실행되는 구간
			alert('실패');

		}
	});

	var modalTag = document.getElementById('lecStuModal');
	var myModal = new bootstrap.Modal(modalTag);
	myModal.show();

}

//성적 등록
function regGrade(selectNum, lecNo) {
	var grade = document.getElementById('selectGrade' + selectNum).value;
	var stuNo = document.getElementById('stuNo' + selectNum).innerHTML;
	$.ajax({
		url: '/pro/regGrade', //요청경로
		type: 'post',
		data: {'grade':grade, 'gradeList[0].lecNo':lecNo, 'lecNo':lecNo , 'stuNo':stuNo}, //필요한 데이터 '데이터이름':값
		success: function(result) {
			//ajax 실행 성공 후 실행할 코드 작성
			alert('성적 변경 완료.');
			var str = '';
			for(var i = 0 ; i < result.length ; i++){
				str += '<tr style="vertical-align: middle;">';
				str += '<th scope="row" id="stuNo' + i +'">' + result[i].stuNo + '</th>';
				str += '<td>' + result[i].memberVO.memName + '</td>';
				str += '<td>' + result[i].deptVO.collVO.collName + '</td>';
				str += '<td>' + result[i].deptVO.deptName + '</td>';
				str += '<td>' + result[i].stuYear + '</td>';
				str += '<td>' + result[i].gradeList[0].grade + '</td>';
				str += '<td><select class="form-select" id="' + ('selectGrade' + i) + '">'
				str += '<option>미선택</option>'
				str += '<option>A</option>'
				str += '<option>B</option>'
				str += '<option>C</option>'
				str += '<option>D</option>'
				str += '<option>F</option>'
				str += '</select></td>'
				str += '<td><button type="button" class="btn btn-primary" onclick="regGrade(' + i + ', ' + '\'' + lecNo +'\'' + ');">성적 변경</button></td>'
				str += '</tr>';
			}
			document.getElementById('lecStuTbody').innerHTML = str;
		},
		error: function() {
			//ajax 실행 실패 시 실행되는 구간
			alert('실패');
		}
	});
	
}


//강의 검색
function searchLec() {
	var lecName = document.getElementById('searchName').value
	var semNo = document.getElementById('selectSem').value
	var lecClose = document.querySelector('.radiobox:checked').value;
	$.ajax({
		url: '/pro/searchLecList', //요청경로
		type: 'post',
		data: {'lecName':lecName, 'semNo':semNo, 'lecClose':lecClose}, //필요한 데이터 '데이터이름':값
		success: function(result) {
			var str = '';
			
			for (var i = 0; i < result.length; i++) {
				str += '<tr style="vertical-align: middle;" onclick="searchStu(' + '\'' + result[i].lecNo + '\'' + ');" role="button">';
				str += '<th scope="row">' + result[i].lecNo + '</th>';
				str += '<td>' + result[i].lecName + '</td>';
				str += '<td>' + result[i].lecScore + '</td>';
				str += '<td>' + result[i].deptVO.collVO.collName + '</td>';
				str += '<td>' + result[i].deptVO.deptName + '</td>';
				str += '<td>' + result[i].empVO.memberVO.memName + '</td>';
				str += '<td>' + result[i].maxNum + '</td>';
				str += '<td>' + result[i].nowNum + '</td>';
				str += '<td>';
				for(var k = 0 ; k < result[i].timeList.length ; k++){
					str += result[i].timeList[k].day + ' / '
					if(result[i].timeList[k].firstTime == result[i].timeList[k].lastTime){
						str += result[i].timeList[k].firstTime + ' 교시 <br>';
					}
					else{
						str += result[i].timeList[k].firstTime + ' ~ ' + result[i].timeList[k].lastTime + ' 교시 <br>';
					}
				} 
				if(result[i].lecClose == 'N'){
					str += '<td>강의중</td>'
				}
				else{
					str += '<td>폐강</td>'
				}
				str += '<td onclick="event.cancelBubble=true"><button type="button" class="btn btn-outline-danger" onclick="lecClose(' + '\'' + result[i].lecNo + '\'' + ');" >폐강</button></td>'
				str += '</tr>';
			}
			
			document.getElementById('lecTable').innerHTML = str;

		},
		error: function() {
			//ajax 실행 실패 시 실행되는 구간
			alert('실패');

		}
	});

}

//폐강
function lecClose(lecNo){
	var bool = confirm('폐강 하시겠습니까?')
	if(bool){
		$.ajax({
			url: '/pro/lecClose', //요청경로
			type: 'post',
			data: {'lecNo':lecNo}, //필요한 데이터 '데이터이름':값
			success: function() {
				alert('폐강 완료');
				
				location.href='/pro/lecList';
			},
			error: function() {
				//ajax 실행 실패 시 실행되는 구간
				alert('실패');
	
			}
		});
	}
}



