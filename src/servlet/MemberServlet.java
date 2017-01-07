package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.Person;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet(description = "会员管理", urlPatterns = { "/MemberServlet" })
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Person user = (Person) request.getSession().getAttribute("user");
		if (user == null){
			response.sendRedirect("register.jsp");
			return;
		}
		if (user.getUser_id() <= 0){
			response.sendRedirect("register.jsp");
			return;
		}
		if ("管理员".equals(user.getUser_flag())){
			response.sendRedirect("adm.jsp");
		} else {
			response.sendRedirect("user.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
