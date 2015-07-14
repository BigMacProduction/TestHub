<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/style.css">
<title>TestHub Password Restore</title>
</head>
<body>
	<section class="container">
	<div class="login">
		<h1>Password recovery</h1>
		<form action="PasswordRequestServlet" method="POST" name="LoginForm"
			onSubmit="return checkFormLogin(this)">
			<p>
				<input type="text" name="email" placeholder="email" required>
			</p>

			<p>
				<input type="submit" value="passowordRecoveryRequest"></input>


			</p>
		</form>
	</div>
	</section>
</html>