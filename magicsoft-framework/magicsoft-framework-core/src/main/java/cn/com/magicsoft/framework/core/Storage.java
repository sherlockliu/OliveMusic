package cn.com.magicsoft.framework.core;

public interface Storage { 

	void set(String key,Object value);
	
	void set(String key,Object value,long expire );
	
	<T> T get(String key);
	
	void remove(String key);
	
	void invalide(String key);
}
