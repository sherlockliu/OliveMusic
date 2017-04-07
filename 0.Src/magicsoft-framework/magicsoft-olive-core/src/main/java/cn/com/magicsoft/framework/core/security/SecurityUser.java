package cn.com.magicsoft.framework.core.security;

import java.util.List;

public class SecurityUser {
	
	private Integer userId;
	private String userName;
	private List<Role> roles;
	private List<FunctionItem> functionItems;
	
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public List<FunctionItem> getFunctionItems() {
		return functionItems;
	}
	public void setFunctionItems(List<FunctionItem> functionItems) {
		this.functionItems = functionItems;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPermissions() {
		// TODO Auto-generated method stub
		return null;
	}
	public List<String> getOprations() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getLoginName() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
