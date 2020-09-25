package assign.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import assign.dbaccess.EMailAddressVOO;
import assign.dbaccess.EMailBO;
import assign.dbaccess.EMailValidationException;

/**
 * Servlet implementation class GetEMailAddressUpdateSuccess : ritika
 */

@WebServlet("/updatesuccess")
public class GetEMailAddressUpdateSuccess extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		EMailAddressVOO eMailAddressVOO = (EMailAddressVOO) request.getSession().getAttribute("emailVOO");
		eMailAddressVOO.setwPhone(request.getParameter("wphone"));
		eMailAddressVOO.setmPhone(request.getParameter("mphone"));

		EMailBO eMailBO = new EMailBO();
		String errors = "";
		try {
			eMailBO.updateEMailAddress(eMailAddressVOO);
		} catch (EMailValidationException e) {
			errors = e.getErrorMessage();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Updated Successfully");

		if (errors.equals("")) {
			System.out.println("first Name: " + eMailAddressVOO.getfName());
			request.setAttribute("emailVO", eMailAddressVOO);
			RequestDispatcher rd = request.getRequestDispatcher("/displayrecordupdatesuccess.jsp");
			rd.forward(request, response);
		} else {
			request.getSession().setAttribute("Errors", errors);
			response.sendRedirect("/mysite/modifycontact.jsp");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
