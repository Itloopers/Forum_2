package forum;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.SubjectUtils;

@WebServlet(urlPatterns = "/subjects")
public class SubjectServlet extends HttpServlet {

	private static final long serialVersionUID = 1979840653122810101L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("subjectList", SubjectUtils.getSubjectList());
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/views/subjects.jsp?");
		requestDispatcher.forward(req, resp);
	}

	/*
	 * @Override protected void doPost(HttpServletRequest req, HttpServletResponse
	 * resp) throws ServletException, IOException {
	 * 
	 * HttpSession session = req.getSession(); if
	 * (UserRegistration.registerUser(req.getParameter("username"),
	 * req.getParameter("password"), req.getParameter("password"))) {
	 * session.setAttribute("loginPageMessage",
	 * String.format("User %s register successful.", req.getParameter("username")));
	 * resp.sendRedirect("login");
	 * 
	 * } else { session.setAttribute("loginPageMessage", "Something went wrong!");
	 * RequestDispatcher requestDispatcher =
	 * req.getRequestDispatcher("WEB-INF/views/login.jsp");
	 * requestDispatcher.forward(req, resp); } }
	 */

}
