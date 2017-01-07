package vo;

import factory.DAOFactory;

/**
 * 商家介绍类
 */
public class Introduce {

	private int id;				//ID
	private String content;		//介绍
	
	private String showIntroduce;	//显示介绍
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getShowIntroduce() {
		showIntroduce = DAOFactory.getIntroduceDAOInstance().show();
		return showIntroduce;
	}
	
	
}
