<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
</head>
<body>
	기간 <input type="date" min="yyy" max="zzz" name="date" id="input_date">
	- <input type="date" min="yyy" max="zzz" name="date" id="input_date1">
	<input type="button" value="년도별">
	<input type="button" value="월별">
	<input type="button" value="일별">
	<div id="chart_div" style="width: 100%; height: 500px;"></div>
</body>
<script type="text/javascript" src="${cp }/resources/js/jquery-3.5.1.js"></script>
    <script type="text/javascript">
    
    $(function(){
    	$("input[value='일별']").click(function(){
    		var date=$("#input_date").val();
    		var date1=$("#input_date1").val();
    		$("#chart_div").empty();
    		$.getJSON("${cp}/sales/dayList.do",{"date":date,"date1":date1},function(results){
    			google.charts.load('current', {'packages':['corechart']});
    		    google.charts.setOnLoadCallback(drawChart);
    		    function drawChart() {
    		    	var array = new Array();
    		    	array[0] = ['day', '티켓수입', '지출', '매점수익','순이익'];
    		    	$(results).each(function(i,revenue){
    		    		var profit=revenue.ticketIncome+revenue.storeIncome-revenue.outcome;/* 순이익 */
    		    		var subArray = [
    		    			revenue.revenuedate,
	            			revenue.ticketIncome,
	            			revenue.outcome,
	            			revenue.storeIncome,
	            			profit
            			];
    		    		array[++i] = subArray;
	            	});
    		        var data = google.visualization.arrayToDataTable(array);
    		        var options = {
    		          title: 'Company Performance',
    		          hAxis: {title: 'day',  titleTextStyle: {color: '#333'}},
    		          vAxis: {minValue: 0}
    		        };
    		        var chart = new google.visualization.AreaChart(document.getElementById('chart_div'));
    		        chart.draw(data, options);
    		      }
			});
    	});
    	
    	$("input[value='월별']").click(function(){
    		var d=$("#input_date").val();
    		var d1=$("#input_date1").val();
    		var date=d.substring(0,7);
    		var date1=d1.substring(0,7);
    		$("#chart_div").empty();
    		$.getJSON("${cp}/sales/monthList.do",{"date":date,"date1":date1},function(results){
    			google.charts.load('current', {'packages':['corechart']});
    		    google.charts.setOnLoadCallback(drawChart);
    		    function drawChart() {
    		    	var array = new Array();
    		    	array[0] = ['month', '티켓수입', '지출', '매점수익', '순이익'];
    		    	$(results).each(function(i,revenue){
    		    		var profit=revenue.ticketIncome+revenue.storeIncome-revenue.outcome;/* 순이익 */
    		    		var subArray = [
    		    			revenue.revenuedate,
	            			revenue.ticketIncome,
	            			revenue.outcome,
	            			revenue.storeIncome,
	            			profit
            			];
    		    		array[++i] = subArray;
	            	});
    		        var data = google.visualization.arrayToDataTable(array);
    		        var options = {
    		          title: 'Company Performance',
    		          hAxis: {title: 'month',  titleTextStyle: {color: '#333'}},
    		          vAxis: {minValue: 0}
    		        };
    		        var chart = new google.visualization.AreaChart(document.getElementById('chart_div'));
    		        chart.draw(data, options);
    		      }
			});
    	});
    	
    	$("input[value='년도별']").click(function(){
    		var d=$("#input_date").val();
    		var d1=$("#input_date1").val();
    		var date=d.substring(0,4);
    		var date1=d1.substring(0,4);
    		$("#chart_div").empty();
    		$.getJSON("${cp}/sales/yearList.do",{"date":date,"date1":date1},function(results){
    			google.charts.load('current', {'packages':['corechart']});
    		    google.charts.setOnLoadCallback(drawChart);
    		    function drawChart() {
    		    	var array = new Array();
    		    	array[0] = ['Year', '티켓수입', '지출', '매점수익', '순이익'];
    		    	$(results).each(function(i,revenue){
    		    		var profit=revenue.ticketIncome+revenue.storeIncome-revenue.outcome;/* 순이익 */
    		    		var subArray = [
    		    			revenue.revenuedate,
	            			revenue.ticketIncome,
	            			revenue.outcome,
	            			revenue.storeIncome,
	            			profit
            			];
    		    		array[++i] = subArray;
	            	});
    		    	
    		        var data = google.visualization.arrayToDataTable(array);
    		    	
    		        var options = {
    		          title: 'Company Performance',
    		          hAxis: {title: 'Year',  titleTextStyle: {color: '#333'}},
    		          vAxis: {minValue: 0}
    		        };

    		        var chart = new google.visualization.AreaChart(document.getElementById('chart_div'));
    		        chart.draw(data, options);
    		      }
			});
    	});
    });
    
    </script>
</html>