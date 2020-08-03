<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>views/layout.jsp</title>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="shortcut icon" href="/project/resources/logo/favicon.png">
<!-- css파일  -->
<link href="${cp}/resources/css/main.css" rel="stylesheet">
<link href="${cp}/resources/css/employ.css" rel="stylesheet">
<link href="${cp}/resources/css/employInsert.css" rel="stylesheet">
</head>
<body>
<div id="wrap">
	<div id="header">
		<tiles:insertAttribute name="header"/>
	</div>
	<div id="content">
		<tiles:insertAttribute name="content"/>
	</div>
	<div id="footer">
		<tiles:insertAttribute name="footer"/>
	</div>
</div>
</body>
<script>
	$(function(){
		$("input:checkbox").on('click',function(){
			if($(this).prop('checked')){
				$("#searchUl").append("<li class='searchLi'>"+$(this).val()+"</li>");
				$("#searchClear").css("opacity","1");
			}else{
				var val = $(this).val();
				$(".searchLi").each(function(i,mem){
					if($(this).text()==val){
						$(this).remove();
					}
					if($(".searchLi").length==0){
						$("#searchClear").css("opacity","0");
					}
				});
			}
		});
		
		
		$("input:checkbox").each(function(){
			if($(this).prop("checked")){
				$("#searchUl").append("<li class='searchLi'>"+$(this).val()+"</li>");
				$("#searchClear").css("opacity","1");
			}
		});
		
		$("#searchClear").on('click',function(){
			$("#searchUl li").remove();
			$("input:checkbox").prop("checked",false);
			$(this).css("opacity","0");
		});
		
	});
</script>
</html>