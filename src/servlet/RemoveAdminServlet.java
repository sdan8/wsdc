package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import factory.DAOFactory;
import vo.Person;

/**
 * Servlet implementation class RemoveAdminServlet
 */
@WebServlet(description = "删除管理员", urlPatterns = { "/RemoveAdminServlet" })
public class RemoveAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveAdminServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("user_id"));
		Person user = DAOFactory.getPersonDAOInstance().searchById(id);
		user.setUser_flag("普通用户");
		DAOFactory.getPersonDAOInstance().update(user);
		response.getWriter().println("<script LANGUAGE='javascript'> alert('删除管理员成功！');history.go(-1);</script>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
