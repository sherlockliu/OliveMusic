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
public class OliveArtist implements Serializable {
    /**
     * id
     */
    private Integer artistId;

    /**
     * GUid
     */
    private String guid;

    /**
     * 姓名
     */
    private String name;

    /**
     * 别名
     */
    private String alias;

    /**
     * 性别
     */
    private Byte gender;

    /**
     * 国家 
     */
    private Integer country;

    /**
     * 出生日期
     */
    private Date birthday;

    /**
     * 图片
     */
    private String avatar;

    /**
     * 创建人
     */
    private Integer creator;

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
     * 简介
     */
    private String description;

    /**
     * 
     * {@linkplain #artistId}
     *
     * @return the value of olive_artist.artist_id
     */
    public Integer getArtistId() {
        return artistId;
    }

    /**
     * 
     * {@linkplain #artistId}
     * @param artistId the value for olive_artist.artist_id
     */
    public void setArtistId(Integer artistId) {
        this.artistId = artistId;
    }

    /**
     * 
     * {@linkplain #guid}
     *
     * @return the value of olive_artist.guid
     */
    public String getGuid() {
        return guid;
    }

    /**
     * 
     * {@linkplain #guid}
     * @param guid the value for olive_artist.guid
     */
    public void setGuid(String guid) {
        this.guid = guid;
    }

    /**
     * 
     * {@linkplain #name}
     *
     * @return the value of olive_artist.name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * {@linkplain #name}
     * @param name the value for olive_artist.name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * {@linkplain #alias}
     *
     * @return the value of olive_artist.alias
     */
    public String getAlias() {
        return alias;
    }

    /**
     * 
     * {@linkplain #alias}
     * @param alias the value for olive_artist.alias
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }

    /**
     * 
     * {@linkplain #gender}
     *
     * @return the value of olive_artist.gender
     */
    public Byte getGender() {
        return gender;
    }

    /**
     * 
     * {@linkplain #gender}
     * @param gender the value for olive_artist.gender
     */
    public void setGender(Byte gender) {
        this.gender = gender;
    }

    /**
     * 
     * {@linkplain #country}
     *
     * @return the value of olive_artist.country
     */
    public Integer getCountry() {
        return country;
    }

    /**
     * 
     * {@linkplain #country}
     * @param country the value for olive_artist.country
     */
    public void setCountry(Integer country) {
        this.country = country;
    }

    /**
     * 
     * {@linkplain #birthday}
     *
     * @return the value of olive_artist.birthday
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 
     * {@linkplain #birthday}
     * @param birthday the value for olive_artist.birthday
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 
     * {@linkplain #avatar}
     *
     * @return the value of olive_artist.avatar
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * 
     * {@linkplain #avatar}
     * @param avatar the value for olive_artist.avatar
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * 
     * {@linkplain #creator}
     *
     * @return the value of olive_artist.creator
     */
    public Integer getCreator() {
        return creator;
    }

    /**
     * 
     * {@linkplain #creator}
     * @param creator the value for olive_artist.creator
     */
    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    /**
     * 
     * {@linkplain #invalid}
     *
     * @return the value of olive_artist.invalid
     */
    public Byte getInvalid() {
        return invalid;
    }

    /**
     * 
     * {@linkplain #invalid}
     * @param invalid the value for olive_artist.invalid
     */
    public void setInvalid(Byte invalid) {
        this.invalid = invalid;
    }

    /**
     * 
     * {@linkplain #modifyTime}
     *
     * @return the value of olive_artist.modify_time
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 
     * {@linkplain #modifyTime}
     * @param modifyTime the value for olive_artist.modify_time
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 
     * {@linkplain #createTime}
     *
     * @return the value of olive_artist.create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 
     * {@linkplain #createTime}
     * @param createTime the value for olive_artist.create_time
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 
     * {@linkplain #description}
     *
     * @return the value of olive_artist.description
     */
    public String getDescription() {
        return description;
    }

    /**
     * 
     * {@linkplain #description}
     * @param description the value for olive_artist.description
     */
    public void setDescription(String description) {
        this.description = description;
    }
}