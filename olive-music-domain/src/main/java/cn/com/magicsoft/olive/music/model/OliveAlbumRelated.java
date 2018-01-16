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
public class OliveAlbumRelated implements Serializable {
    /**
     * 
     */
    private Integer relatedId;

    /**
     * 专辑id
     */
    private Integer albumId;

    /**
     * 相关专辑id
     */
    private Integer relatedAlbumId;

    /**
     * 分值
     */
    private Integer score;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 
     * {@linkplain #relatedId}
     *
     * @return the value of olive_album_related.related_id
     */
    public Integer getRelatedId() {
        return relatedId;
    }

    /**
     * 
     * {@linkplain #relatedId}
     * @param relatedId the value for olive_album_related.related_id
     */
    public void setRelatedId(Integer relatedId) {
        this.relatedId = relatedId;
    }

    /**
     * 
     * {@linkplain #albumId}
     *
     * @return the value of olive_album_related.album_id
     */
    public Integer getAlbumId() {
        return albumId;
    }

    /**
     * 
     * {@linkplain #albumId}
     * @param albumId the value for olive_album_related.album_id
     */
    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    /**
     * 
     * {@linkplain #relatedAlbumId}
     *
     * @return the value of olive_album_related.related_album_id
     */
    public Integer getRelatedAlbumId() {
        return relatedAlbumId;
    }

    /**
     * 
     * {@linkplain #relatedAlbumId}
     * @param relatedAlbumId the value for olive_album_related.related_album_id
     */
    public void setRelatedAlbumId(Integer relatedAlbumId) {
        this.relatedAlbumId = relatedAlbumId;
    }

    /**
     * 
     * {@linkplain #score}
     *
     * @return the value of olive_album_related.Score
     */
    public Integer getScore() {
        return score;
    }

    /**
     * 
     * {@linkplain #score}
     * @param score the value for olive_album_related.Score
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     * 
     * {@linkplain #createTime}
     *
     * @return the value of olive_album_related.create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 
     * {@linkplain #createTime}
     * @param createTime the value for olive_album_related.create_time
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}