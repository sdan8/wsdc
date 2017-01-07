package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.UserInfoDAO;
import factory.DAOFactory;
import util.DbcpConnectionPool;
import vo.Person;
import vo.UserInfo;

public class UserInfoDAOImpl implements UserInfoDAO {

	@Override
	public void save(UserInfo userInfo) {
		String sql = "INSERT INTO user_info(user_id, address, tel, mobile, notice, send_date) VALUES(?,?,?,?,?,?)";
		try {
			Connection conn = DbcpConnectionPool.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userInfo.getUser().getUser_id());
			ps.setString(2, userInfo.getAddress());
			ps.setString(3, userInfo.getTel());
			ps.setString(4, userInfo.getMobile());
			ps.setString(5, userInfo.getNotice());
			ps.setString(6, userInfo.getSend_date());
			ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int delete(UserInfo userInfo) {
		String sql = "DELETE FROM user_info WHERE id=?";
		int i = 0;
		try {
			Connection conn = DbcpConnectionPool.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userInfo.getId());
			i = ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int update(UserInfo userInfo) {
		String sql = "UPDATE user_info SET address=?, tel=?, mobile=? WHERE id=?";
		int i = 0;
		try {
			Connection conn = DbcpConnectionPool.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userInfo.getAddress());
			ps.setString(2, userInfo.getTel());
			ps.setString(3, userInfo.getMobile());
			ps.setInt(4, userInfo.getId());
			i = ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public UserInfo searchById(int id) {
		UserInfo userInfo = new UserInfo();
		String sql = "SELECT * FROM user_info WHERE id=?";
		try {
			Connection conn = DbcpConnectionPool.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()){
				userInfo.setId(rs.getInt("id"));
				userInfo.setUser(DAOFactory.getPersonDAOInstance().searchById(rs.getInt("user_id")));
				userInfo.setAddress(rs.getString("address"));
				userInfo.setTel(rs.getString("tel"));
				userInfo.setMobile(rs.getString("mobile"));
				userInfo.setNotice(rs.getString("notice"));
				userInfo.setSend_date(rs.getString("send_date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userInfo;
	}

	/**
	 * 根据用户查询配送信息
	 */
	@Override
	public UserInfo searchByUser(Person user) {
		String sql = "SELECT * FROM user_info WHERE user_id=?";
		UserInfo userInfo = new UserInfo();		
		try {
			Connection conn = DbcpConnectionPool.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getUser_id());
			ResultSet rs = ps.executeQuery();
			if (rs.next()){
				userInfo.setId(rs.getInt("id"));
				userInfo.setUser(user);
				userInfo.setAddress(rs.getString("address"));
				userInfo.setTel(rs.getString("tel"));
				userInfo.setMobile(rs.getString("mobile"));
				userInfo.setNotice(rs.getString("notice"));
				userInfo.setSend_date(rs.getString("send_date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userInfo;
	}

}
