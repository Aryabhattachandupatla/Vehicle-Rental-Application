package com.keane.training.web.handlers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import com.keane.mvc.HttpRequestHandler;
import com.keane.training.dao.DAOAppException;
import com.keane.training.dao.RegisterDAO;
import com.keane.training.domain.User;

public class RegisterUser implements HttpRequestHandler {
	static Logger log = Logger.getLogger(RegisterUser.class);

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RegisterDAO dao = new RegisterDAO();
	    User user = new User();
		user.setUid(Integer.parseInt(request.getParameter("uid")));
		user.setName(request.getParameter("name"));
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		user.setContactno(Integer.parseInt(request.getParameter("contactno")));
		user.setRno(Integer.parseInt(request.getParameter("rno")));
		user.setCity(request.getParameter("city"));

		boolean isExists;
		try {
			isExists = dao.validateUser(user.getUid());

			if (isExists) {
				log.info("User already registered");
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("..\\Pages\\Register.jsp");
				request.setAttribute("Err",
						"User already registered with the system");
				dispatcher.forward(request, response);
			} else {
				/*user.setPassword("NttData@"
						+ Integer.toString(user.getUid()));*/
				int finalRes = dao.registerUser(user);
				if (finalRes > 0) {

					RequestDispatcher dispatcher = request
							.getRequestDispatcher("..\\Pages\\success.jsp");
					request.setAttribute("success",
							"User succesfully registered with the system");
					request.setAttribute("details", user);
					dispatcher.forward(request, response);
				}
			}
		} catch (DAOAppException e) {
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("error.jsp");
			request.setAttribute("Err", e.getMessage());
			dispatcher.forward(request, response);
		}
	}

}
