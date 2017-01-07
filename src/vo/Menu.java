package vo;

import java.util.List;

import factory.DAOFactory;

/**
 * 菜单类
 */
public class Menu {
	private int menu_id;			//菜单ID
	private String menu_name;		//菜单名
	private String menu_content;	//菜单简介
	private double menu_price;		//菜单单价
	private String menu_image;
	
	private StringBuffer showMenuList;		//列出菜单
	private StringBuffer showMenuTop;		//列出推荐菜单
	private StringBuffer showUpdateList;	//更新菜单列表
	private StringBuffer showMenuTopUpdate;	//列出推荐菜单删除操作
	private StringBuffer showMenuUpdate;	//列出所有菜单推荐操作
	
	
	public int getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}
	public String getMenu_name() {
		return menu_name;
	}
	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}
	public String getMenu_content() {
		return menu_content;
	}
	public void setMenu_content(String menu_content) {
		this.menu_content = menu_content;
	}
	public double getMenu_price() {
		return menu_price;
	}
	public void setMenu_price(double menu_price) {
		this.menu_price = menu_price;
	}
	public String getMenu_image() {
		return menu_image;
	}
	public void setMenu_image(String menu_image) {
		this.menu_image = menu_image;
	}
	public StringBuffer getShowMenuList() {
		List<Menu> list = DAOFactory.getMenuDAOInstance().showAllList();
		showMenuList = new StringBuffer();
		for (Menu menu : list) {
			showMenuList.append("<li class=\"content\"><figure class=\"fig\"><img src=\"images/");
			showMenuList.append(menu.getMenu_image() + ".jpg\" width=\"200px\" class=\"img\"/>");
			showMenuList.append("<figcaption class=\"describe\">");
			showMenuList.append("<p class=\"name\">" + menu.getMenu_name() + "</p>");
			showMenuList.append("<p class=\"price\"><span class=\"sign\">￥</span><span class=\"current\">");
			showMenuList.append(menu.getMenu_price());
			showMenuList.append("/份</span></p><div class=\"buying\"><a href=\"information.jsp?id=" + menu.getMenu_id() + "\">加入购物车</a></div></figcaption></figure></li>");
			
//			<li class="content">
//            <figure class="fig">
//                <img src="images/1.jpg" width="200px" class="img"/>
//                <figcaption class="describe">
//                    <p class="name">图片</p>
//                    <p class="price">
//                        <span class="sign">￥</span>
//                        <span class="current">19/份</span>
//                    </p>
//                    <div class="buying">
//                        <a href="information.jsp?id=1">加入购物车</a>
//                    </div>
//                </figcaption>
//            </figure>
//        </li>
		}
		return showMenuList;
	}
	public StringBuffer getShowMenuTop() {
		List<Menu> list = DAOFactory.getMenuDAOInstance().showTopList();
		showMenuTop = new StringBuffer();
		for (Menu menu : list) {
			showMenuTop.append("<li class=\"content\"><figure class=\"fig\"><img src=\"images/");
			showMenuTop.append(menu.getMenu_image() + ".jpg\" width=\"200px\" class=\"img\"/>");
			showMenuTop.append("<figcaption class=\"describe\"><p class=\"name\">");
			showMenuTop.append(menu.getMenu_name());
			showMenuTop.append("</p><p class=\"price\"><span class=\"sign\">￥</span><span class=\"current\">");
			showMenuTop.append(menu.getMenu_price() + "/份</span>");
			showMenuTop.append("</p><div class=\"buying\"><a href=\"information.jsp?id=" + menu.getMenu_id() + "\">加入购物车</a></div></figcaption></figure></li>");
		}
//		<li class="content">
//        <figure class="fig">
//            <img src="images/1.jpg" width="200px" class="img"/>
//            <figcaption class="describe">
//                <p class="name">图片</p>
//                <p class="price">
//                    <span class="sign">￥</span>
//                    <span class="current">19/份</span>
//                </p>
//                <div class="buying">
//                    加入购物车
//                </div>
//            </figcaption>
//        </figure>
//    </li>
		return showMenuTop;
	}
	public StringBuffer getShowUpdateList() {
		List<Menu> list = DAOFactory.getMenuDAOInstance().showAllList();
		showUpdateList = new StringBuffer();
		for (Menu menu : list) {
			showUpdateList.append("<tr><td class=\"food_id\">");
			showUpdateList.append(menu.getMenu_id());
			showUpdateList.append("</td><td class=\"food_name\">");
			showUpdateList.append(menu.getMenu_name());
			showUpdateList.append("</td><td class=\"price\">");
			showUpdateList.append(menu.getMenu_price());
			showUpdateList.append("</td><td class=\"infor\">");
			showUpdateList.append(menu.getMenu_content());
			showUpdateList.append("</td></tr>");
		}
//		<tr>
//        <td class="food_id">01</td>
//        <td class="food_name">菜名</td>
//        <td class="price">19</td>
//        <td class="infor">菜品信息</td>
//    	</tr>
		return showUpdateList;
	}
	public StringBuffer getShowMenuTopUpdate() {
		System.out.println("getShowMenuTopUpdate");
		showMenuTopUpdate = new StringBuffer();
		List<Menu> list = DAOFactory.getMenuDAOInstance().showTopList();
		for (Menu menu : list) {
			showMenuTopUpdate.append("<tr><td class=\"food_id\">");
			showMenuTopUpdate.append(menu.getMenu_id());
			showMenuTopUpdate.append("</td><td class=\"food_name\">");
			showMenuTopUpdate.append(menu.getMenu_name());
			showMenuTopUpdate.append("</td><td class=\"price\">");
			showMenuTopUpdate.append(menu.getMenu_price());
			showMenuTopUpdate.append("</td><td class=\"infor\">");
			showMenuTopUpdate.append(menu.getMenu_content());
			showMenuTopUpdate.append("</td><td class=\"op\"><span class=\"delete\"><a href=\"");
			showMenuTopUpdate.append("RemoveMenuTopServlet?id=" + menu.getMenu_id());		//删除操作链接
			showMenuTopUpdate.append("\">删除</a></span></td></tr>");
			System.out.println("menu");
		}
//		<tr>
//        <td class="food_id">01</td>
//        <td class="food_name">菜名</td>
//        <td class="price">19</td>
//        <td class="infor">菜品信息</td>
//        <td class="op"><span class="delete"><a href="#">增加</a></span></td>
//    	</tr>
		return showMenuTopUpdate;
	}
	public StringBuffer getShowMenuUpdate() {
		showMenuUpdate = new StringBuffer();
		List<Menu> list = DAOFactory.getMenuDAOInstance().showAllList();
		for (Menu menu : list) {
			showMenuUpdate.append("<tr><td class=\"food_id\">");
			showMenuUpdate.append(menu.getMenu_id());
			showMenuUpdate.append("</td><td class=\"food_name\">");
			showMenuUpdate.append(menu.getMenu_name());
			showMenuUpdate.append("</td><td class=\"price\">");
			showMenuUpdate.append(menu.getMenu_price());
			showMenuUpdate.append("</td><td class=\"infor\">");
			showMenuUpdate.append(menu.getMenu_content());
			showMenuUpdate.append("</td><td class=\"op\"><span class=\"delete\"><a href=\"");
			showMenuUpdate.append("AddMenuTopServlet?id=" + menu.getMenu_id());		//增加操作链接
			showMenuUpdate.append("\">增加</a></span></td></tr>");
		}
//		<tr>
//        <td class="food_id">01</td>
//        <td class="food_name">菜名</td>
//        <td class="price">19</td>
//        <td class="infor">菜品信息</td>
//        <td class="op"><span class="delete"><a href="#">增加</a></span></td>
		return showMenuUpdate;
	}
	
}
