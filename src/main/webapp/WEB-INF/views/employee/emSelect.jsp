<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<c:set var="i" value="0"/>
<div>
	<form action="${cp}/employee/emSelect.do" method="post">
		<fieldset class="mainFieldSet">
		  <legend>조건 검색</legend>
		  	<fieldset class="subFieldSet">
		  		<legend>지점</legend>
					<c:forEach items="${brList}" var="string">
						<input type="checkbox" name="br" class="br" value="${string}">
						<span class="checkbox-span">${string}</span>
						<c:set var="i" value="${i+1}"/>
						<c:if test="${i eq 10}">
							<br><c:set var="i" value="0"/>
						</c:if>
					</c:forEach>
			</fieldset>
			<fieldset class="subFieldSet">
				<legend>직원 타입</legend>
					<c:forEach items="${sfList}" var="string">
						<c:set var="i" value="0"/>
						<input type="checkbox" name="sf" class="sf" value="${string}">
						<span class="checkbox-span">${string}</span>
						<c:set var="i" value="${i+1}"/>
						<c:if test="${i eq 10}">
							<br><c:set var="i" value="0"/>
						</c:if>
					</c:forEach>
			</fieldset>
				<fieldset class="subFieldSet">
			  		<legend>부서</legend>
					<c:forEach items="${diList}" var="string">
						<c:set var="i" value="0"/>
						<input type="checkbox" name="di" class="di" value="${string}">
						<span class="checkbox-span">${string}</span>
						<c:set var="i" value="${i+1}"/>
						<c:if test="${i eq 10}">
							<br><c:set var="i" value="0"/>
						</c:if>
					</c:forEach>
				</fieldset>
			<input type="submit" value="검색">
		</fieldset>
	</form>
</div>
<div class="container">
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<div class="display-flex align-center">
				<h6 class="m-0 font-weight-bold text-primary">직원 현황</h6>
			</div>
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered" width="100%" cellspacing="0">
					<thead>
						<tr>
							<th>이름</th>
							<th>나이</th>
							<th>주소</th>
							<th>성별</th>
							<th>재직상태</th>
							<th>지점</th>
							<th>부서</th>
							<th>직원타입</th>
							<th>정보조회 및 수정</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="map">
							<tr>
								<td>${map.name}</td>
								<td>${map.age}</td>
								<td>${map.addr}</td>
								<td>${map.gender}</td>
								<td>${map.status}</td>
								<td>${map.brName}</td>
								<td>${map.division}</td>
								<td>${map.position}</td>
								<td data-toggle="modal" data-target="#squarespaceModal"
								 class="btn btn-primary center-block">go</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>

