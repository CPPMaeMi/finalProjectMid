<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section class="get-in-touch">
   <h1 class="title">직원 등록</h1>
   <form class="contact-form row" action="${cp}/employee/emInsertOk.do" method="get">
   
   	  <!--번호(임의로) 지점명,재직상태 히든으로보냄 -->
   	  <input type="hidden" name="branchNum" value="${branchNum}">
   	  <input type="hidden" name="sffStatus" value="재직중">
   	  
      <div class="form-field col-lg-6">
         <input name="sffName" id="name" class="input-text js-input" type="text" required>
         <label class="label" for="name">이름</label>
      </div>
      <div class="form-field col-lg-6 ">
         <input name="sffAge" id="age" class="input-text js-input" type="text"  required>
         <label class="label" for="age">나이</label>
      </div>
      <div class="form-field col-lg-6 ">
         <input name="sffAddr" id="addr" class="input-text js-input" type="text" required>
         <label class="label" for="addr">거주지</label>
      </div>
       <div class="form-field col-lg-6 ">
         <input name="jumin" id="jumin" class="input-text js-input" type="text" placeholder="-빼고 입력하세요" required>
         <label class="label" for="jumin">주민등록번호</label>
      </div>
      <div class="form-field col-lg-6 ">
         <input name="gender" id="gender" class="input-text js-input" type="text" required>
         <label class="label" for="gender">성별</label>
      </div>
      <div class="form-field col-lg-6 ">
         <input name="accountNum" id="account" class="input-text js-input" type="text" placeholder="-빼고 입력하세요." required>
         <label class="label" for="account">계좌번호</label>
      </div>
      <div class="form-field col-lg-6"><gr>
	      <label class="label" for="grade">직원등급</label>
	      <select id="grade" name="sffNum">
	      	<c:forEach items="${sfList}" var="i" varStatus="status">
	      		<option value="${i.sffNum}">${i.sffPosition}</option>
	      	</c:forEach>
	      </select>
      </div>
      <div class="form-field col-lg-6"><gr>
	      <label class="label" for="grade1">부서정보</label>
	      <select id="grade1" name="divisionNum">
	      	<c:forEach items="${diList}" var="i" varStatus="status">
	      		<option value="${i.divisionNum}">${i.divisionName}</option>
	      	</c:forEach>
	      </select>
      </div>
      <div class="form-field col-lg-12">
         <input class="submit-btn" type="submit" value="등록">
      </div>
   </form>
</section>