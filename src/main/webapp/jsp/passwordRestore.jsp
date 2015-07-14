<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/style.css">
<title>TestHub passwordRestore</title>
</head>
<body>
<section class="container" >
		<div class="login">
		<h1>Password recovery</h1>
			<form  action="PasswordRecoveryServlet" method="POST"  name="LoginForm" onSubmit="return checkFormLogin(this)">
				<p>
					<input type="password" name="password" placeholder="New password" required>
				</p>
				<p>
					<input type="password" name="password1" placeholder="Confirm new password" required>
				</p>
				<p>
					<input type="submit" value="Create new password"></input>
				</p>
			</form>
		</div>
		</section>

</body>
</html>