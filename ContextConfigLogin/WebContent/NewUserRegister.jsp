<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="cyan">
	<center>
		<h1 style="color: grey">Fill The Form</h1>
		<form action="det" method="post">
			<table>
				<tr>
					<td>Enter UserName</td>
					<td><input type="text" name="uname" /></td>
				</tr>
				<tr>
					<td>Enter Password</td>
					<td><input type="password" name="password" /></td>
				</tr>

				<!-- <tr>
					<td>Enter Email</td>
					<td><input type="text" name="email" /></td>
				</tr>
				<tr>
					<td>Enter Id</td>
					<td><input type="text" name="id" /></td>
				</tr>
				<tr> -->
					<td></td>
					<td><input type="submit" value="Register" />
			</table>
		</form>
	</center>
</body>
</html>