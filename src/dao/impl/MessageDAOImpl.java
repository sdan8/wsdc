package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.MessageDAO;
import factory.DAOFactory;
import util.DbcpConnectionPool;
import vo.Message;
/**
 * 留言信息操作实现类
 */
public class MessageDAOImpl implements MessageDAO {

	/**
	 * 保存留言
	 */
	@Override
	public void save(Message message) {
		String sql = "INSERT INTO tb_message(user_id, menu_id, content, mg_date) VALUES(?,?,?,?)";
		try {
			Connection conn = DbcpConnectionPool.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, message.getUser().getUser_id());
			ps.setInt(2, message.getMenu().getMenu_id());
			ps.setString(3, message.getContent());
			ps.setString(4, message.getMg_date());
			ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 删除留言
	 */
	@Override
	public int delete(Message message) {
		String sql = "DELETE FROM tb_message WHERE id=?";
		int i = 0;
		try {
			Connection conn = DbcpConnectionPool.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, message.getId());
			i = ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	/**
	 * 列出所有留言
	 */
	@Override
	public List<Message> searchAllList() {
		List<Message> list = new ArrayList<Message>();
		String sql = "SELECT * FROM tb_message";
		Message message = new Message();
		try {
			Connection conn = DbcpConnectionPool.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()){
				message.setId(rs.getInt("id"));
				message.setUser(DAOFactory.getPersonDAOInstance().searchById(rs.getInt("user_id")));
				message.setMenu(DAOFactory.getMenuDAOInstance().searchById(rs.getInt("menu_id")));
				message.setContent(rs.getString("content"));
				message.setMg_date(rs.getString("mg_date"));
				list.add(message);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
