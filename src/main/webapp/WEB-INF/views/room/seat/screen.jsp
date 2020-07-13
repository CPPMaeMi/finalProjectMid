<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
#room {
	width: 100%;
	height: 93%;
}

#roomMain {
	width: 100%;
	height: 100%;
	float: left;
	border: 1px solid red;
	float: left;
	position: relative;
}

#seatMain {
	position: relative;
}

.seat {
	width: 45px;
	height: 45px;
	position: absolute;
}
</style>
<div id="room">
	<h1 style="text-align: center;">상영관 수정</h1>
	<div id="roomMain">
		<div style="text-align: center;">
			<img src="${cp }/resources/images/join_logo_3.png"
				style="width: 80%; height: 150px;">
		</div>
		<div id="seatMain"></div>
	</div>
	<div id="roomCreate">
		<div class="form-group">
			<label for="line">행</label> <input type="number" class="form-control"
				id="line">
		</div>
		<div class="form-group">
			<label for="heat">열</label> <input type="number" class="form-control"
				id="heat">
		</div>
		<button type="button" id="btn1" class="btn btn-primary btn-block">만들기</button>
		<div id="createDiv">
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
					class="form-check-input" name="optradio" value="110">110%
				</label>
			</div>
			<button type="button" id="btn2" class="btn btn-primary btn-block">저장하기</button>
		</div>
	</div>
</div>
<script>
	var seatMain=$(".seatMain");
	<c:forEach var="vo" items="${list }">
		var seatX=${vo.seatX};
		var seatY=${vo.seatY};
		var seatSale=${vo.seatSale};
		var seatName="${vo.seatName}";
		var btn=$("<input type='button' class='seat'>"+seatName+"</input>").appendTo(seatMain);
//		var btn=document.createElement("input");
//		btn.className("seat");
//		btn.val(seatName);
		btn.offset({
			top : seatY,
			left : seatX
		});
	</c:forEach>

	function() {
		var sMain = $("#seatMain");
		var seatX=${vo.seatX};
		var seatY=${vo.seatY};
		var seatSale=${vo.seatSale};
		var seatName="${vo.seatName}";
		sMain.empty();
		for (let i = 0; i < ${list.length}; i++) {
				var seatBtn = $("<input type='button' class='seat'></input>");
				seatBtn.offset({
					top : y,
					left : x
				});
				seatBtn.val(str[i] + j);
				sMain.append(seatBtn);
				seatBtn
						.before("<input type='hidden' name='seatName' value="+str[i]+j+"></input>");
				seatBtn
						.before("<input type='hidden' name='seatX' value="+x+"></input>");
				seatBtn
						.before("<input type='hidden' name='seatY' value="+y+"></input>");
				seatBtn
						.before("<input type='hidden' name='seatSale' value='100'></input>");
		}

$("#seatMain").on("click", ".seat", function() {
var radio = $("input[name='optradio']:checked").val();
$(this).prev().val(radio);
if (radio == '80') {
$(this).css("backgroundColor", "blue");
} else if (radio == '90') {
$(this).css("backgroundColor", "red");
} else if (radio == '110') {
$(this).css("backgroundColor", "pink");
}
});

	
</script>