<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="container-contact2">
	<div class="wrap-contact2">
		<form class="contact2-form validate-form" method="post"
			action="${cp }/room/seat/insertOk.do">
			<h1 style="text-align: center;"><span class="contact2-form-title">상영관생성 </span></h1> <input type="hidden"
				value="${branchNum }" name="${branchNum }">

			<div class="form-group">
				<label for="theatherName">상영관명</label> <input type="text"
					class="form-control" name="theatherName">
			</div>
			<div class="form-group">
				<label for="theatherSort">상영관종류</label> <input type="text"
					class="form-control" name="theatherSort">
			</div>
			<div class="container-contact2-form-btn">
				<div class="wrap-contact2-form-btn">
					<div class="contact2-form-bgbtn"></div>
					<button class="btn btn-danger">등록하기</button>
				</div>
			</div>
		</form>
	</div>
</div>
