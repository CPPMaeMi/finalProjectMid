<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<style>
.alltable {
	background-color: MediumSeaGreen;
	border: 1px solid black;
	width: auto;
	margin-left: 200px;
	margin-right: 200px;
}

.datetable {
	display: inline-block;
	font-family: fantasy;
}

.timetable {
	display: inline-block;
	border: 1px solid Gray;
	height: 43px;
	width: 72px;
	text-shadow: bold;
}

.medium{
	background-color: yellow;
}

.dateyoo{
	align-content: center;
    background-color: blue;
    width: fit-content;
    margin-left: 15%;
}
</style>
<div class="alltable">
			<div class="dateyoo">
			<c:forEach var="week" items="${weeklist }">
				<a href="${cp }/schedule/scheduleInsert.do?branchNum=1&regDate=${week}">
				<button type="button" name="choice" class="btn btn-light" style="border: 2px solid red;">
				${week }</button></a>
			</c:forEach>
			</div>
			<div class="midieum">
				<c:set var="checkName" value="null" />
				<c:set var="checkTheather" value="0" />
				<c:forEach var="vo" items="${list }">
					<c:if test="${vo.FILMNAME != checkName }">
						<div><br><h2>${vo.FILMNAME }</h2></div>
					</c:if>
					<c:if test="${vo.THEATHERNUM != checkTheather }">
							<p>${vo.THEATHERNAME }
					<c:forEach var="seat" items="${scount }">
						<c:if test="${vo.THEATHERNUM==seat.THEATHERNUM }">
						${seat.CNT }석</p></c:if></c:forEach>
									</c:if>		
		
				<div class="timetable">
					<fmt:formatDate value="${vo.MSTARTTIME }" pattern="HH:mm" var="mstarttime" />
					<p style="font-size: 12px; font-family: sans-serif; font-color: #333333; text-align: center; text-decoration-color: darkslategray;">${mstarttime }</p>
				</div>
				<c:set var="checkName" value="${vo.FILMNAME }" />
				<c:set var="checkTheather" value="${vo.THEATHERNUM }" />
			</c:forEach>
		<br>
	</div>
</div>	