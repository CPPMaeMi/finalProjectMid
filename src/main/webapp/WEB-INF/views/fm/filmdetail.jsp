<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="container my-5 z-depth-1">


  <!--Section: Content-->
  <section class="dark-grey-text">

    <div class="row pr-lg-5">
      <div class="col-md-7 mb-4">

        <div class="view">
          <img src="${vo3.movieImgUrl }" class="img-fluid" alt="smaple image">
        </div>

      </div>
      
      <div class="col-md-5 d-flex align-items-center">
        <div>
          <form action="">
          <h3 class="font-weight-bold mb-4">${vo.filmName }</h3>

        	<p>감독 : ${vo.filmHead }</p>
        	<p>장르 : ${vo2.genreName }</p>
			<p>출연진 : ${vo1.castName }</p>        	
			<p>줄거리 : ${vo.filmStory }</p>
        	<fmt:formatDate value="${vo.filmStart }" pattern="yyyy-MM-dd" var="filmStart"/>
        	<p>개봉일 : ${filmStart }</p>
			<fmt:formatDate value="${vo.filmEnd }" pattern="yyyy-MM-dd" var="filmEnd"/>
        	<p>종료일 : ${filmEnd }</p>
        	<p>판권가 : ${vo.filmPrice }</p>
			<p>상태 : ${vo.filmStatus }</p>

        	<button type="button" class="btn btn-orange btn-rounded mx-0">구매</button>
		</form>
        </div>
      </div>
      
    </div>

  </section>
  <!--Section: Content-->


</div>