<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="/project/resources/css/scheduler.css" rel="stylesheet" id="bootstrap-css">
<script src="https://code.jquery.com/jquery-3.3.1.min.js" type="text/javascript"></script>

<h1 style="text-align: center; margin-top: 30px;">- 근 무 관 리 -</h1>
<div class="container">
	<div class="table-wrapper">
		<div class="table-title">
			<div class="row">
				<div class="col-sm-8"><h2><b>일 간 근 무 표</b></h2></div>
				<div class="col-sm-5"><input type="date" id="checkdate" name="checkdate">
				<input type="button" id="datecheck" name="datecheck" value="검색">
				</div>
				<div class="col-sm-4">
					 <div class="center"><button id="btn1" data-toggle="modal" data-target="#squarespaceModal" class="btn btn-info add-new"><i class="fa fa-plus"></i> Add New</button></div>
				</div>
            </div>
		</div>
		<table class="table table-bordered" id="sctable">
			<thead>
				<tr>
					<th>이름</th>
					<th>부서</th>
					<th>파트</th>
					<th>시작시간</th>
					<th>종료시간</th>
					<th style="width: 67px;">수정</th>
					<th style="width: 67px;">삭제</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>Subhash</td>
					<td>Administration</td>
					<td>88***88***</td>
					<td>15:30</td>
					<td>20:30</td>
					<td>
						<a href="#" class="edit" title="Edit">수정</a>
					</td>
					<td>
						<a href="#" class="delete" title="Delete">삭제</a>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	
	<!-- 모달 -->
	<div class="modal fade" id="squarespaceModal" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
  	<div class="modal-dialog">
	<div class="modal-content" style="width: 503px;">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
			
			<h3 class="modal-title" id="lineModalLabel">근 무 추 가</h3>
		</div>
		<div class="modal-body">
			<select name="sffname" id="sffname">
				<c:forEach var="vo" items="${list }">
					<option value="">${vo.sffPosition }</option>
				</c:forEach>
			</select><br>
			<div>시작시간 <input type="text"> 종료시간 <input type="text"></div>
		</div>
		<div class="modal-footer">
			<div class="btn-group btn-group-justified" role="group" aria-label="group button">
				<div class="btn-group" role="group">
					<button type="button" class="btn btn-default" data-dismiss="modal"  role="button">Close</button>
				</div>
				<div class="btn-group btn-delete hidden" role="group">
					<button type="button" id="delImage" class="btn btn-default btn-hover-red" data-dismiss="modal"  role="button">Delete</button>
				</div>
				<div class="btn-group" role="group">
					<button type="button" id="saveImage" class="btn btn-default btn-hover-green" data-action="save" role="button">Save</button>
				</div>
			</div>
		</div>
	</div>
  </div>
</div>
</div>
<script>
    $(function(){
    	$('#datecheck').click(function(){
    		var datec=$('#checkdate').val();
    		console.log(datec);
    		$.ajax({
	    		url: "${cp}/schedule/slist.do",
	    		type: 'post',
	    		data: {workDate:datec},
	    		contentType : "application/x-www-form-urlencoded; charset=UTF-8",
	    		dataType : "json",
	    		success: function(data){
		    			$("#sctable td").remove();
		    			var tbody2 = $("<tbody/>");
		    			$(data).each(function(i,item){
				    		var sffname = item.sffname;
							var divisionname = item.divisionname;
							var sffposition = item.sffposition;
							var workstart = item.workstart;
							var workend = item.workend;
							var row = $("#sctable").append($("<tr/>").append(
								$("<td/>").text(sffname),
								$("<td/>").text(divisionname),
								$("<td/>").text(sffposition),
								$("<td/>").text(workstart),
								$("<td/>").text(workend),
								$("<td> <a href='#' class='edit' title='Edit'>수정</a></td>"),
								$("<td> <a href='#' class='delete' title='Delete'>삭제</a></td>")
								)
							);
		    			});
	    		},
	    		error:function(){
	    			$("#sctable td").remove();
	    		}
	    	});
		});
    	$("#btn1").on('click',function(){
    		alert("모달열림");
    		  document.get
    		  $("#modal").fadeIn(300);
    		  $.ajax({
    				url: "${cp}/schedule/sadd.do",
  	    			type: 'get',
  	    			contentType : "application/x-www-form-urlencoded; charset=UTF-8",
  	    			dataType : "json",
  	    			success: function(data){
  	    				alert("모달펑션터짐");
  	    			}
    		  });
    		});
			
    		$("#modal, .close").on('click',function(){
    			alert("모달 닫림");
    		  $("#modal").fadeOut(300);
    		  $(".modal-con").fadeOut(300);
    		});
   });

</script>