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
 * Servlet implementation class DeleteMenuServlet
 */
@WebServlet(description = "删除菜品", urlPatterns = { "/DeleteMenuServlet" })
public class DeleteMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteMenuServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String foodId = request.getParameter("food_id");
		int id = Integer.parseInt(foodId);
		Menu menu = DAOFactory.getMenuDAOInstance().searchById(id);
		DAOFactory.getMenuDAOInstance().delete(menu);
		response.sendRedirect("update_food.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
