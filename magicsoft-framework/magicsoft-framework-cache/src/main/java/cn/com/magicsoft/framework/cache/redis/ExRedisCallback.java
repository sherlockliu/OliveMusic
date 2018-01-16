/**
 * TODO: 增加描述
 * 
 * @author user
 * @date 2015-4-7 下午12:59:56
 * @version 0.1.0
 * @copyright www.wonhigh.cn 
 */
package cn.com.magicsoft.framework.cache.redis;

/**
 * TODO: 增加描述
 * 
 * @author user
 * @date 2015-4-7 下午12:59:56
 * @version 0.1.0 
 * @copyright www.wonhigh.cn 
 */
public interface ExRedisCallback {

	Object doWithMyJedis(ExJedis myJedis);
}
