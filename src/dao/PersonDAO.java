package dao;

import java.util.List;

import vo.Person;

/**
 * 用户类接口
 */
public interface PersonDAO {
	/**
	 * 注册用户
	 * @param user
	 */
	public void save(Person user);
	/**
	 * 更新用户
	 * @param user
	 */
	public int update(Person user);
	/**
	 * 根据ID查询用户
	 * @param id
	 * @return
	 */
	public Person searchById(int id);
	/**
	 * 根据用户名查询用户是否存在
	 * @param user
	 * @return 存在用户返回 true ，否则返回 false
	 */
	public boolean searchByUsername(Person user);
	/**
	 * 根据用户名查询用户
	 * @param username 用户名
	 * @return 返回用户，用户不存在返回null
	 */
	public Person searchByUsername(String username);
	/**
	 * 验证密码是否正确，用户不存在则返回 null
	 * @param user
	 * @return 正确返回 用户，否则返回 null
	 */
	public Person validatePassword(Person user);
	/**
	 * 获得所有的管理员信息
	 * @return
	 */
	public List<Person> getAllAdmin();
}
