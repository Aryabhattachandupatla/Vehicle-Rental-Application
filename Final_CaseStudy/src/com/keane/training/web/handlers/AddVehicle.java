package com.keane.training.web.handlers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.keane.mvc.HttpRequestHandler;
import com.keane.training.dao.DAOAppException;
import com.keane.training.dao.VehicleDAO;
import com.keane.training.domain.Vehicle;

public class AddVehicle implements HttpRequestHandler {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		VehicleDAO dao=new VehicleDAO();
		Vehicle v=new Vehicle();
		v.setVno(request.getParameter("v_no"));
		v.setVtype(request.getParameter("v_type"));
		v.setVname(request.getParameter("v_name"));
		v.setPrice(Integer.parseInt(request.getParameter("v_p")));
		v.setStatus(request.getParameter("stat"));
		v.setDiscount(Integer.parseInt(request.getParameter("v_d")));
		
		
		//boolean isExists;
		try {
			int finalRes=dao.insertVehicle(v);
			if(finalRes>0)
			{

				RequestDispatcher dispatcher = request.getRequestDispatcher("..\\Pages\\success.jsp");
				request.setAttribute("success","Vehicle succesfully inserted!!");
				//request.setAttribute("details", v);
				dispatcher.forward(request, response);
			}
		}catch (Exception e) {
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("error.jsp");
			request.setAttribute("Err", e.getMessage());
			dispatcher.forward(request, response);

		}
		
		
		
	}

}
