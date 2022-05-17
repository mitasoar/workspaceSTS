$(document).ready(function() {
	$.ajax({
		url: "/board/cateList",
		type: "GET",
		data: {},
		success: function(data) {
			let bCode = '<div class="d-inline-block pe-3 ps-3 border-end" role="button" onclick="viewBoard();">공지사항</div>';
			data.forEach((e, i) => {
				if (i == data.length - 1) { // 마지막
					bCode += '<div class="d-inline-block pe-3 ps-3" role="button" onclick="viewBoard(\'' + e.cateNo + '\');">';
				} else {
					bCode += '<div class="d-inline-block pe-3 ps-3 border-end" role="button" onclick="viewBoard(\'' + e.cateNo + '\');">';
				}
				bCode += e.cateName + '</div>';
			});
			document.getElementById('cateDiv').innerHTML = bCode;
		},
		error: function() {
		}
	});
	
	viewBoard();	
});

function viewBoard(cateType) {
	$.ajax({
		url: "/board/viewBoardList",
		type: "GET",
		data: {cateType: cateType},
		success: function(data) {
			let bCode = '';
			if (data.length == 0) {
				bCode += '<li class="col-10 mt-3 text-center list-inline">해당 게시판의 게시글이 존재하지 않습니다</li>';
			} else {
				data.forEach((e, i) => {
					bCode += '<li class="row mb-1">';
					bCode += '<div class="col-9">';
					bCode += '<a class="text-dark text-decoration-none" role="button" href="/board/boardContent?boardNo=' + e.boardNo + '">';
					bCode += e.boardTitle + ' (' + e.replyCnt + ') ';
					if (e.fileCnt != 0) {
						bCode += '<svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-folder-plus pb-1" viewBox="0 0 16 16">';
						bCode += '<path d="m.5 3 .04.87a1.99 1.99 0 0 0-.342 1.311l.637 7A2 2 0 0 0 2.826 14H9v-1H2.826a1 1 0 0 1-.995-.91l-.637-7A1 1 0 0 1 2.19 4h11.62a1 1 0 0 1 .996 1.09L14.54 8h1.005l.256-2.819A2 2 0 0 0 13.81 3H9.828a2 2 0 0 1-1.414-.586l-.828-.828A2 2 0 0 0 6.172 1H2.5a2 2 0 0 0-2 2zm5.672-1a1 1 0 0 1 .707.293L7.586 3H2.19c-.24 0-.47.042-.683.12L1.5 2.98a1 1 0 0 1 1-.98h3.672z"/>';
						bCode += '<path d="M13.5 10a.5.5 0 0 1 .5.5V12h1.5a.5.5 0 1 1 0 1H14v1.5a.5.5 0 1 1-1 0V13h-1.5a.5.5 0 0 1 0-1H13v-1.5a.5.5 0 0 1 .5-.5z"/>';
						bCode += '</svg>';
					}
					bCode += '</a></div>';
					bCode += '<div class="col-3 text-end">';
					if (e.updateDate != null && e.updateDate != '') {
						bCode += e.updateDate;
					} else {
						bCode += e.createDate;
					}
					bCode += '</div></li>';
				});
			}
			
			document.getElementById('viewBoard').innerHTML = bCode;
		},
		error: function() {
		}
	});
}

//slide-wrap
var slideWrapper = document.getElementById('slider-wrap');
//current slideIndexition
var slideIndex = 0;
//items
var slides = document.querySelectorAll('#slider-wrap ul li');
//number of slides
var totalSlides = slides.length;
//get the slide width
var sliderWidth = slideWrapper.clientWidth;
//set width of items
slides.forEach(function (element) {
    element.style.width = sliderWidth + 'px';
})
//set width to be 'x' times the number of slides
var slider = document.querySelector('#slider-wrap ul#slider');
slider.style.width = sliderWidth * totalSlides + 'px';

// next, prev
var nextBtn = document.getElementById('next');
var prevBtn = document.getElementById('previous');
nextBtn.addEventListener('click', function () {
    plusSlides(1);
});
prevBtn.addEventListener('click', function () {
    plusSlides(-1);
});

// hover
slideWrapper.addEventListener('mouseover', function () {
    this.classList.add('active');
    clearInterval(autoSlider);
});
slideWrapper.addEventListener('mouseleave', function () {
    this.classList.remove('active');
    autoSlider = setInterval(function () {
        plusSlides(1);
    }, 5000);
});


function plusSlides(n) {
    showSlides(slideIndex += n);
}

function currentSlides(n) {
    showSlides(slideIndex = n);
}

function showSlides(n) {
    slideIndex = n;
    if (slideIndex == -1) {
        slideIndex = totalSlides - 1;
    } else if (slideIndex === totalSlides) {
        slideIndex = 0;
    }

    slider.style.left = -(sliderWidth * slideIndex) + 'px';
    pagination();
}

//pagination
slides.forEach(function () {
    var li = document.createElement('li');
    document.querySelector('#slider-pagination-wrap ul').appendChild(li);
})

function pagination() {
    var dots = document.querySelectorAll('#slider-pagination-wrap ul li');
    dots.forEach(function (element) {
        element.classList.remove('active');
    });
    dots[slideIndex].classList.add('active');
}

pagination();
var autoSlider = setInterval(function () {
    plusSlides(1);
}, 5000);
