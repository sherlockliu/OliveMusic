package cn.com.magicsoft.framework.core.security;

public class DefaultRoleAccessProvider implements RoleAccessProvider {

	@Override
	public boolean hasPermission(String name) { 
		SecurityUser user = Authorization.getUser();
		if (user == null)
			return true;
		return false;
	}

	@Override
	public void clear() {
		 
	}

}
