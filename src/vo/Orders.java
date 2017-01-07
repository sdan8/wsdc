package vo;

import java.util.List;

import factory.DAOFactory;

/**
 * 订单类
 */
public class Orders {
	private int order_id;			//订单ID
	private Person user;			//用户ID，参照用户类
	private Menu menu;				//菜单ID，参照菜单类
	private int order_num;			//订购菜品数量
	private String order_notice;	//口味要求
	private String other_notice;	//其他要求
	private String states;			//订单付款状态
	
	private StringBuffer showBuyList;		//显示购物车列表
	private int total;						//购物车总数量
	private int totalPrice;					//所有商品总价格
	private StringBuffer showNoPayList;		//显示未支付列表
	private StringBuffer showPayList;		//显示已支付列表
	
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public Person getUser() {
		return user;
	}
	public void setUser(Person user) {
		this.user = user;
	}
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	public int getOrder_num() {
		return order_num;
	}
	public void setOrder_num(int order_num) {
		this.order_num = order_num;
	}
	public String getOrder_notice() {
		return order_notice;
	}
	public void setOrder_notice(String order_notice) {
		this.order_notice = order_notice;
	}
	public String getOther_notice() {
		return other_notice;
	}
	public void setOther_notice(String other_notice) {
		this.other_notice = other_notice;
	}
	public String getStates() {
		return states;
	}
	public void setStates(String states) {
		this.states = states;
	}
	/**
	 * 显示购物车列表
	 * @return
	 */
	public StringBuffer getShowBuyList() {
		showBuyList = new StringBuffer();
		List<Orders> list = DAOFactory.getOrdersDAOInstance().searchBuy(user);
		for (Orders orders : list) {
			showBuyList.append("<tr class=\"tr\"><td class=\"td1\"><span class=\"no\">");
			//编号
			showBuyList.append(orders.getOrder_id());
			showBuyList.append("</span></td><td class=\"td1\"><span class=\"food\">");
			//菜名
			showBuyList.append(orders.getMenu().getMenu_name());
			showBuyList.append("</span></td><td class=\"td1\"><span class=\"number\">");
			//数量
			showBuyList.append(orders.getOrder_num());
			showBuyList.append("</span></td><td class=\"td1\"><span class=\"per_price\">");
			//单价
			showBuyList.append(orders.getMenu().getMenu_price());
			showBuyList.append("</span></td><td class=\"td1\"><span class=\"price\">");
			//总价
			showBuyList.append(orders.getOrder_num()*orders.getMenu().getMenu_price());
			showBuyList.append("</span></td><td class=\"td1\"><span class=\"information\">");
			//备注：口味要求+其他要求
			showBuyList.append(orders.getOrder_notice() + "," + orders.getOther_notice());
			showBuyList.append("</span></td><td class=\"td1\"><span class=\"delete\"><a href=\"DeleteBuyServlet?id=" + orders.getOrder_id() + "\">删除</a></span></td></tr>");
		}
//		<tr class="tr">
//      <td class="td1"><span class="no">1</span></td>
//      <td class="td1"><span class="food">菜品</span></td>
//      <td class="td1"><span class="number">1</span></td>
//      <td class="td1"><span class="per_price">19.0</span></td>
//      <td class="td1"><span class="price">19.0</span></td>
//      <td class="td1"><span class="information">菜品信息</span></td>
//      <td class="td1"><span class="delete"><a href="#">删除</a></span></td>
//  	</tr>
		return showBuyList;
	}
	/**
	 * 返回总数量
	 * @return
	 */
	public int getTotal() {
		total = 0;
		List<Orders> list = DAOFactory.getOrdersDAOInstance().searchBuy(user);
		for (Orders orders : list) {
			total += orders.getOrder_num();
		}
		return total;
	}
	/**
	 * 所有商品总价格
	 * @return
	 */
	public int getTotalPrice() {
		totalPrice = 0;
		List<Orders> list = DAOFactory.getOrdersDAOInstance().searchBuy(user);
		for (Orders orders : list) {
			totalPrice += orders.getOrder_num() * orders.getMenu().getMenu_price();
			System.out.println(totalPrice);
		}
		return totalPrice;
	}
	/**
	 * 显示未支付列表
	 * @return
	 */
	public StringBuffer getShowNoPayList() {
		showNoPayList = new StringBuffer();
		List<Orders> list = DAOFactory.getOrdersDAOInstance().searchBuy(user);
		for (Orders orders : list) {
			showNoPayList.append("<tr class=\"tr\"><td class=\"td1\"><span class=\"no\">");
			showNoPayList.append(orders.getOrder_id());
			showNoPayList.append("</span></td><td class=\"td1\"><span class=\"food\">");
			showNoPayList.append(orders.getMenu().getMenu_name());
			showNoPayList.append("</span></td><td class=\"td1\"><span class=\"number\">");
			showNoPayList.append(orders.getOrder_num());
			showNoPayList.append("</span></td><td class=\"td1\"><span class=\"per_price\">");
			showNoPayList.append(orders.getMenu().getMenu_price());
			showNoPayList.append("</span></td><td class=\"td1\"><span class=\"price\">");
			showNoPayList.append(orders.getMenu().getMenu_price() * orders.getOrder_num());
			showNoPayList.append("</span></td><td class=\"td1\"><span class=\"information\">");
			showNoPayList.append(orders.getOrder_notice() + "," + orders.getOther_notice());
		}
		return showNoPayList;
//		<tr class="tr">
//        <td class="td1"><span class="no">1</span></td>
//        <td class="td1"><span class="food">菜品</span></td>
//        <td class="td1"><span class="number">1</span></td>
//        <td class="td1"><span class="per_price">19.0</span></td>
//        <td class="td1"><span class="price">19.0</span></td>
//        <td class="td1"><span class="information">菜品信息</span></td>
//    	</tr>
	}
	/**
	 * 显示已支付列表
	 * @return
	 */
	public StringBuffer getShowPayList() {
		showPayList = new StringBuffer();
		List<Orders> list = DAOFactory.getOrdersDAOInstance().searchPaidList(user);
		for (Orders orders : list) {
			showPayList.append("<tr class=\"tr\"><td class=\"td1\"><span class=\"no\">");
			showPayList.append(orders.getOrder_id());
			showPayList.append("</span></td><td class=\"td1\"><span class=\"food\">");
			showPayList.append(orders.getMenu().getMenu_name());
			showPayList.append("</span></td><td class=\"td1\"><span class=\"number\">");
			showPayList.append(orders.getOrder_num());
			showPayList.append("</span></td><td class=\"td1\"><span class=\"per_price\">");
			showPayList.append(orders.getMenu().getMenu_price());
			showPayList.append("</span></td><td class=\"td1\"><span class=\"price\">");
			showPayList.append(orders.getOrder_num() * orders.getMenu().getMenu_price());
			showPayList.append("</span></td><td class=\"td1\"><span class=\"information\">");
			showPayList.append(orders.getOrder_notice() + "," + orders.getOther_notice());
			showPayList.append("</span></td></tr>");
		}
		return showPayList;
		
//		<tr class="tr">
//        <td class="td1"><span class="no">1</span></td>
//        <td class="td1"><span class="food">菜品</span></td>
//        <td class="td1"><span class="number">1</span></td>
//        <td class="td1"><span class="per_price">19.0</span></td>
//        <td class="td1"><span class="price">19.0</span></td>
//        <td class="td1"><span class="information">菜品信息</span></td>
//    	</tr>
	}
	
	
}
