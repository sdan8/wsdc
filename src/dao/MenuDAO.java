package dao;

import java.util.List;

import vo.Menu;

/**
 * 菜单类接口
 */
public interface MenuDAO {
	/**
	 * 保存菜品
	 * @param menu
	 */
	public void save(Menu menu);
	/**
	 * 更新菜品
	 * @param menu
	 */
	public int update(Menu menu);
	/**
	 * 删除菜品
	 * @param menu
	 */
	public int delete(Menu menu);
	/**
	 * 模糊查询菜品
	 * @param property 查询的字段名
	 * @param val 查询的字段值
	 */
	public List<Menu> searchByLikeProperty(String property, String val);
	/**
	 * 根据菜品ID查询
	 * @param id 菜品ID
	 * @return
	 */
	public Menu searchById(int id);
	/**
	 * 查询所有的记录
	 * @return
	 */
	public List<Menu> showAllList();
	/**
	 * 查询推荐的记录
	 * @return
	 */
	public List<Menu> showTopList();
}
