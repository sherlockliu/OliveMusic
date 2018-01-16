package cn.com.magicsoft.framework.core.security;

public interface ITicket {

	 String getIdentity();
	 
	 Boolean isEncrypted();
	 
	 String getPassword();
}
