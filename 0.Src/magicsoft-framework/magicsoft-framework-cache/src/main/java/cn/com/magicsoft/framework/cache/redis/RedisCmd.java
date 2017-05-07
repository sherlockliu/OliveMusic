/**
 * TODO: 增加描述
 * 
 * @author user
 * @date 2015-4-7 下午12:56:03
 * @version 0.1.0
 * @copyright www.wonhigh.cn 
 */
package cn.com.magicsoft.framework.cache.redis;

import java.util.Collection;

import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisConnectionUtils;
import org.springframework.data.redis.core.RedisTemplate;

import cn.com.magicsoft.framework.core.SpringContext;
import redis.clients.jedis.Jedis;

/**
 * redis命令执行帮助类
 * 
 * @author user
 * @date 2015-4-7 下午12:56:03
 * @version 0.1.0 
 * @copyright www.wonhigh.cn 
 */
public abstract class RedisCmd {

	private static RedisTemplate<String, String> redisTemplate;

	private static RedisTemplate<String, String> getRedisTemplate() {
		if (redisTemplate == null) {
			redisTemplate = SpringContext.getBean("redisTemplate");
		}
		return redisTemplate;
	}

	private static Object execute(ExRedisCallback myRedisCallback) {
		RedisConnectionFactory factory = getRedisTemplate().getConnectionFactory();
		RedisConnection conn = null;
		try {
			conn = RedisConnectionUtils.getConnection(factory);
			boolean pipelineStatus = conn.isPipelined();
			if (!pipelineStatus) {
				conn.openPipeline();
			}
			ExJedis myJedis = new ExJedis((Jedis) conn.getNativeConnection());
			Object obj = myRedisCallback.doWithMyJedis(myJedis);
			// close pipeline
			if (!pipelineStatus) {
				conn.closePipeline();
			}
			return obj;
		} finally {
			RedisConnectionUtils.releaseConnection(conn, factory);
		}
	}

	/**
	 * 这个需要redis 2.8 版本以上命令才支持
	 * @param key
	 * @param min
	 * @param max
	 * @param offset
	 * @param take
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Collection<String> zrangebylex(final String key, final String min, final String max,
			final int offset, final int take) {
		return (Collection<String>) execute(new ExRedisCallback() {
			public Object doWithMyJedis(ExJedis myJedis) {
				String maxValue = "+";
				if (max != null) {
					maxValue = max;
				}
				String minValue = "-";
				if (minValue != null) {
					minValue = "[" + min;
				}
				return myJedis.zrangebylex(key, minValue, maxValue, offset, take);
			}
		});
	}
}
