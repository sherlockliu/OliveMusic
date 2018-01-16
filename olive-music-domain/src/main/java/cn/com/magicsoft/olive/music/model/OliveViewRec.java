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
public class OliveViewRec implements Serializable {
    /**
     * id
     */
    private Integer viewId;

    /**
     * 浏览人id
     */
    private Integer userId;

    /**
     * 专辑id
     */
    private Integer albumId;

    /**
     * 浏览时间
     */
    private Date viewTime;

    /**
     * 
     * {@linkplain #viewId}
     *
     * @return the value of olive_view_rec.view_id
     */
    public Integer getViewId() {
        return viewId;
    }

    /**
     * 
     * {@linkplain #viewId}
     * @param viewId the value for olive_view_rec.view_id
     */
    public void setViewId(Integer viewId) {
        this.viewId = viewId;
    }

    /**
     * 
     * {@linkplain #userId}
     *
     * @return the value of olive_view_rec.user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 
     * {@linkplain #userId}
     * @param userId the value for olive_view_rec.user_id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 
     * {@linkplain #albumId}
     *
     * @return the value of olive_view_rec.album_id
     */
    public Integer getAlbumId() {
        return albumId;
    }

    /**
     * 
     * {@linkplain #albumId}
     * @param albumId the value for olive_view_rec.album_id
     */
    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    /**
     * 
     * {@linkplain #viewTime}
     *
     * @return the value of olive_view_rec.view_time
     */
    public Date getViewTime() {
        return viewTime;
    }

    /**
     * 
     * {@linkplain #viewTime}
     * @param viewTime the value for olive_view_rec.view_time
     */
    public void setViewTime(Date viewTime) {
        this.viewTime = viewTime;
    }
}