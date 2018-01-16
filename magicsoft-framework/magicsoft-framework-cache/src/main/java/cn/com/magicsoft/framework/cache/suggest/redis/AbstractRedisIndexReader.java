/**
 * TODO: 增加描述
 * 
 * @author user
 * @date 2015-4-20 下午4:47:27
 * @version 0.1.0
 * @copyright www.wonhigh.cn 
 */
package cn.com.magicsoft.framework.cache.suggest.redis;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import cn.com.magicsoft.framework.cache.suggest.IndexReader;

/**
 * TODO: 增加描述
 * 
 * @author user
 * @date 2015-4-20 下午4:47:27
 * @version 0.1.0 
 * @copyright www.wonhigh.cn 
 */
public abstract class AbstractRedisIndexReader<T> implements IndexReader<T> {

	@Resource
	protected RedisConnectionFactory redisConnectionFactory;

	protected RedisTemplate<String, String> stringTmpl;

	public List<T> search(String word, int skip, int take, Map<String, Object> condition) {
		throw new RuntimeException("not impl");
	}
}
