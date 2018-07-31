package forum;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.UserAccountUtils;

@WebServlet(urlPatterns = "/newUser")
public class NewUserServlet extends HttpServlet {

	private static final long serialVersionUID = 1584840653122817860L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getSession().invalidate();
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/views/newUser.jsp");
		requestDispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		if (UserAccountUtils.registerUser(req.getParameter("username"), req.getParameter("password"),
				req.getParameter("password2"))) {
			session.setAttribute("loginPageMessage",
					String.format("User %s register successful.", req.getParameter("username")));
			resp.sendRedirect("login");

		} else {
			session.setAttribute("loginPageMessage", "Something went wrong!");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/views/login.jsp");
			requestDispatcher.forward(req, resp);
		}
	}

}
