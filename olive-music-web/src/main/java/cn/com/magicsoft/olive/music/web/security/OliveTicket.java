package cn.com.magicsoft.olive.music.web.security;

import cn.com.magicsoft.framework.core.security.ITicket;

public class OliveTicket implements ITicket{

	private String identity;
	private Boolean isEncrypted;
	private String password;
	
	public OliveTicket(String identity,String password, Boolean isEncrypted){
		this.identity = identity;
		this.password = password;
		this.isEncrypted = isEncrypted;
	}
	
	@Override
	public String getIdentity() {
		return this.identity;
	}

	@Override
	public Boolean isEncrypted() {
		return this.isEncrypted;
	}
	
	public String getPassword() {
		return this.password;
	}
}
