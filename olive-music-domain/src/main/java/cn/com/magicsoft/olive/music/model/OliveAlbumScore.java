package cn.com.magicsoft.olive.music.model;

import java.io.Serializable;
import java.util.Date;

/**
 * ��д�������; 
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
public class OliveAlbumScore implements Serializable {
    /**
     * ����id
     */
    private Integer albumScoreId;

    /**
     * ר��id
     */
    private Integer albumId;

    /**
     * ������id
     */
    private Integer scoreId;

    /**
     * �ؼ���
     */
    private String content;

    /**
     * ��ֵ
     */
    private Integer score;

    /**
     * ����ʱ��
     */
    private Date createTime;

    /**
     * 
     * {@linkplain #albumScoreId}
     *
     * @return the value of olive_album_score.album_score_id
     */
    public Integer getAlbumScoreId() {
        return albumScoreId;
    }

    /**
     * 
     * {@linkplain #albumScoreId}
     * @param albumScoreId the value for olive_album_score.album_score_id
     */
    public void setAlbumScoreId(Integer albumScoreId) {
        this.albumScoreId = albumScoreId;
    }

    /**
     * 
     * {@linkplain #albumId}
     *
     * @return the value of olive_album_score.album_id
     */
    public Integer getAlbumId() {
        return albumId;
    }

    /**
     * 
     * {@linkplain #albumId}
     * @param albumId the value for olive_album_score.album_id
     */
    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    /**
     * 
     * {@linkplain #scoreId}
     *
     * @return the value of olive_album_score.score_id
     */
    public Integer getScoreId() {
        return scoreId;
    }

    /**
     * 
     * {@linkplain #scoreId}
     * @param scoreId the value for olive_album_score.score_id
     */
    public void setScoreId(Integer scoreId) {
        this.scoreId = scoreId;
    }

    /**
     * 
     * {@linkplain #content}
     *
     * @return the value of olive_album_score.content
     */
    public String getContent() {
        return content;
    }

    /**
     * 
     * {@linkplain #content}
     * @param content the value for olive_album_score.content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 
     * {@linkplain #score}
     *
     * @return the value of olive_album_score.Score
     */
    public Integer getScore() {
        return score;
    }

    /**
     * 
     * {@linkplain #score}
     * @param score the value for olive_album_score.Score
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     * 
     * {@linkplain #createTime}
     *
     * @return the value of olive_album_score.create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 
     * {@linkplain #createTime}
     * @param createTime the value for olive_album_score.create_time
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}