package com.keane.training.web.handlers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.keane.mvc.HttpRequestHandler;
import com.keane.training.dao.DAOAppException;
import com.keane.training.dao.VehicleDAO;
import com.keane.training.domain.Vehicle;

public class AddDisc implements HttpRequestHandler {
	static Logger log = Logger.getLogger(RegisterUser.class);
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
		VehicleDAO dao=new VehicleDAO();
		Vehicle v=new Vehicle();
		String v_n=request.getParameter("v_name");
		int d=Integer.parseInt(request.getParameter("v_d"));
		
		PrintWriter out=response.getWriter();
		int res=dao.updatedDiscount(d,v_n);
		out.print(res);
		if(res!=0)
		{
			out.print("Discount added successfully");
			request.setAttribute("success","DISCOUNT SUCCESSFULLY APPLIED!!");
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("success.jsp");
		
			dispatcher.forward(request, response);
		}
		
		}
		catch (Exception e) {
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("error.jsp");
			request.setAttribute("Err", e.getMessage());
			dispatcher.forward(request, response);

	}

}}
