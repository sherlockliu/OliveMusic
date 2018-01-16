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
public class OliveUser implements Serializable {
    /**
     * id
     */
    private Integer userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 积分
     */
    private Integer score;

    /**
     * QQ
     */
    private String qq;

    /**
     * 电话
     */
    private String tel;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 性别
     */
    private Byte gender;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 居住地
     */
    private Integer residence;

    /**
     * 自我简介
     */
    private String selfIntro;

    /**
     * 是否禁用
     */
    private Byte invalid;

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
     * @return the value of olive_user.user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 
     * {@linkplain #userId}
     * @param userId the value for olive_user.user_id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 
     * {@linkplain #userName}
     *
     * @return the value of olive_user.user_name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 
     * {@linkplain #userName}
     * @param userName the value for olive_user.user_name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 
     * {@linkplain #password}
     *
     * @return the value of olive_user.password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 
     * {@linkplain #password}
     * @param password the value for olive_user.password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 
     * {@linkplain #email}
     *
     * @return the value of olive_user.email
     */
    public String getEmail() {
        return email;
    }

    /**
     * 
     * {@linkplain #email}
     * @param email the value for olive_user.email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 
     * {@linkplain #score}
     *
     * @return the value of olive_user.score
     */
    public Integer getScore() {
        return score;
    }

    /**
     * 
     * {@linkplain #score}
     * @param score the value for olive_user.score
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     * 
     * {@linkplain #qq}
     *
     * @return the value of olive_user.qq
     */
    public String getQq() {
        return qq;
    }

    /**
     * 
     * {@linkplain #qq}
     * @param qq the value for olive_user.qq
     */
    public void setQq(String qq) {
        this.qq = qq;
    }

    /**
     * 
     * {@linkplain #tel}
     *
     * @return the value of olive_user.tel
     */
    public String getTel() {
        return tel;
    }

    /**
     * 
     * {@linkplain #tel}
     * @param tel the value for olive_user.tel
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * 
     * {@linkplain #avatar}
     *
     * @return the value of olive_user.avatar
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * 
     * {@linkplain #avatar}
     * @param avatar the value for olive_user.avatar
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * 
     * {@linkplain #gender}
     *
     * @return the value of olive_user.gender
     */
    public Byte getGender() {
        return gender;
    }

    /**
     * 
     * {@linkplain #gender}
     * @param gender the value for olive_user.gender
     */
    public void setGender(Byte gender) {
        this.gender = gender;
    }

    /**
     * 
     * {@linkplain #birthday}
     *
     * @return the value of olive_user.birthday
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 
     * {@linkplain #birthday}
     * @param birthday the value for olive_user.birthday
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 
     * {@linkplain #residence}
     *
     * @return the value of olive_user.residence
     */
    public Integer getResidence() {
        return residence;
    }

    /**
     * 
     * {@linkplain #residence}
     * @param residence the value for olive_user.residence
     */
    public void setResidence(Integer residence) {
        this.residence = residence;
    }

    /**
     * 
     * {@linkplain #selfIntro}
     *
     * @return the value of olive_user.self_intro
     */
    public String getSelfIntro() {
        return selfIntro;
    }

    /**
     * 
     * {@linkplain #selfIntro}
     * @param selfIntro the value for olive_user.self_intro
     */
    public void setSelfIntro(String selfIntro) {
        this.selfIntro = selfIntro;
    }

    /**
     * 
     * {@linkplain #invalid}
     *
     * @return the value of olive_user.invalid
     */
    public Byte getInvalid() {
        return invalid;
    }

    /**
     * 
     * {@linkplain #invalid}
     * @param invalid the value for olive_user.invalid
     */
    public void setInvalid(Byte invalid) {
        this.invalid = invalid;
    }

    /**
     * 
     * {@linkplain #modifyTime}
     *
     * @return the value of olive_user.modify_time
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 
     * {@linkplain #modifyTime}
     * @param modifyTime the value for olive_user.modify_time
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 
     * {@linkplain #createTime}
     *
     * @return the value of olive_user.create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 
     * {@linkplain #createTime}
     * @param createTime the value for olive_user.create_time
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}