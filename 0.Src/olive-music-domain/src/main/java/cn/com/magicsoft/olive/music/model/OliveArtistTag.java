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
public class OliveArtistTag implements Serializable {
    /**
     * 
     */
    private Integer artistTagId;

    /**
     * 
     */
    private Integer artistId;

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
     * {@linkplain #artistTagId}
     *
     * @return the value of olive_artist_tag.artist_tag_id
     */
    public Integer getArtistTagId() {
        return artistTagId;
    }

    /**
     * 
     * {@linkplain #artistTagId}
     * @param artistTagId the value for olive_artist_tag.artist_tag_id
     */
    public void setArtistTagId(Integer artistTagId) {
        this.artistTagId = artistTagId;
    }

    /**
     * 
     * {@linkplain #artistId}
     *
     * @return the value of olive_artist_tag.artist_id
     */
    public Integer getArtistId() {
        return artistId;
    }

    /**
     * 
     * {@linkplain #artistId}
     * @param artistId the value for olive_artist_tag.artist_id
     */
    public void setArtistId(Integer artistId) {
        this.artistId = artistId;
    }

    /**
     * 
     * {@linkplain #tagId}
     *
     * @return the value of olive_artist_tag.tag_id
     */
    public Integer getTagId() {
        return tagId;
    }

    /**
     * 
     * {@linkplain #tagId}
     * @param tagId the value for olive_artist_tag.tag_id
     */
    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    /**
     * 
     * {@linkplain #createTime}
     *
     * @return the value of olive_artist_tag.create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 
     * {@linkplain #createTime}
     * @param createTime the value for olive_artist_tag.create_time
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}