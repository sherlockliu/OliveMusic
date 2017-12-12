package cn.com.magicsoft.framework.core.security;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import cn.com.magicsoft.framework.core.SpringContext;
import cn.com.magicsoft.framework.core.Storage;

@Component("securityStorage")
public class SecurityStorage implements Storage {
	final static int time_out = 60*30; //second;
			
	private String getKey(String key) {
		SecurityUser user = Authorization.getUser();
		if (user == null)
			return "_auth_" + key;
		if(StringUtils.isNotEmpty(key))
			return "user:" + user.getUserId() + "," + key;
		else
			return "user:" + user.getUserId();
	}

	@Override
	public void set(String key, Object value) {
		key = getKey(key); 
		getStorage().set(key, value,time_out);
	}

	@Override
	public <T> T get(String key) {
		key = getKey(key);
		return getStorage().get(key);
	}

	@Override
	public void remove(String key) {
		key = getKey(key);
		getStorage().remove(key);
	}

	private Storage getStorage() {
		return SpringContext.getBean("redisStorage");
	}

	@Override
	public void set(String key, Object value, long expire) {
		key = getKey(key); 
		getStorage().set(key, value,expire);
	}

	@Override
	public void invalide(String key) {
		key = getKey("");
		getStorage().remove(key);
	}

}
