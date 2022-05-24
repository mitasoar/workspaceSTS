// 파일 다운로드
$('.filedown').click(function() {
    // alert("원본 :  " + $(this).attr('ofile') + "      실제 :  " + $(this).attr('sfile'));
    $(document).find('[name="sfolder"]').val($(this).attr('sfolder'));
    $(document).find('[name="ofile"]').val($(this).attr('ofile'));
    $(document).find('[name="sfile"]').val($(this).attr('sfile'));
    $('#downform').attr('action', '/board/download').attr('method', 'get').submit();
});

// 게시글 삭제 버튼
function deleteBoard(boardNo) {
	if (confirm('해당 게시글을 삭제하시겠습니까?')) {
		$.ajax({ // 삭제 ajax
			url: "/board/deleteBoard",
			type: "POST",
			data: {boardNo: boardNo},
			success: function() {
				alert('게시글이 삭제되었습니다.');
				location.href = '/board/boardList';
			},
			error: function() {
				alert('게시글 삭제를 실패하였습니다.. 다시 확인해주세요.');
			}
		})
	}
}

$('[name=commentInsertBtn]').click(function(){ //댓글 등록 버튼 클릭시 
	if (document.getElementById('content').value.length > 0) { // 댓글 내용이 있을 시
		var insertData = $('[name=commentInsertForm]').serialize(); //commentInsertForm의 내용을 가져옴
		commentInsert(insertData); //Insert 함수호출(아래)
	} else { // 댓글 내용이 없을 시
		alert('댓글 내용을 입력해주세요');
	}
  
});
 
 
 
//댓글 목록 
function commentList(){
    $.ajax({
        url : '/board/reply',
        type : 'GET',
        data : {boardNo: $('#boardNo').val(), nowPage: $('#nowPage').val()},
        success : function(data){
            let a = ''; 
            $.each(data, function(key, value){ 
                a += '<div class="commentArea_'+value.replyNo+'" style="border-bottom:1px solid darkgray; margin: 10px 0;">';
                if (value.isSecret == 'Y' && value.replyWriter != $('#loginId').val() && $('#boardWriter').val() != $('#loginId').val() && $('#loginType').val() != 'admin') { // 비밀 댓글인 경우
					a += '<div class="d-inline-block col-7 commentContent_'+value.replyNo+'"> <p style="padding-left: 5px; margin-bottom: 5px; word-wrap:break-word;">' + 
					'<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-lock" viewBox="0 0 16 16"><path d="M8 1a2 2 0 0 1 2 2v4H6V3a2 2 0 0 1 2-2zm3 6V3a3 3 0 0 0-6 0v4a2 2 0 0 0-2 2v5a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V9a2 2 0 0 0-2-2zM5 8h6a1 1 0 0 1 1 1v5a1 1 0 0 1-1 1H5a1 1 0 0 1-1-1V9a1 1 0 0 1 1-1z"/></svg> 해당 댓글은 작성자와 관리자만 확인 가능합니다.' 
					+ '</p></div>';
				} else { // 비밀 댓글이 아닌 경우
					a += '<div class="d-inline-block col-7 commentContent_'+value.replyNo+'"> <p style="padding-left: 5px; margin-bottom: 5px; word-wrap:break-word;">';
					if (value.isSecret == 'Y') {
						a += '<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-lock" viewBox="0 0 16 16"><path d="M8 1a2 2 0 0 1 2 2v4H6V3a2 2 0 0 1 2-2zm3 6V3a3 3 0 0 0-6 0v4a2 2 0 0 0-2 2v5a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V9a2 2 0 0 0-2-2zM5 8h6a1 1 0 0 1 1 1v5a1 1 0 0 1-1 1H5a1 1 0 0 1-1-1V9a1 1 0 0 1 1-1z"/></svg> ';
					}
					a += value.replyContent + '</p></div>';
				}
                if (value.updateDate == null) {
					a += '<div class="d-inline-block col-5 text-end commentInfo_'+value.replyNo+'">'+ value.memName + ' / ' + value.createDate;
				} else {
					a += '<div class="d-inline-block col-5 text-end commentInfo_'+value.replyNo+'">'+ value.memName + ' / ' + value.updateDate;
				}
                if (value.replyWriter == $('#loginId').val() || $('#loginType').val() == 'admin') {
					a += '<a href="javascript:void(0);" class="link-primary text-decoration-none" onclick="commentUpdate(\''+value.replyNo+'\',\''+value.replyContent+'\',\''+value.isSecret+'\'); return false;"> 수정 </a>';
	                a += '<a href="javascript:void(0);" class="link-danger text-decoration-none" role="button" onclick="commentDelete(\''+value.replyNo+'\'); return false;"> 삭제 </a>';
				}
                a += '</div></div>';
            });
            
            $(".commentList").html(a);
        }
    });
}
 
//댓글 등록
function commentInsert(insertData){
    $.ajax({
        url : '/board/insertReply',
        type : 'POST',
        data : insertData,
        success : function(){
            /* commentList(); //댓글 작성 후 댓글 목록 reload
            $('#content').val(''); */
            location.href="/board/boardContent?boardNo=" + $('#boardNo').val();
        }
    });
}
 
//댓글 수정 - 댓글 내용 출력을 input 폼으로 변경 
function commentUpdate(cno, content, secret){
    var a ='';
    
    a += '<div class="input-group">';
    a += '<div class="form-check form-switch pt-1"><input class="form-check-input" type="checkbox" role="switch" name="isSecret_' + cno + '" id="isSecret_' + cno + '" value="Y"';
    if (secret == 'Y') {
	  	a += 'checked>';
	} else {
		a += '>';
	}
    a += '<label class="form-check-label me-2" for="isSecret_' + cno + '">비밀댓글</label></div>';
    a += '<input type="text" class="form-control border me-1" name="content_'+cno+'" value="'+content+'"/>';
    a += '<span class="input-group-btn"><button class="btn btn-white" type="button" onclick="commentUpdateProc(\''+cno+'\');">수정</button> </span>';
    a += '</div>';
    $('.commentArea_'+cno).html(a);
    $('.commentArea_'+cno).css('border-bottom', '0');
    
}
 
//댓글 수정
function commentUpdateProc(cno){
	if (confirm('댓글을 수정하시겠습니까?')) {
	    $.ajax({
	        url : '/board/updateReply',
	        type : 'POST',
	        data : {'replyContent' : $('[name=content_'+cno+']').val(), 'replyNo' : cno, 'isSecret' : $('[name=isSecret_'+cno+']').val()},
	        success : function(){
	            commentList(); // 댓글 수정후 목록 출력
	            alert('댓글이 수정되었습니다.'); 
	        }
	    });
	}
}
 
//댓글 삭제 
function commentDelete(cno){
	if (confirm('해당 댓글을 삭제하시겠습니까?')) {
		 $.ajax({
	        url : '/board/deleteReply',
	        type : 'POST',
	        data : {replyNo : cno},
	        success : function(){
	            /* commentList(); // 댓글 삭제후 목록 출력 */
	            location.href="/board/boardContent?boardNo=" + $('#boardNo').val();
	        }
	    });
	}
}
 
$(document).ready(function(){
    commentList(); //페이지 로딩시 댓글 목록 출력 
});