<!-- 페이징 처리 -->
<div>
	<c:choose>
		<c:when test="${pu.startPageNum>5}">
			<c:choose>
				<c:when test="${br != null and sf != null and di != null}">
					<a href="${cp}/employee/emSelect.do?pageNum=${pu.startPageNum-1}<c:forEach items='${br}' var='y'>&br=${y}</c:forEach><c:forEach items='${sf}' var='y'>&sf=${y}</c:forEach><c:forEach items='${di}' var='y'>&di=${y}</c:forEach>">
					<span style="color:blue">
					[이전]</span></a>
				</c:when>
				<c:otherwise>
					<a href="${cp}/employee/emSelect.do?pageNum=${i}">
					<span style="color:blue">
					[이전]</span></a>
				</c:otherwise>
			</c:choose>
		</c:when>
		<c:otherwise>
			[이전]
		</c:otherwise>
	</c:choose>
	<c:forEach begin="${pu.startPageNum}" end="${pu.endPageNum}" var="i">
		<c:choose>
			<c:when test="${br != null and sf != null and di != null}">
				<c:choose>
					<c:when test="${i == pu.pageNum}">
						<a href="${cp}/employee/emSelect.do?pageNum=${i}<c:forEach items='${br}' var='y'>&br=${y}</c:forEach><c:forEach items='${sf}' var='y'>&sf=${y}</c:forEach><c:forEach items='${di}' var='y'>&di=${y}</c:forEach>">
						<span style="color:blue">
						[${i}]</span></a>
					</c:when>
					<c:otherwise>
						<a href="${cp}/employee/emSelect.do?pageNum=${i}<c:forEach items='${br}' var='y'>&br=${y}</c:forEach><c:forEach items='${sf}' var='y'>&sf=${y}</c:forEach><c:forEach items='${di}' var='y'>&di=${y}</c:forEach>">
						<span style="color:gray">
						[${i}]</span></a>
					</c:otherwise>
				</c:choose>
			</c:when>
			<c:otherwise>
				<c:choose>
					<c:when test="${i==pageNum}">
						<a href="${cp}/employee/emSelect.do?pageNum=${i}">
						<span style="color:blue">
						[${i}]</span></a>
					</c:when>
					<c:otherwise>
						<a href="${cp}/employee/emSelect.do?pageNum=${i}">
						<span style="color:gray">
						[${i}]</span></a>
					</c:otherwise>
				</c:choose>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	<c:choose>
		<c:when test="${pu.totalPageCount>pu.endPageNum}">
			<c:choose>
				<c:when test="${br != null and sf != null and di != null}">
					<a href="${cp}/employee/emSelect.do?pageNum=${pu.endPageNum+1}<c:forEach items='${br}' var='y'>&br=${y}</c:forEach><c:forEach items='${sf}' var='y'>&sf=${y}</c:forEach><c:forEach items='${di}' var='y'>&di=${y}</c:forEach>">
					<span style="color:blue">
					[다음]</span></a>
				</c:when>
				<c:otherwise>
					<a href="${cp}/employee/emSelect.do?pageNum=${pu.endPageNum+1}">
					<span style="color:blue">
					[다음]</span></a>
				</c:otherwise>
			</c:choose>
		</c:when>
		<c:otherwise>
			[다음]
		</c:otherwise>
	</c:choose>
</div>

<!-- modal -->
<div class="modal fade" id="squarespaceModal" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
  <div class="modal-dialog">
	<div class="modal-content">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
			<h3 class="modal-title" id="lineModalLabel">직원정보 수정</h3>
		</div>
		<div class="modal-body">
		
            <!-- content goes here -->
			<form>
              <div class="form-group">
                <label for="exampleInputPassword1">주소</label>
                <input type="password" class="form-control" id="exampleInputPassword1" placeholder="addr">
              </div>
              <div class="form-group">
                <label for="exampleInputPassword1">계좌번호</label>
                <input type="password" class="form-control" id="exampleInputPassword1" placeholder="account">
              </div>
              <div class="form-group">
              	 <label for="emStatus">재직상태</label>
              	 <select class="modalSelect" id="emStatus">
	              	<option>재직</option>
	              	<option>퇴직</option>
             	 </select>
              </div>
              <div class="form-group">
              	 <label for="brName">지점</label>
              	 <select class="modalSelect" id="brName" style="left:82px">  
	              	<c:forEach var="i" items="${brList}">
	              		<option value="${i}">${i}</option>
	              	</c:forEach>
             	 </select>
              </div>
              <div class="form-group">
              	 <label for="emDivision">부서</label>
              	 <select class="modalSelect" id="emDivision" style="left:82px">
	              	<c:forEach var="i" items="${diList}">
	              		<option value="${i}">${i}</option>
	              	</c:forEach>
             	 </select>
              </div>
              <div class="form-group">
              	 <label for="emType">직원타입</label>
              	 <select class="modalSelect" id="emType">
	              	<c:forEach var="i" items="${sfList}">
	              		<option value="${i}">${i}</option>
	              	</c:forEach>
             	 </select>
              </div>
              <button type="submit" class="btn btn-default">Submit</button>
            </form>
		
		</div>
		<div class="modal-footer">
			<div class="btn-group btn-group-justified" role="group" aria-label="group button">
				<div class="btn-group" role="group">
					<button type="button" class="btn btn-default" data-dismiss="modal"  role="button">Close</button>
				</div>
				<div class="btn-group" role="group">
					<button type="button" id="saveImage" class="btn btn-default btn-hover-green" data-action="save" role="button">Save</button>
				</div>
			</div>
		</div>
	</div>
  </div>
</div>
<script>

</script>