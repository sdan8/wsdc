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
 * Servlet implementation class UserUpdateServlet
 */
@WebServlet(description = "用户信息更新", urlPatterns = { "/UserUpdateServlet" })
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdateServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String info = request.getParameter("info");

		if (info.equals("updateinfo")){			//修改个人信息
			String realname = request.getParameter("realname");
			String sex = request.getParameter("sex");
			String email = request.getParameter("email");
			Person person = (Person) request.getSession().getAttribute("user");
			person.setUser_realname(realname);
			person.setUser_sex(sex);
			person.setUser_mail(email);
			DAOFactory.getPersonDAOInstance().update(person);
			System.out.println("id: " + person.getUser_id());
			System.out.println("realname: " + person.getUser_realname());
			response.getWriter().println("<script LANGUAGE='javascript'> alert('修改成功！');history.go(-1);</script>");
			
		} else if (info.equals("updatepsw")){	//修改密码
			Person person = (Person) request.getSession().getAttribute("user");
			String oldPsw = DAOFactory.getPersonDAOInstance().searchById(person.getUser_id()).getUser_password();
			String psw = request.getParameter("psw");
			String newPsw = request.getParameter("psw1");
			if (oldPsw.equals(psw)){	//原密码正确
				person.setUser_password(newPsw);
				DAOFactory.getPersonDAOInstance().update(person);
				response.getWriter().println("<script LANGUAGE='javascript'> alert('密码修改成功！');history.go(-1);</script>");
			} else {					//原密码错误
				response.getWriter().println("<script LANGUAGE='javascript'> alert('原密码输入错误！');history.go(-1);</script>");
			}
		} else if (info.equals("findpsw")){		//找回密码
			String username = request.getParameter("username");
			String email = request.getParameter("email");
			String psw = request.getParameter("password1");
			Person user = new Person();
			user = DAOFactory.getPersonDAOInstance().searchByUsername(username);
			if (email.equals(user.getUser_mail())){		//邮箱正确
				user.setUser_password(psw);
				DAOFactory.getPersonDAOInstance().update(user);
				response.getWriter().println("<script LANGUAGE='javascript'> alert('密码修改成功！');self.location='register.jsp'</script>");
			} else {									//邮箱错误
				response.getWriter().println("<script LANGUAGE='javascript'> alert('邮箱输入错误！');history.go(-1);</script>");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
