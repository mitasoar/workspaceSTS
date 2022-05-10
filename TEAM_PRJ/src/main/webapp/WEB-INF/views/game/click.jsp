<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>click game</title>
<style>
    * {margin: 0; padding: 0; user-select: none;}
    .screen_out {display: none;}
    html, body {height: 100%;}
    body {
        display: flex; /* 수평 정렬이 수직 정렬화 됨 */
        flex-direction: column; /* flex 정렬 위치를 변경하는 옵션 */
        align-items: center; /* (자식요소들의) 가로정렬 */
        justify-content: center; /* (자식요소들의) 세로정렬 */
    } 
    #time {
    	background-color: #EEEEEE;
    	padding: 10px 30px;
        text-align: center;
    }
    #score {
        min-width: 300px; 
        padding: 10px 0; 
        text-align: center;
        font: bold 30px/30px tahoma, sans-serif;
    }
    
    #score:hover {
   	 cursor: pointer;
    }
    
    #result {
        border: 5px solid #AAAAAA; 
        position: fixed;
        width: 600px;
        height: 300px;
        background-color: #EEEEEE;
        display: none;
        align-items: center;
        justify-content: center;
        font-size: 20px;
        top: 35%;
        left: 35%;
    }
    
    .re_bt {
        border-radius: 100px; 
        padding: 10px 30px; 
        position: fixed; 
        top: 25%;
    }
</style>
</head>
<body>
<h1 class="screen_out">Click Game</h1>
<p id="time">10초 광클릭 게임</p>
<p id="score">클릭하면 자동으로 시작합니다.</p>
<div id="result">당신은 신의 손이군요.</div>

<script>
    var sec = 10;
    var num = -1;
    var play;
    var ti;
    var tsc = 0;
    var start = true;
    $('#score').click(function(){
        if (start) {
            $(this).css('cursor', 'default');
            $('#time').css('cursor', 'default');
//            $(this).text(num);
            play = true;
            start = false;
            ti = setInterval(function(){
                $('#time').text(--sec + '초');
                if (sec <= 0) {
                    var msg = '';
                    play = false;
                    $('#time').text('10초 광클릭 게임');
                    $('#score').text('클릭하면 자동으로 시작합니다.');
                    $('#result').css('display', 'flex');
                    if (num > tsc) {
                        tsc = num;
                        msg = '@@@@@최고점수 갱신@@@@@<br>';
                    }
                    if (num < tsc - 10) {
                        $('#result').html(msg + '현재까지의 최고 점수 => ' + tsc + '점!<br><br>뭐하셨나요..?<br>10초간 클릭한 횟수는 ' + num + '회 입니다.<br><button>다시하기</button>');
                    } else if (num < tsc - 5) {
                        $('#result').html(msg + '현재까지의 최고 점수 => ' + tsc + '점!<br><br>평범하네요ㅎㅎ<br>10초간 클릭한 횟수는 ' + num + '회 입니다.<br><button>다시하기</button>');
                    } else {
                        $('#result').html(msg + '현재까지의 최고 점수 => ' + tsc + '점!<br><br>당신은 신의손이군요!<br>10초간 클릭한 횟수는 ' + num + '회 입니다.<br><button>다시하기</button>');
                    }
                    $('#result button').css('cursor', 'pointer');
                    $('#result button').addClass('re_bt');
                    $('#result button').click(function(){
                        $('#result').css('display', 'none');
                        $('#score').css('cursor', 'pointer');
//                        $('#score').click();
                    });
                    start = true;
                    sec = 10;
                    num = -1;
                    clearInterval(ti);
                }
            }, 1000);
        }
    });
    
    $('body').click(function(){
        if (play) {
            $('#score').text(++num);
        }
    });
    
//    $('#time').change(function(){
//        if (sec <= 0) {
//            clearInterval(ti);
//            start = true;
//        }
//    });
</script>
</body>
</html>