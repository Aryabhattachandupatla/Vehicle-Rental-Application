package com.keane.training.web.handlers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.keane.mvc.HttpRequestHandler;
import com.keane.training.dao.VehicleDAO;
import com.keane.training.domain.Rented;

public class BookVeh implements HttpRequestHandler{
	static Logger log = Logger.getLogger(RegisterUser.class);
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			VehicleDAO dao=new VehicleDAO();
			Rented v=new Rented();
			int d=Integer.parseInt(request.getParameter("v_d"));
			
			String v_n=request.getParameter("v_no");
			PrintWriter out=response.getWriter();
			int res=dao.insertRented(d,v_n);
			out.print(res);
			if(res!=0)
			{
				//out.print("Avalibale Vehicles for booking");
				RequestDispatcher dispatcher = request.getRequestDispatcher("success.jsp");
				request.setAttribute("success","Vehicle Booked succesfully");
				dispatcher.include(request, response);
			}
			
		}
		catch (Exception e) {
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("error.jsp");
			request.setAttribute("Err", e.getMessage());
			dispatcher.forward(request, response);

	}

}}
