package cn.com.magicsoft.framework.core.security;

import java.util.List;

public class EmptyDataAccessProvider implements DataAccessProvider {

	@Override
	public List<String> getAccessData(String name) {		
		return null;
	}

	@Override
	public String getAccessDataString(String name) {
		return null;
	}

	@Override
	public void clear() {
		 
	}
	
	

}
