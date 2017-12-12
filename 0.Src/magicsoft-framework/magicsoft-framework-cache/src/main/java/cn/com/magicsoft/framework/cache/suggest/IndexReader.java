package cn.com.magicsoft.framework.cache.suggest;

import java.util.List;
import java.util.Map;

public interface IndexReader<T> {
	String name();

	List<T> search(String word,int skip,int take);
	
	List<T> search(String word, int skip, int take, Map<String, Object> condition);
	
	List<T> get(String key);
	
	List<T> get(String key, Map<String, Object> condition);
}
