package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.MenuTopDAO;
import util.DbcpConnectionPool;
import vo.Menu;

public class MenuTopDAOImpl implements MenuTopDAO {

	/**
	 * 添加推荐菜单
	 */
	@Override
	public void add(Menu menu) {
		String sql = "INSERT INTO tb_menu_top (menu_id) VALUES(?)";
		String sql2 = "SELECT * FROM tb_menu_top WHERE menu_id=?";
		try {
			Connection conn = DbcpConnectionPool.getConnection();
			PreparedStatement ps2 = conn.prepareStatement(sql2);
			ps2.setInt(1, menu.getMenu_id());
			ResultSet rs = ps2.executeQuery();
			if (rs.next()){
				return;
			} else {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, menu.getMenu_id());
				ps.executeUpdate();
				ps.close();
				conn.close();				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据菜单ID从推荐菜单移除
	 */
	@Override
	public void remove(int id) {
		String sql = "DELETE FROM tb_menu_top WHERE menu_id=?";
		try {
			Connection conn = DbcpConnectionPool.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
