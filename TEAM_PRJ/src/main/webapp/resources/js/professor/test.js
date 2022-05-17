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
						'#215190'
						, '#7687AC'
						, '#9AA2B7'
					],
					borderColor: ['white'],
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