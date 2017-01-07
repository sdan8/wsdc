package dao;

import java.util.List;

import vo.Message;

/**
 * 留言信息类接口
 */
public interface MessageDAO {

	/**
	 * 保存留言
	 * @param message
	 */
	public void save(Message message);
	/**
	 * 删除留言
	 * @param message
	 */
	public int delete(Message message);
	/**
	 * 列出所有留言
	 * @return
	 */
	public List<Message> searchAllList();
}
