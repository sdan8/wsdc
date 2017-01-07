package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import factory.DAOFactory;
import vo.Person;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet(description = "用户登录动作处理", urlPatterns = { "/UserLoginServlet" })
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		Person user = new Person();
		user.setUser_name(request.getParameter("username"));
		user.setUser_password(request.getParameter("password"));
		//判断是否登录成功
		Person curUser = DAOFactory.getPersonDAOInstance().validatePassword(user);
		if (curUser != null){
			HttpSession session = request.getSession(true);
			session.setAttribute("user", curUser);
			response.sendRedirect("index.jsp");
		} else {
			response.getWriter().println("<script LANGUAGE='javascript'> alert('用户名或密码错误！');self.location='register.jsp'</script>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
