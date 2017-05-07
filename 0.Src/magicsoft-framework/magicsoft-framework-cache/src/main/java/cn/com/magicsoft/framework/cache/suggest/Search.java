package cn.com.magicsoft.framework.cache.suggest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

@Component(value = "search")
public class Search implements ApplicationContextAware, java.lang.AutoCloseable {
	private int defaultTake = 10;
	@SuppressWarnings("rawtypes")
	Map<String, IndexReader> readers = new HashMap<String, IndexReader>();
	private boolean cached = false;
	static Cache<String, Object> cache;
	static {
		cache = callableCached();
	}

	public Search() {

	}

	final protected void initialize() {

	}

	public synchronized void clear(String type, String key, String bean) {
		if (StringUtils.isEmpty(type) && StringUtils.isEmpty(key))
			cache.invalidateAll();
		else if (StringUtils.isNotEmpty(type) && StringUtils.isNotEmpty(key)) {
			String s = type + "_" + key;
			if (StringUtils.isNotEmpty(bean))
				s = s + "_" + bean;
			cache.invalidate(s);
		}

	}

	static <K, V> Cache<K, V> callableCached() {
		Cache<K, V> cache = CacheBuilder.newBuilder().maximumSize(50000).expireAfterWrite(45, TimeUnit.MINUTES).build();
		return cache;
	}

	public Search open() {
		Search search = new Search();
		search.readers = this.readers;
		search.cached = true;
		// search.cache = new HashMap<>();
		return search;
	}

	public <T> List<T> search(String type, String word) {
		return this.search(type, word, 0, defaultTake);
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> get(String type, String key) {
		// IndexReader<T> reader = readers.get(type);
		// Map<String,Object> params = new HashMap<>();
		// if(reader == null){
		// reader = readers.get("default");
		// params.put("bean", type);
		// return reader.get(key,params);
		// }
		// return reader.get(key);
		return get(type, key, null);
	}

	public <T> T getSingle(String type, String key) {
		return getSingle(type, key, null);
	}

	public <T> T getSingle(String type, String key, Map<String, Object> params) {
		List<T> lst = get(type, key, params);
		if (lst == null || lst.size() == 0)
			return null;
		return lst.get(0);
	}

	// HashMap<String, Object> cache;

	@SuppressWarnings("unchecked")
	public <T> List<T> get(String type, String key, Map<String, Object> params) {
		if (StringUtils.isEmpty(key) || StringUtils.isEmpty(type))
			return null;
		List<T> result;
		String s = type + "_" + key;
		if (params != null && params.containsKey("bean"))
			s = s + "_" + params.get("bean");

		result = (List<T>) cache.getIfPresent(s);
		if (cached &&  result != null && result.size()>0)
			return result;

		if (params == null)
			params = new HashMap<>();

		IndexReader<T> reader = readers.get(type);
		if (reader == null) {
			reader = readers.get("default");
			params.put("bean", type);
		}
		result = reader.get(key, params);
		if (cached && result != null)
			cache.put(s, result);
		if( result == null )
			return null;
		List<T> lst = new ArrayList<>(result);
		return lst;
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> search(String type, String word, int skip, int take) {
		if (!readers.containsKey(type)) {
			return null;
		}
		IndexReader<T> reader = readers.get(type);
		return reader.search(word, skip, take);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		Map<String, IndexReader> items = BeanFactoryUtils.beansOfTypeIncludingAncestors(context, IndexReader.class,
				false, false);

		for (Entry<String, IndexReader> kv : items.entrySet()) {
			IndexReader<?> item = kv.getValue();
			String typeName = item.name();
			readers.put(typeName.toLowerCase(), item);
		}
	}

	@Override
	public void close() throws Exception {

	}
}
