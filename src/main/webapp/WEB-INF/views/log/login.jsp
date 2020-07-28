<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css"
	href="${cp }/resources/css/log/vendor/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="${cp }/resources/css/log/vendor/animate/animate.css">
<link rel="stylesheet" type="text/css"
	href="${cp }/resources/css/log/vendor/css-hamburgers/hamburgers.min.css">
<link rel="stylesheet" type="text/css"
	href="${cp }/resources/css/log/vendor/animsition/css/animsition.min.css">
<link rel="stylesheet" type="text/css"
	href="${cp }/resources/css/log/vendor/select2/select2.min.css">
<link rel="stylesheet" type="text/css"
	href="${cp }/resources/css/log/vendor/daterangepicker/daterangepicker.css">
<link rel="stylesheet" type="text/css"
	href="${cp }/resources/css/log/loginutil.css">
<link rel="stylesheet" type="text/css"
	href="${cp }/resources/css/log/loginmain.css">

<div class="limiter">
	<div class="container-login100">
		<div class="wrap-image">
		<img alt="" src="${cp}/resources/images/finger.gif">
		</div>
		<div class="wrap-login100">
			<form class="login100-form validate-form" action="${cp }/log/banchloging.do" method="post" id="loging">
				<span class="login100-form-title p-b-26"> 로 그 인 </span> <span
					class="login100-form-title p-b-48"> 
					<img src="${cp}/resources/images/fingerv.png" alt="smile" style="width:75px"/>
				</span>

				<div class="wrap-input100 validate-input"
					data-validate="Valid email is: a@b.c">
					<input class="input100" type="text" name="memId" id="memId"> <span
						class="focus-input100" data-placeholder="아이디"></span>
				</div>

				<div class="wrap-input100 validate-input"
					data-validate="Enter password">
					<span class="btn-show-pass"> <i class="zmdi zmdi-eye"></i>
					</span> <input class="input100" type="password" name="memPwd" id="memPwd"> <span
						class="focus-input100" data-placeholder="비밀번호"></span>
				</div>

				<div class="container-login100-form-btn">
					<div class="wrap-login100-form-btn">
						<div class="login100-form-bgbtn"></div>
						<button class="login100-form-btn" id="submit">로그인</button>
					</div>
				</div>

				<div class="text-center p-t-115">
					<span class="txt1"> 관계자 계정은 본사에서 관리 바랍니다.</span> 
					<span class="txt1">${msg }</span>
				</div>
			</form>
		</div>
	</div>
</div>

<div id="dropDownSelect1"></div>

<script src="${cp }/resources/css/log/vendor/jquery/jquery-3.2.1.min.js"></script>

<script src="${cp }/resources/css/log/vendor/animsition/js/animsition.min.js"></script>

<script src="${cp }/resources/css/log/vendor/bootstrap/js/popper.js"></script>
<script src="${cp }/resources/css/log/vendor/bootstrap/js/bootstrap.min.js"></script>

<script src="${cp }/resources/css/log/vendor/select2/select2.min.js"></script>

<script src="${cp }/resources/css/log/vendor/daterangepicker/moment.min.js"></script>
<script src="${cp }/resources/css/log/vendor/daterangepicker/daterangepicker.js"></script>

<script src="${cp }/resources/css/log/vendor/countdowntime/countdowntime.js"></script>

<script src="${cp }/resources/js/log/login.js"></script>