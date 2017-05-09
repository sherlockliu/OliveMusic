package cn.com.magicsoft.olive.music.dto;

import java.util.Date;
 
public class MenuInfoExt {

	private int menuID;
	private String menuName;
	private int parentID;
	private String menuURL;
	private short menuOrder;
	private String menuIcon;
	private short menuType;
	private short isSystem;
	private short invalid;
	private Date modifyTime;
	private Date createTime;
	private Boolean isParent;

	public int getMenuID() {
		return menuID;
	}

	public void setMenuID(int menuID) {
		this.menuID = menuID;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public int getParentID() {
		return parentID;
	}

	public void setParentID(int parentID) {
		this.parentID = parentID;
	}

	public String getMenuURL() {
		return menuURL;
	}

	public void setMenuURL(String menuURL) {
		this.menuURL = menuURL;
	}

	public short getMenuOrder() {
		return menuOrder;
	}

	public void setMenuOrder(short menuOrder) {
		this.menuOrder = menuOrder;
	}

	public String getMenuIcon() {
		return menuIcon;
	}

	public void setMenuIcon(String menuIcon) {
		this.menuIcon = menuIcon;
	}

	public short getMenuType() {
		return menuType;
	}

	public void setMenuType(short menuType) {
		this.menuType = menuType;
	}

	public short getIsSystem() {
		return isSystem;
	}

	public void setIsSystem(short isSystem) {
		this.isSystem = isSystem;
	}

	public short getInvalid() {
		return invalid;
	}

	public void setInvalid(short invalid) {
		this.invalid = invalid;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Boolean getIsParent() {
		return isParent;
	}

	public void setIsParent(Boolean isParent) {
		this.isParent = isParent;
	}
}
