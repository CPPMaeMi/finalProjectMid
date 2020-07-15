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
	
	<!-- add모달 -->
	<div class="modal fade" id="squarespaceModal" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
	  	<div class="modal-dialog">
		<div class="modal-content" style="width: 503px;">
		<form action="${cp }/schedule/modalistOk.do" method="post" id="modalform">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
				
				<h3 class="modal-title" id="lineModalLabel">근 무 추 가</h3>
			</div>
			<div class="modal-body">
				<div>
				<table class="table table-bordered" id="sffname">
				<thead>
					<tr>
						<th>이름</th>
						<th>부서</th>
						<th>파트</th>
						<th>적용</th>
					</tr>
				</thead>
				</table>
				</div><br>
				<div>시작시간 <input type="time" name="startime"> 종료시간 <input type="time" name="endtime"></div>
			</div>
			<div class="modal-footer">
				<div class="btn-group btn-group-justified" role="group" aria-label="group button">
					<div class="btn-group" role="group">
						<button type="button" class="btn btn-default" data-dismiss="modal"  role="button">Close</button>
					</div>
					<div class="btn-group" role="group">
						<button type="button" id="saveSC" class="btn btn-default btn-hover-green" data-action="save" role="button">Save</button>
					</div>
				</div>
			</div>
			</form>
		</div>
	  </div>
	</div>
	
<!-- 수정 모달 -->
	<div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
	  	<div class="modal-dialog">
		<div class="modal-content" style="width: 503px;">
		<form action="#" method="post" id="modalform">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
				
				<h3 class="modal-title" id="lineModalLabel">근 무 수 정</h3>
			</div>
			<div class="modal-body">
				<div>
				</div><br>
				<div>시작시간 <input type="text" name="upstartime"> 종료시간 <input type="text" name="upendtime"></div>
			</div>
			<div class="modal-footer">
				<div class="btn-group btn-group-justified" role="group" aria-label="group button">
					<div class="btn-group" role="group">
						<button type="button" class="btn btn-default" data-dismiss="modal"  role="button">Close</button>
					</div>
					<div class="btn-group" role="group">
						<button type="button" id="updateSC" class="btn btn-default btn-hover-green" data-action="save" role="button">Save</button>
					</div>
				</div>
			</div>
			</form>
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
	    			getList(data);
		    			
	    		},
	    		error:function(){
	    			$("#sctable td").remove();
	    		}
	    	});
		});
    	
    	$("#updateSC").on('click',function(){
    		var datec=$('#checkdate').val();
  		    $("#modal").fadeIn(300);
    		alert("수정 터짐");
    	});
    	
    	
    	$("#btn1, #updatedal").on('click',function(e){
    		alert("버튼1 눌림...");
	    		var datec=$('#checkdate').val();
	    		  $("#modal").fadeIn(300);
	    		  $.ajax({
	    				url: "${cp}/schedule/modalist.do",
	  	    			type: 'get',
	  	    			data: {workDate:datec},
	  	    			contentType : "application/x-www-form-urlencoded; charset=UTF-8",
	  	    			dataType : "json",
	  	    			success: function(data){
	  	    				var tbody2 = $("<tbody/>");
	  	    				$("#sffname tbody").remove();
	  	    				$(data).each(function(index,item){
	  	    					var staffnum = item.staffnum;
	  	    					var sffname = item.sffname;
								var divisionname = item.divisionname;
								var sffposition = item.sffposition;
								var row = $("#sffname").append(tbody2).append($("<tr/>").append(
										$("<td/>").text(sffname),
										$("<td/>").text(divisionname),
										$("<td/>").text(sffposition),
										$("<td/>").html("<input type='checkbox' name='namecheck' value='"+staffnum+"'/>")
									)
								);
	  	    				});
	  	    			}
	    		  });
    	});
			
    		$("#modal, .close").on('click',function(){
    		  $("#modal").fadeOut(300);
    		  $(".modal-con").fadeOut(300);
    		  var datec=$('#checkdate').val();
	      		console.log(datec);
	      		$.ajax({
	  	    		url: "${cp}/schedule/slist.do",
	  	    		type: 'post',
	  	    		data: {workDate:datec},
	  	    		contentType : "application/x-www-form-urlencoded; charset=UTF-8",
	  	    		dataType : "json",
	  	    		success: function(data){
	  	    			getList(data);
	  	    		},
	  	    		error:function(){
	  	    			$("#sctable td").remove();
	  	    		}
	  	    	});
    		});
    		
    		function getList(data){
    			$("#sctable td").remove();
	    			var tbody2 = $("<tbody/>");
	    			$(data).each(function(i,item){
	    				var snum = item.sNum;
	    				console.log(snum);
			    		var sffname = item.sffname;
						var divisionname = item.divisionname;
						var sffposition = item.sffposition;
						var workstart = item.workstart;
						var workend = item.workend;
						var row = $("#sctable").append($("<tr/>").append(
							$("<td/>").html(sffname+"<input type='hidden' value='"+snum+"' id='sNum"+i+"'>"),
							$("<td/>").text(divisionname),
							$("<td/>").text(sffposition),
							$("<td/>").html("<input type='text' value='"+workstart+"' id='workstart"+i+"'>"),
							$("<td/>").html("<input type='text' value='"+workend+"' id='workend"+i+"'>"),
							$("<td><input type='button' value='수정' onclick='updateok()'></td>"),
							$("<td> <a href='#' class='delete' title='Delete'>삭제</a></td>")
							)
						);
						
	    			});
    		}
    		
    		function updateok+i(){
        		alert('zzzzz');
        	}
    		
    	
    		
    		$("#saveSC").on('click',function(e){
    			var datec=$('#checkdate').val();
    			alert($('#modalform').serialize());
    			var modalform = $('#modalform').serialize();
    			e.preventDefault();
    			$.ajax({
    				url: "${cp}/schedule/modalistOk.do?workDate="+datec,
  	    			type: 'post',
  	    			data: modalform,
  	    			contentType : "application/x-www-form-urlencoded; charset=UTF-8",
  	    			dataType : "json",
  	    			success: function(data){
  	    				$("#sffname td").remove();
  	    				$(data).each(function(index,item){
  	    					var staffnum = item.staffnum;
  	    					var sffname = item.sffname;
							var divisionname = item.divisionname;
							var sffposition = item.sffposition;
							var row = $("#sffname").append($("<tr/>").append(
									$("<td/>").text(sffname),
									$("<td/>").text(divisionname),
									$("<td/>").text(sffposition),
									$("<td/>").html("<input type='checkbox' name='namecheck' value='"+staffnum+"'/>")
								)
							);
  	    				});
  	    				
  	    			}
    			});
    		});
   });

</script>