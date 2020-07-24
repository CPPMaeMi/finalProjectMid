<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="container">
	<div class="row1">
		<div class="col-12">
			<table id="filmlist" class="table table-image">
				<thead>
					<tr>
						<th scope="col">No.</th>
						<th scope="col">포스터</th>
						<th scope="col">영화제목</th>
						<th scope="col">감독</th>
						<th scope="col">상태</th>
						<th scope="col">관리하기</th>
						<th scope="col">상영종료일</th>
						<th scope="col">판권종료일</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="vo" items="${branchList}">
						<tr>
							<th scope="row">${vo.RNUM}</th>
							<td class="w-25"><img src="${vo.MOVIEIMGURL}"
								class="img-fluid img-thumbnail" alt="Sheep" class="image"
								style="height: 158px; width: 110px;"></td>
							<td>${vo.FILMNAME}</td>
							<td>${vo.FILMHEAD }</td>
							<td>${vo.FILMSTATUS}</td>
							<jsp:useBean id="myDate" class="java.util.Date"/>
								<c:set target="${myDate}" property="time" value="${vo.FILMDEADLINE }"/>
								<fmt:formatDate var="filmDeadline" value="${myDate}" pattern="yyyy-MM-dd"/> 
							<c:set var="now" value="<%=new java.util.Date()%>" />
							<c:choose>
								<c:when test="${now<myDate }">
								<td><a
									href="${cp }/schedule/showScheduleList.do?branchNum=1&purchasefilmNum=${vo.PURCHASEFILMNUM}"><button
											type="button" class="btn btn-primary">스케쥴 관리</button></a></td>
							</c:when>
							<c:otherwise>
								<td><button type="button" class="btn btn-secondary">상영
										종료</button></td>
							</c:otherwise>
							</c:choose>
							<td>${filmDeadline}</td>
							<c:set target="${myDate}" property="time" value="${vo.FILMEND }"/>
								<fmt:formatDate var="filmEnd" value="${myDate}" pattern="yyyy-MM-dd"/> 
							<td>${filmEnd}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
