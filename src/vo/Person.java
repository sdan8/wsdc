package vo;

import java.util.List;

import factory.DAOFactory;

/**
 * 用户类
 */
public class Person {
	private int user_id;			//用户名ID
	private String user_name;		//用户名
	private String user_password;	//用户密码
	private String user_realname;	//用户真实姓名
	private String user_sex;		//性别
	private String user_flag;		//身份
	private String user_mail;		//E-mail
	
	private StringBuffer showAdminList;	//显示管理员列表
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_realname() {
		return user_realname;
	}
	public void setUser_realname(String user_realname) {
		this.user_realname = user_realname;
	}
	public String getUser_sex() {
		return user_sex;
	}
	public void setUser_sex(String user_sex) {
		this.user_sex = user_sex;
	}
	public String getUser_flag() {
		return user_flag;
	}
	public void setUser_flag(String user_flag) {
		this.user_flag = user_flag;
	}
	public String getUser_mail() {
		return user_mail;
	}
	public void setUser_mail(String user_mail) {
		this.user_mail = user_mail;
	}
	public StringBuffer getShowAdminList() {
		showAdminList = new StringBuffer();
		List<Person> list = DAOFactory.getPersonDAOInstance().getAllAdmin();
		for (Person person : list) {
			showAdminList.append("<tr><td class=\"use_id\">");
			showAdminList.append(person.getUser_id());
			showAdminList.append("</td><td class=\"use_name\">");
			showAdminList.append(person.getUser_name());
			showAdminList.append("</td><td class=\"name\">");
			showAdminList.append(person.getUser_realname());
			showAdminList.append("</td><td class=\"sex\">");
			showAdminList.append(person.getUser_sex());
			showAdminList.append("</td><td class=\"mail\">");
			showAdminList.append(person.getUser_mail());
			showAdminList.append("</td></tr>");
		}
		return showAdminList;
	}
//	<tr>
//	    <td class="use_id">123</td>
//	    <td class="use_name">mm</td>
//	    <td class="name">力量</td>
//	    <td class="sex">女</td>
//	    <td class="mail">kjkj@13.com</td>
//	</tr>
	
}
