package assign.servlets;

import java.io.*;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import assign.dbaccess.EMailAddressVOO;
import assign.dbaccess.EMailDBAccess;
import assign.dbaccess.EMailBO;
import assign.dbaccess.EMailValidationException;

/*
 * Get All Email Addresses by Group Servlet 
 */

@WebServlet("/GroupMail")
public class GetAllEMailListbyGroupServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String errors = "";
		String groupID = request.getParameter("groupid");
		response.setContentType("text/html");

		EMailBO eMailBO = new EMailBO();
		ArrayList eMailAddress = null;

		try {
			eMailAddress = eMailBO.getAllEMailAddressListbyGroup(groupID);
			System.out.println("email address is: " + eMailAddress);
		} catch (EMailValidationException emve) {
			errors = emve.getErrorMessage();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (errors.equals("")) {
			request.getSession().setAttribute("emailList", eMailAddress);
			response.sendRedirect("/mysite/viewbygroupsuccess.jsp");

		} else {
			request.getSession().setAttribute("Errors", errors);
			response.sendRedirect("/mysite/error.jsp");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		doGet(request, response);
	}

}
