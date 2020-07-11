<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<input type="button" value="월별">
	<div id="columnchart_material" style="width: 500px; height: 500px;"></div>
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
			    	  console.log(111);
			    	  var array = new Array();
	    		    	array[0] = ['day', '여자', '남자'];
	    		    	$(results).each(function(i,charge){
	    		    		var chregdate=charge.chRegdate;
	    		    		var man=0;
	    		    		var woman=0;
	    		    		//남자 매출
	    		    		if(charge.birth=='1'){
	    		    			man+=charge.totalbill;
	    		    		//여자 매출
	    		    		}else{
	    		    			woman+=charge.totalbill;
	    		    		}
	    		    			var subArray = [
	    		    				charge.chRegdate,
	    		    				woman,
	    		    				man
			    				];
	    		    		array[++i] = subArray;
		            	});
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
	    		    	array[0] = ['day', '여자', '남자'];
	    		    	$(results).each(function(i,charge){
	    		    		var man=0;
	    		    		var woman=0;
	    		    		//남자 매출
	    		    		if(charge.birth.substr(8,1)==1 && charge.birth.substr(8,1)==3){
	    		    			mam+=charge.totalbill;
	    		    		//여자 매출
	    		    		}else{
	    		    			woman+=charge.totalbill;
	    		    		}
		    		    	
	    		    			var subArray = [
	    		    				charge.chRegdate,
	    		    				man,
	    		    				woman
			    				];
	    		    		array[++i] = subArray;
		            	});
	    		    	
	    		    	var options = {
	    		    	          chart: {
	    		    	            title: 'Company Performance'
	    		    	          }
	    		    	        };
	    		    	 var data = google.visualization.arrayToDataTable(array);
			          var chart = new google.charts.Bar(document.getElementById('columnchart_material'));

			          chart.draw(data, google.charts.Bar.convertOptions(options));
			        }
			});
		});
	});
</script>
</html>









