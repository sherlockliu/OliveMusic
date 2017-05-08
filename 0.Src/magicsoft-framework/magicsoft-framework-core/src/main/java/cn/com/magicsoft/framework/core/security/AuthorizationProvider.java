package cn.com.magicsoft.framework.core.security;

import java.util.List;
import java.util.Map;

import cn.com.magicsoft.framework.core.exception.ManagerException;

public interface AuthorizationProvider {
		
	Map<String, SecurityUser> getUserModel( ) throws ManagerException;
	
	Map<String, Integer> getOptions();

	String getCurrentModule();
	
	SecurityUser getUser();
	
	SecurityUser getUser(Integer userId);
	
	void setUser(SecurityUser user);
	
	void signout();
	
	void clear();
	
	SecurityUser getUserPermission();
	
	List<String> getRoles();
	
	List<String> getFunctionItems();

	SecurityUser getUser(ITicket ticket);
}
