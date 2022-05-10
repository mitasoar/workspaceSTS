<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메모리 게임</title>
<style>
    * {margin: 0; padding: 0; user-select: none;}
    h1 {text-align: center; padding: 20px;}
    #wrap {
        display: flex; 
        background: #ccc; 
        height: 300px; 
        justify-content: center; 
        align-items: center;
    }
    #wrap div {
        width: 200px; 
        height: 200px; 
        display: flex;
        justify-content: center; 
        align-items: center;
    }
    #wrap div:nth-child(1) p {background: red;}
    #wrap div:nth-child(2) p {background: orange;}
    #wrap div:nth-child(3) p {background: yellow;}
    #wrap div:nth-child(4) p {background: green;}
    #wrap p {
        border: 3px solid #fff;
        border-radius: 50%; 
        width: 100px; 
        height: 100px;
        cursor: pointer;
    }
/*    #wrap p:hover {width: 110px; height: 110px;}*/
    #score {
        text-align: center; 
        padding: 20px; 
        font: bold 50px Tahoma, sans-serif;
    }
    #start, #over {
        background-color: rgba(0,0,0,.9);
        position: fixed;
        left: 0;
        top: 0;
        width: 100%;
        height: 100%;
        display: none;
        justify-content: center; 
        align-items: center;
        opacity: 0;
    }
    #start {
        display: flex;
    }
    #start_bt, #replay_bt {
        padding: 20px 50px;
        font-weight: bold;
        font-size: 40px;
        cursor: pointer;
    }
    #start p {
        font-size: 50px;
        font-weight: bold;
        color: white;
        position: absolute;
        top: 20%;
    }
    #over p {
        font-size: 50px;
        font-weight: bold;
        color: red;
        position: absolute;
        top: 20%;
    }
</style>
</head>
<body>
<h1>기억게임</h1>
<h1>Level - <span id="level">1</span></h1>
<div id="wrap">
    <div><p></p></div>
    <div><p></p></div>
    <div><p></p></div>
    <div><p></p></div>
</div>
<div id="score">0</div>
<div id="start"><p>재밌는~ 기억게임!</p><button id="start_bt">Start</button></div>
<div id="over"><p>Game Over</p><button id="replay_bt">Replay</button></div>

<script>
    var num = '';
    var i = 0;
    var level = 1;
    var score = 0;
    
    $('#start').animate({opacity:1}, 500);
    
    function motion(){
        for(var j = 0; j < level; j++){
            num += Math.floor(Math.random() * 4);
        };
        var ss = setInterval(function(){
            var n = num.charAt(i);
            $('#wrap p').eq(n).animate({width: 120, height: 120}, 300);
            $('#wrap p').eq(n).animate({width: 100, height: 100}, 300);
            i++;
            if (i >= num.length) {
                i = 0;
                clearInterval(ss);
            }
        }, 600);
    };
    
    $('#start_bt').click(function(){
        $('#start').animate({opacity:0}, 500);
        setTimeout(function(){
            $('#start').css('display', 'none');
            motion(); 
        }, 500);
    });
    
    $('#wrap p').click(function(){
        var m = $('#wrap p').index(this);
        $(this).animate({width: 80, height: 80}, 200); 
        $(this).animate({width: 100, height: 100}, 200);
        setTimeout(function(){
            if(num.charAt(i) == m){
//                alert('정답!');
                i++;
                if(i >= num.length){
                    alert('정답!');
                    i = 0;
                    level++;
                    num = '';
                    score += 1000;
                    $('#level').text(level);
                    $('#score').text(score);
                    alert('레벨업!');
                    motion();
                }
            } else {
                alert('오답!');
                i = 0;
                num = '';
                if (score < 3000) {
                    $('#over p').text('붕어시군요! 기억력이 3초..!?');
                } else if (score < 6000) {
                    $('#over p').text('평범합니다. 더 기억해보세요!');
                } else if (score < 9000) {
                    $('#over p').text('물건을 놓고 가는일은 없겠네요!');
                } else {
                    $('#over p').text('미쵸따 미쵸따! 탯줄자른기억도 나시겠다!!');
                }
                $('#over').css('display', 'flex');
                $('#over').animate({opacity:1}, 500);
                $('#replay_bt').click(function(){
                    location.reload();
                });
            }
        }, 400);
    });
</script>
</body>
</html>