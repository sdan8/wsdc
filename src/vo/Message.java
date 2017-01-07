package vo;

import java.util.List;

import factory.DAOFactory;

/**
 * 留言信息类
 */
public class Message {
	private int id;			//留言ID
	private Person user;	//用户ID，参照用户类
	private Menu menu;		//菜品ID，参照菜单类
	private String content;	//内容
	private String mg_date;	//留言时间
	
	private StringBuffer showMessageList;	//显示所有留言
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Person getUser() {
		return user;
	}
	public void setUser(Person user) {
		this.user = user;
	}
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getMg_date() {
		return mg_date;
	}
	public void setMg_date(String mg_date) {
		this.mg_date = mg_date;
	}
	public StringBuffer getShowMessageList() {
		showMessageList = new StringBuffer();
		List<Message> list = DAOFactory.getMessageDAOInstance().searchAllList();
		for (Message message : list) {
			showMessageList.append("<li class=\"li\"><div class=\"text\"><span class=\"name\">");
			showMessageList.append(message.getUser().getUser_name());
			showMessageList.append("</span></div><div class=\"text1\"><span class=\"time\">");
			showMessageList.append(message.getMg_date());
			showMessageList.append("</span></div><div class=\"text2\"><span class=\"content\">");
			showMessageList.append(message.getContent());
			showMessageList.append("</span></div></li>");
//			<li class="li">
//            <div class="text"><span class="name">用户名</span></div>
//            <div class="text1"><span class="time">2017-01-01</span></div>
//            <div class="text2"><span class="content">评价内容</span></div>
//        	</li>
		}
		return showMessageList;
	}
	
	
}
