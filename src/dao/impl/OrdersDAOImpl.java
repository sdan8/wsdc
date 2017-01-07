package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.OrdersDAO;
import factory.DAOFactory;
import util.DbcpConnectionPool;
import vo.Orders;
import vo.Person;
/**
 * 订单类操作实现类
 */
public class OrdersDAOImpl implements OrdersDAO {
	/**
	 * 保存订单
	 */
	@Override
	public void save(Orders orders) {
		String sql = "INSERT INTO tb_orders(user_id, menu_id, order_num, order_notice, other_notice, states) VALUES(?,?,?,?,?,?)";
		try {
			Connection conn = DbcpConnectionPool.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, orders.getUser().getUser_id());
			ps.setInt(2, orders.getMenu().getMenu_id());
			ps.setInt(3, orders.getOrder_num());
			ps.setString(4, orders.getOrder_notice());
			ps.setString(5, orders.getOther_notice());
			ps.setString(6, orders.getStates());
			ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 删除订单
	 */
	@Override
	public int delete(Orders orders) {
		String sql = "DELETE FROM tb_orders WHERE order_id=?";
		int i = 0;
		try {
			Connection conn = DbcpConnectionPool.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, orders.getOrder_id());
			i = ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	/**
	 * 更新订单
	 */
	@Override
	public int update(Orders orders) {
		String sql = "UPDATE tb_orders SET user_id=?, menu_id=?, order_num=?, order_notice=?, other_notice=?, states=? WHERE order_id=?";
		int i = 0;
		try {
			Connection conn = DbcpConnectionPool.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, orders.getUser().getUser_id());
			ps.setInt(2, orders.getMenu().getMenu_id());
			ps.setInt(3, orders.getOrder_num());
			ps.setString(4, orders.getOrder_notice());
			ps.setString(5, orders.getOther_notice());
			ps.setString(6, orders.getStates());
			ps.setInt(7, orders.getOrder_id());
			i = ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	/**
	 * 模糊查询订单
	 */
	@Override
	public List<Orders> searchByLikeProperty(String property, String val) {
		String sql = "SELECT * FROM tb_orders WHERE " + property + " like '%" + val + "%'";
		List<Orders> list = new ArrayList<Orders>();
		try {
			Connection conn = DbcpConnectionPool.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()){
				Orders orders = new Orders();
				orders.setOrder_id(rs.getInt("order_id"));
				orders.setUser(DAOFactory.getPersonDAOInstance().searchById(rs.getInt("user_id")));
				orders.setMenu(DAOFactory.getMenuDAOInstance().searchById(rs.getInt("menu_id")));
				orders.setOrder_num(rs.getInt("order_num"));
				orders.setOrder_notice(rs.getString("order_notice"));
				orders.setOther_notice(rs.getString("other_notice"));
				orders.setStates(rs.getString("states"));
				list.add(orders);
				System.out.println("List: " + orders.toString());
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (Orders orders : list) {
			System.out.println("DAO: " + orders.toString());
		}
		return list;
	}
	/**
	 * 查询购物车
	 */
	@Override
	public List<Orders> searchBuy(Person user) {
		String sql = "SELECT * FROM tb_orders WHERE user_id=? and states=?";
		List<Orders> list = new ArrayList<Orders>();
		try {
			Connection conn = DbcpConnectionPool.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getUser_id());
			ps.setString(2, "未付款");
			ResultSet rs = ps.executeQuery();
			while (rs.next()){
				Orders orders = new Orders();
				orders.setOrder_id(rs.getInt("order_id"));
				orders.setUser(DAOFactory.getPersonDAOInstance().searchById(rs.getInt("user_id")));
				orders.setMenu(DAOFactory.getMenuDAOInstance().searchById(rs.getInt("menu_id")));
				orders.setOrder_num(rs.getInt("order_num"));
				orders.setOrder_notice(rs.getString("order_notice"));
				orders.setOther_notice(rs.getString("other_notice"));
				orders.setStates(rs.getString("states"));
				list.add(orders);
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * 订单支付
	 */
	@Override
	public int pay(Person user) {
		
		return 0;
	}
	/**
	 * 查询已支付订单
	 */
	@Override
	public List<Orders> searchPaidList(Person user) {
		String sql = "SELECT * FROM tb_orders WHERE user_id=? and states=?";
		List<Orders> list = new ArrayList<Orders>();
		try {
			Connection conn = DbcpConnectionPool.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getUser_id());
			ps.setString(2, "已付款");
			ResultSet rs = ps.executeQuery();
			while (rs.next()){
				Orders orders = new Orders();
				orders.setOrder_id(rs.getInt("order_id"));
				orders.setUser(DAOFactory.getPersonDAOInstance().searchById(rs.getInt("user_id")));
				System.out.println("userId: " + orders.getUser().getUser_id());
				System.out.println("menuId: " + rs.getInt("menu_id"));
				orders.setMenu(DAOFactory.getMenuDAOInstance().searchById(rs.getInt("menu_id")));
				orders.setOrder_num(rs.getInt("order_num"));
				orders.setOrder_notice(rs.getString("order_notice"));
				orders.setOther_notice(rs.getString("other_notice"));
				orders.setStates(rs.getString("states"));
				list.add(orders);
				System.out.println("menuId: " + orders.getMenu().getMenu_id());
				System.out.println("menuName: " + orders.getMenu().getMenu_name());
				
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
