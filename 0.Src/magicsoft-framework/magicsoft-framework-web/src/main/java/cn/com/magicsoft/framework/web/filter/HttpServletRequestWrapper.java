package cn.com.magicsoft.framework.web.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.magicsoft.framework.core.model.CookieModel;

public class HttpServletRequestWrapper extends javax.servlet.http.HttpServletRequestWrapper {
	private CookieModel cookie;
	private HttpServletResponse res;
	private HttpServletRequest req;

	public HttpServletRequestWrapper(CookieModel cookie, HttpServletRequest req, HttpServletResponse res) {
		super(req);
		this.cookie = cookie;
		this.req = req;
		this.res = res;
	}

	public HttpSession getSession(boolean create) {
		return new HttpSessionExtendWrapper(this.cookie, super.getSession(create), this.req, this.res);
	}

	public HttpSession getSession() {
		return new HttpSessionExtendWrapper(this.cookie, super.getSession(), this.req, this.res);
	}
}