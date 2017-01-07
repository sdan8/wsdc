package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.MenuDAO;
import util.DbcpConnectionPool;
import vo.Menu;
/**
 * 菜单管理实现类
 */
public class MenuDAOImpl implements MenuDAO {

	/**
	 * 保存菜品
	 */
	@Override
	public void save(Menu menu) {
		String sql = "INSERT INTO tb_menu(menu_name, menu_content, menu_price, menu_image) VALUES(?,?,?,?)";
		try {
			Connection conn = DbcpConnectionPool.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, menu.getMenu_name());
			ps.setString(2, menu.getMenu_content());
			ps.setDouble(3, menu.getMenu_price());
			ps.setString(4, menu.getMenu_image());
			ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 更新菜品
	 */
	@Override
	public int update(Menu menu) {
		String sql = "UPDATE tb_menu SET menu_name=?, menu_content=?, menu_price=?, menu_image=? WHERE menu_id=?";
		int i = 0;
		try {
			Connection conn = DbcpConnectionPool.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, menu.getMenu_name());
			ps.setString(2, menu.getMenu_content());
			ps.setDouble(3, menu.getMenu_price());
			ps.setString(4, menu.getMenu_image());
			ps.setInt(5, menu.getMenu_id());
			i = ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	/**
	 * 删除菜品
	 */
	@Override
	public int delete(Menu menu) {
		String sql = "DELETE FROM tb_menu WHERE menu_id=?";
		int i = 0;
		try {
			Connection conn = DbcpConnectionPool.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, menu.getMenu_id());
			i = ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	/**
	 * 模糊查询菜品信息
	 */
	@Override
	public List<Menu> searchByLikeProperty(String property, String val) {
		String sql = "SELECT * FROM tb_menu WHERE " + property + " like '%" + val + "%'";
		List<Menu> list = new ArrayList<Menu>();
		try {
			Menu menu = new Menu();
			Connection conn = DbcpConnectionPool.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()){
				menu.setMenu_id(rs.getInt("menu_id"));
				menu.setMenu_name(rs.getString("menu_name"));
				menu.setMenu_content(rs.getString("menu_content"));
				menu.setMenu_price(rs.getDouble("menu_price"));
				menu.setMenu_image(rs.getString("menu_image"));
				list.add(menu);
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
	 * 根据ID查询菜品
	 */
	@Override
	public Menu searchById(int id) {
		String sql = "SELECT * FROM tb_menu WHERE menu_id=?";
		try {
			Connection conn = DbcpConnectionPool.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()){
				Menu menu = new Menu();
				menu.setMenu_id(rs.getInt("menu_id"));
				menu.setMenu_name(rs.getString("menu_name"));
				menu.setMenu_content(rs.getString("menu_content"));
				menu.setMenu_price(rs.getDouble("menu_price"));
				menu.setMenu_image(rs.getString("menu_image"));
				return menu;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 查询所有记录
	 */
	@Override
	public List<Menu> showAllList() {
		String sql = "SELECT * FROM tb_menu";
		List<Menu> list = new ArrayList<Menu>();
		try {
			Connection conn = DbcpConnectionPool.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()){
				Menu menu = new Menu();
				menu.setMenu_id(rs.getInt("menu_id"));
				menu.setMenu_name(rs.getString("menu_name"));
				menu.setMenu_content(rs.getString("menu_content"));
				menu.setMenu_price(rs.getDouble("menu_price"));
				menu.setMenu_image(rs.getString("menu_image"));
				list.add(menu);
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
	 * 查询推荐的记录
	 */
	@Override
	public List<Menu> showTopList() {
		String sql = "SELECT * FROM tb_menu_top";
		List<Menu> list = new ArrayList<Menu>();
		try {
			Connection conn = DbcpConnectionPool.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()){
				Menu menu = new Menu();
				menu = searchById(rs.getInt("menu_id"));
				list.add(menu);
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
