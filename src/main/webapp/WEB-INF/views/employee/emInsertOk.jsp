<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<div class="container">
	<div class="row">
		<div class="modal fade" id="ignismyModal" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="">
							<span>×</span>
						</button>
					</div>
					<div class="modal-body">
						<div class="thank-you-pop">
							<c:choose>
								<c:when test="${code != null}">
									<img
									src="http://goactionstations.co.uk/wp-content/uploads/2017/03/Green-Round-Tick.png"
									alt="success">
									<h1>직원등록 성공</h1>
									<p>Your submission is received and we will contact you soon</p>
									<h3 class="cupon-pop">
										직원등록: <span>${sffName}님</span>
									</h3>
								</c:when>
								<c:when test="${code2 != null}">
									<img
									src="http://goactionstations.co.uk/wp-content/uploads/2017/03/Green-Round-Tick.png"
									alt="success">
									<h1>정보수정 성공</h1>
									<p>Your submission is received and we will contact you soon</p>
								</c:when>
							</c:choose>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script>
	$(function() {
		$("#ignismyModal").modal();
		//modal 꺼지면 이벤트 발생 
		$(".modal").on('hidden.bs.modal',function(){
			location.href="${cp}";
		});
	});
</script>