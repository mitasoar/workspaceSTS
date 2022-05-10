<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
전과/복전 화면
<div class="container">
	<table class="table">
		<colgroup>
			<col>
			<col>
			<col>
			<col>
			<col>
			<col>
			<col>
			<col>
			<col>
			<col>
			<col>
		</colgroup>
		<thead>
			<tr>
				<th>No</th>
				<th>소속대학</th>
				<th>소속학과</th>
				<th>학번</th>
				<th>이름</th>
				<th>학년</th>
				<th>학적상태</th>
				<th>변경대학</th>
				<th>변경학과</th>
				<th>신청상태</th>
				<th>신청일</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>2</td>
				<td>자연과학대학</td>
				<td>생명과학화학부</td>
				<td>STU_1</td>
				<td>김자바</td>
				<td>3</td>
				<td>재학</td>
				<td>인문과학대학</td>
				<td>국어국문학과</td>
				<!-- 신청상태열의 버튼 클릭시 modal 실행 -->
				<td><input type="button" value="승인완료" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop"></td>
				<td>2022-04-19</td>
			</tr>
			<tr>
				<td>1</td>
				<td>자연과학대학</td>
				<td>생명과학화학부</td>
				<td>STU_2</td>
				<td>이이이</td>
				<td>3</td>
				<td>재학</td>
				<td>인문과학대학</td>
				<td>국어국문학과</td>
				<td><input type="button" value="처리대기" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop"></td>
				<td>2022-04-19</td>
			</tr>
		</tbody>
	</table>
	
	<!-- 신청상태열의 버튼 클릭시 나타나는 modal -->
	<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="staticBackdropLabel">Modal title</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<table class="table">
						<colgroup>
							<col>
							<col>
							<col>
						</colgroup>
						<tr>
							<td>학번</td>
							<td colspan="2">STU_1<td>
						</tr>
						<tr>
							<td>이름</td>
							<td colspan="2">김자바<td>
						</tr>
						<tr>
							<td>학년</td>
							<td colspan="2">2<td>
						</tr>
						<tr>
							<td>기존 소속</td>
							<td>제 1 전공<br>인문과학대학 경영학과<td>
							<td>제 2 전공<br>없음<td>
						</tr>
						<tr>
							<td>변경 소속</td>
							<td>제 1 전공<br>인문과학대학 경영학과<td>
							<td>제 2 전공<br>자연과학대학 생물학과<td>
						</tr>
						<tr>
							<td>신청사유</td>
							<td colspan="2">그냥!</td>
						</tr>
					</table>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
					<button type="button" class="btn btn-primary">저장</button>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>