<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	기간 <input type="date" value="xxx" min="yyy" max="zzz" name="date" id="input_date">
	- <input type="date" value="xxx" min="yyy" max="zzz" name="date" id="input_date1">
	<input type="button" value="년도별">
	<input type="button" value="월별"><br>
	<div id="columnchart_material" style="width: 500px; height: 500px; float: left;"></div>
	<div id="gender_table" style="width: 500px; height: 500px; border:1px; float: left; overflow: auto;" class="container"></div>
</body>
<script type="text/javascript" src="${cp }/resources/js/jquery-3.5.1.js"></script>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
	$(function(){
		$("input[value='월별']").click(function(){
			var d=$("#input_date").val();
    		var d1=$("#input_date1").val();
    		var date=d.substring(0,7);
    		var date1=d1.substring(0,7);
			$("#columnchart_material").empty();
			$.getJSON("${cp}/sales/gender/monthList.do",{"date":date,"date1":date1},function(results){
				google.charts.load ( 'current', { 'packages': ['bar']});
			      google.charts.setOnLoadCallback (drawChart);
			      function drawChart () {
			    	  var array = new Array();
	    		    	array[0] = ['month', '남자', '여자'];
	    		    	var str="";
	    		    	str+="<table class='table table-striped'>";
	    		    	str+="<thead>";
		    		    	str+="<tr>";
			    		    	str+="<th>날짜</th>";
			    		    	str+="<th>남자</th>";
			    		    	str+="<th>여자</th>";
	    		    		str+="</tr>";
    		    		str+="</thead>";
	    		    	$(results).each(function(i,charge){
	    		    		
    		    			var subArray = [
    		    				charge.chRegdate,
    		    				charge.man,
    		    				charge.woman
		    				];
	    		    		array[++i] = subArray;
	    		    		if(charge.man == null){
	    		    			charge.man=0;
	    		    		}else if(charge.woman == null){
	    		    			charge.woman=0;
	    		    		}
	    		    		str+="<tbody>";
		    		    		str+="<tr>";
				    		    	str+="<th>"+charge.chRegdate+"</th>";
				    		    	str+="<th>"+charge.man+"</th>";
				    		    	str+="<th>"+charge.woman+"</th>";
		    		    		str+="</tr>";
	    		    		str+="</tbody>";
		            	});
	    		    	str+="</table>";
    		    		$("#gender_table").html(str);
			          var options = {
			            chart: {
			              title: 'Company Performance',
			              subtitle: ''
			            }
			          };
			          var data = google.visualization.arrayToDataTable(array);
			          var chart = new google.charts.Bar(document.getElementById ( 'columnchart_material'));
			          chart.draw(data, google.charts.Bar.convertOptions(options));
			        }
			});
		});
		
		$("input[value='년도별']").click(function(){
			var d=$("#input_date").val();
    		var d1=$("#input_date1").val();
    		var date=d.substring(0,4);
    		var date1=d1.substring(0,4);
			$("#columnchart_material").empty();
			$.getJSON("${cp}/sales/gender/yearList.do",{"date":date,"date1":date1},function(results){
				google.charts.load ( 'current', { 'packages': ['bar']});
			      google.charts.setOnLoadCallback (drawChart);
			      function drawChart () {
			    	  var array = new Array();
	    		    	array[0] = ['month', '남자', '여자'];
	    		    	var str="";
	    		    	str+="<table class='table table-striped'>";
	    		    	str+="<thead>";
		    		    	str+="<tr>";
			    		    	str+="<th>날짜</th>";
			    		    	str+="<th>남자</th>";
			    		    	str+="<th>여자</th>";
	    		    		str+="</tr>";
  		    		str+="</thead>";
	    		    	$(results).each(function(i,charge){
	    		    		
  		    			var subArray = [
  		    				charge.chRegdate,
  		    				charge.man,
  		    				charge.woman
		    				];
	    		    		array[++i] = subArray;
	    		    		if(charge.man == null){
	    		    			charge.man=0;
	    		    		}else if(charge.woman == null){
	    		    			charge.woman=0;
	    		    		}
	    		    		str+="<tbody>";
		    		    		str+="<tr>";
				    		    	str+="<th>"+charge.chRegdate+"</th>";
				    		    	str+="<th>"+charge.man+"</th>";
				    		    	str+="<th>"+charge.woman+"</th>";
		    		    		str+="</tr>";
	    		    		str+="</tbody>";
  		    		
		            	});
	    		    	str+="</table>";
  		    		$("#gender_table").html(str);
			          var options = {
			            chart: {
			              title: 'Company Performance',
			              subtitle: ''
			            }
			          };
			          var data = google.visualization.arrayToDataTable(array);
			          var chart = new google.charts.Bar(document.getElementById ( 'columnchart_material'));
			          chart.draw(data, google.charts.Bar.convertOptions(options));
			        }
			});
		});
	});
</script>
</html>