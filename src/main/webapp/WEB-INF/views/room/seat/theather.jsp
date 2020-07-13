<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="${cp }/resources/js/jquery-3.5.1.js"></script>
<div class="container">
		<div class="container-contact2">
				<span class="contact2-form-title"> 상영관목록 </span>
				<p></p>
				<table class="table table-dark table-striped">
					<thead>
						<tr>
							<th>상영관명</th>
							<th>상영관규모</th>
							<th>수정</th>
							<th>삭제</th>
							<th>비고</th>
						</tr>
					</thead>
					<tbody>
						<c:set var="i" value="0"/>
						<c:forEach var="vo" items="${list }">
							<tr>
								<td>${vo.theatherName }</td>
								<td>${vo.theatherSort }</td>
								<td><a href="${cp }/room/seat/delete.do?theatherNum=${vo.theatherNum}">삭제</a></td>
								<td><a href="${cp }/room/seat/update.do?theatherNum=${vo.theatherNum}">수정</a></td>
								<c:choose>
									<c:when test="${blist.get(i) == 'true' }">
										<td><a href="${cp }/room/seat/search.do?theatherNum=${vo.theatherNum}">확인하기</a></td>
									</c:when>
									<c:otherwise>
										<td><a href="${cp }/room/seat/create.do?theatherNum=${vo.theatherNum}">만들기</a></td>
									</c:otherwise>
								</c:choose>
							</tr>	
							<c:set var="i" value="${i+1 }"/>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<a href="${cp }/room/seat/theatherInsert.do?branchNum=${branchNum }">
			<button type="button" class="btn btn-danger">상영관 추가</button></a>
</div>
