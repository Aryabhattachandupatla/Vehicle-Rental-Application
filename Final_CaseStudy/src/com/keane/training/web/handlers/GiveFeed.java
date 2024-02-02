package com.keane.training.web.handlers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.keane.mvc.HttpRequestHandler;
import com.keane.training.dao.VehicleDAO;
import com.keane.training.domain.Rented;

public class GiveFeed implements HttpRequestHandler {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			VehicleDAO dao=new VehicleDAO();
			Rented v=new Rented();
			//String v_n=request.getParameter("v_no");
			String f=request.getParameter("feed");
			int d=Integer.parseInt(request.getParameter("v_no"));
			
			PrintWriter out=response.getWriter();
			int res=dao.updateFeedback(f,d);
			out.print(res);
			if(res!=0)
			{
				out.print("Feedback given successfully!!!");
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("..\\Pages\\success.jsp");
				request.setAttribute("success",
						"Feedback succesfully given");
				dispatcher.forward(request, response);
			}
			
			}
			catch (Exception e) {
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("error.jsp");
				request.setAttribute("Err", e.getMessage());
				dispatcher.forward(request, response);

		}
			
		}
		
	}


