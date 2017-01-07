package vo;

public class MenuTop {
	private int id;		//ID
	private Menu menu;	//推荐菜单，参考菜单类
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
}
