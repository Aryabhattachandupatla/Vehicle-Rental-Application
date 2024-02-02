<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
body{
padding-top:60:px;
padding-bottom:40px;
background:url("car.jpg");
background-repeat:no-repeat;
background-size:cover;}
</style>

<body>

<div id="example1">
<h1 align="center">Login</h1>
<form action="login.do" id="register">
<center>
<table>
	<tr>
		<td colspan="2"><c:if test="${requestScope.Err!=null}">
			<font color="red">${requestScope.Err}</font>
		</c:if></td>
	</tr>
	<tr>
		<h3><td>Role Id</td></h3>
		<td><input type="number" name="role" placeholder="1.Admin 2.User"/></td>
	</tr>
	<tr>
		<h3><td>User id</td></h3>
		<td><input type="number" name="u_id" placeholder="User Id"/></td>
	</tr>
	<tr>
		<h3><td>password</td></h3>
		<td><input type="text" name="pass" placeholder="Password" required/></td>
	</tr>
	<tr>
	<tr>
	<tr>
	<tr>
		<td colspan="2" align="center"><input type="submit" value="Login"></td>
	</tr>
	<tr>
	<td colspan="2" align="center"><input type="reset" value="reset"></td></tr>
</table>
</center>
</form>
</div>
</body>
</html>