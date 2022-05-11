function enterkey(){
	//엔터키를 눌렀을 때
	if (window.event.keyCode == 13) {
		searchStudentAjax();
	}
}

function collChangeAjax() {
	var collNo = document.getElementById('coll').value;

	$.ajax({
		url: '/admin/collChangeAjax', 
		data: { 'collNo': collNo },
		success: function(result) {
			document.getElementById('dept').innerHTML = '';

			var str = '<option value="">전체</option>';
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

function searchStudentAjax(){
	var collNo = document.getElementById('coll').value;
	var deptNo = document.getElementById('dept').value;
	var stuYear = document.getElementById('stuYear').value;
	var stuStatus = document.getElementById('stuStatus').value;
	var memName = document.getElementById('memName').value;
	
	$.ajax({
		url: '/admin/searchStudentAjax', 
		type: 'get',
		data: { 'collNo': collNo,
				'deptNo': deptNo, 
				'stuYear': stuYear, 
				'stuStatus': stuStatus,
				'memberVO.memName': memName },
				
		success: function(result) {
			document.getElementById('listDiv').innerHTML = '';

			var str = '<option value="">전체</option>';
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
			str += '<td>학년</td>';
			str += '<td>이름</td>';
			str += '<td>소속 대학</td>';
			str += '<td>전공</td>';
			str += '<td>학적 상태</td>';
			str += '</tr>';
			str += '</thead>';
			str += '<tbody>';
			
			for (var i = 0; i < result.length; i++) {
				str += '<tr>';
				str += '<td>' + result[i].stuNo + '</td>';
				str += '<td>' + result[i].stuYear + '</td>';
				str += '<td>' + result[i].memberVO.memName + '</td>';
				str += '<td>' + result[i].deptVO.collVO.collName + '</td>';
				str += '<td>' + result[i].deptVO.deptName + '</td>';
				str += '<td>' + result[i].stuStatus + '</td>';
				str += '</tr>';
			}
			
			str += '</tbody>';
			str += '</table>';

			document.getElementById('listDiv').innerHTML = str;
		},
		error: function(request, error) {
			alert('code:' + request.status + '\n' + 'message:' + request.responseText + '\n' + 'error:' + error);
		}
	});
	
}