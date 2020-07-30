<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.who{
	overflow-y: scroll;
    height: 766px;
}
.filminfo {

}
table{
	width : 100%;
	border-top:1px solid #444444;
	broder-collapse: collapse;
}
 tr, td{
 	border-bottom : 1px solid #444444;
 	padding : 10px;

 
 }
 th{
  	text-align:center;
  	background-color: LightGray;
 }

</style>
<center>
<!-- 조인해서 들고온 데이터 노출 -->
<div class="who">
<h1>상영 스케줄 편성</h1>
<div class="filminfo">
	<table style="width: 700px; text-align:center;">
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
	</table>
</div>
<!-- theather 노출 -->
<p></p>
<div class="rownow">
	<!-- branchNum 지점번호 값 수정할것 -->
	<form action="${cp }/schedule/scheduleInsert.do" method="post">
		<table style="width: 700px; text-align: center;">
			<tr>
				<th>No.<input type="hidden" name="branchNum" value="${vo.branchNum }"></th>
				<th>상영관명</th>
				<th>상영관 규모</th>
				<th>확인란</th>
			</tr>
			<c:forEach var="vo1" items="${vo1 }">
			<tr>
				<td>${vo1.theatherNum }</td>
				<td>${vo1.theatherName }</td>
				<td>${vo1.theatherSort }</td>
				<td><input type="checkbox" class="thNum"
				 <c:if test="${vo1.live!=0 }">disabled</c:if>
				 value="${vo1.theatherNum }" name="theatherNum" ></td>				
				<input type="hidden" name="purchasefilmNum" value="${vo.purchasefilmNum }">
				<input type="hidden" name="filmDeadline" value="${vo.filmDeadline }">
			</tr>
			</c:forEach>
		</table>
		<p></p>
		<div class="button-collect">
			<p>상영 시작 날짜 : <input type="date" min="${vo.purchaseDate }" max="${vo.filmDeadline }" name="date"> 
			시간 배치하기 : <input type="time" value="00:00:00" min="06:00:00" max="01:00:00" name="time"></p>
			<button type="submit" class="btn btn-success" name="time2" id="time2">추가하기</button>
		</div>
	</form>
</div>
</div>
<script type="text/javascript">
	$("button[name='time2']").on("click",function(){
		alert($("input[name='date']").val());
	});
	
	/*
	$(".thNum").click(function(){
		$("input[type='checkbox']").each(function(){
			var check=$(this).val();
			if($(this).is(":checked")){
				alert("되냐:"+check);
			}	
		});
	});
	*/
</script>
</center>
