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
					label: 'KH대 취업률',
					data: [result[0]
						, result[1]
						, result[2]
						, result[3]
						, result[4]],
					backgroundColor: '#215190',
					borderColor: '#215190',
					borderWidth: 2
				},
				{
					label: '타대학 평균 취업률',
					data: [ 40.6, 34.2, 44.7, 15.4, 10.9],
					backgroundColor: '#F38181',
					borderColor: '#F38181',
					borderWidth: 1
				},
				{
					label: '20대 평균 취업률',
					data: [ 34.2, 14.2, 24.7, 34.4, 44.1],
					backgroundColor: '#FBC687',
					borderColor: '#FBC687',
					borderWidth: 1
				},
				],
				
			},
			options: {
				scales: {
					y: {
						beginAtZero: true,
						max: 100,
						min: 0,
						ticks: {
							stepSize: 10,
						}
					}
				},
			}
		});

	},
	error: function() {
		//ajax 실행 실패 시 실행되는 구간
		alert('실패');
	}
});