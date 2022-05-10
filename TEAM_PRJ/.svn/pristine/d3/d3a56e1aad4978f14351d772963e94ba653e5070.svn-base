$.ajax({
	url: '/pro/lecSchedule', //요청경로
	type: 'post',
	data: {}, //필요한 데이터 '데이터이름':값
	success: function(result) {
		//ajax 실행 성공 후 실행할 코드 작성
		
		
		for(var i = 0 ; i < result.length ; i++){
			if(result[i].day == '화'){
				for(var j = 1 ; j < 9 ; j++){
					if(result[i].firstTime == j){
						var selectedTd = document.querySelector('#tr' + j +' td:nth-child(3)');
						
						selectedTd.innerHTML = result[i].lecName;
						selectedTd.style.backgroundColor = result[i].color;
						selectedTd.rowSpan = result[i].lastTime - result[i].firstTime + 1;
						
						for(var k = (result[i].firstTime + 1) ; k <= result[i].lastTime ; k++){
							document.querySelector('#tr' + k +' td:nth-child(2)').remove();
						}
						break;
					}
					
				}
			}
			if(result[i].day == '수'){
				for(var j = 1 ; j < 9 ; j++){
					if(result[i].firstTime == j){
						var selectedTd = document.querySelector('#tr' + j +' td:nth-child(4)');
						
						selectedTd.innerHTML = result[i].lecName;
						selectedTd.style.backgroundColor = result[i].color;
						selectedTd.rowSpan = result[i].lastTime - result[i].firstTime + 1;
						
						for(var k = (result[i].firstTime + 1) ; k <= result[i].lastTime ; k++){
							document.querySelector('#tr' + k +' td:nth-child(2)').remove();
						}
						break;
					}
					
				}
			}
			if(result[i].day == '목'){
				for(var j = 1 ; j < 9 ; j++){
					if(result[i].firstTime == j){
						var selectedTd = document.querySelector('#tr' + j +' td:nth-child(5)');
						
						selectedTd.innerHTML = result[i].lecName;
						selectedTd.style.backgroundColor = result[i].color;
						selectedTd.rowSpan = result[i].lastTime - result[i].firstTime + 1;
						
						for(var k = (result[i].firstTime + 1) ; k <= result[i].lastTime ; k++){
							document.querySelector('#tr' + k +' td:nth-child(2)').remove();
						}
						break;
					}
					
				}
			}
			if(result[i].day == '금'){
				for(var j = 1 ; j < 9 ; j++){
					if(result[i].firstTime == j){
						var selectedTd = document.querySelector('#tr' + j +' td:nth-child(6)');
						
						selectedTd.innerHTML = result[i].lecName;
						selectedTd.style.backgroundColor = result[i].color;
						selectedTd.rowSpan = result[i].lastTime - result[i].firstTime + 1;
						
						for(var k = (result[i].firstTime + 1) ; k <= result[i].lastTime ; k++){
							document.querySelector('#tr' + k +' td:nth-child(2)').remove();
						}
						break;
					}
					
				}
			}
			
		}
		for(var i = 0 ; i < result.length ; i++){
			if(result[i].day == '월'){
				for(var j = 1 ; j < 9 ; j++){
					if(result[i].firstTime == j){
						var selectedTd = document.querySelector('#tr' + j +' td:nth-child(2)');
						
						selectedTd.innerHTML = result[i].lecName;
						selectedTd.style.backgroundColor = result[i].color;
						selectedTd.rowSpan = result[i].lastTime - result[i].firstTime + 1;
						
						for(var k = (result[i].firstTime + 1) ; k <= result[i].lastTime ; k++){
							document.querySelector('#tr' + k +' td:nth-child(2)').remove();
						}
						break;
					}
					
				}
			}
		}
	},
	error: function() {
		//ajax 실행 실패 시 실행되는 구간
		alert('실패');
	}
});


	