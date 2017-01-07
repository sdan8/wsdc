package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.IntroduceDAO;
import util.DbcpConnectionPool;

public class IntroduceDAOImpl implements IntroduceDAO {

	/**
	 * 更新商家介绍
	 */
	@Override
	public void update(String content) {
		String sql = "UPDATE tb_introduce SET content=? WHERE id=1";
		try {
			Connection conn = DbcpConnectionPool.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, content);
			ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 显示商家信息
	 */
	@Override
	public String show() {
		String content = "";
		String sql = "SELECT * FROM tb_introduce WHERE id=1";
		try {
			Connection conn = DbcpConnectionPool.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()){
				content = rs.getString("content");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return content;
	}

}
