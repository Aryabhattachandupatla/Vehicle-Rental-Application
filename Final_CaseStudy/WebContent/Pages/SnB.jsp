<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.util.List" %>
    <%@ page import="java.util.Iterator" %>
    <%@ page import="com.keane.training.dao.VehicleDAO" %>
    <%@ page import="com.keane.training.domain.Vehicle" %>
    <%@ page import="com.keane.dbfw.DBFWException" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
try{
List clist=null;
VehicleDAO v=new VehicleDAO();
clist=v.getState();
%>
<form>
<center>
<h1>AVAILABLE VEHICLES</h1>
<table border='1'>
<tr><td>Vehicle_No</td><td>Vehicle_Type</td><td>Vehicle_Name</td><td>VEHICLE_PRICE</td><td>status</td></tr>
<%
for(Iterator it=clist.iterator();it.hasNext();)
{
	Vehicle v1=(Vehicle)it.next();
	%>
	<tr><td><%=v1.getVno() %></td><td><%=v1.getVtype() %></td><td><%=v1.getVname() %></td><td><%=v1.getPrice() %></td><td><%=v1.getStatus() %></td></tr>
<%
}
}catch(DBFWException e)
{
	e.printStackTrace();
	
}
%>
</table></center></form>
<% if(request.getAttribute("success")!=null)
	{
	out.print(request.getAttribute("success"));
	}
	%>
<a href="..\Pages\View_Veh.jsp">1.Search Vehicle</a>
 <form action="VehBook.do">
<p>Enter Vehicle type to search</p>
<table>
<tr>
<td>User_id</td>
<td><input type="number" name="v_d"></td></tr>
<tr>
<td>Vehicle_Number</td>
<td><input type="text" name="v_no"></td></tr>
<tr>
		<td colspan="2" align="center"><input type="submit" value="ADD"></td>
	</tr>
</table>
 </form>
</body>
</html>