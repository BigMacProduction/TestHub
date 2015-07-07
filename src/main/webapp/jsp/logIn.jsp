<%@ page contentType="text/html; charset=utf-8"%>
<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css">


<script type="text/javascript">
	function checkFormLogin(form) {
		if (form.username.value == "") {
			alert("Error: Username cannot be blank!");
			form.username.focus();
			return false;
		}
		re = /^\w+$/;
		if (!re.test(form.username.value)) {
			alert("Error: Username must contain only letters, numbers and underscores!");
			form.username.focus();
			return false;
		}
		if (form.password.value == "") {
			alert("Error: Password cannot be blank!");
			form.username.focus();
			return false;
		}

		if (form.password.value != "" ) {
			if (form.password.value.length < 6) {
				alert("Error: Password must contain at least six characters!");
				form.password.focus();
				return false;
			}
			if (form.password.value == form.username.value) {
				alert("Error: Password must be different from Username!");
				form.password.focus();
				return false;
			}
			re = /[0-9]/;
			if (!re.test(form.password1.value)) {
				alert("Error: password must contain at least one number (0-9)!");
				form.password.focus();
				return false;
			}
			re = /[a-z]/;
			if (!re.test(form.password.value)) {
				alert("Error: password must contain at least one lowercase letter (a-z)!");
				form.password.focus();
				return false;
			}
			re = /[A-Z]/;
			if (!re.test(form.password.value)) {
				alert("Error: password must contain at least one uppercase letter (A-Z)!");
				form.password.focus();
				return false;
			}
		} else {
			alert("Error: Please check that you've entered and confirmed your password!");
			form.password.focus();
			return false;
		}

		alert("You entered a valid password: " + form.password.value);
		return true;
	}
</script>

</head>
<body>


	

		<section class="container" >
		<div class="login">
		<h1>Log In Form</h1>
			<form  action="LoginServlet" method="POST"  name="LoginForm" onSubmit="return checkFormLogin(this)">
				<p>
					<input type="text" name="userName" placeholder="Username" required>
				</p>
				<p>
					<input type="password" name="password" placeholder="Password" required>
				</p>
				<p>
					<input type="submit" value="Login"></input>
				</p>
			</form>
		</div>
		</section>
</body>
</html>