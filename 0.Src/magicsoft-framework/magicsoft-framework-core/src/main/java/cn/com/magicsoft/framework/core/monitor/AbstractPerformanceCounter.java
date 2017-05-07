package cn.com.magicsoft.framework.core.monitor;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;

public class AbstractPerformanceCounter implements PerformanceCounter{

	private String name;	
	protected  AtomicLong atomic = new AtomicLong(1);	
	protected  AtomicLong count = new AtomicLong(0);
	protected long min=2000;
	protected long max=0;
	protected long take=0;
	
	public AbstractPerformanceCounter(String name){		
		this.name = name;		 
	}
	
	@Override
	public void setName(String value) {
		 this.name = value;
	}

	@Override
	public String getName() {
		return this.name;		
	}

	 
	@Override
	public long increment(long value) {
		if( take == 0 || counting() == 0)
			take = System.currentTimeMillis();
		long result = atomic.addAndGet(value);
		max = Math.max(value,max);
		min = Math.min(value,min);
		count.addAndGet(1);
		return result;
	}
 
	@Override
	public long total() {
		 return count.get();
	}

	@Override
	public long max() {
		return max;
	}

	@Override
	public long min() {
		 return min;
	}

	/*
	 * (non-Javadoc)
	 * @see cn.wonhigh.retail.backend.monitor.PerformanceCounter#avg()
	 */
	@Override
	public double avg() {
		if( count.get() == 0 )
			return 0;
		return atomic.get()/count.get();
	}

	private long increment=0;
	private double counting = 0;
	/**
	 * 每秒完成数
	 */
	@Override
	public double counting() {
		long v = (System.currentTimeMillis()- take) /1000;
		if( v < 1 )
			return counting;			
		
		long c = count.get();
		long r = (c - increment);				
		if( r <= 0 ) 
			return counting;
		
		take = System.currentTimeMillis();
		counting = r / v;
		increment = c;
		return counting;
	}
	
	@Override
	public synchronized void reset(){
		max = 0;
		min = 2000;
		count.set(0);
		atomic.set(0);
	}
	
	Counter info = new Counter();
	public Counter info(){
		info.avg = this.avg();
		info.max = this.max();
		info.name = this.name;
		info.counting = this.counting();
		info.total = this.total();
		info.min = this.min;
		return info;
	}
	
	public static class Counter implements Serializable{
		/**
		 * 
		 */
		private static final long serialVersionUID = 6662244910096597486L;
		
		private int type;
		private String name;		
		public int getType() {
			return type;
		}
		public void setType(int type) {
			this.type = type;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public long getMax() {
			return max;
		}
		public void setMax(long max) {
			this.max = max;
		}
		public long getMin() {
			return min;
		}
		public void setMin(long min) {
			this.min = min;
		}
		public long getTotal() {
			return total;
		}
		public void setTotal(long total) {
			this.total = total;
		}
		public double getAvg() {
			return avg;
		}
		public void setAvg(double avg) {
			this.avg = avg;
		}
		public double getCounting() {
			return counting;
		}
		public void setCounting(double counting) {
			this.counting = counting;
		}
		private long max;
		private long min;
		private long total;
		private double avg;
		private double counting;
	}
	
	
}
