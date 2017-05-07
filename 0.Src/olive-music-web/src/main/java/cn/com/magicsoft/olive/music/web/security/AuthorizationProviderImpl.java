package cn.com.magicsoft.olive.music.web.security;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.ext.XLogger;
import org.slf4j.ext.XLoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import cn.com.magicsoft.framework.core.PublicContants;
import cn.com.magicsoft.framework.core.Storage;
import cn.com.magicsoft.framework.core.security.Authorization;
import cn.com.magicsoft.framework.core.security.AuthorizationProvider;
import cn.com.magicsoft.framework.core.security.SecurityUser;
import cn.com.magicsoft.framework.web.filter.HttpSessionExtendWrapper;

@Component(value = "authorizationProvider")
public class AuthorizationProviderImpl implements AuthorizationProvider {

	protected String SYSTEM_OPREATION_MAP = "system_opreation_map";
	protected static final String SESSION_USER = PublicContants.SESSION_USER;
	protected static final String SESSION_SYSTEMID = "systemid";
	protected static final String SESSION_AREASYSTEMID = "areasystemid";
	protected ThreadLocal<SecurityUser> localUser = new ThreadLocal<>();
	
	@Value("${system.id}")
	protected String systemId = "16";

	@Value("${area.system.id}")
	protected String areaSystemId = "17";

	protected static final XLogger logger = XLoggerFactory.getXLogger(AuthorizationProviderImpl.class);

	private HttpServletRequest getRequest() {
		if (RequestContextHolder.getRequestAttributes() == null)
			return null;
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		return request;
	}

	private final static String MODULE_CACHE_KEY = "moduleList";

	@Override
	@SuppressWarnings("unchecked")
	public Map<String, SecurityUser> getUserModel() {
		HttpServletRequest req = getRequest();
		HttpSession session = req != null ? req.getSession() : null;

		int userId = Authorization.getUser().getUserId();

		Map<String, SecurityUser> moduleMap = null;
		// 关闭缓存

		List<SecurityUser> mList = null;
		try {
//			mList = userApi.findAllUserHasModules(userId, areasystemid);
//			get modules
		} catch (Exception e) {
			logger.error("获取用户模块信息失败.", e);
			return new HashMap<String, SecurityUser>();
		}
		return moduleMap;
	}

	@Override
	@SuppressWarnings("unchecked")
	public Map<String, Integer> getOptions() {
		HttpServletRequest req = getRequest();
		if (req != null) {
			HttpSession session = req.getSession();
			return (Map<String, Integer>) session.getAttribute(SYSTEM_OPREATION_MAP);
		}
		return null;
	}

	@Override
	public void clear() {
		HttpServletRequest req = getRequest();
		localUser.remove();
		if (req != null) {
			HttpSession session = req.getSession(false);
			session.removeAttribute(SYSTEM_OPREATION_MAP);
			session.removeAttribute(SYSTEM_OPREATION_MAP);
		}
	}

	@Override
	public void signout() {
		HttpServletRequest req = getRequest();
		if (req != null) {
			HttpSession session = req.getSession(false);
			if (session != null){
				session.invalidate();
			}
		}
	}

	@Override
	public String getCurrentModule() {
		HttpServletRequest req = getRequest();
		return String.valueOf(req != null ? req.getAttribute("module") : null);
	}

	@Override
	public SecurityUser getUserPermission() {
		return null;
	}

	@Override
	public SecurityUser getUser() {
		HttpServletRequest req = getRequest();
		SecurityUser user = null;
		if (req != null) {
			HttpSession session = req.getSession();
			if ("dev".equalsIgnoreCase(System.getProperty("env")))
				user = (SecurityUser) session.getAttribute("user");
			if (user == null) {
				HttpSessionExtendWrapper sessionWrapper = (HttpSessionExtendWrapper) session;
				user = (SecurityUser) sessionWrapper.getAttribute(SESSION_USER, false);
				session.setAttribute("user", user);
			}
			return user;
		} else {
			return localUser.get();
		}
	}

	@Override
	public void setUser(SecurityUser user) {
		HttpServletRequest req = getRequest();
		if (req != null && user != null) {
			HttpSession session = req.getSession();
			if ("dev".equalsIgnoreCase(System.getProperty("env"))){
				session.setAttribute("user", user);
			}
			session.setAttribute(SESSION_USER, user);
		} else {
			localUser.set(user);
		}
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public List<String> getRoles() {
		Storage store = Authorization.getStorage();
		List<String> roles = null;
		return roles;
	}

	@Override
	public SecurityUser getUser(Integer userId) {
		SecurityUser user = new SecurityUser();
		try {
//			AuthorityUser u = userApi.findAuthorityUserById(userId);
//			user.setLoginName(u.getLoginName());
//			user.setOrganizNo(u.getOrganNo());
//			user.setOrganTypeNo(u.getOrganTypeNo());
//			user.setOrganLevel(u.getOrganLevel());
//			user.setUsername(u.getUserName());
//			TODO.GetUser
		} catch (Exception e) {
			logger.error("获取用户信息错误", e);
		}
		user.setUserId(userId);
		return user;

	}
	
	@Override
	public List<String> getFunctionItems() {
		// TODO Auto-generated method stub
		return null;
	}

}
