function searchDept() {
	var selectColl = document.getElementById('selectColl').value
	$.ajax({
		url: '/pro/selectDept', //요청경로
		type: 'post',
		data: {'collNo':selectColl}, //필요한 데이터 '데이터이름':값
		success: function(result) {
			//ajax 실행 성공 후 실행할 코드 작성
			str = '';
			str = '<option value="">전체</option>';
			for(var i = 0 ; i < result.length ; i++){
				str += '<option value="' + result[i].deptNo + '">'+ result[i].deptName + '</option>'
			}
			document.getElementById('selectDept').innerHTML = str;
			
		},
		error: function() {
			//ajax 실행 실패 시 실행되는 구간
			alert('실패');
		}
	});
}

function searchLec() {
	var collNo = document.getElementById('selectColl').value
	var deptNo = document.getElementById('selectDept').value
	var lecName = document.getElementById('searchName').value
	$.ajax({
		url: '/stu/searchLecList', //요청경로
		type: 'post',
		data: {'collNo':collNo, 'deptNo':deptNo, 'lecName':lecName}, //필요한 데이터 '데이터이름':값
		success: function(result) {
			$.ajax({
				url: '/stu/regLecList',
				type: 'post',
				data: {},
				success: function(regLec) {
					var str = '';
					debugger;
					
					for (var i = 0; i < result.length; i++) {
						str += '<tr>';
						str += '<th scope="row">' + result[i].lecNo + '</th>';
						str += '<td>' + result[i].lecName + '</td>';
						str += '<td>' + result[i].lecScore + '</td>';
						str += '<td>' + result[i].deptVO.collVO.collName + '</td>';
						str += '<td>' + result[i].deptVO.deptName + '</td>';
						str += '<td>' + result[i].empVO.memberVO.memName + '</td>';
						str += '<td>' + result[i].maxNum + '</td>';
						str += '<td>' + result[i].nowNum + '</td>';
						str += '<td>'
						for (var k = 0; k < result[i].timeList.length; k++) {
							str += result[i].timeList[k].day + ' / '
							if (result[i].timeList[k].firstTime == result[i].timeList[k].lastTime) {
								str += result[i].timeList[k].firstTime + ' 교시 ';
							}
							else {
								str += result[i].timeList[k].firstTime + ' ~ ' + result[i].timeList[k].lastTime + ' 교시 ';
							}
						} 
						str += '</td>';
						str += '<td>'
						if(result[i].maxNum == result[i].nowNum){
							str += '<button type="button">신청 마감</button>'
						}
						else if(regLec != "" && regLec != null && regLec != undefined){
							for(var k = 0 ; k < regLec.length ; k++){
								if(regLec[k].lecNo === result[i].lecNo){
									str += '<button type="button">신청 완료</button>'
								}
								else{
									str += '<button type="button" onclick="regClass(' +'\'' + result[i].lecNo +'\'' + ');">수강 신청</button>'
								}
							}
						}
						else{
							str += '<button type="button" onclick="regClass(' +'\'' + result[i].lecNo +'\'' + ');">수강 신청</button>'
						}
						str += '</td>';
						str += '</tr>';
					}
					
					document.getElementById('lecTable').innerHTML = str;
					
				},
				error: function() {
					alert('실패');
				}
			});

		},
		error: function() {
			//ajax 실행 실패 시 실행되는 구간
			alert('실패');

		}
	});

}

function regClass(lecNo){
	var collNo = document.getElementById('selectColl').value
	var deptNo = document.getElementById('selectDept').value
	var lecName = document.getElementById('searchName').value
	$.ajax({
		url: '/stu/regClass', //요청경로
		type: 'post',
		data: {'lecNo':lecNo, 'collNo':collNo, 'deptNo':deptNo, 'lecName':lecName}, //필요한 데이터 '데이터이름':값
		success: function(result) {
			$.ajax({
				url: '/stu/regLecList',
				type: 'post',
				data: {},
				success: function(regLec) {
					alert('수강 신청이 완료 되었습니다!');
					var str = '';
					
					for (var i = 0; i < result.length; i++) {
						str += '<tr>';
						str += '<th scope="row">' + result[i].lecNo + '</th>';
						str += '<td>' + result[i].lecName + '</td>';
						str += '<td>' + result[i].lecScore + '</td>';
						str += '<td>' + result[i].deptVO.collVO.collName + '</td>';
						str += '<td>' + result[i].deptVO.deptName + '</td>';
						str += '<td>' + result[i].empVO.memberVO.memName + '</td>';
						str += '<td>' + result[i].maxNum + '</td>';
						str += '<td>' + result[i].nowNum + '</td>';
						str += '<td>'
						for (var k = 0; k < result[i].timeList.length; k++) {
							str += result[i].timeList[k].day + ' / '
							if (result[i].timeList[k].firstTime == result[i].timeList[k].lastTime) {
								str += result[i].timeList[k].firstTime + ' 교시 ';
							}
							else {
								str += result[i].timeList[k].firstTime + ' ~ ' + result[i].timeList[k].lastTime + ' 교시 ';
							}
						} 
						str += '</td>';
						str += '<td>'
						if(result[i].maxNum == result[i].nowNum){
							str += '<button type="button">신청 마감</button>'
						}
						else if(regLec != "" && regLec != null && regLec != undefined){
							for(var k = 0 ; k < regLec.length ; k++){
								if(regLec[k].lecNo === result[i].lecNo){
									str += '<button type="button">신청 완료</button>'
								}
								else{
									str += '<button type="button" onclick="regClass(' +'\'' + result[i].lecNo +'\'' + ');">수강 신청</button>'
								}
							}
						}
						else{
							str += '<button type="button" onclick="regClass(' +'\'' + result[i].lecNo +'\'' + ');">수강 신청</button>'
						}
						str += '</td>';
						str += '</tr>';
					}
					
					document.getElementById('lecTable').innerHTML = str;
					
				},
				error: function() {
					alert('실패');
				}
			});
			
		},
		error: function() {
			alert('수강 신청을 실패 하셨습니다.');
		}
	});
}