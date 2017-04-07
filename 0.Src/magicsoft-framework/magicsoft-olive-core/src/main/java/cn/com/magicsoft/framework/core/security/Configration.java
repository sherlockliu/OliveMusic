package cn.com.magicsoft.framework.core.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("configration")
public class Configration {
	 
	public int dataaccess;
	@Value("${dataaccess}")
	public void setDataaccess(int val){
		this.dataaccess = val;		 
	}	
	
	@Value("${session.disable:0}")
	public int sessionDisable;
}
