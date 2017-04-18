package cn.com.magicsoft.framework.web.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.magicsoft.framework.core.model.CookieModel;
import cn.com.magicsoft.framework.core.security.SecurityUser;
import cn.com.magicsoft.framework.core.utils.CookieUtils;
import cn.com.magicsoft.framework.core.utils.EncryptUtils;
import cn.com.magicsoft.framework.core.utils.Enumerator;

public class HttpSessionExtendWrapper extends HttpSessionWrapper {
	private static final Logger logger = LoggerFactory.getLogger(HttpSessionExtendWrapper.class);
	private static final String CHAR_CODE = "UTF-8";
	private static final String RANDOM_KEY = "random";
	private static final String TOKEN_KEY = "token";
	private static final String STORE_TOKEN_KEY = "store_token";
	private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	private CookieModel c;
	private String sid;
	private String path;
	private String domain;
	private long expiry;
	private String expiryKey;
	private HttpServletResponse res;
	private HttpServletRequest req;

	public HttpSessionExtendWrapper(CookieModel cookie, HttpSession session, HttpServletRequest req,
			HttpServletResponse res) {
		super(session);
		this.c = cookie;
		this.sid = this.c.getKey();
		this.path = this.c.getPath();
		this.domain = this.c.getDomain();
		this.expiry = this.c.getExpiry();
		this.expiryKey = this.c.getExpiryKey();
		this.res = res;
		this.req = req;
	}

	public Object getAttribute(String name) {
		return getAttribute(name, true);
	}

	public Object getAttribute(String name, boolean localCached) {
		if (("session_user".equals(name)) || ("logistics_session_user".equals(name))) {
			Cookie expiryCookie = CookieUtils.getCookie(this.req, this.expiryKey);
			if ((null == expiryCookie) || (null == expiryCookie.getValue())
					|| (!(expiryCookie.getValue().matches("[0-9]*")))) {
				return null;
			}
			long tempExpiryTime = new Long(expiryCookie.getValue()).longValue();
			Long curTime = Long.valueOf(System.currentTimeMillis());

			if (tempExpiryTime < curTime.longValue()) {
				logger.warn("{}已超时，当前系统时间{}", new Date(tempExpiryTime), new Date(curTime.longValue()));
				CookieUtils.cancleCookie(this.res, this.expiryKey, this.domain);
				CookieUtils.cancleCookie(this.res, name, this.domain);
				return null;
			}

			Object u = null;
			if (localCached) {
				u = super.getAttribute("___session_local_user___");
				if (null != u) {
					return u;
				}
			}

			Cookie c = CookieUtils.getCookie(this.req, name);
			if (c != null) {
				try {
					String value = c.getValue();
					if (StringUtils.isEmpty(value)) {
						return null;
					}

					u = sign(value);

					if (localCached) {
						super.setAttribute("___session_local_user___", u);
					}

					return u;
				} catch (JsonParseException e) {
					logger.error("json转换错误,请检查数据格式", e);
				} catch (JsonMappingException e) {
					logger.error("json映射错误,请检查数据格式", e);
				} catch (IOException e) {
					logger.error("", e);
				}
			}
			return null;
		}
		return super.getAttribute(name);
	}

	private SecurityUser sign(String value)
			throws IOException, JsonParseException, JsonMappingException, UnsupportedEncodingException {
		ObjectMapper map = new ObjectMapper();
		Map m = (Map) map.readValue(EncryptUtils.base64Decode(URLDecoder.decode(value, "UTF-8")), Map.class);

		String encryption = System.getProperty("encryption");
		String random = (String) m.get("random");
		if (StringUtils.isEmpty(random)) {
			logger.debug("random为空");
			return null;
		}
		String token = (String) m.get("token");
		if (StringUtils.isEmpty(token)) {
			logger.debug("token为空");
			return null;
		}

		String userJson = (String) m.get("session_user");
		SecurityUser u = (SecurityUser) map.readValue(userJson, SecurityUser.class);

		String tokenTemp = builderToken(random, (StringUtils.isEmpty(encryption)) ? "MD5" : encryption, u);
		if (token.equals(tokenTemp)) {
			if (StringUtils.isNotEmpty(u.getUserName())) {
				String uName = URLDecoder.decode(u.getUserName(), "UTF-8");
				u.setUserName(uName);
			}

			String storeTimeToken = (String) m.get("store_token");
			if (StringUtils.isNotBlank(storeTimeToken)) {
				String storeTimetokenTemp = builderToken(token, (StringUtils.isEmpty(encryption)) ? "MD5" : encryption,
						u);
				if (!(StringUtils.equals(storeTimeToken, storeTimetokenTemp))) {
					logger.info("store token验证不通过,与客户端不对应");
					return null;
				}
			}

			return u;
		}
		logger.info("token验证不通过,与客户端不对应");

		return null;
	}

