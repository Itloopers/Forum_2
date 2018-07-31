package forum;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.entity.UserAccount;
import utils.UserAccountUtils;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 7601979219166327493L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		if (req.getSession().getAttribute("user") == null) {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/views/login.jsp");
			requestDispatcher.forward(req, resp);
		} else {
			resp.sendRedirect("subjects");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if (UserAccountUtils.isUserValid(req.getParameter("username"), req.getParameter("password"))) {
			UserAccount userAccount = UserAccountUtils.getUserAccount(req.getParameter("username"),
					req.getParameter("password"));
			UserAccountUtils.setSessionUser(session, userAccount);
			resp.sendRedirect("subjects");

		} else {
			session.setAttribute("loginPageMessage", "You entered incorrect credentials!");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/views/login.jsp");
			requestDispatcher.forward(req, resp);
		}
	}

}
