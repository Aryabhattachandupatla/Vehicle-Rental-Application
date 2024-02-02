<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="lightgray">
<h2 align="center">Add Discount</h2>
<form action="VehicleDis.do">
<p> give Vehicle name to add discount</p>
<table>
<tr>
<td>Vehicle_Name</td>
<td><input type="text" name="v_name"></td>
</tr>
<tr>
<td>Discount</td>
<td><input type="text" name="v_d"></td>
</tr>
<tr>
		<td colspan="2" align="center"><input type="submit" value="ADD"></td>
	</tr></table></form>

</body>
</html>