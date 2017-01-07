package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import factory.DAOFactory;
import vo.Menu;

/**
 * Servlet implementation class UpdateMenuServlet
 */
@WebServlet(description = "更新菜品", urlPatterns = { "/UpdateMenuServlet" })
public class UpdateMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMenuServlet() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String menu_id = request.getParameter("foodId");
		String price = request.getParameter("price");
		Menu menu = DAOFactory.getMenuDAOInstance().searchById(Integer.parseInt(menu_id));
		if (menu != null){
			menu.setMenu_price(Double.parseDouble(price));			
			DAOFactory.getMenuDAOInstance().update(menu);
			response.getWriter().println("<script LANGUAGE='javascript'> alert('修改成功！');history.go(-1);</script>");
		} else {
			response.getWriter().println("<script LANGUAGE='javascript'> alert('菜品ID输入错误！');history.go(-1);</script>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
