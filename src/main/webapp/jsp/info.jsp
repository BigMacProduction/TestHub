<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TestHub Info</title>
<link rel="stylesheet" href="css/style.css">


</head>
<body>
<% String userName = request.getParameter("userName"); %>


	<section class="container">
	<div class="login">
		<h1>TestHub info</h1>
		<h4>Welcome, <%=userName %></h4>
	</div>
	</section>
	
	

</body>
</html>