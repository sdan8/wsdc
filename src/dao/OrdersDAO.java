package dao;

import java.util.List;

import vo.Orders;
import vo.Person;

/**
 * 订单类接口
 */
public interface OrdersDAO {
	/**
	 * 保存订单
	 * @param orders
	 */
	public void save(Orders orders);
	/**
	 * 删除订单
	 * @param orders
	 * @return 改动的记录数量
	 */
	public int delete(Orders orders);
	/**
	 * 更新订单
	 * @param orders
	 * @return 改动的记录数量
	 */
	public int update(Orders orders);
	/**
	 * 查询订单
	 * @param property 查询的字段名
	 * @param val 查询的字段值
	 * @return
	 */
	public List<Orders> searchByLikeProperty(String property, String val);
	/**
	 * 查询购物车
	 * @param user
	 * @return
	 */
	public List<Orders> searchBuy(Person user);
	/**
	 * 订单支付
	 * @param user
	 * @return
	 */
	public int pay(Person user);
	/**
	 * 查询已支付的订单
	 * @param user
	 * @return
	 */
	public List<Orders> searchPaidList(Person user);
}
