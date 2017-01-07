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
 * Servlet implementation class UserRegisterServlet
 */
@WebServlet(description = "用户注册Servlet", urlPatterns = { "/UserRegisterServlet" })
public class UserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegisterServlet() {
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
		user.setUser_realname(request.getParameter("realname"));
		user.setUser_sex(request.getParameter("sex"));
		user.setUser_flag("普通用户");		//默认注册为普通用户
		user.setUser_mail(request.getParameter("email"));
		//判断用户是否已经注册
		if (DAOFactory.getPersonDAOInstance().searchByUsername(user)){
			response.getWriter().println("<script LANGUAGE='javascript'> alert('该用户已存在');self.location='register.jsp'</script>");
		} else {
			DAOFactory.getPersonDAOInstance().save(user);
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			response.getWriter().println("<script LANGUAGE='javascript'> alert('注册成功！');self.location='register.jsp'</script>");
			System.out.println("注册成功！");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
