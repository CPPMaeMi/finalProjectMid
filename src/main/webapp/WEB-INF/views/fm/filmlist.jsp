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
						<th scope="col">장르</th>
						<th scope="col">감독</th>
						<th scope="col">개봉일</th>
						<th scope="col">종료일</th>
						<th scope="col">상태</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="vo" items="${list}">
						<tr>
							<th scope="row">${vo.FILMNUM}</th>
							<td class="w-25"><a
								href="${cp}/fm/filmdetail.do?filmNum=${vo.FILMNUM}&genreNum=${vo.GENRENUM}&buy=${vo.BUY}">
									<img src="${vo.MOVIEIMGURL}" class="img-fluid img-thumbnail"
									alt="Poster" class="image" style="height: 158px; width: 110px;">
							</a></td>
							<td>${vo.FILMNAME}</td>
							<td>${vo.GENRENAME }</td>
							<td>${vo.FILMHEAD}</td>
							<fmt:formatDate value="${vo.FILMSTART}" pattern="yyyy-MM-dd"
								var="filmStart" />
							<td>${filmStart}</td>
							<fmt:formatDate value="${vo.FILMEND}" pattern="yyyy-MM-dd"
								var="filmEnd" />
							<td>${filmEnd}</td>
							<td>${vo.FILMSTATUS}</td>
							<td></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div>
				<ul class="pagination justify-content-center" style="margin: 20px 0">
					<c:forEach var="i" begin="${pu.startPageNum }"
						end="${pu.endPageNum }">
						<c:choose>
							<c:when test="${i==pu.pageNum }">
								<li class="page-item active"><a class="page-link"
									href="/projectMid/fm/filmlist.do?pageNum=${i }">${i }</a></li>
							</c:when>
							<c:otherwise>
								<li class="page-item"><a class="page-link"
									href="/projectMid/fm/filmlist.do?pageNum=${i }">${i }</a></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
</div>
