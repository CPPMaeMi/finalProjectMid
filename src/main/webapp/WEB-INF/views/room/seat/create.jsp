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
}
</style>

<div id="room">
	<h1 style="text-align: center;">상영관 만들기</h1>
	<div id="roomMain">
		<div style="text-align: center;">
			<img src="${cp }/resources/images/join_logo_3.png"
				style="width: 80%;">
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
		<button type="button" id="btn" class="btn btn-primary btn-block">만들기</button>
		<div id="createDiv">
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
		</div>
	</div>
</div>
<script>
	var str = [ "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L",
			"M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y",
			"Z" ];
	var sale = [];
	$("#btn")
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
						for (let i = 0; i < line + 1; i++) {
							for (let j = 1; j < heat + 1; j++) {
								x += 50;
								if (j == spasce + 1 || j == heat - spasce + 1) {
									x += 50;
								}
								var seatBtn = $("<button class='seat' onclick='sale()'></button>");
								seatBtn.offset({
									top : y,
									left : x
								});
								seatBtn.append(str[i] + j);
								sMain.append(seatBtn);
							}
							x = 50;
							y += 50;
						}
					});

	$("#seatMain").on("click", ".seat", function() {
		var radio=$("input[name='optradio']:checked").val();
		if(radio=='80'){
			
		}else if(radio=='90'){
			
		}else if(radio=='110'){
			alert(radio);
		}
	});
</script>