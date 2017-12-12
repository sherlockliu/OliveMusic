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
public class OliveFavoriteRec implements Serializable {
    /**
     * id
     */
    private Integer favoriteId;

    /**
     * 收藏人id
     */
    private Integer userId;

    /**
     * 专辑id
     */
    private Integer albumId;

    /**
     * 收藏时间
     */
    private Date favoriteTime;

    /**
     * 
     * {@linkplain #favoriteId}
     *
     * @return the value of olive_favorite_rec.favorite_id
     */
    public Integer getFavoriteId() {
        return favoriteId;
    }

    /**
     * 
     * {@linkplain #favoriteId}
     * @param favoriteId the value for olive_favorite_rec.favorite_id
     */
    public void setFavoriteId(Integer favoriteId) {
        this.favoriteId = favoriteId;
    }

    /**
     * 
     * {@linkplain #userId}
     *
     * @return the value of olive_favorite_rec.user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 
     * {@linkplain #userId}
     * @param userId the value for olive_favorite_rec.user_id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 
     * {@linkplain #albumId}
     *
     * @return the value of olive_favorite_rec.album_id
     */
    public Integer getAlbumId() {
        return albumId;
    }

    /**
     * 
     * {@linkplain #albumId}
     * @param albumId the value for olive_favorite_rec.album_id
     */
    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    /**
     * 
     * {@linkplain #favoriteTime}
     *
     * @return the value of olive_favorite_rec.favorite_time
     */
    public Date getFavoriteTime() {
        return favoriteTime;
    }

    /**
     * 
     * {@linkplain #favoriteTime}
     * @param favoriteTime the value for olive_favorite_rec.favorite_time
     */
    public void setFavoriteTime(Date favoriteTime) {
        this.favoriteTime = favoriteTime;
    }
}