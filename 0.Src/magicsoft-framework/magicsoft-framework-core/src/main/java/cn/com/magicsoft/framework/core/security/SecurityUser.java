package cn.com.magicsoft.framework.core.security;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SecurityUser implements Serializable, Cloneable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
