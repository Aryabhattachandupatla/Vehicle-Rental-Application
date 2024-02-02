<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vehicle</title>
</head>
<style>
body{
padding-top:60:px;
padding-bottom:40px;
background:url("mou1.jpg");
background-repeat:no-repeat;
background-size:cover;}
</style>
<body>
<h2 align="center">Add Vehicle</h2>
<form action="vehicle.do">
<table>
<tr>
<td colspan="2"><c:if test="${requestScope.Err!=null }">
<font color="skyblue">${requestScope.Err }</font>
</c:if></td></tr>
<tr>
<td>Vehicle_no</td>
<td><input type="text" name="v_no"></td></tr>
<tr>
<td>Vehicle type</td>
<td><select name="v_type">
	<option value="CAR">CAR</option>
	<option value="BUS">BUS</option>
	<option value="SRIDE">SRIDE</option>
	<option value="SHUTTLE">SHUTTLE</option>
	<option value="BIKE">BIKE</option></select></td>
</tr>
<tr>
<td>Vehicle_Name</td>
<td><input type="text" name="v_name"></td></tr>
<tr>
<td>Price</td>
<td><input type="number" name="v_p"></td></tr>
<tr>
<td>Status</td>
<td><select name="stat">
	<option value="YES">Yes</option>
	<option value="NO">No</option></select></td>
</tr>
<tr>
<td>Discount</td>
<td><input type="number" name="v_d"></td></tr>
<tr>
		<td colspan="2" align="center"><input type="submit" value="Register"></td>
	</tr>
	</table></form>
</body>
</html>