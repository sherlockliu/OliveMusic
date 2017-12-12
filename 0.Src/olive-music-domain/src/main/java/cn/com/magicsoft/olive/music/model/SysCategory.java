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
public class SysCategory implements Serializable {
    /**
     * 
     */
    private Integer categoryId;

    /**
     * 
     */
    private String categoryCode;

    /**
     * 
     */
    private String categoryName;

    /**
     * 
     */
    private String categoryDesc;

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
     * {@linkplain #categoryId}
     *
     * @return the value of sys_category.category_id
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * 
     * {@linkplain #categoryId}
     * @param categoryId the value for sys_category.category_id
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 
     * {@linkplain #categoryCode}
     *
     * @return the value of sys_category.category_code
     */
    public String getCategoryCode() {
        return categoryCode;
    }

    /**
     * 
     * {@linkplain #categoryCode}
     * @param categoryCode the value for sys_category.category_code
     */
    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    /**
     * 
     * {@linkplain #categoryName}
     *
     * @return the value of sys_category.category_name
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * 
     * {@linkplain #categoryName}
     * @param categoryName the value for sys_category.category_name
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * 
     * {@linkplain #categoryDesc}
     *
     * @return the value of sys_category.category_desc
     */
    public String getCategoryDesc() {
        return categoryDesc;
    }

    /**
     * 
     * {@linkplain #categoryDesc}
     * @param categoryDesc the value for sys_category.category_desc
     */
    public void setCategoryDesc(String categoryDesc) {
        this.categoryDesc = categoryDesc;
    }

    /**
     * 
     * {@linkplain #modifyTime}
     *
     * @return the value of sys_category.modify_time
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 
     * {@linkplain #modifyTime}
     * @param modifyTime the value for sys_category.modify_time
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 
     * {@linkplain #createTime}
     *
     * @return the value of sys_category.create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 
     * {@linkplain #createTime}
     * @param createTime the value for sys_category.create_time
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}