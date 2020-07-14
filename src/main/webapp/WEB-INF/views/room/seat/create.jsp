<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
#room {
	width: 100%;
	height: 93%;
}

#roomMain {
	width: 70%;
	height: 100%;
	float: left;
	border: 1px solid red;
	float: left;
	position: relative;
}

#seatMain {
	position: relative;
}

#roomCreate {
	width: 30%;
	height: 100%;
	float: left;
	border: 1px solid blue;
}

.seat {
	width: 45px;
	height: 45px;
	position: absolute;
}
</style>
<div id="room">
	<h1 style="text-align: center;">상영관 보기</h1>
	<div id="roomMain">
		<div style="text-align: center;">
			<img src="${cp }/resources/images/join_logo_3.png"
				style="width: 80%;">
		</div>
		<form id="sub"
			action="${cp }/room/seat/createOk.do?theatherNum=${vo.theatherNum}"
			method="post">
			<div id="seatMain"></div>
		</form>
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
			<div class="form-check-inline">
				<label class="form-check-label"> <input type="radio"
					class="form-check-input" name="optradio" value="100">100%
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
	var str = [ "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L",
			"M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y",
			"Z" ];
	var sale = [];
	$("#btn1")
			.click(
					function() {
						var line = parseInt($("#line").val());
						var heat = parseInt($("#heat").val());
						var spasce = Math.round(heat * 0.20);
						console.log("띄우는 칸의 기준" + spasce);
						//$("#btn").prop("disabled","disabled");
						var sMain = $("#seatMain");
						sMain.empty();
						var x = parseInt(50);
						var y = parseInt(50);
						for (let i = 0; i < line; i++) {
							for (let j = 1; j < heat + 1; j++) {
								x += 50;
								if (j == spasce + 1 || j == heat - spasce + 1) {
									x += 50;
								}
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
							x = 50;
							y += 50;
						}
					});

	$("#seatMain").on("click", ".seat", function() {
		var radio = $("input[name='optradio']:checked").val();
		$(this).prev().val(radio);
		if (radio == '80') {
			$(this).css("backgroundColor", "blue");
		} else if (radio == '90') {
			$(this).css("backgroundColor", "red");
		} else if (radio == '100') {
			$(this).css("backgroundColor", "transparent");
		} else if (radio == '110') {
			$(this).css("backgroundColor", "pink");
		}
	});

	$("#btn2").click(function() {
		$("#sub").submit();
	});
</script>