<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<section class="get-in-touch">
   <h1 class="title">직원 등록</h1>
   <form class="contact-form row">
      <div class="form-field col-lg-6">
         <input id="name" class="input-text js-input" type="text" required>
         <label class="label" for="name">이름</label>
      </div>
      <div class="form-field col-lg-6 ">
         <input id="email" class="input-text js-input" type="text" required>
         <label class="label" for="email">나이</label>
      </div>
      <div class="form-field col-lg-6 ">
         <input id="company" class="input-text js-input" type="text" required>
         <label class="label" for="company">거주지</label>
      </div>
       <div class="form-field col-lg-6 ">
         <input id="phone" class="input-text js-input" type="text" required>
         <label class="label" for="phone">주민등록번호</label>
      </div>
      <div class="form-field col-lg-6 ">
         <input id="phone" class="input-text js-input" type="text" required>
         <label class="label" for="phone">성별</label>
      </div>
      <div class="form-field col-lg-6 ">
         <input id="phone" class="input-text js-input" type="text" required>
         <label class="label" for="phone">계좌번호</label>
      </div>
      <div class="form-field col-lg-6"><gr>
	      <label class="label" for="grade">직원등급</label>
	      <select id="grade">
	      	<option>점장</option>
	      	<option>매니저</option>
	      	<option>직원</option>
	      	<option>파트생</option>
	      </select>
      </div>
      <div class="form-field col-lg-12">
         <input class="submit-btn" type="submit" value="Submit">
      </div>
   </form>
</section>