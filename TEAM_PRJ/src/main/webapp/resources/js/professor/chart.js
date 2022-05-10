$.ajax({
	url: '/pro/chartAll',
	type: 'post',
	data: {},
	success: function(result) {
		// 차트를 그럴 영역을 dom요소로 가져온다.
		var chartArea = document.getElementById('statusChart').getContext('2d');
		// 차트를 생성한다. 
		var myChart = new Chart(chartArea, {
			type: 'pie',
			data: {
				labels: ['재학', '휴학', '자퇴'],
				datasets: [{
					data: [result[0], result[1], result[2]],
					backgroundColor: [
						'#F38181'
						, '#FFD460'
						, '#F07B3F'
					],
					borderColor: ['black'],
					borderWidth: 1
				}]
			},
			options: {
				plugins: {
					datalabels: {
						anchor: 'center',
						formatter: function(value, context) {
							return value;
						}
					}
				}
			}
		});
		
	},
	error: function() {
		alert('실패');
	}
});


$.ajax({
	url: '/pro/selectLecNum', //요청경로
	type: 'post',
	data: {}, //필요한 데이터 '데이터이름':값
	success: function(result) {
		var chartArea = document.getElementById('lecChart').getContext('2d');
		var myChart = new Chart(chartArea, {
			type: 'line',
			data: {
				labels: [
					'2018', '2019', '2020', '2021', '2022'
				],
				datasets: [{
					label: '취업률',
					data: [result[0]
						, result[1]
						, result[2]
						, result[3]
						, result[4]],
					backgroundColor: [
						'#FFAAA6'
						, '#FBC687'
						, '#FCE38A'
						, '#99DDCC'
						, '#A2D5F2'
						, '#EDB1F1'
					],
					borderColor: [
						'#FF8C94'
						, '#FF9A3C'
						, '#FFC93C'
						, '#62D2A2'
						, '#07689F'
						, '#D59BF6'
					],
					borderWidth: 1
				},
				]
			},
			options: {
				scales: {
					y: {
						beginAtZero: true,
						max: 60,
						min: 30,
					}
				},
				ticks: {

				}
			}
		});

	},
	error: function() {
		//ajax 실행 실패 시 실행되는 구간
		alert('실패');
	}
});
