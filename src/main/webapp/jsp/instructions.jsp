<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TestHub Validate</title>
<link rel="stylesheet" href="css/style.css">


</head>
<body>



	<section class="container">
	<div class="login">
		<h1><%= request.getAttribute("title") %> </h1>
		<h4><%= request.getAttribute("message") %></h4>
	</div>
	</section>

</body>
</html>