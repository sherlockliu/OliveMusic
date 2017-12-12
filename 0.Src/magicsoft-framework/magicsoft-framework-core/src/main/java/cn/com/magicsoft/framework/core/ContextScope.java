package cn.com.magicsoft.framework.core;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

public class ContextScope implements AutoCloseable {
	static ThreadLocal<ContextScope> local = new ThreadLocal<>();
	public static AtomicLong counter = new AtomicLong(0);
	Set<AutoCloseable> container = new HashSet<>();

	public ContextScope() {
		if( local.get() == null){
			local.set(this);
		}
		counter.addAndGet(1);
	}
	
	public static ContextScope current(){
		return local.get();
	}
	
	public static void set(AutoCloseable item){
		ContextScope scope = local.get();
		if( scope == null){
			throw new NullPointerException("调用之前必须先实例化ContextScope.");
		}
		scope.container.add(item);
	}
	
	public static void remove(AutoCloseable item){
		ContextScope scope = local.get();
		if( scope == null){
			throw new NullPointerException("调用之前必须先实例化ContextScope.");
		}
		scope.container.remove(item);
	}
	
	@Override
	public void close() throws Exception {
		local.remove();
		counter.addAndGet(-1);
		for (AutoCloseable it : container) {
			try {
				it.close();
			} catch (Exception e) {
		
			}
		}
	}
}
