package cn.com.magicsoft.framework.cache.core;

import cn.com.magicsoft.framework.core.enums.EntityStatus;

public class EventArgs {
	private String type;
	private Object data;
	private EntityStatus status;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public EntityStatus getStatus() {
		return status;
	}
	public void setStatus(EntityStatus type) {
		this.status = type;
	}
	
	
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
}
