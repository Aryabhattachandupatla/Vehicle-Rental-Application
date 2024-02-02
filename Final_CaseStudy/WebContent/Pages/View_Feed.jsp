<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
    <%@ page import="java.util.Iterator" %>
    <%@ page import="com.keane.training.dao.VehicleDAO" %>
    <%@ page import="com.keane.training.domain.Rented" %>
    <%@ page import="com.keane.dbfw.DBFWException" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="mintcream">
<%
try{
List clist=null;
VehicleDAO v=new VehicleDAO();
clist=v.getRented();
%>
<form>
<center>
<h1>Feedback</h1>
<table border='1'>
<tr><td>User Id</td><td>Vehicle_No</td><td>Feedback</td></tr>
<%
for(Iterator it=clist.iterator();it.hasNext();)
{
	Rented r1=(Rented)it.next();
	%>
	<tr><td><%=r1.getId() %></td><td><%=r1.getVehicle_no() %></td><td><%=r1.getFeedback() %></td></tr>
<%
}
}catch(DBFWException e)
{
	e.printStackTrace();
	
}
%>
</table>
</center>
</body>
</html>