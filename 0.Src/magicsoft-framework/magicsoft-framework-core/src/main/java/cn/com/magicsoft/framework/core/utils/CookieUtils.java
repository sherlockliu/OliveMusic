package cn.com.magicsoft.framework.core.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.Assert;

public class CookieUtils {
	public static Cookie getCookie(HttpServletRequest request, String name, String domain) {
		Assert.notNull(request);
		Cookie[] cookies = request.getCookies();
		if ((cookies != null) && (cookies.length > 0)) {
			for (Cookie c : cookies) {
				if (c.getName().equals(name)) {
					return c;
				}
			}
		}
		return null;
	}

	public static Cookie getCookie(HttpServletRequest request, String name) {
		return getCookie(request, name, null);
	}

	public static Cookie addCookie(HttpServletRequest request, HttpServletResponse response, String name, String value,
			Integer expiry) {
		Cookie cookie = new Cookie(name, value);
		cookie.setHttpOnly(true);
		if (expiry != null) {
			cookie.setMaxAge(expiry.intValue());
		}
		String ctx = request.getContextPath();
		cookie.setPath((StringUtils.isBlank(ctx)) ? "/" : ctx);
		response.addCookie(cookie);
		return cookie;
	}

	public static Cookie addCookie(HttpServletResponse response, String name, String value, String path, String domain,
			Integer expiry) {
		Cookie cookie = new Cookie(name, value);
		cookie.setHttpOnly(true);
		if (expiry != null) {
			cookie.setMaxAge(expiry.intValue());
		}
		cookie.setPath((StringUtils.isBlank(path)) ? "/" : path);
		cookie.setDomain(domain);
		response.addCookie(cookie);
		return cookie;
	}

	public static Cookie addCookie(HttpServletResponse response, Cookie cookie, String path, String domain,
			Integer expiry) {
		if (null == cookie) {
			return null;
		}
		if (expiry != null) {
			cookie.setMaxAge(expiry.intValue());
		}
		cookie.setHttpOnly(true);
		cookie.setPath((StringUtils.isBlank(path)) ? "/" : path);
		cookie.setDomain(domain);
		response.addCookie(cookie);
		return cookie;
	}

	public static void cancleCookie(HttpServletResponse response, String name, String domain) {
		Cookie cookie = new Cookie(name, null);
		cookie.setMaxAge(0);
		cookie.setPath("/");
		if (!(StringUtils.isBlank(domain))) {
			cookie.setDomain(domain);
		}
		response.addCookie(cookie);
	}
}