package forum;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.entity.UserAccount;
import utils.SubjectUtils;

@WebServlet(urlPatterns="/newSubject")
public class NewSubjectServlet extends HttpServlet{

	private static final long serialVersionUID = 5289129616693998068L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String subject = req.getParameter("subject");
		String content = req.getParameter("content");
		UserAccount user = (UserAccount)req.getSession().getAttribute("user");
		if(subject.isEmpty() || content.isEmpty()) {
			resp.sendRedirect("subjects?error=All fields are required.");	
		}else if(SubjectUtils.getSubjectList().stream().anyMatch(sub -> sub.getName().equals(subject))){
			resp.sendRedirect(String.format("subjects?error=Subject: %s already exists.",subject));				
		}else {
			SubjectUtils.create(subject, content, user);
			resp.sendRedirect("subjects");		
		}
	}
}
