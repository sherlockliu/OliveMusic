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
public class OliveTag implements Serializable {
    /**
     * id
     */
    private Integer tagId;

    /**
     * 标签名称
     */
    private String name;

    /**
     * 标签描述
     */
    private String tagDesc;

    /**
     * 标签类别
     */
    private Byte tagType;

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
     * {@linkplain #tagId}
     *
     * @return the value of olive_tag.tag_id
     */
    public Integer getTagId() {
        return tagId;
    }

    /**
     * 
     * {@linkplain #tagId}
     * @param tagId the value for olive_tag.tag_id
     */
    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    /**
     * 
     * {@linkplain #name}
     *
     * @return the value of olive_tag.name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * {@linkplain #name}
     * @param name the value for olive_tag.name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * {@linkplain #tagDesc}
     *
     * @return the value of olive_tag.tag_desc
     */
    public String getTagDesc() {
        return tagDesc;
    }

    /**
     * 
     * {@linkplain #tagDesc}
     * @param tagDesc the value for olive_tag.tag_desc
     */
    public void setTagDesc(String tagDesc) {
        this.tagDesc = tagDesc;
    }

    /**
     * 
     * {@linkplain #tagType}
     *
     * @return the value of olive_tag.tag_type
     */
    public Byte getTagType() {
        return tagType;
    }

    /**
     * 
     * {@linkplain #tagType}
     * @param tagType the value for olive_tag.tag_type
     */
    public void setTagType(Byte tagType) {
        this.tagType = tagType;
    }

    /**
     * 
     * {@linkplain #invalid}
     *
     * @return the value of olive_tag.invalid
     */
    public Byte getInvalid() {
        return invalid;
    }

    /**
     * 
     * {@linkplain #invalid}
     * @param invalid the value for olive_tag.invalid
     */
    public void setInvalid(Byte invalid) {
        this.invalid = invalid;
    }

    /**
     * 
     * {@linkplain #modifyTime}
     *
     * @return the value of olive_tag.modify_time
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 
     * {@linkplain #modifyTime}
     * @param modifyTime the value for olive_tag.modify_time
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 
     * {@linkplain #createTime}
     *
     * @return the value of olive_tag.create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 
     * {@linkplain #createTime}
     * @param createTime the value for olive_tag.create_time
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}