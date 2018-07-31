package forum;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.entity.UserAccount;
import utils.PostUtils;

@WebServlet(urlPatterns = "/newPost")
public class NewPostServlet extends HttpServlet {

	private static final long serialVersionUID = -357337770493900690L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String subject = req.getParameter("subject");
		req.setAttribute("currentSub", subject);
		String content = req.getParameter("content");
		UserAccount user = (UserAccount) req.getSession().getAttribute("user");
		if (subject == null || content.isEmpty()) {
			String errorMsg = "Contetnt field are required";
			req.getRequestDispatcher(String.format("posts?error=%s", errorMsg)).forward(req, resp);
		} else {
			PostUtils.create((String) req.getAttribute("currentSub"), content, user);
			String errorMsg = String.format("Post created in the: %s",(String) req.getAttribute("currentSub"));
			resp.sendRedirect(String.format("posts?subject=%s&error=%s",req.getAttribute("currentSub") ,errorMsg));
			
		}
	}
}
