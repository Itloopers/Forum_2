package forum;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.PostUtils;

@WebServlet(urlPatterns = "/deletePost")
public class DeletePostServlet extends HttpServlet {

	private static final long serialVersionUID = 2938582502960342443L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long postId = Long.valueOf(req.getParameter("postId"));
		PostUtils.delete(postId);

		req.setAttribute("currentSub", req.getParameter("subject"));
		req.setAttribute("postList", PostUtils.getPostList((String) req.getAttribute("currentSub")));
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/views/posts.jsp?");
		requestDispatcher.forward(req, resp);
	}

}
