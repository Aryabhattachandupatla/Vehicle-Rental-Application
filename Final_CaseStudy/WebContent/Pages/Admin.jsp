<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="login.do" id="register">

<table>
	<tr>
		<td colspan="2"><c:if test="${requestScope.Err!=null}">
			<font color="red">${requestScope.Err}</font>
		</c:if></td>
	</tr>
	<tr>
		<td>Role no</td>
		<td><input type="text" name="role_no"></td>
	</tr>
	
	<tr>
		<td>User id</td>
		<td><input type="text" name="user_id"></td>
	</tr>
	<tr>
		<td>password</td>
		<td><input type="password" name="password"></td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="submit" value="Login"></td>
	</tr>
</table>
</form>
</body>
</html>