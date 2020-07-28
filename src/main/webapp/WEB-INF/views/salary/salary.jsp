<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<div class="container">
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<div class="display-flex align-center">
				<h6 class="m-0 font-weight-bold text-primary">Custom Table</h6>
				<div class="ml-auto display-flex align-center">
					<input type="month" id="m1">
					<input type="month" id="m2">
					<button class="btn btn-md btn-primary ml-2">Search</button>
				</div>
			</div>
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered" width="100%" cellspacing="0">
					<thead>
						
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
<script>
	$("#m1,#m2").on('change',function(){
		if($("#m1").val()>$("#m2").val()){
			alert($("#m1").val());
		}
	});
	
</script>