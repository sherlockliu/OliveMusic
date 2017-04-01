package cn.com.magicsoft.framework.core;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapQueryParam<K, V> implements QueryParam<K, V> {
	private Map<K, V> map = new HashMap<K,V>();
	@Override
	public int size() {
		 return map.size();
	}

	@Override
	public boolean isEmpty() {
		 return map.isEmpty();
	}

	@Override
	public boolean containsKey(Object key) {
		 return map.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		 return map.containsValue(value);
	}

	@Override
	public V get(Object key) {
		 return map.get(key);
	}

	@Override
	public V put(K key, V value) {
		return map.put(key, value);
	}

	@Override
	public V remove(Object key) {
		 return map.remove(key);
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		  map.putAll(m);		
	}

	@Override
	public void clear() {
		map.clear();		
	}

	@Override
	public Set<K> keySet() {
		return map.keySet();
	}

	@Override
	public Collection<V> values() {
		return map.values();
	}

	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		return map.entrySet();
	}
	
}
