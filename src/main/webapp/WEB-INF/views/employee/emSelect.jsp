<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container">
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<div class="display-flex align-center">
				<h6 class="m-0 font-weight-bold text-primary">직원 현황</h6>
				<div class="ml-auto display-flex align-center">
					<input type="text" name="" class="form-control"
						placeholder="Search">
					<button class="btn btn-md btn-primary ml-2">Search</button>
				</div>
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
              	 <label for="emDivision">부서</label>
              	 <select class="modalSelect" id="emDivision" style="left:82px">
	              	<option>영업부</option>
	              	<option>미화부</option>
	              	<option>인사부</option>
             	 </select>
              </div>
              <div class="form-group">
              	 <label for="emType">직원타입</label>
              	 <select class="modalSelect" id="emType">
	              	<option>점장</option>
	              	<option>정직원</option>
	              	<option>파트타이머</option>
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