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
public class OliveStarRec implements Serializable {
    /**
     * id
     */
    private Integer starId;

    /**
     * 评分人id
     */
    private Integer userId;

    /**
     * 专辑id
     */
    private Integer albumId;

    /**
     * 分值
     */
    private Integer score;

    /**
     * 评分时间
     */
    private Date starTime;

    /**
     * 
     * {@linkplain #starId}
     *
     * @return the value of olive_star_rec.star_id
     */
    public Integer getStarId() {
        return starId;
    }

    /**
     * 
     * {@linkplain #starId}
     * @param starId the value for olive_star_rec.star_id
     */
    public void setStarId(Integer starId) {
        this.starId = starId;
    }

    /**
     * 
     * {@linkplain #userId}
     *
     * @return the value of olive_star_rec.user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 
     * {@linkplain #userId}
     * @param userId the value for olive_star_rec.user_id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 
     * {@linkplain #albumId}
     *
     * @return the value of olive_star_rec.album_id
     */
    public Integer getAlbumId() {
        return albumId;
    }

    /**
     * 
     * {@linkplain #albumId}
     * @param albumId the value for olive_star_rec.album_id
     */
    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    /**
     * 
     * {@linkplain #score}
     *
     * @return the value of olive_star_rec.Score
     */
    public Integer getScore() {
        return score;
    }

    /**
     * 
     * {@linkplain #score}
     * @param score the value for olive_star_rec.Score
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     * 
     * {@linkplain #starTime}
     *
     * @return the value of olive_star_rec.star_time
     */
    public Date getStarTime() {
        return starTime;
    }

    /**
     * 
     * {@linkplain #starTime}
     * @param starTime the value for olive_star_rec.star_time
     */
    public void setStarTime(Date starTime) {
        this.starTime = starTime;
    }
}