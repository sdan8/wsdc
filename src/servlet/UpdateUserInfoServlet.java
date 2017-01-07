package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import factory.DAOFactory;
import vo.Person;
import vo.UserInfo;

/**
 * Servlet implementation class UpdateUserInfoServlet
 */
@WebServlet(description = "更新配送地址", urlPatterns = { "/UpdateUserInfoServlet" })
public class UpdateUserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserInfoServlet() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String address = request.getParameter("address");
		String tel = request.getParameter("tel");
		String mobile = request.getParameter("mobile");
		Person user = (Person) request.getSession().getAttribute("user");
		
		UserInfo userInfo = DAOFactory.getUserInfoDAOInstance().searchByUser(user);
		if (userInfo == null || userInfo.getId() <= 0){
			//创建配送信息
			userInfo.setUser(user);
			userInfo.setAddress(address);
			userInfo.setTel(tel);
			userInfo.setMobile(mobile);
			DAOFactory.getUserInfoDAOInstance().save(userInfo);
		} else {
			//更新配送信息
			System.out.println(userInfo.getId());
			userInfo.setUser(user);
			userInfo.setAddress(address);
			userInfo.setTel(tel);
			userInfo.setMobile(mobile);
			DAOFactory.getUserInfoDAOInstance().update(userInfo);
		}
		response.getWriter().println("<script LANGUAGE='javascript'> alert('更新成功！');history.go(-1);</script>");
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
