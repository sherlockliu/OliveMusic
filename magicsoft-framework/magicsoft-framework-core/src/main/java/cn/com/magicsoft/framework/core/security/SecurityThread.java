package cn.com.magicsoft.framework.core.security;

public class SecurityThread extends Thread {
	
	public SecurityThread(){
		load();
	}
	
	public SecurityThread(Runnable task){
		super(task);
		load();
	}
	
	public void init(){
		Authorization.setUser(user);
	}

	@Override
	public void run(){
		init();	
		super.run();
	}
	SecurityUser user;
	private void load(){
		user = Authorization.getUser();
	}
}
