<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TestHub Sing in</title>
<link rel="stylesheet" href="css/style.css">
<script type="text/javascript" src="javaScript/checkFormSingIn.js"></script>


<script >
function (form) {
	
	alert("Hello");
    var re = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
    return re.test(form.email.value);
}

</script>


</head>

<body>

	<section class="container">
	<div class="login">
		<h1>Registration form</h1>

		<form action="SingInServlet" method="POST" name="regForm"
			onsubmit="return checkFormSingIn(this)">
			<meta charset="UTF-8">

			<p>
				<input type="text" name="firstName" value=""
					placeholder="First name" required>
			</p>

			<p>
				<input type="text" name="lastName" value="" placeholder="Last name"
					required>
			</p>

			<p>
				<input type="text" name="email" value="" placeholder="email"
					required>
			</p>

			<p>
				<input type="text" name="login" value=""
					placeholder="Username (login)" required>
			</p>

			<p>
				<input type="password" name="password" value=""
					placeholder="Password" required>
			</p>
			<p>
				<input type="password" name="password1" value=""
					placeholder="Repeat assword" required>
			</p>

			<p class="remember_me">
				<label> <input type="checkbox" name="remember_me"
					id="remember_me"> Remember me on this computer
				</label>
			</p>
			<input type="submit" value="Registrate Me">
		</form>

	</div>

	
	</section>

</body>
</html>