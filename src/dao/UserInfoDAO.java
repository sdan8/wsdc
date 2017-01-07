package dao;

import vo.Person;
import vo.UserInfo;

/**
 * 用户配送信息类接口
 */
public interface UserInfoDAO {
	/**
	 * 保存用户配送信息
	 * @param userInfo
	 */
	public void save(UserInfo userInfo);
	/**
	 * 删除用户配送信息
	 * @param userInfo
	 * @return
	 */
	public int delete(UserInfo userInfo);
	/**
	 * 更新用户配送信息
	 * @param userInfo
	 * @return
	 */
	public int update(UserInfo userInfo);
	/**
	 * 根据ID查询用户配送信息
	 * @param id
	 * @return
	 */
	public UserInfo searchById(int id);
	/**
	 * 根据用户查询配送信息
	 * @param user
	 * @return
	 */
	public UserInfo searchByUser(Person user);
}
