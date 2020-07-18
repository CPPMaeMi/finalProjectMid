<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div>
<h1>야호~ 입력이 됐다네요~~~</h1>
<h1>달력 만들어주실분</h1>
<h2>구합니다</h2>
	<c:forEach var="week" items="${weeklist }">
		<a href="${cp }/schedule/scheduleInsert.do?branchNum=1&regDate=${week}"><div style="display: inline-block;border: 2px solid yellow;">${week }</div></a>
	</c:forEach>
	<div>
		<c:set var="checkName" value="null"/>
		<c:set var="checkTheather" value="0"/>
		<c:forEach var="vo" items="${list }">
			<c:if test="${vo.FILMNAME != checkName }">
				<div>${vo.FILMNAME }</div>
			</c:if>
			<c:if test="${vo.THEATHERNUM != checkTheather }">
				<div>
					<h4>${vo.THEATHERNAME }</h4>
				</div>
			</c:if>
			<div style="display: inline-block;border: 3px solid red;">
				<p>${vo.MSTARTTIME }</p>
			</div>
			<c:set var="checkName" value="${vo.FILMNAME }"/>
			<c:set var="checkTheather" value="${vo.THEATHERNUM }"/>
		</c:forEach>
	</div>
</div>