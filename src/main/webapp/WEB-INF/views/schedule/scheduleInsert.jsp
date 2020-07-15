<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<h1>상영스케줄편성</h1>
<!-- 조인해서 들고온 데이터 노출 -->
<div>
	<table border="1" style="width: 700px; text-align: center;">
		<c:forEach var="vo" items="${allList }">
			<tr>
				<th>포스터</th>
				<th>제목</th>
				<th>장르</th>
				<th>상영 종료일</th>
			</tr>
			<tr>
				<td><img src="${vo.movieimgUrl }"
					style="height: 300px; width: 200px;"></td>
				<td>${vo.filmName }</td>
				<td>${vo.genreName }</td>
				<td>${vo.filmDeadline }</td>
			</tr>
		</c:forEach>
	</table>
</div>
<!-- theather 노출 -->
<div>
	<form action="${cp }/schedule/scheduleInsert.do" method="post">
		<table border="1" class="theatherList" style="width: 700px; text-align: center;">
			<tr>
				<th>No.</th>
				<th>상영관명</th>
				<th>상영관 규모</th>
				<th>확인란</th>
			</tr>
			<c:forEach var="vo1" items="${vo1 }">
			<tr>
				<td>${vo1.theatherNum }</td>
				<td>${vo1.theatherName }</td>
				<td>${vo1.theatherSort }</td>
				<td><input type="checkbox" name="theatherNum" value="${vo1.theatherNum }"></td>
			</tr>
			</c:forEach>
		</table>
		<c:forEach var="vo" items="${allList }">
		<p>상영 시작 날짜 : <input type="date" min="${vo.purchaseDate }" max="${vo.filmDeadline }" name="date"> 시간 배치하기 : <input type="time" value="00:00:00" min="06:00:00" max="01:00:00" name="time"></p>
		</c:forEach>
		<button type="submit" class="btn btn-success" name="time2">추가하기</button>
	</form>
</div>
<script>
	$("button[name='time2']").on("click",function(){
		alert($("input[name='time']").val());
	});

</script>