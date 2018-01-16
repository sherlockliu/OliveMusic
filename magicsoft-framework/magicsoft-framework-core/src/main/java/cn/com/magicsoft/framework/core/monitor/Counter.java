package cn.com.magicsoft.framework.core.monitor;

import java.io.Serializable;
import java.util.Date;
 

/**
 * 性能日志计数器
 * @author kain
 *
 */
public class Counter implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 159894182460338603L;

	private String app;
	
	public String getApp() {
		return app;
	}

	public void setApp(String app) {
		this.app = app;
	}

	private Date date;
	
	private String type;
	
	private String uri;
	
	private String status;
	
	private long takes;
	
	private String tag;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getTakes() {
		return takes;
	}

	public void setTakes(long takes) {
		this.takes = takes;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

 
}
