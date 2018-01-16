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
public class OliveShareRec implements Serializable {
    /**
     * id
     */
    private Integer shareId;

    /**
     * 分享人id
     */
    private Integer userId;

    /**
     * 专辑id
     */
    private Integer albumId;

    /**
     * 分享时间
     */
    private Date shareTime;

    /**
     * 
     * {@linkplain #shareId}
     *
     * @return the value of olive_share_rec.share_id
     */
    public Integer getShareId() {
        return shareId;
    }

    /**
     * 
     * {@linkplain #shareId}
     * @param shareId the value for olive_share_rec.share_id
     */
    public void setShareId(Integer shareId) {
        this.shareId = shareId;
    }

    /**
     * 
     * {@linkplain #userId}
     *
     * @return the value of olive_share_rec.user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 
     * {@linkplain #userId}
     * @param userId the value for olive_share_rec.user_id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 
     * {@linkplain #albumId}
     *
     * @return the value of olive_share_rec.album_id
     */
    public Integer getAlbumId() {
        return albumId;
    }

    /**
     * 
     * {@linkplain #albumId}
     * @param albumId the value for olive_share_rec.album_id
     */
    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    /**
     * 
     * {@linkplain #shareTime}
     *
     * @return the value of olive_share_rec.share_time
     */
    public Date getShareTime() {
        return shareTime;
    }

    /**
     * 
     * {@linkplain #shareTime}
     * @param shareTime the value for olive_share_rec.share_time
     */
    public void setShareTime(Date shareTime) {
        this.shareTime = shareTime;
    }
}