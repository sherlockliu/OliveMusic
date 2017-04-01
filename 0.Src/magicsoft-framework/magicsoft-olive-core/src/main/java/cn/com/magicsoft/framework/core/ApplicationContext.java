package cn.com.magicsoft.framework.core;

import java.util.HashMap;
import java.util.Map;

import org.springframework.core.NamedThreadLocal;

public class ApplicationContext {

	private static NamedThreadLocal<ApplicationContext> context = new NamedThreadLocal<>(
			"core.context");
	
	public static String host;
	
	private Map<String, Object> map = new HashMap<String, Object>();

	private ApplicationContext() {

	}

	public static ApplicationContext current() {
		ApplicationContext app = context.get();
		if (app == null) {
			app = new ApplicationContext();
			context.set(app);
		}
		return app;
	}

	public void dispose() {
		try {
			context.remove();
		} catch (Exception e) {
			
		}

	}
	
	public void clear(){
		map.clear();
	}

	public <T> T getValue(String key) {
		if (map.containsKey(key))
			return (T) map.get(key);
		return null;
	}

	public void setValue(String key, Object value) {
		map.put(key, value);
	}

	
	public static String getAppCode(){
		int id = Integer.parseInt(System.getProperty("system.id","0"));
		if( id == 12 )
			return "gms";
		else if( id == 16)
			return "mdm";
		else if( id == 14)
			return "fas";
		else if( id == 10)
			return "pms";
		else
			return "unknow";
	}
}
