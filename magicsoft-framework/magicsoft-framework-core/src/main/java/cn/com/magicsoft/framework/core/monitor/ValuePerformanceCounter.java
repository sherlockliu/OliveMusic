package cn.com.magicsoft.framework.core.monitor;


public class ValuePerformanceCounter  extends AbstractPerformanceCounter{

	public ValuePerformanceCounter(String name) {
		super(name); 
	}
	 
	@Override
	public long increment(long value) {	  
		return count.addAndGet(1);		
	}
	
	@Override
	public long total() {
		 return count.get();
	}
}
