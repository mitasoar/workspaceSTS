<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>랜덤한글 타자게임</title>
<style>
    * {margin: 0; padding: 0;}
    #wrap {margin: auto; max-width: 1000px; width: 100%; margin-bottom: 5%;}
    h1 {text-align: center; margin: 20px;}
    h2 {text-align: center;}
    #q {
        text-align: center; 
        font: 100px bold Tahoma, sans-serif; 
/*        color: #f30;*/
        letter-spacing: -10px;
    }
    #bar {
        background-color: #f30;
        width: 100%;
        margin-top: 30px;
        height: 5px;
        transition: all .3s linear;
    }
    #a {
        border: 3px solid #ccc; 
        outline: none; 
        text-align: center; 
        font-size: 30px;
        padding: 20px;
        width: 600px;
        display: none;
        margin: 50px auto;
        transition: all .2s ease;
        position: relative;
    }
    #over {
        background-color: rgba(0,0,0,.8); 
        position: fixed;
        left: 0;
        top: 0;
        width: 100%;
        height: 100%;
        display: none;
        justify-content: center;
        align-items: center;
        opacity: 0;
        transition: all .8s ease;
    }
    #over #replay {
        display: block;
        padding: 20px 100px;
        font-size: 40px;
        cursor: pointer;
    }
    #start {
        display: block;
        padding: 20px 100px;
        font-size: 40px;
        cursor: pointer;
        margin: auto;
        margin-top: 50px;
    }
</style>
</head>
<body>
<div id="wrap">
    <h1>랜덤한글 타자게임</h1>
    <h2>Level(<span id="level">1</span>) Stage(<span id="stage">1/10</span>) setTime(<span id="time">10</span>)</h2>
    <p id="q">얇뷁</p>
    <div id="bar"></div>
    <input type="text" id="a">
    <button id="start">시작</button>
    <div id="over"><button id="replay">REPLAY</button></div>
</div>

<script>
    var word = '';
    var level = 1;
    var stage = 1;
    var total_stage = 5;
    var time = 10;
    var bar_wid = 100;
    
    $('#start').click(function(){
        new_word();
        $(this).css('display', 'none');
        $('#a').css('display', 'block');
    });
    
    function random_hangul() {
        return String.fromCharCode( 44031 + Math.ceil( 11172 * Math.random() ) );
    };
    
    function new_word() {
        for(var i = 0; i < level; i++) {
            word += random_hangul();
        }
        $('#q').text(word);
        $('#level').text(level);
        $('#stage').text(stage + '/' + total_stage);
        $('#a').focus();
        count();
    };
    
    $('#a').keydown(function(e){
        if(e.keyCode == 13) {
            if($('#q').text() === $('#a').val()) {
                $(this).css('background-color', 'white');
                ++stage;
                word = '';
                $('#a').val('');
                if (stage > total_stage) {
                    ++level;
                    stage = 1;
                }
                clearInterval(end);
                time = 10;
                bar_wid = 100;
                $('#time').text(time);
                $('#bar').css('width', bar_wid + '%');
                new_word();
            } else {
                $(this).css('background-color', 'red');
                setTimeout(function(){
                    $('#a').css('background-color', 'white');
                }, 300);
            }
        }
    });
    
    var end;
    
    function count(){
        end = setInterval(function(){
        $('#time').text(--time);
        bar_wid -= 10;
        $('#bar').css('width', bar_wid + '%');
        if (time <= 0) {
                $('#over').css('display', 'flex');
//                $('#over').css('opacity', '.8');
                $('#over').animate({opacity:1}, 500);
                $('#replay').focus();
                $('#a').blur();
                clearInterval(end);
            }
        }, 1000);
    };
    
    $('#replay').click(function(){
       location.reload(); 
    });
</script>
</body>
</html>