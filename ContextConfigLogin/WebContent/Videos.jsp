<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="grey">
	<center>
		<h1 style="color: red">
			<marquee>Click To Play The Video</marquee>
		</h1>

		<%
			response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
			response.setHeader("Pragma", "no-cache");
			response.setHeader("Expires", "0");
			if (session.getAttribute("userName") == null) {
				response.sendRedirect("SignIn.jsp");
			}
		%>

		<iframe width="560" height="315"
			src="https://www.youtube.com/embed/gQLQ0t9B5yk" frameborder="0"
			allow="autoplay; encrypted-media" allowfullscreen></iframe>


		<form action="rss" method="post">
			<input type="submit" value="LogOut" />
		</form>
	</center>

</body>
</html>