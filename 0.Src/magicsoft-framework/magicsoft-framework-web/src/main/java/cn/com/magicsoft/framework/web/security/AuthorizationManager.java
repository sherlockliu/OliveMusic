package cn.com.magicsoft.framework.web.security;

import cn.com.magicsoft.framework.core.security.Authorization;
import cn.com.magicsoft.framework.core.security.ITicket;
import cn.com.magicsoft.framework.core.security.SecurityUser;

public class AuthorizationManager {
	
	public static SecurityUser login(ITicket ticket) {
		SecurityUser user = Authorization.getUser(ticket);
		if(user!=null){
			Authorization.setUser(user);
		}
		return user;
	}
	
	public static void logout() {
		Authorization.signout();
	}
}
