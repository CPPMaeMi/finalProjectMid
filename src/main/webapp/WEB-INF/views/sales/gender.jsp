<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
      google.charts.load ( 'current', { 'packages': [ 'bar']});
      google.charts.setOnLoadCallback (drawChart);

      function drawChart () {
        var data = google.visualization.arrayToDataTable ([
          ['Year', '남자', '여자'],
          ['2014', 1000, 400],
          ['2015', 1170, 460],
          ['2016', 660, 1120],
          ['2017', 1030, 540]
        ]);

        var options = {
          chart: {
            title: 'Company Performance',
            subtitle: '',
          }
        };

        var chart = new google.charts.Bar(document.getElementById('columnchart_material'));

        chart.draw(data, google.charts.Bar.convertOptions(options));
      }
</script>
</head>
<body>
	<div id="columnchart_material" style="width: 800px; height: 500px;"></div>
</body>
</html>