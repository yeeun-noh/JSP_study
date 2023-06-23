<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype HTML>
<head>
	<meta charset="UTF-8">
	<title>제주어때 로그인</title>
	<link rel="stylesheet" href="login.css">
	<script src="https://kit.fontawesome.com/51db22a717.js" crossorigin="anonymous"></script>
	<script type="text/javascript" src="script/loginCheck.js"></script>
</head>
<body>
<form name="frm" method="post" action="Servlet?command=Jeju_Login">
	<div class="main-container">
		<div class="main-wrap">
			</div>
			<div class="logo-wrap">
				<img src="images/logo.png">
			</div>
		
		<section class="login-input-section-wrap">
			<div class="login-input-wrap">	
				<input placeholder="Email" type="email" name="email"></input>
			</div>
			<div class="login-input-wrap password-wrap">	
				<input placeholder="Password" type="password" name="password"></input>
			</div>
			<div class="login-button-wrap">
				<button style='cursor:pointer;' onclick="return loginCheck()"> 로그인 </button>
			</div>
		</section>
		<div class="check_wrap">
  			<input type="checkbox" id="check_btn"/>
 			 <label for="check_btn"><span>로그인 유지하기</span></label>
		</div>	
		<section class="Easy-sgin-in-wrap">
			<h2>간편 로그인</h2>
			<ul class="sign-button-list">
				<li><button style='cursor:pointer;'><i class="fas fa-qrcode"></i><span>QR코드로 로그인 하기</span></button></li>
				<li><button style='cursor:pointer;'><i class="fab fa-facebook-square"></i><span>Facebook</span></button></li>
				<li><button style='cursor:pointer;'><i class="fab fa-line"></i><span>line</span></button></li>
			</ul>
			<p class="forget-msg" style='cursor:pointer;'>아이디 혹은 비밀번호 찾기 </p>
			<p class="forget-msg" style='cursor:pointer;' onclick="location.href='Servlet?command=Jeju_Join'">가입하기</p>
			
		</section>
		<footer>
			<div class="copyright-wrap">
			<span><img src="img/logo.png"> Copyright © EZEN Corp. All Rights Reserved.</span>
			</div>
		</footer>
		</div>
	</form>
</body>