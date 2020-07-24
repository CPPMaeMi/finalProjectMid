<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<style>
.alltable {
	background-color: white;
	width: auto;
	margin-left: 200px;
	margin-right: 200px;
    height: -webkit-fill-available;
	overflow-y:scroll;
}
.alltable::-webkit-scrollbar {
	display: none;
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
    background-color: white;
    width: fit-content;
    padding-top: 1%;
    padding-bottom: 1%;
}
.line{
	width:100%;
	height:1px;
	background: black;
}
.fname{
	padding-right: 10px;
	border-right: 2px;
	border-right-color: white;
	display:inline-block;
	width:auto;
}
p {
    margin-top: 0;
    margin-bottom: 0rem;
}
</style>
<div class="alltable">
			<div class="dateyoo">
			<a href="${cp }/schedule/scheduleInsert.do?branchNum=1&regDate=${prevDate}">
				<button type="button" name="choice" class="btn btn-light" style="font-family: fantasy;">
				${prevDate }</button></a>
			<c:forEach var="week" items="${weeklist }" varStatus="i">
				<a href="${cp }/schedule/scheduleInsert.do?branchNum=1&regDate=${week}">
				<button type="button" name="choice" class="btn btn-light" style="font-family: fantasy;<c:if test="${i.index==0 }">background-color:gray;</c:if>">
				${week }</button></a>
			</c:forEach>
			</div>
			<div class="line"></div>
			<div class="midieum">
				<c:set var="checkName" value="null" />
				<c:set var="checkTheather" value="0" />
				<c:forEach var="vo" items="${list }">
					<c:if test="${vo.FILMNAME != checkName }">
						<div><br><h2>${vo.FILMNAME }</h2></div>
					</c:if>
					<c:if test="${vo.THEATHERNUM != checkTheather }">
							<p>▶ ${vo.THEATHERNAME }
					<c:forEach var="seat" items="${scount }">
						<c:if test="${vo.THEATHERNUM==seat.THEATHERNUM }">
						| ${seat.CNT }석 <span class="badge badge-success">예매중</span></p></c:if></c:forEach>
						</c:if>		
		
				<div class="timetable">
						<jsp:useBean id="myDate" class="java.util.Date"/>
							<c:set target="${myDate}" property="time" value="${vo.MSTARTTIME }"/>
							<fmt:formatDate value="${myDate }" pattern="HH:mm" var="mstarttime" />
					<p style="font-size: 12px; font-family: sans-serif; font-color: #333333; text-align: center; text-decoration-color: darkslategray;">${mstarttime }</p>
				</div>
				<c:set var="checkName" value="${vo.FILMNAME }" />
				<c:set var="checkTheather" value="${vo.THEATHERNUM }" />
			</c:forEach>
		<br>
	</div>
</div>	