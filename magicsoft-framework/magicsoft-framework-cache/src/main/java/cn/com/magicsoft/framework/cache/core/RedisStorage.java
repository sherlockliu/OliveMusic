package cn.com.magicsoft.framework.cache.core;

import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import cn.com.magicsoft.framework.core.Storage;

@Component("redisStorage")
public class RedisStorage implements Storage {
	private static final String KEY_PREFIX = "";
	private long timeout = 30 * 60;
	private static RedisStorage current;
	
	public RedisStorage(){
		current = this;
	}
	
	public static RedisStorage getCurrent(){
		return current;
	}
	
	@Resource(name = "objRedisTemplate")
	private RedisTemplate<String, Object> objectTmpl;

	@Override
	public void set(String key, Object value) {
		set(key, value, timeout);
	}

	@Override
	public void set(String key, Object value, long expire) {
		String[] keys = key.split(",");
		if (keys.length == 1) {
			ValueOperations<String, Object> set = objectTmpl.opsForValue();
			key = KEY_PREFIX + key;
			set.set(key, value);
			objectTmpl.expire(key, expire, TimeUnit.SECONDS);
		} else if (keys.length == 2) {
			HashOperations<String, Object, Object> hset = objectTmpl.opsForHash();
			hset.put(keys[0], keys[1], value);
			objectTmpl.expire(keys[0], expire, TimeUnit.SECONDS);
		} else {
			throw new UnknownError(key);
		}

	} 
	@SuppressWarnings("unchecked")
	@Override
	public <T> T get(String key) {
		String[] keys = key.split(",");
		if (keys.length == 1) {
			ValueOperations<String, Object> set = objectTmpl.opsForValue();
			key = KEY_PREFIX + key;
			return (T) set.get(key);
		} else if (keys.length == 2) {
			HashOperations<String, Object, Object> hset = objectTmpl.opsForHash();
			return (T)hset.get(keys[0], keys[1]);
		} else {
			throw new UnknownError(key);
		}
	}

	@Override
	public void remove(String key) {
		key = KEY_PREFIX + key;
		objectTmpl.delete(key);

	}

	@Override
	public void invalide(String key) {
		objectTmpl.delete(key);
	}

}
