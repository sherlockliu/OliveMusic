package cn.com.magicsoft.olive.music.model;

import java.io.Serializable;
import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import cn.com.magicsoft.framework.core.utils.JsonDateDeserializer$19;
import cn.com.magicsoft.framework.core.utils.JsonDateSerializer$19;

/**
 * ��д�������;
 * 
 * @author user
 * @date 2017-04-01 17:10:22
 * @version 1.0.0
 * @copyright (C) 2013 WonHigh Information Technology Co.,Ltd All Rights
 *            Reserved.
 * 
 *            The software for the WonHigh technology development, without the
 *            company's written consent, and any other individuals and
 *            organizations shall not be used, Copying, Modify or distribute the
 *            software.
 * 
 */
public class SysInternalUser implements Serializable {

	public SysInternalUser() {
		this.lastLoginTime = new Date();
		this.modifyTime = new Date();
		this.createTime = new Date();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	private Integer userId;

	/**
	 * �û���¼��
	 */
	private String userAccount;

	/**
	 * �û���
	 */
	private String userName;

	/**
	 * ����
	 */
	private String password;

	/**
	 * �Ƿ����
	 */
	private Byte invalid;

	/**
	 * �ϴε�¼ʱ��
	 */
	@JsonSerialize(using = JsonDateSerializer$19.class)
	@JsonDeserialize(using = JsonDateDeserializer$19.class)
	private Date lastLoginTime;

	/**
	 * �޸�ʱ��
	 */
	@JsonSerialize(using = JsonDateSerializer$19.class)
	@JsonDeserialize(using = JsonDateDeserializer$19.class)
	private Date modifyTime;

	/**
	 * ����ʱ��
	 */
	@JsonSerialize(using = JsonDateSerializer$19.class)
	@JsonDeserialize(using = JsonDateDeserializer$19.class)
	private Date createTime;

	
	/**
	 * 
	 * {@linkplain #userId}
	 *
	 * @return the value of sys_internal_user.user_id
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * 
	 * {@linkplain #userId}
	 * 
	 * @param userId
	 *            the value for sys_internal_user.user_id
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * 
	 * {@linkplain #userAccount}
	 *
	 * @return the value of sys_internal_user.user_account
	 */
	public String getUserAccount() {
		return userAccount;
	}

	/**
	 * 
	 * {@linkplain #userAccount}
	 * 
	 * @param userAccount
	 *            the value for sys_internal_user.user_account
	 */
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	/**
	 * 
	 * {@linkplain #userName}
	 *
	 * @return the value of sys_internal_user.user_name
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 
	 * {@linkplain #userName}
	 * 
	 * @param userName
	 *            the value for sys_internal_user.user_name
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * 
	 * {@linkplain #password}
	 *
	 * @return the value of sys_internal_user.password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 
	 * {@linkplain #password}
	 * 
	 * @param password
	 *            the value for sys_internal_user.password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 
	 * {@linkplain #invalid}
	 *
	 * @return the value of sys_internal_user.invalid
	 */
	public Byte getInvalid() {
		return invalid;
	}

	/**
	 * 
	 * {@linkplain #invalid}
	 * 
	 * @param invalid
	 *            the value for sys_internal_user.invalid
	 */
	public void setInvalid(Byte invalid) {
		this.invalid = invalid;
	}

	/**
	 * 
	 * {@linkplain #lastLoginTime}
	 *
	 * @return the value of sys_internal_user.last_login_time
	 */
	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	/**
	 * 
	 * {@linkplain #lastLoginTime}
	 * 
	 * @param lastLoginTime
	 *            the value for sys_internal_user.last_login_time
	 */
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	/**
	 * 
	 * {@linkplain #modifyTime}
	 *
	 * @return the value of sys_internal_user.modify_time
	 */
	public Date getModifyTime() {
		if(this.modifyTime == null){
			this.modifyTime = new Date();
		}
		return modifyTime;
	}

	/**
	 * 
	 * {@linkplain #modifyTime}
	 * 
	 * @param modifyTime
	 *            the value for sys_internal_user.modify_time
	 */
	public void setModifyTime(Date modifyTime) {
		if(modifyTime == null){
			modifyTime = new Date();
		}
		this.modifyTime = modifyTime;
	}

	/**
	 * 
	 * {@linkplain #createTime}
	 *
	 * @return the value of sys_internal_user.create_time
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * 
	 * {@linkplain #createTime}
	 * 
	 * @param createTime
	 *            the value for sys_internal_user.create_time
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}