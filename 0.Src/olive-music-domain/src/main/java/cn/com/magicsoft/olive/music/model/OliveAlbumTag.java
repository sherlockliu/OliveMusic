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
public class OliveAlbumTag implements Serializable {
    /**
     * 
     */
    private Integer albumTagId;

    /**
     * 
     */
    private Integer albumId;

    /**
     * 
     */
    private Integer tagId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 
     * {@linkplain #albumTagId}
     *
     * @return the value of olive_album_tag.album_tag_id
     */
    public Integer getAlbumTagId() {
        return albumTagId;
    }

    /**
     * 
     * {@linkplain #albumTagId}
     * @param albumTagId the value for olive_album_tag.album_tag_id
     */
    public void setAlbumTagId(Integer albumTagId) {
        this.albumTagId = albumTagId;
    }

    /**
     * 
     * {@linkplain #albumId}
     *
     * @return the value of olive_album_tag.album_id
     */
    public Integer getAlbumId() {
        return albumId;
    }

    /**
     * 
     * {@linkplain #albumId}
     * @param albumId the value for olive_album_tag.album_id
     */
    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    /**
     * 
     * {@linkplain #tagId}
     *
     * @return the value of olive_album_tag.tag_id
     */
    public Integer getTagId() {
        return tagId;
    }

    /**
     * 
     * {@linkplain #tagId}
     * @param tagId the value for olive_album_tag.tag_id
     */
    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    /**
     * 
     * {@linkplain #createTime}
     *
     * @return the value of olive_album_tag.create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 
     * {@linkplain #createTime}
     * @param createTime the value for olive_album_tag.create_time
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}