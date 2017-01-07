package dao;

import vo.Menu;

/**
 * 推荐菜单接口
 */
public interface MenuTopDAO {
	/**
	 * 添加推荐菜单
	 * @param menu
	 */
	public void add(Menu menu);
	/**
	 * 从推荐菜单移除
	 * @param menu
	 */
	public void remove(int id);
}
