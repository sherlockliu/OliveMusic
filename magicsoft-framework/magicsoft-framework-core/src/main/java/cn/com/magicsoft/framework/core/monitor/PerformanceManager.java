package cn.com.magicsoft.framework.core.monitor;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Map;

public class PerformanceManager {
	
	private boolean enable = true;
	
	private static PerformanceManager instance;
	
	public PerformanceManager(){
		instance = this;
	}
	
	public static PerformanceManager getInstance(){
		if( instance == null )
			instance = new PerformanceManager();
		return instance;
	}
	
	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	

	private Map<String, PerformanceCounter> counters = new Hashtable<>();

	public synchronized void addCouter(PerformanceCounter counter){
		counters.put(counter.getName(), counter);
	}
	
	public Collection<PerformanceCounter> getCounters(){
		return counters.values();
	}
		
	public PerformanceCounter getCounter(String name){
		if( counters.containsKey(name) ){
			return counters.get(name);
		}
		synchronized (name.intern()) {
			if( counters.containsKey(name) ){
				return counters.get(name);
			}
			AbstractPerformanceCounter counter = new AbstractPerformanceCounter(name);
			counters.put(name, counter);
			return counter;
		}
	}
}
