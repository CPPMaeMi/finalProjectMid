<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!--메뉴바 추가 부분-->

<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<a class="navbar-brand" href="#"> <img
		src="/project/resources/logo/logo.png" width="50" height="50">MegaCinema
	</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
	</button>

	<div class="collapse navbar-collapse" id="navbarNavDropdown">
		<ul class="navbar-nav">
			<li class="nav-item active"><a class="nav-link" href="#">Home
					<span class="sr-only">(current)</span>
			</a></li>
			
			<li class="nav-item dropdown">
           <a class="nav-link dropdown-toggle" href="http://example.com" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
           	영화
           </a>
           <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
             <a class="dropdown-item" href="#">상영 영화 관리</a>
             <a class="dropdown-item" href="#">상영 기간 결정</a>
             <a class="dropdown-item" href="#">본사 판권 관리</a>
             <a class="dropdown-item" href="${cp }/room/seat/theather.do">영화관 좌석 관리</a>
           </div>
           </li>
           
           <li class="nav-item dropdown">
           <a class="nav-link dropdown-toggle" href="http://example.com" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          	 직원
           </a>
           <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
             <a class="dropdown-item" href="#">직원현황</a>
             <a class="dropdown-item" href="${cp }/schedule/scheduler.do">근무관리</a>
             <a class="dropdown-item" href="#">급여관리</a>
           </div>
           </li>
           
			<li class="nav-item dropdown">
           <a class="nav-link dropdown-toggle" href="http://example.com" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
           	매출관리
           </a>
            <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
             <a class="dropdown-item" href="${cp }/sales/dateSalesInfo.do">매출정보 조회</a>
             <a class="dropdown-item" href="${cp }/sales/genderInfo.do">성별 조회</a>
             <a class="dropdown-item" href="${cp }/sales/ageInfo.do">연령별 조회</a>
           </div>
           </li>
		</ul>
	</div>
</nav>



