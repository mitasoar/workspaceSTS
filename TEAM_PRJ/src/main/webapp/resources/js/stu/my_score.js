function searchSem(){
	var semNo = document.getElementById('semSelectBox').value
	
	$.ajax({
		url: '/stu/searchSem',
		type: 'post',
		data: {'semNo':semNo},
		success: function(result) {
			var str = '';
			
			for(var i = 0 ; i < result.length ; i++){
				str += '<tr><th scope="row">' + (i + 1) + '</th>';
				str += '<td>' + result[i].lecName + '</td>';
				str += '<td>' + result[i].semVO.semName + '</td>';
				str += '<td>' + result[i].gradeVO.grade + '</td>';
				str += '<td>' + result[i].gradeVO.score + '</td>';
				str += '</tr>';
			}
			
			document.getElementById('gradeTbody').innerHTML = str;
			
		},
		error: function() {

			alert('실패');
		}
	});
	
}



