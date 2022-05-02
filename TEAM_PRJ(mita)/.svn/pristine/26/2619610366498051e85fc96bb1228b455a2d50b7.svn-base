function searchDept() {
	var selectColl = document.getElementById('selectColl').value
	$.ajax({
		url: '/pro/selectDept', //요청경로
		type: 'post',
		data: {'collNo':selectColl}, //필요한 데이터 '데이터이름':값
		success: function(result) {
			//ajax 실행 성공 후 실행할 코드 작성
			str = '';
			str = '<option>선택</option>';
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