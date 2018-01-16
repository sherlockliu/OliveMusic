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
public class OliveScore implements Serializable {
    /**
     * ����id
     */
    private Integer scoreId;

    /**
     * ����
     */
    private String scoreType;

    /**
     * ��ֵ
     */
    private Integer score;

    /**
     * �޸�ʱ��
     */
    private Date modifyTime;

    /**
     * ����ʱ��
     */
    private Date createTime;

    /**
     * 
     * {@linkplain #scoreId}
     *
     * @return the value of olive_score.score_id
     */
    public Integer getScoreId() {
        return scoreId;
    }

    /**
     * 
     * {@linkplain #scoreId}
     * @param scoreId the value for olive_score.score_id
     */
    public void setScoreId(Integer scoreId) {
        this.scoreId = scoreId;
    }

    /**
     * 
     * {@linkplain #scoreType}
     *
     * @return the value of olive_score.score_type
     */
    public String getScoreType() {
        return scoreType;
    }

    /**
     * 
     * {@linkplain #scoreType}
     * @param scoreType the value for olive_score.score_type
     */
    public void setScoreType(String scoreType) {
        this.scoreType = scoreType;
    }

    /**
     * 
     * {@linkplain #score}
     *
     * @return the value of olive_score.Score
     */
    public Integer getScore() {
        return score;
    }

    /**
     * 
     * {@linkplain #score}
     * @param score the value for olive_score.Score
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     * 
     * {@linkplain #modifyTime}
     *
     * @return the value of olive_score.modify_time
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 
     * {@linkplain #modifyTime}
     * @param modifyTime the value for olive_score.modify_time
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 
     * {@linkplain #createTime}
     *
     * @return the value of olive_score.create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 
     * {@linkplain #createTime}
     * @param createTime the value for olive_score.create_time
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}