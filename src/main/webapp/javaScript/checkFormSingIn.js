/**
 * 
 */


	function checkFormSingIn(form) {
		
		re = /^\w+$/;
		if (!re.test(form.firstName.value) || !re.test(form.lastName.value)|| !re.test(form.login.value)) {
			alert("Error: First name, last name and login must contain only letters, numbers and underscores!");
			form.username.focus();
			return false;
		}
				
		re = /^(([^<>()[\]\.,;:\s@\"]+(\.[^<>()[\]\.,;:\s@\"]+)*)|(\".+\"))@(([^<>()[\]\.,;:\s@\"]+\.)+[^<>()[\]\.,;:\s@\"]{2,})$/i;
		if (!re.test(form.email.value)) {
			alert("Error: email is incorrect");
			form.email.focus();
			return false;
		}
		
		
		if (form.password.value != "" && form.password.value == form.password1.value) {
			if (form.password1.value.length < 6) {
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
			if (!re.test(form.password.value)) {
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