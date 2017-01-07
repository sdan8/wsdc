package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.PersonDAO;
import util.DbcpConnectionPool;
import vo.Person;
/**
 * 用户操作实现类
 */
public class PersonDAOImpl implements PersonDAO {

	/**
	 * 保存用户
	 */
	@Override
	public void save(Person user) {
		String sql = "INSERT INTO tb_user(user_name, user_password, user_realname, user_sex, user_flag, user_mail) VALUES(?,?,?,?,?,?)";
		try {
			Connection conn = DbcpConnectionPool.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUser_name());
			ps.setString(2, user.getUser_password());
			ps.setString(3, user.getUser_realname());
			ps.setString(4, user.getUser_sex());
			ps.setString(5, user.getUser_flag());
			ps.setString(6, user.getUser_mail());
			System.out.println("impl: " + user.getUser_mail());
			ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 更新用户
	 */
	@Override
	public int update(Person user) {
		String sql = "UPDATE tb_user SET user_name=?, user_password=?, user_realname=?, user_sex=?, user_flag=?, user_mail=? WHERE user_id=?";
		int i = 0;
		try {
			Connection conn = DbcpConnectionPool.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUser_name());
			ps.setString(2, user.getUser_password());
			ps.setString(3, user.getUser_realname());
			ps.setString(4, user.getUser_sex());
			ps.setString(5, user.getUser_flag());
			ps.setString(6, user.getUser_mail());
			ps.setInt(7, user.getUser_id());
			i = ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	/**
	 * 根据ID查询用户
	 */
	@Override
	public Person searchById(int id) {
		Person user = new Person();
		String sql = "SELECT * FROM tb_user WHERE user_id=?";
		try {
			Connection conn = DbcpConnectionPool.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()){
				user.setUser_id(rs.getInt("user_id"));
				user.setUser_name(rs.getString("user_name"));
				user.setUser_password(rs.getString("user_password"));
				user.setUser_realname(rs.getString("user_realname"));
				user.setUser_sex(rs.getString("user_sex"));
				user.setUser_flag(rs.getString("user_flag"));
				user.setUser_mail(rs.getString("user_mail"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	/**
	 * 根据用户名查询用户是否存在
	 */
	@Override
	public boolean searchByUsername(Person user) {
		String sql = "SELECT * FROM tb_user WHERE user_name=?";
		try {
			Connection conn = DbcpConnectionPool.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUser_name());
			ResultSet rs = ps.executeQuery();
			if (rs.next()){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 验证密码是否正确，用户不存在则返回 false
	 */
	@Override
	public Person validatePassword(Person user) {
		String sql = "SELECT * FROM tb_user WHERE user_name=?";
		Connection conn;
		try {
			conn = DbcpConnectionPool.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUser_name());
			ResultSet rs = ps.executeQuery();
			if (rs.next()){
				String password = rs.getString("user_password");
				if (password.equals(user.getUser_password())){
					user.setUser_id(rs.getInt("user_id"));
					user.setUser_realname(rs.getString("user_realname"));
					user.setUser_sex(rs.getString("user_sex"));
					user.setUser_flag(rs.getString("user_flag"));
					user.setUser_mail(rs.getString("user_mail"));
					return user;
				} else {
					return null;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获得所有管理员信息
	 */
	@Override
	public List<Person> getAllAdmin() {
		List<Person> list = new ArrayList<Person>();
		String sql = "SELECT * FROM tb_user WHERE user_flag=?";
		try {
			Connection conn = DbcpConnectionPool.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "管理员");
			ResultSet rs = ps.executeQuery();
			while (rs.next()){
				Person person = new Person();
				person.setUser_id(rs.getInt("user_id"));
				person.setUser_name(rs.getString("user_name"));
				person.setUser_password(rs.getString("user_password"));
				person.setUser_realname(rs.getString("user_realname"));
				person.setUser_sex(rs.getString("user_sex"));
				person.setUser_flag(rs.getString("user_flag"));
				person.setUser_mail(rs.getString("user_mail"));
				list.add(person);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 根据用户名查询用户
	 */
	@Override
	public Person searchByUsername(String username) {
		Person person = new Person();
		String sql = "SELECT * FROM tb_user WHERE user_name=?";
		Connection conn;
		try {
			conn = DbcpConnectionPool.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if (rs.next()){
				person.setUser_id(rs.getInt("user_id"));
				person.setUser_name(rs.getString("user_name"));
				person.setUser_password(rs.getString("user_password"));
				person.setUser_realname(rs.getString("user_realname"));
				person.setUser_sex(rs.getString("user_sex"));
				person.setUser_flag(rs.getString("user_flag"));
				person.setUser_mail(rs.getString("user_mail"));
				return person;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
