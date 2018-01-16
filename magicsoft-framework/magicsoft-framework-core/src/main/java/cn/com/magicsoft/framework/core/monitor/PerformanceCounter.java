package cn.com.magicsoft.framework.core.monitor;

import cn.com.magicsoft.framework.core.monitor.AbstractPerformanceCounter.Counter;

/**
 * 计数器
 * @author
 *
 */
public interface PerformanceCounter {
	
	public void setName(String value);
	public String getName();
	 
	public long increment(long value);
		
	public long total();
	
	public long max();
	
	public long min();
	
	public double avg();
	
	public double counting();
	
	public Counter info();
	
	public void reset();
}
