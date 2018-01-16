package cn.com.magicsoft.olive.music.web.viewmodel;

import java.util.List;

public class MenuView {
	
    private int menuId ;
    private String menuName ;
    private int parentId ;
    private String menuUrl ;
    private String menuIcon ;
    private List<MenuView> subMenu ;
    
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public String getMenuUrl() {
		return menuUrl;
	}
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	public String getMenuIcon() {
		return menuIcon;
	}
	public void setMenuIcon(String menuIcon) {
		this.menuIcon = menuIcon;
	}
	public List<MenuView> getSubMenu() {
		return subMenu;
	}
	public void setSubMenu(List<MenuView> subMenu) {
		this.subMenu = subMenu;
	}

}
