package servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.SmartUpload;

import factory.DAOFactory;
import vo.Menu;


/**
 * Servlet implementation class AddMenuServlet
 */
@WebServlet(description = "添加菜品", urlPatterns = { "/AddMenuServlet" })
public class AddMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletConfig servletConfig;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMenuServlet() {
        super();

    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		this.servletConfig = config;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//新建一个SmartUpload对象
			SmartUpload su = new SmartUpload();
			//上传初始化
			su.initialize(servletConfig, request, response);
			//限制每个上传文件的最大长度
			su.setMaxFileSize(1000000);
			//限制总上传数据的长度
//			su.setTotalMaxFileSize(200000);
			//设定允许上传的文件（通过扩展名限制），仅允许jpg，png文件
//			su.setAllowedFilesList("jpg,png");
			//设定禁止上传的文件（通过扩展名限制），禁止上传带有exe,bat,jsp,htm,html扩展名的文件和没有扩展名的文件
			su.setDeniedFilesList("exe,bat,jsp,htm,html");
			//上传文件
			su.upload();
			//获取上传的文件操作
			Files files = su.getFiles();
			//获取单个文件
			File singleFile = files.getFile(0);
			//获取上传文件的扩展名
			String fileType = singleFile.getFileExt();
			//设置上传文件的扩展名
			String[] type = {"JPG","jpg"};
			// 判断上传文件的类型是否正确
			int place = java.util.Arrays.binarySearch(type, fileType);
			//判断文件扩展名是否正确
			if (place != -1){
				//判断该文件是否被选择
				if (!singleFile.isMissing()){
//					String picSize = String.valueOf(singleFile.getSize());
					
					//以系统时间作为上传文件名称，设置上传完整路径
					String fileName = String.valueOf(System.currentTimeMillis());
					String filedir = "images/" + fileName + "." + singleFile.getFileExt();
//					String smalldir = "samllImages/" + fileName + "." + singleFile.getFileExt();
					
					
//					String sql = "INSERT INTO image(image) VALUES(" + fileName + ")";
					
					//执行上传操作
					singleFile.saveAs(filedir, File.SAVEAS_VIRTUAL);
					System.out.println("上传至： " + filedir);
					String menuName = su.getRequest().getParameter("menuName");
					String menuPrice = su.getRequest().getParameter("menuPrice");
					String menuNotice = su.getRequest().getParameter("menuNotice");
					Menu menu = new Menu();
					menu.setMenu_name(menuName);
					menu.setMenu_content(menuNotice);
					Double price = Double.parseDouble(menuPrice);
					menu.setMenu_price(price);
					menu.setMenu_image(fileName);
					DAOFactory.getMenuDAOInstance().save(menu);
					System.out.println("menuName: " + menuName);
					System.out.println("menuPrice: " + menuPrice);
					System.out.println("menuNotice: " + menuNotice);
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("add_food.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
