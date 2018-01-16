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
public class SysCategoryItem implements Serializable {
    /**
     * 
     */
    private Integer categoryItemId;

    /**
     * 
     */
    private String categoryItemCode;

    /**
     * 
     */
    private String categoryItemName;

    /**
     * 
     */
    private Integer categoryId;

    /**
     * 
     */
    private Integer parentItemId;

    /**
     * 
     */
    private Integer orderNo;

    /**
     * 
     */
    private Byte isDefault;

    /**
     * 
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
     * {@linkplain #categoryItemId}
     *
     * @return the value of sys_category_item.category_item_id
     */
    public Integer getCategoryItemId() {
        return categoryItemId;
    }

    /**
     * 
     * {@linkplain #categoryItemId}
     * @param categoryItemId the value for sys_category_item.category_item_id
     */
    public void setCategoryItemId(Integer categoryItemId) {
        this.categoryItemId = categoryItemId;
    }

    /**
     * 
     * {@linkplain #categoryItemCode}
     *
     * @return the value of sys_category_item.category_item_code
     */
    public String getCategoryItemCode() {
        return categoryItemCode;
    }

    /**
     * 
     * {@linkplain #categoryItemCode}
     * @param categoryItemCode the value for sys_category_item.category_item_code
     */
    public void setCategoryItemCode(String categoryItemCode) {
        this.categoryItemCode = categoryItemCode;
    }

    /**
     * 
     * {@linkplain #categoryItemName}
     *
     * @return the value of sys_category_item.category_item_name
     */
    public String getCategoryItemName() {
        return categoryItemName;
    }

    /**
     * 
     * {@linkplain #categoryItemName}
     * @param categoryItemName the value for sys_category_item.category_item_name
     */
    public void setCategoryItemName(String categoryItemName) {
        this.categoryItemName = categoryItemName;
    }

    /**
     * 
     * {@linkplain #categoryId}
     *
     * @return the value of sys_category_item.category_id
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * 
     * {@linkplain #categoryId}
     * @param categoryId the value for sys_category_item.category_id
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 
     * {@linkplain #parentItemId}
     *
     * @return the value of sys_category_item.parent_item_id
     */
    public Integer getParentItemId() {
        return parentItemId;
    }

    /**
     * 
     * {@linkplain #parentItemId}
     * @param parentItemId the value for sys_category_item.parent_item_id
     */
    public void setParentItemId(Integer parentItemId) {
        this.parentItemId = parentItemId;
    }

    /**
     * 
     * {@linkplain #orderNo}
     *
     * @return the value of sys_category_item.order_no
     */
    public Integer getOrderNo() {
        return orderNo;
    }

    /**
     * 
     * {@linkplain #orderNo}
     * @param orderNo the value for sys_category_item.order_no
     */
    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    /**
     * 
     * {@linkplain #isDefault}
     *
     * @return the value of sys_category_item.is_default
     */
    public Byte getIsDefault() {
        return isDefault;
    }

    /**
     * 
     * {@linkplain #isDefault}
     * @param isDefault the value for sys_category_item.is_default
     */
    public void setIsDefault(Byte isDefault) {
        this.isDefault = isDefault;
    }

    /**
     * 
     * {@linkplain #invalid}
     *
     * @return the value of sys_category_item.invalid
     */
    public Byte getInvalid() {
        return invalid;
    }

    /**
     * 
     * {@linkplain #invalid}
     * @param invalid the value for sys_category_item.invalid
     */
    public void setInvalid(Byte invalid) {
        this.invalid = invalid;
    }

    /**
     * 
     * {@linkplain #modifyTime}
     *
     * @return the value of sys_category_item.modify_time
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 
     * {@linkplain #modifyTime}
     * @param modifyTime the value for sys_category_item.modify_time
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 
     * {@linkplain #createTime}
     *
     * @return the value of sys_category_item.create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 
     * {@linkplain #createTime}
     * @param createTime the value for sys_category_item.create_time
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}