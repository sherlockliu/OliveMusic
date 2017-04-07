package cn.com.magicsoft.framework.core.security;

public interface RoleAccessProvider {
	
	boolean hasPermission(String name);	
	
	void clear(); 
}
