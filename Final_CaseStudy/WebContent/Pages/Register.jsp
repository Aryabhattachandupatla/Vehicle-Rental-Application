<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register urself</title>
</head>
<style>
body{
padding-top:60:px;
padding-bottom:40px;
background:url("simple1.jpg");
background-repeat:no-repeat;
background-size:cover;}
</style>
<body>
<body>
<h1 align="center">REGISTER</h1>
<form action="register.do">
<table>
	<tr>
		<td colspan="2"><c:if test="${requestScope.Err!=null}">
			<font color="red">${requestScope.Err}</font>
		</c:if></td>
	</tr>
	<tr>
		<td>User id</td>
		<td><input type="text" name="uid"></td>
	</tr>
	<tr>
		<td>User Name</td>
		<td><input type="text" name="name"></td>
	</tr>
	<tr>
		<td>Role no</td>
		<td><input type="text" name="rno"></td>
	</tr>
	<tr>
		<td>Email</td>
		<td><input type="text" name="email"></td>
	</tr>
	<tr>
		<td>Contact</td>
		<td><input type="number" name="contactno"></td>
	</tr>
	<tr>
		<td>Password</td>
		<td><input type="text" name="password"></td>
	</tr>
	<tr>
		<td>City</td>
		<td><select name="city">
			<option value="Hyderabad">Hyderabad</option>
			<option value="Karimnagar">Karimnagar</option>
			<option value="Khammam">Khammam</option>
		</select></td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="submit"
			value="Register"></td>
	</tr>
</table>
</form>
</body>
</html>