package cn.com.magicsoft.framework.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import cn.com.magicsoft.framework.core.PublicContants;
import cn.com.magicsoft.framework.core.model.CookieModel;
import cn.com.magicsoft.framework.core.utils.CookieUtils;

public class SessionFilter implements Filter {
	private String sessionKey;
	private String expiryKey;
	private String cookieDomainKey;
	private static String cookieDomain = "";
	private String cookiePath;
	private Integer expiry;

	public SessionFilter() {
		this.sessionKey = null;
		this.expiryKey = null;
		this.cookieDomainKey = "cookieDomain";
		this.cookiePath = "/";
		this.expiry = Integer.valueOf(1800);
	}

	public static String getCookieDomain() {
		return cookieDomain;
	}
	
	public void init(FilterConfig filterConfig) throws ServletException {
		String sessionId = filterConfig.getInitParameter("sessionId");
		sessionId = StringUtils.isNotEmpty(sessionId)?sessionId:PublicContants.SESSION_USER;

		String expiryKey = filterConfig.getInitParameter("expiryKey");
		this.expiryKey = StringUtils.isNotEmpty(expiryKey)?expiryKey:PublicContants.EXPIRY_KEY;
		
		String cookieDomain = System.getProperty(this.cookieDomainKey);
		if (StringUtils.isEmpty(cookieDomain)) {
			cookieDomain = filterConfig.getInitParameter(this.cookieDomainKey);
			if (StringUtils.isEmpty(cookieDomain)) {
				throw new RuntimeException("域名不能为空");
			}
		}

		String cookiePath = filterConfig.getInitParameter("cookiePath");
		if (StringUtils.isNotEmpty(cookiePath)) {
			this.cookiePath = cookiePath;
		}

		String expiry = filterConfig.getInitParameter("expiry");
		if ((!(StringUtils.isNotEmpty(expiry))) || (!(expiry.matches("^([0-9]*)")))){
			return;
		}
		this.expiry = Integer.valueOf(Integer.parseInt(expiry));
	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		if (excludes(request.getServletPath())) {
			filterChain.doFilter(request, response);
		} else {
			Cookie storeCookie = CookieUtils.getCookie(request, "store_key");
			Integer storeTime = Integer.valueOf(((null == storeCookie) || (StringUtils.isBlank(storeCookie.getValue())))
					? -1 : Integer.valueOf(storeCookie.getValue()).intValue());

			long expiryTime = 0L;
			if (this.expiry.intValue() > 0) {
				if (storeTime.intValue() > 0)
					expiryTime = System.currentTimeMillis() + storeTime.intValue() * 1000;
				else {
					expiryTime = System.currentTimeMillis() + this.expiry.intValue() * 1000;
				}
			} else {
				expiryTime = System.currentTimeMillis() + 86400000L;
			}

			Cookie expiryCookie = CookieUtils.getCookie(request, this.expiryKey);
			Cookie cookie = CookieUtils.getCookie(request, this.sessionKey);
			if ((null != expiryCookie) && 
				(null != cookie) && 
				(StringUtils.isNotEmpty(expiryCookie.getValue())) && 
				(expiryCookie.getValue().matches("[0-9]*"))) {
				long tempExpiryTime = Long.valueOf(expiryCookie.getValue()).longValue();

				if (tempExpiryTime < System.currentTimeMillis()) {
					CookieUtils.cancleCookie(response, this.expiryKey, cookieDomain);
					CookieUtils.cancleCookie(response, this.sessionKey, cookieDomain);
				} else if (storeTime.intValue() == -1) {
					CookieUtils.addCookie(response, this.expiryKey, expiryTime + "", this.cookiePath, cookieDomain,
							storeTime);
				}
			}
			filterChain.doFilter(new HttpServletRequestWrapper(
					new CookieModel(this.sessionKey, null, cookieDomain, this.cookiePath, expiryTime, this.expiryKey),
					request, response), servletResponse);
		}
	}

	public boolean excludes(String url) {
		return ((url.endsWith(".gif")) || 
				(url.endsWith(".jpg")) || 
				(url.endsWith(".png")) || 
				(url.endsWith(".bmp")) || 
				(url.endsWith(".css")) || 
				(url.endsWith(".js"))  || 
				(url.endsWith(".jsx")));
	}

	public void destroy() {
	}
}