package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import factory.DAOFactory;
import vo.Menu;
import vo.Orders;
import vo.Person;

/**
 * Servlet implementation class OrderAddServlet
 */
@WebServlet(description = "添加订单", urlPatterns = { "/OrderAddServlet" })
public class OrderAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderAddServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Orders order = new Orders();
		Menu menu = DAOFactory.getMenuDAOInstance().searchById(Integer.parseInt(request.getParameter("id")));
		Person user = (Person) request.getSession().getAttribute("user");
		System.out.println(user.getUser_name());
		order.setUser(user);
		order.setMenu(menu);
		order.setOrder_num(Integer.parseInt(request.getParameter("number")));
		order.setOrder_notice(request.getParameter("notice"));
		order.setOther_notice(request.getParameter("otherNotice"));
		order.setStates("未付款");
		DAOFactory.getOrdersDAOInstance().save(order);
		response.getWriter().println("<script LANGUAGE='javascript'> alert('加入购物车成功！');history.go(-1);</script>");
		
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
