package factory;

import dao.IntroduceDAO;
import dao.MenuDAO;
import dao.MenuTopDAO;
import dao.MessageDAO;
import dao.OrdersDAO;
import dao.PersonDAO;
import dao.UserInfoDAO;
import dao.impl.IntroduceDAOImpl;
import dao.impl.MenuDAOImpl;
import dao.impl.MenuTopDAOImpl;
import dao.impl.MessageDAOImpl;
import dao.impl.OrdersDAOImpl;
import dao.impl.PersonDAOImpl;
import dao.impl.UserInfoDAOImpl;
/**
 * DAO工厂类
 */
public class DAOFactory {
	/**
	 * 用户操作
	 * @return PersonDAO
	 */
	public static PersonDAO getPersonDAOInstance(){
		return new PersonDAOImpl();
	}
	/**
	 * 菜品操作
	 * @return
	 */
	public static MenuDAO getMenuDAOInstance(){
		return new MenuDAOImpl();
	}
	/**
	 * 留言信息操作
	 * @return
	 */
	public static MessageDAO getMessageDAOInstance(){
		return new MessageDAOImpl();
	}
	/**
	 * 订单操作
	 * @return
	 */
	public static OrdersDAO getOrdersDAOInstance(){
		return new OrdersDAOImpl();
	}
	/**
	 * 用户配送信息操作
	 * @return
	 */
	public static UserInfoDAO getUserInfoDAOInstance(){
		return new UserInfoDAOImpl();
	}
	/**
	 * 商家介绍操作
	 * @return
	 */
	public static IntroduceDAO getIntroduceDAOInstance(){
		return new IntroduceDAOImpl();
	}
	/**
	 * 推荐菜单操作
	 * @return
	 */
	public static MenuTopDAO getMenuTopDAOInstance(){
		return new MenuTopDAOImpl();
	}
}
