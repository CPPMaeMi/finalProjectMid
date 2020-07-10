<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
</head>
<body>
	기간 <input type="date" value="xxx" min="yyy" max="zzz" name="date" id="input_date">
	- <input type="date" value="xxx" min="yyy" max="zzz" name="date" id="input_date1">
	<input type="button" value="년도별">
	<input type="button" value="월별">
	<div id="columnchart_material" style="width: 500px; height: 500px;"></div>
</body>
<script type="text/javascript">
	$(function(){
		$("input[value='월별']").click(function(){
			$("#columnchart_material").empty();
			$.getJSON("${cp}/sales/gender.do",{"date":date,"date1":date1},function(results){
			      google.charts.load ( 'current', { 'packages': [ 'bar']});
			      google.charts.setOnLoadCallback (drawChart);
    		    
			      function drawChart () {
			    	  var array = new Array();
			    	  var manTotalbill=0;
			    	  var WomanTotalbill=0;
	    		    	array[0] = ['day', '여자', '남자'];
	    		    	$(results).each(function(i,charge){
	    		    		var chRegdate=charge.chRegdate;
	    		    		//남자 매출
	    		    		if(charge.birth.substr(8,1)==1 && charge.birth.substr(8,1)==3){
	    		    			manTotalbill+=charge.totalbill;
	    		    		//여자 매출
	    		    		}else{
	    		    			WomanTotalbill+=charge.totalbill;
	    		    		}
		    		    	var subArray = [
	            					chRegdate,
	            					manTotalbill,
	            					WomanTotalbill
			    				];
	    		    		array[++i] = subArray;
		            	});
			          var options = {
			            chart: {
			              title: 'Company Performance',
			              subtitle: '',
			            }
			          };

			          var chart = new google.charts.Bar(document.getElementById('columnchart_material'));

			          chart.draw(data, google.charts.Bar.convertOptions(options));
			        }
			});
		});
	});
</script>
</html>









