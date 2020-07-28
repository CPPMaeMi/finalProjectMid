<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<c:set var="i" value="0"/>
<div>
	<form action="${cp}/employee/emSelect.do" method="get">
		<fieldset class="mainFieldSet">
		  <legend>조건 검색</legend>
		  	<fieldset class="subFieldSet">
		  		<legend>지점</legend>
					<c:forEach items="${brList}" var="string">
						<label><input type="checkbox" name="br" class="br" value="${string}" 
						<c:forEach var="y" items="${br}"><c:if test="${y==string}">checked="checked"</c:if></c:forEach>>
						<span class="checkbox-span">${string}</span></label>
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
						<label><input type="checkbox" name="sf" class="sf" value="${string}"
						<c:forEach var="y" items="${sf}"><c:if test="${y==string}">checked="checked"</c:if></c:forEach>>
						<span class="checkbox-span">${string}</span></label>
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
						<label><input type="checkbox" name="di" class="di" value="${string}" 
						<c:forEach var="y" items="${di}"><c:if test="${y==string}">checked="checked"</c:if></c:forEach>>
						<span class="checkbox-span">${string}</span></label>
						<c:set var="i" value="${i+1}"/>
						<c:if test="${i eq 10}">
							<br><c:set var="i" value="0"/>
						</c:if>
					</c:forEach>
				</fieldset>
			<div>
				<ul id="searchUl"></ul>
				<input type="button" id="searchClear" value="조건 제거">
			</div>
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
								 class="btn btn-primary center-block" 
								 data-addr="${map.addr}" data-brnum="${map.brNum}"
								 data-account="${map.account}" data-brname="${map.brName}">go</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>

<!-- 페이징 처리 -->
<div class="emSelect-div">
	<c:if test="${pu.startPageNum>5}">
		<c:choose>
			<c:when test="${br != null or sf != null or di != null}">
				<a class="emSelect-first" href="${cp}/employee/emSelect.do?pageNum=${pu.startPageNum-1}<c:forEach items='${br}' var='y'>&br=${y}</c:forEach><c:forEach items='${sf}' var='y'>&sf=${y}</c:forEach><c:forEach items='${di}' var='y'>&di=${y}</c:forEach>">
				&lt;&lt;</a>
			</c:when>
			<c:otherwise>
				<a class="emSelect-first" href="${cp}/employee/emSelect.do?pageNum=${i}">
				&lt;&lt;</a>
			</c:otherwise>
		</c:choose>
	</c:if>
	<c:forEach begin="${pu.startPageNum}" end="${pu.endPageNum}" var="i">
		<c:choose>
			<c:when test="${br != null or sf != null or di != null}">
				<c:choose>
					<c:when test="${i == pu.pageNum}">
						<a style="color:#2a2a2a;" class='emSelect-paging' href="${cp}/employee/emSelect.do?pageNum=${i}<c:forEach items='${br}' var='y'>&br=${y}</c:forEach><c:forEach items='${sf}' var='y'>&sf=${y}</c:forEach><c:forEach items='${di}' var='y'>&di=${y}</c:forEach>">
						${i}</a>
					</c:when>
					<c:otherwise>
						<a class='emSelect-paging' href="${cp}/employee/emSelect.do?pageNum=${i}<c:forEach items='${br}' var='y'>&br=${y}</c:forEach><c:forEach items='${sf}' var='y'>&sf=${y}</c:forEach><c:forEach items='${di}' var='y'>&di=${y}</c:forEach>">
						${i}</a>
					</c:otherwise>
				</c:choose>
			</c:when>
			<c:otherwise>
				<c:choose>
					<c:when test="${i==pu.pageNum}">
						<a style="color:#2a2a2a;" class='emSelect-paging' href="${cp}/employee/emSelect.do?pageNum=${i}">
						${i}</a>
					</c:when>
					<c:otherwise>
						<a class='emSelect-paging' href="${cp}/employee/emSelect.do?pageNum=${i}">
						${i}</a>
					</c:otherwise>
				</c:choose>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	<c:if test="${pu.totalPageCount>pu.endPageNum}">
		<c:choose>
			<c:when test="${br != null or sf != null or di != null}">
				<a class="emSelect-last" href="${cp}/employee/emSelect.do?pageNum=${pu.endPageNum+1}<c:forEach items='${br}' var='y'>&br=${y}</c:forEach><c:forEach items='${sf}' var='y'>&sf=${y}</c:forEach><c:forEach items='${di}' var='y'>&di=${y}</c:forEach>">
				&gt;&gt;</a>
			</c:when>
			<c:otherwise>
				<a class="emSelect-last" href="${cp}/employee/emSelect.do?pageNum=${pu.endPageNum+1}">
				&gt;&gt;</a>
			</c:otherwise>
		</c:choose>
	</c:if>
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
			<form action="${cp}/employee/emUpdateOk.do">
			  <!-- 나중에 지점번호로 value 값주기 -->
			  <input type="hidden" name="staffNum" id="staffNum" value="1">
			  <div class="form-group">
                <label for="brName">이름</label>
                <input type="text" class="form-control" id="brName" readonly="readonly">
              </div>
              <div class="form-group">
                <label for="employeeAddr">주소</label>
                <input name="addr" type="text" class="form-control" id="employeeAddr" 
                placeholder="주소" >
              </div>
              <div class="form-group">
                <label for="employeeAccount">계좌번호</label>
                <input name="account" type="text" class="form-control" id="employeeAccount" 
                placeholder="계좌번호">
              </div>
              <div class="form-group">
              	 <label for="emStatus">재직상태</label>
              	 <select name="status" class="modalSelect" id="emStatus">
	              	<option value="재직">재직</option>
	              	<option value="휴직">휴식</option>
	              	<option value="퇴직">퇴직</option>
             	 </select>
              </div>
              <!--<div class="form-group">
              	 <label for="brName">지점</label>
              	 <select name="branchNum" class="modalSelect" id="brName" style="left:82px">  
	              	<c:forEach var="i" items="${brList}" varStatus="status">
	              		<option value="${status.count}">${i}</option>
	              	</c:forEach>
             	 </select>
              </div>-->
              <div class="form-group">
              	 <label for="emDivision">부서</label>
              	 <select name="divisionNum" class="modalSelect" id="emDivision" style="left:82px">
	              	<c:forEach var="i" items="${diList}" varStatus="status">
	              		<option value="${status.count}">${i}</option>
	              	</c:forEach>
             	 </select>
              </div>
              <div class="form-group">
              	 <label for="emType">직원타입</label>
              	 <select name="sffNum" class="modalSelect" id="emType" >
	              	<c:forEach var="i" items="${sfList}" varStatus="status">
	              		<option value="${status.count}">${i}</option>
	              	</c:forEach>
             	 </select>
              </div>
              <button type="submit" class="btn btn-default">수정</button>
            </form>
		
		</div>
		<div class="modal-footer">
			<div class="btn-group btn-group-justified" role="group" aria-label="group button">
				<div class="btn-group" role="group">
					<button type="button" class="btn btn-default" data-dismiss="modal"  role="button">X</button>
				</div>
				<div class="btn-group" role="group">
					<button type="button" id="saveImage" class="btn btn-default btn-hover-green" data-action="save" role="button">O</button>
				</div>
			</div>
		</div>
	</div>
  </div>
</div>