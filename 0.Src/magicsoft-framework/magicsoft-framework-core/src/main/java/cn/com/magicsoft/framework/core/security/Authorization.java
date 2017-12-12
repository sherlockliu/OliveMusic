package cn.com.magicsoft.framework.core.security;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.ext.XLogger;
import org.slf4j.ext.XLoggerFactory;
import org.springframework.util.StringUtils;

import cn.com.magicsoft.framework.core.SpringContext;
import cn.com.magicsoft.framework.core.Storage;

public class Authorization {
	private static Configration configration = null;

	// @Resource
	private static AuthorizationProvider authorizationProvider = null;
//	private static DataAccessProvider dataAccessProvider;

	protected static final XLogger logger = XLoggerFactory.getXLogger(Authorization.class);

	private static AuthorizationProvider getProvider() {
		if (authorizationProvider == null && SpringContext.containsBean("authorizationProvider")){
			authorizationProvider = SpringContext.getBean("authorizationProvider");
		}
		return authorizationProvider;
	}

	private static Storage storage = null;

	public static Storage getStorage() {
		if (storage == null){
			storage = SpringContext.getBean("securityStorage");
		}
		return storage;
	}

	private static RoleAccessProvider roleProvider=null;

	private static RoleAccessProvider getRoleProvider() {
		if (roleProvider == null){
			if (SpringContext.containsBean("roleAccessProvider")){
				roleProvider = SpringContext.getBean("roleAccessProvider");
			}
			else{
				roleProvider = new DefaultRoleAccessProvider();
			}
		}
		return roleProvider;
	}

	private static Configration getConfig() {
		if (configration == null){
			configration = SpringContext.getBean("configration");
		}
		return configration;
	}

	public static SecurityUser getUser(Integer userId) {
		if (getProvider() == null){
			return null;
		}
		 return  getProvider().getUser(userId);	 
	}

	public static SecurityUser getUser() {
		if (getProvider() == null){
			return null;
		}
		SecurityUser user = getProvider().getUser();
		if (user == null){// && getConfig().sessionDisable > 0) {
//			logger.info("验证关闭，自动创建用户:" + getConfig().sessionDisable);
			logger.info("验证关闭，自动创建游客用户");
			user = new SecurityUser();
			user.setUserId(0);//TODO, read from configuration.
			user.setUserName("Guest");
			getProvider().setUser(user);
			clear();
		}
		return user;
	}

	public static void setUser(SecurityUser val) {
		if (getProvider() == null){
			return;
		}
		clear();
		getProvider().setUser(val);
	}

	public static void signout() {
		if (getProvider() == null){
			return;
		}
		getProvider().signout();
		clear();
	}

	private static void clear() {
		if (getProvider() == null){
			return;
		}
//		getStorage().invalide(null);
		getProvider().clear();
//		getRoleProvider().clear();
	}

	private static boolean valide() {
		if (getConfig().dataaccess == 0 || getConfig().sessionDisable > 0){
			return true;
		}
		if (getProvider() == null)
			return false;
		String module = getProvider().getCurrentModule();
		if (StringUtils.hasLength(module))
			return false;
		else
			return true;

	}

	/**
	 * 是否拥有指定角色
	 * 
	 * @param role
	 * @return
	 */
	public static boolean hasRole(String role) {
		if (getProvider() == null)
			return false;
		return getProvider().getRoles().contains(role);
	}

	public static boolean hasPermission(int ove) {
		if (getProvider() == null)
			return true;
		if (valide())
			return true;
		List<String> opts = Authorization.getOptions(); // tempModuleDto.getOperations();
		if (opts == null)
			return false;

		return opts.contains(ove);
	}

	public static boolean hasPermission(String name, String opt) {
		if (getProvider() == null)
			return true;
		// 当前方法没有设置权限,
		if (!StringUtils.hasLength(opt) || opt.equalsIgnoreCase(FunctionCodeConstant.IGNORE))
			return true;

		if (valide())
			return true;

		List<String> opts = Authorization.getOptions();
		if (opts == null)
			return false;

		return opts.contains(opt);
	}

	/**
	 * 是否拥有操作权限
	 * 
	 * @param option
	 * @return
	 */
	public static boolean hasPermission(String option) {

		if (valide())
			return true;
		if (getProvider() == null)
			return true;
		SecurityUser um = getProvider().getUserPermission();
		if (um == null)
			return false;

		String userPermission = "," + um.getPermissions() + ",";
		return userPermission.indexOf(option + ",") >= 0;
	}

	/**
	 * 是否拥有特定的数据权限
	 * 
	 * @param name
	 * @return
	 */
	public static boolean hasDataPermission(String name) {
		if (getProvider() == null)
			return true;
		return getRoleProvider().hasPermission(name);
	}

	public static List<String> getOptions() {
		if (getProvider() == null)
			return new ArrayList<String>();
		SecurityUser um = getProvider().getUserPermission();
		if (um == null)
			return null;
		List<String> opts = um.getOprations();
		if (opts == null) // 模块存在表示可以浏览(用户中心无法设置浏览权限);
			return new ArrayList<String>();
		return opts;
	}

	final static String zone_no_key = "z_";
	
	public static SecurityUser getUser(ITicket ticket) {
		if(getProvider() != null){
			return getProvider().getUser(ticket);
		}
		return null;
	}
}
