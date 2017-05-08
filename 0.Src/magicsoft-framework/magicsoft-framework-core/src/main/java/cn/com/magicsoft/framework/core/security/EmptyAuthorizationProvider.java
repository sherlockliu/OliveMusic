package cn.com.magicsoft.framework.core.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cn.com.magicsoft.framework.core.exception.ManagerException;

public class EmptyAuthorizationProvider implements AuthorizationProvider {

	@Override
	public Map<String, SecurityUser> getUserModel()
			throws ManagerException { 
		return null;
	}

	@Override
	public Map<String, Integer> getOptions() { 
		return null;
	}

	@Override
	public String getCurrentModule() { 
		return null;
	}

	@Override
	public SecurityUser getUser() { 
		return null;
	}

	@Override
	public SecurityUser getUser(Integer userId) { 
		return null;
	}

	@Override
	public void setUser(SecurityUser user) { 
		
	}

	@Override
	public void signout() { 
		
	}

	@Override
	public void clear() {  
	}

	@Override
	public SecurityUser getUserPermission() { 
		return null;
	}

	@Override
	public List<String> getRoles() {
		return new ArrayList<String>();
	}

	@Override
	public List<String> getFunctionItems() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SecurityUser getUser(ITicket ticket) {
		// TODO Auto-generated method stub
		return null;
	}

}
