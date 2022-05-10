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


function addTime(num) {
	
	if(num < 4){
	var table = document.getElementById('lecTable').insertRow()
	
	var td1 = table.insertCell(0);
	var td2 = table.insertCell(1);
	var td3 = table.insertCell(2);
	var td4 = table.insertCell(3);
	
		td1.innerText = '요일';
		td2.innerHTML = '<select name="timeList['+ (num + 1) +'].day" class="test1"><option>월</option><option>화</option><option>수</option><option>목</option><option>금</option></select>';
	  	td3.innerText = '시간';
	  	td4.innerHTML = '<select name="timeList['+ (num + 1) +'].firstTime"><option>1</option><option>2</option><option>3</option><option>4</option><option>5</option><option>6</option><option>7</option><option>8</option>'
		+ '	</select> 교시 ~ <select name="timeList['+ (num + 1) +'].lastTime"><option>1</option><option>2</option><option>3</option><option>4</option><option>5</option><option>6</option><option>7</option><option>8</option></select>교시';	
	  	
	  	document.getElementById('addButton').innerHTML = '<button type="button" onclick="addTime(' + (num + 1) + ');">추가</button>';
	  	document.getElementById('removeButton').innerHTML = '<button type="button" onclick="removeTime('+ (num + 1) +');">삭제</button>';
	}
	else{
		
	}
  	
}

function removeTime(num) {
	
	if(num > 0){
		document.getElementById('lecTable').deleteRow(-1);
	}
	var totalNum = num - 1;
	document.getElementById('removeButton').innerHTML = '<button type="button" onclick="removeTime('+ totalNum +');">삭제</button>';
	document.getElementById('addButton').innerHTML = '<button type="button" onclick="addTime(' + totalNum+ ');">추가</button>';
	
	if(totalNum <= 0){
		document.getElementById('removeButton').innerHTML = '';
	}
}

//강의 요일 확인
$.validator.addMethod('testValidation', function(value, element){
	//return this.optional(element) || value.match(/^[a-zA-Z0-9\.\,\s]+( [a-zA-Z0-9\.\,\s]+)*$/);
	var days = document.getElementsByClassName('test1');
	
	
	if(days.length != 1){
		for(var i = 0 ; i < days.length - 1 ; i++){
			if(days[i].value == days[i + 1].value){
				return false;
			}
		}
	}
	
	return true;
});


$('#regLecForm').validate({
	//true: 유효성 검사 성공 시에도 sumit이 되지 않음
	debug:true,
	
	//유효성 검사 대상 설정
	rules: {
		lecName: {//input 태그의 name 속성으로 검사 대상을 지정
			required: true,
		},
		collNo: {
			required: true,
		},
		deptNo: {
			required: true,
		},
		maxNum: {
			required: true,
		},
		time0: {
			testValidation: true,
		}
	},
	//유효성 검사 실패시 나타날 메세지 설정
	messages: {
		lecName: {
			required: "이름을 입력해주세요.",
		},
		collNo: {
			required: "단과대를 선택해주세요.",
		},
		deptNo: {
			required: "학과를 선택해주세요.",
		},
		maxNum: {
			required: "인원을 입력해주세요.",
		},
		time0: {
			testValidation: "요일이 중복 됩니다.",
		}
		
	},
	//유효성 실패시 추가할 태그(default:label)
	errorElement:'div',
	errorPlacement: function(error, element) {
		//element: 유효성 검사 실패한 태그(input)
		//error: 검사
		
		//요일
		if($(element).attr('class') == 'test1 error'){
			error.insertAfter($('#lecTable'));
		}
		else{
			error.insertAfter(element);
		}
		
		error.css('color', 'red');
		//error.css('fontsize, '12px' );
	
	},
	//유효성 검사 성공시 실행
	submitHandler: function(form) {
		debugger;
		document.getElementsByName('time0')[0].name = 'timeList[0].day'
		
		form.submit();   //유효성 검사를 통과시 전송
		
	}
});



