package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import factory.DAOFactory;
import vo.Orders;
import vo.Person;

/**
 * Servlet implementation class OrdersPayServlet
 */
@WebServlet(description = "订单支付", urlPatterns = { "/OrdersPayServlet" })
public class OrdersPayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrdersPayServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Orders> list = new ArrayList<Orders>();
		Person user = (Person) request.getSession().getAttribute("user");
		list = DAOFactory.getOrdersDAOInstance().searchBuy(user);
		for (Orders orders : list) {
			orders.setStates("已付款");
			DAOFactory.getOrdersDAOInstance().update(orders);
		}
		System.out.println("支付成功！");
		response.getWriter().println("<script LANGUAGE='javascript'> alert('支付成功！');history.go(-1);</script>");
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
