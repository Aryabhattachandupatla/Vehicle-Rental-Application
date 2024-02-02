<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
    <%@ page import="java.util.Iterator" %>
    <%@ page import="com.keane.training.dao.VehicleDAO" %>
    <%@ page import="com.keane.training.domain.Vehicle" %>
    <%@ page import="com.keane.dbfw.DBFWException" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
body{
padding-top:60:px;
padding-bottom:40px;
background:url("a1.jpg");
background-repeat:no-repeat;
background-size:cover;}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
try{
List clist=null;
VehicleDAO v=new VehicleDAO();
clist=v.getPrice();
%>
<form>
<center>
<h1>Vehicle PRICE Details</h1>
<table border='1'>
<tr><td>Vehicle_No</td><td>Vehicle_Type</td><td>Vehicle_Name</td><td>NEW PRICE</td></tr>
<%
for(Iterator it=clist.iterator();it.hasNext();)
{
	Vehicle v1=(Vehicle)it.next();
	%>
	<tr><td><%=v1.getVno() %></td><td><%=v1.getVtype() %></td><td><%=v1.getVname() %></td><td><%=v1.getPrice() %></td></tr>
<%
}
}catch(DBFWException e)
{
	e.printStackTrace();
	
}
%>


</table></center></form>

</body>
</html>