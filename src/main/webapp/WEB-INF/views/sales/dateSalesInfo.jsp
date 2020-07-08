<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Year', '티켓수입', '지출', '매점수익'],
          [`${list[0].month}, ${list.[0].ticketincome}, ${list.[0].outcome}, ${list.[0].storeincome}`],
          [`${list[1].month}, ${list.[1].ticketincome}, ${list.[1].outcome}, ${list.[1].storeincome}`],
          [`${list[2].month}, ${list.[2].ticketincome}, ${list.[2].outcome}, ${list.[2].storeincome}`]
          
        ]);

        var options = {
          title: 'Company Performance',
          hAxis: {title: 'Year',  titleTextStyle: {color: '#333'}},
          vAxis: {minValue: 0}
        };

        var chart = new google.visualization.AreaChart(document.getElementById('chart_div'));
        chart.draw(data, options);
      }
    </script>
</head>
<body>
	<div id="chart_div" style="width: 100%; height: 500px;"></div>
</body>
</html>