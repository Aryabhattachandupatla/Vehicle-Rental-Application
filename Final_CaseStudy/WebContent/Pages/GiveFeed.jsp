<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
background:url("b1.jpg");
background-repeat:no-repeat;
background-size:cover;}
</style>
<body>
<h2 align="center">GiveFeedback</h2>
<form action="feed.do">
<p>Enter Vehicle number to give feedback</p>
<table>
<tr>
<td>USER ID</td>
<td><input type="text" name="v_no"></td>
</tr>
<tr>
<td>Feedback</td>
<td><input type="text" name="feed"></td>
</tr>
<tr>
		<td colspan="2" align="center"><input type="submit" value="ADD"></td>
	</tr>
</table>
</form>
</body>
</html>