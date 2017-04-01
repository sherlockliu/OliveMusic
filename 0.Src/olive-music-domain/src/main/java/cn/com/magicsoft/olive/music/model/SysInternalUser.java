package cn.com.magicsoft.olive.music.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 请写出类的用途 
 * @author user
 * @date  2017-04-01 17:10:22
 * @version 1.0.0
 * @copyright (C) 2013 WonHigh Information Technology Co.,Ltd 
 * All Rights Reserved. 
 * 
 * The software for the WonHigh technology development, without the 
 * company's written consent, and any other individuals and 
 * organizations shall not be used, Copying, Modify or distribute 
 * the software.
 * 
 */
public class SysInternalUser implements Serializable {
    /**
     * id
     */
    private Integer userId;

    /**
     * 用户登录名
     */
    private String userAccount;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 是否禁用
     */
    private Byte invalid;

    /**
     * 上次登录时间
     */
    private Date lastLoginTime;

    /**
     * 修改时间
     */
    private Date modifyTime;

    /**
     * 创建时间
     */
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
     * @param userId the value for sys_internal_user.user_id
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
     * @param userAccount the value for sys_internal_user.user_account
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
     * @param userName the value for sys_internal_user.user_name
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
     * @param password the value for sys_internal_user.password
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
     * @param invalid the value for sys_internal_user.invalid
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
     * @param lastLoginTime the value for sys_internal_user.last_login_time
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
        return modifyTime;
    }

    /**
     * 
     * {@linkplain #modifyTime}
     * @param modifyTime the value for sys_internal_user.modify_time
     */
    public void setModifyTime(Date modifyTime) {
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
     * @param createTime the value for sys_internal_user.create_time
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}