package com.keane.training.web.handlers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.keane.mvc.HttpRequestHandler;
import com.keane.training.dao.VehicleDAO;
import com.keane.training.domain.Vehicle;

public class Booked implements HttpRequestHandler {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			//int type=Integer.parseInt(request.getParameter("uid"));
			VehicleDAO dao=new VehicleDAO();
			PrintWriter out=response.getWriter();
			int num=Integer.parseInt(request.getParameter("uid"));
			List res=VehicleDAO.bookedVehicles(num);
			out.print("<table border='1'><tr><td>Vehicle No</td><td>Vehicle Name</td><td>Vehicle type</td></tr>");
			
			if(!(res.isEmpty()))
			{
				for(Iterator it=res.iterator();it.hasNext();)
				{
					Vehicle v1=(Vehicle)it.next();
					out.print("<tr><td>"+v1.getVno()+"</td><td>"+v1. getVname()+"</td><td>"+v1.getVtype());
				}
				out.print("/table");
			}
		
		else {
			out.print("Invalid Type");
		}
		
	}catch(Exception e)
		{
		e.printStackTrace();
		}
	}

}
