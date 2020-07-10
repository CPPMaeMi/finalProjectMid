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
	<h1 style="text-align: center;">상영관 만들기</h1>
	<div id="roomMain">
		<div style="text-align: center;">
			<img src="${cp }/resources/images/join_logo_3.png"
				style="width: 80%;height: 150px;">
		</div>
		<div id="seatMain">
		</div>
	</div>
</div>
<script>
	$(function(){
		var seatMain=$(".seatMain");
		var i=0;
		<c:forEach var="vo" items="${list }">
			var theatherNum=${vo.theatherNum};
			var seatX=${vo.seatX};
			var seatY=${vo.seatY};
			var seatSale=${vo.seatSale};
			let btn=$("<button class='.seat'></button>");
		</c:forEach>
	});
</script>