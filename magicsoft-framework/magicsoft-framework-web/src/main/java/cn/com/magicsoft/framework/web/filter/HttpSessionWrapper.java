package cn.com.magicsoft.framework.web.filter;

import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

public class HttpSessionWrapper implements HttpSession {
	private HttpSession session;

	public HttpSessionWrapper(HttpSession session) {
		this.session = session;
	}

	public Object getAttribute(String arg0) {
		if (this.session == null)
			return null;
		return this.session.getAttribute(arg0);
	}

	@SuppressWarnings("unchecked")
	public Enumeration getAttributeNames() {
		if (this.session == null)
			return null;
		return this.session.getAttributeNames();
	}

	public long getCreationTime() {
		return this.session.getCreationTime();
	}

	public String getId() {
		try {
			return this.session.getId();
		} catch (Exception e) {
		}
		return "";
	}

	public long getLastAccessedTime() {
		return this.session.getLastAccessedTime();
	}

	public int getMaxInactiveInterval() {
		return this.session.getMaxInactiveInterval();
	}

	public ServletContext getServletContext() {
		return this.session.getServletContext();
	}

	public HttpSessionContext getSessionContext() {
		return this.session.getSessionContext();
	}

	public Object getValue(String arg0) {
		return this.session.getValue(arg0);
	}

	public String[] getValueNames() {
		return this.session.getValueNames();
	}

	public void invalidate() {
		this.session.invalidate();
	}

	public boolean isNew() {
		return this.session.isNew();
	}

	public void putValue(String arg0, Object arg1) {
		this.session.putValue(arg0, arg1);
	}

	public void removeAttribute(String arg0) {
		this.session.removeAttribute(arg0);
	}

	public void removeValue(String arg0) {
		this.session.removeValue(arg0);
	}

	public void setAttribute(String arg0, Object arg1) {
		this.session.setAttribute(arg0, arg1);
	}

	public void setMaxInactiveInterval(int arg0) {
		this.session.setMaxInactiveInterval(arg0);
	}
}