	@SuppressWarnings("rawtypes")
	public Enumeration getAttributeNames() {
		List list = new ArrayList();
		Enumeration ets = super.getAttributeNames();
		while (ets.hasMoreElements()) {
			list.add(ets.nextElement());
		}

		Cookie c = CookieUtils.getCookie(this.req, this.sid);
		if (c != null) {
			try {
				if (null != sign(c.getValue()))
					list.add(this.sid);
			} catch (Exception e) {
				logger.error("读取cookie添加getAttributeNames错误", e);
			}
		}
		return new Enumerator(list, true);
	}

	public void invalidate() {
		super.invalidate();
		CookieUtils.cancleCookie(this.res, this.sid, this.domain);
	}

	public void removeAttribute(String name) {
		if (("session_user".equals(name)) || ("logistics_session_user".equals(name))) {
			if (StringUtils.isNotBlank(super.getId())) {
				super.removeAttribute("___session_local_user___");
			}
			CookieUtils.cancleCookie(this.res, this.expiryKey, this.domain);
			CookieUtils.cancleCookie(this.res, name, this.domain);
			CookieUtils.cancleCookie(this.res, "store_key", this.domain);
		} else {
			super.removeAttribute(name);
		}
	}

	public void setAttribute(String name, Object value) {
		storeObject(name, value, -1);
	}

	public void setAttribute(String name, Object value, int storeTime) {
		storeObject(name, value, storeTime);
	}

	private void storeObject(String name, Object value, int storeTime) {
		if (("session_user".equals(name)) || ("logistics_session_user".equals(name))) {
			if (!(value instanceof SecurityUser)) {
				throw new RuntimeException("用户对象不是SecurityUser");
			}
			Map m = new HashMap(3);
			ObjectMapper map = new ObjectMapper();
			String v = "";
			try {
				SecurityUser u = (SecurityUser) value;
				try {
					super.setAttribute("___session_local_user___", u.clone());
				} catch (CloneNotSupportedException e) {
					logger.error("复制session对象错误", e);
				}

				if (StringUtils.isNotEmpty(u.getUserName())) {
					String uName = URLEncoder.encode(u.getUserName(), "UTF-8");
					u.setUserName(uName);
				}
				String user = map.writeValueAsString(value);
				m.put("session_user", user);

				Random r = new Random();
				String random = r.nextInt() + "";
				m.put("random", random);

				String encryption = System.getProperty("encryption");
				String token = builderToken(random, (StringUtils.isEmpty(encryption)) ? "MD5" : encryption, u);
				m.put("token", token);

				if (storeTime > 0) {
					String storeToken = builderToken(token, (StringUtils.isEmpty(encryption)) ? "MD5" : encryption, u);
					m.put("store_token", storeToken);
				}

				v = map.writeValueAsString(m);
				v = URLEncoder.encode(EncryptUtils.base64Encode(v), "UTF-8");
			} catch (JsonGenerationException e) {
				logger.error("json生成错误", e);
			} catch (JsonMappingException e) {
				logger.error("json映射错误", e);
			} catch (IOException e) {
				logger.error("", e);
			} catch (IllegalArgumentException e) {
				logger.error("", e);
			}

			CookieUtils.addCookie(this.res, name, v, this.path, this.domain, Integer.valueOf(storeTime));
			CookieUtils.addCookie(this.res, this.expiryKey, this.expiry + "", this.path, this.domain,
					Integer.valueOf(storeTime));
			CookieUtils.addCookie(this.res, "store_key", storeTime + "", this.path, this.domain,
					Integer.valueOf(storeTime));
		} else {
			super.setAttribute(name, value);
		}
	}

	private String builderToken(String random, String encryption, SecurityUser u) {
		String token = "";
		String gmtCreate = "";
		String userEncrypt = u.getUserName() + gmtCreate + random;
		if (encryption.equals("MD5"))
			token = EncryptUtils.md5(userEncrypt);
		else if (encryption.equals("SHA1"))
			token = EncryptUtils.sha(userEncrypt);
		else {
			token = EncryptUtils.md5(userEncrypt);
		}
		return token;
	}
}
