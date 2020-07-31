<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
#room {
	width: 100%;
	height: 93%;
}

#roomMain {
	width: 70%;
	height: 90%;
	border: 1px solid gray;
	border-radius:10px;
	margin: auto;
	margin-top: 10px;
}

#seatMain {
	position: relative;
	margin: auto;
}

.seat {
	width: 45px;
	height: 45px;
	position: absolute;
}
#content{
	overflow: hidden;
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<div id="room">
	<h1 style="text-align: center;">배율 수정</h1>
	<div id="roomCreate" style="margin: auto; width: 40%">
		<div id="createDiv" style="padding-left: 140px;">
			<label for="optradio">할인율</label>
			<div class="form-check-inline">
				<label class="form-check-label"> <input type="radio" 
					class="form-check-input" name="optradio" value="80">80%
				</label>
			</div>
			<div class="form-check-inline">
				<label class="form-check-label"> <input type="radio"
					class="form-check-input" name="optradio" value="90">90%
				</label>
			</div>
			<div class="form-check-inline disabled">
				<label class="form-check-label"> <input type="radio"
					class="form-check-input" name="optradio" value="100">100%
				</label>
			</div>
			<div class="form-check-inline disabled">
				<label class="form-check-label"> <input type="radio"
					class="form-check-input" name="optradio" value="110">110%
				</label>
			</div>
			<button type="button" id="btn2" class="btn btn-primary btn-block" style="width: 100px; display: inline-block;">수정하기</button>
		</div>
	</div>
	<div id="roomMain">
		<div style="text-align: center;padding-top: 20px;">
			<img src="${cp }/resources/images/join_logo_3.png"
				style="width: 80%; height: 90px;">
		</div>
		<form id="sub"
			action="${cp }/room/seat/createUpdate.do?theatherNum=${theatherNum}"
			method="post">
			<div id="seatMain"></div>
		</form>
	</div>
</div>
<script>
	var seatMain = $("#seatMain");
	<c:forEach var="vo" items="${list }">
		var seatNum = '${vo.seatNum}';
		var seatX = '${vo.seatX}';
		var seatY = '${vo.seatY}';
		var seatSale = '${vo.seatSale}';
		var seatName = '${vo.seatName}';
		var btn = $("<input type='button' class='seat' value='"+seatName+"'></input>");
		if (seatSale == '80') {
			btn.css("backgroundColor", "#FFB646");
		} else if (seatSale == '90') {
			btn.css("backgroundColor", "#6dff00");
		} else if (seatSale == '110') {
			btn.css("backgroundColor", "pink");
		}
		btn.offset({
			top : seatY,
			left : seatX
		});
		seatMain.append(btn);
		btn.before("<input type='hidden' name='seatNum' value='"+seatNum+"'></input>");
		btn.before("<input type='hidden' name='seatSale' value='"+seatSale+"'></input>");
	</c:forEach>
	
	$("#seatMain").on("click", ".seat", function() {
		var radio = $("input[name='optradio']:checked").val();
		$(this).prev().val(radio);
		if (radio == '80') {
			$(this).css("backgroundColor", "#FFB646");
		} else if (radio == '90') {
			$(this).css("backgroundColor", "#6dff00");
		} else if (radio == '100') {
			$(this).css("backgroundColor", "white");
		} else if (radio == '110') {
			$(this).css("backgroundColor", "pink");
		}
	});
	
	$("#btn2").click(function() {
		$("#sub").submit();
	});
</script>