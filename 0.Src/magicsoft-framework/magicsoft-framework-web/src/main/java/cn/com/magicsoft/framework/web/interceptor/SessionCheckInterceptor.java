package cn.com.magicsoft.framework.web.interceptor;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.ext.XLogger;
import org.slf4j.ext.XLoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.com.magicsoft.framework.core.ApplicationContext;
import cn.com.magicsoft.framework.core.security.Authorization;
import cn.com.magicsoft.framework.core.security.SecurityUser;
import cn.com.magicsoft.framework.core.utils.CookieUtils;

/**
 * 
 * Session检查
 * 
 * @author wei.b
 * @date 2013-8-6 下午7:53:08
 * @version 0.1.0
 * @copyright yougou.com
 */
public class SessionCheckInterceptor implements HandlerInterceptor {
	protected static final XLogger logger = XLoggerFactory.getXLogger(SessionCheckInterceptor.class);

	@Value("${sso.logout.url}")
	private String logoutUrl; 
	
	public static String domain = ".com.cn";

	public String getDomain() {
		return domain;
	}

	public void setDomain(String val) {
		domain = val;
	}

	public static String hostAddress = "";
	static {
		try {
			hostAddress = InetAddress.getLocalHost().getHostAddress();
			String[] v = hostAddress.split("\\.");
			hostAddress = v[2] + "." + v[3];
		} catch (UnknownHostException e) {

		}
	}

	private void resetThreadName(HttpServletRequest request) {
		ApplicationContext.current().setValue("user", "");
		// http-bio-3810-exec-11;
		if (request.getSession(false) == null)
			return;
		String uname = "";
		SecurityUser user = Authorization.getUser();
		Thread thread = Thread.currentThread();
		String threadName = thread.getName();
		if (user != null) {
			uname = user.getLoginName();
			String[] tmp = threadName.split("\\$");
			threadName = tmp[0];
			threadName += "$" + uname;
			thread.setName(threadName);
			ApplicationContext.current().setValue("user", uname);
		}
		ApplicationContext.current().setValue("thread.id", threadName);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.yougou.logistics.base.web.interceptor.AnnotationBasedIgnoreableInterceptor#preHandleInternal(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse, java.lang.Object)
	 *      {@inheritDoc}
	 */

	@Override 
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		if (!StringUtils.isEmpty(request.getParameter("ticket"))) {
			String ticket = request.getParameter("ticket");
			ApplicationContext.current().setValue("ticket", ticket);
		}
		if (ApplicationContext.host == null)
			ApplicationContext.host = hostAddress + ":" + request.getLocalPort();

		response.addHeader("RD", ApplicationContext.host);

		String redirectUrl = logoutUrl;
		if (request.getRequestURI().indexOf("sys/") >= 0 
				|| request.getRequestURI().indexOf(".ig") > 0
				|| request.getRequestURI().indexOf("/druid/") > 0)
			return true;

		Object tempObj = Authorization.getUser();
		if (tempObj == null) {
			if (System.getProperty("env", "").equals("dev")) {
				String url = request.getHeader("Origin");
				String organTypeNo = request.getParameter("$oo");
				String userId = request.getParameter("$u");
				String zoneNo = request.getParameter("$z");
				if( url != null && url.indexOf("dev.wholesale") > 0){
					userId="1447";//sports/111111
					organTypeNo="U010102";// 设置本部为体类
				}else{
					if (StringUtils.isEmpty(userId))
						userId = "1374";
					if (StringUtils.isEmpty(organTypeNo))
						organTypeNo = "U010101";
					if (StringUtils.isEmpty(zoneNo))
						zoneNo = "Z";
				}
				SecurityUser u = Authorization.getUser(Integer.parseInt(userId.replace(",", "")));
				Authorization.setUser(u);
				Authorization.setCurrentZone(zoneNo);

			} else {
				ajaxHandle(request, response, redirectUrl);
				return false;
			}

		} else {
			String env = System.getProperty("env", "");
			if ( !env.equalsIgnoreCase("online")){
				recharge(request,response);
			}
		}
		 
		ApplicationContext.current().clear();
		if (request.getSession() != null) {
			Cookie cookie = CookieUtils.getCookie(request, "zone");
			if (cookie != null) {
				String zone = cookie.getValue();
				Authorization.setCurrentZone(zone);
			}
		}
		resetThreadName(request);
		return true;
	}
 

	private boolean recharge(HttpServletRequest request,HttpServletResponse response) throws Exception {		
		String url = request.getHeader("Origin");
		if(!StringUtils.isEmpty(url)){
			response.addHeader("Access-Control-Allow-Origin", url);
			response.addHeader("Access-Control-Allow-Credentials","true");	
		}		
		return true;
	}

	private void ajaxHandle(HttpServletRequest request, HttpServletResponse response, String redirectUrl)
			throws IOException {
		// 如果是ajax请求头会有，x-requested-with
		String ajaxFlag = request.getHeader("x-requested-with");
		if ("XMLHttpRequest".equalsIgnoreCase(ajaxFlag)) {
			logger.info("ajax timeout  ");
		} else {
			logger.info("timeout or loginout,redirect to:" + redirectUrl);
			response.setHeader("sessionTimeOutFlag", "true");// 设置标志状态
		}
		response.getOutputStream().println("<html>");
		response.getOutputStream().println("<script>");
		response.getOutputStream().println("window.open ('" + redirectUrl + "','_top')");
		response.getOutputStream().println("</script>");
		response.getOutputStream().println("</html>");
		response.flushBuffer();
	}

//	@Override
//	protected void postHandleInternal(HttpServletRequest request, HttpServletResponse response, Object handler,
//			ModelAndView modelAndView) throws Exception {
//		
//		request.setAttribute("organTypeNo", Authorization.getUser().getOrganTypeNo());
//		request.setAttribute("userId", Authorization.getUser().getUserid());
//		request.setAttribute("zoneNo", Authorization.getCurrentZone());
//	}
//
//	@Override
//	protected void afterCompletionInternal(HttpServletRequest request, HttpServletResponse response, Object handler,
//			Exception ex) throws Exception {
//		ApplicationContext.current().dispose();
//	}

 

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		request.setAttribute("userId", Authorization.getUser().getUserId());
		request.setAttribute("zoneNo", Authorization.getCurrentZone());
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception { 
		
	}

}