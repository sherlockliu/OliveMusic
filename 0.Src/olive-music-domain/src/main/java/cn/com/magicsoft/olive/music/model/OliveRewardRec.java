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
public class OliveRewardRec implements Serializable {
    /**
     * id
     */
    private Integer rewardId;

    /**
     * 被奖惩人id
     */
    private Integer userId;

    /**
     * 分值
     */
    private Integer score;

    /**
     * 奖惩原因
     */
    private String content;

    /**
     * 奖惩时间
     */
    private Date rewardTime;

    /**
     * 创建人
     */
    private Integer creator;

    /**
     * 
     * {@linkplain #rewardId}
     *
     * @return the value of olive_reward_rec.reward_id
     */
    public Integer getRewardId() {
        return rewardId;
    }

    /**
     * 
     * {@linkplain #rewardId}
     * @param rewardId the value for olive_reward_rec.reward_id
     */
    public void setRewardId(Integer rewardId) {
        this.rewardId = rewardId;
    }

    /**
     * 
     * {@linkplain #userId}
     *
     * @return the value of olive_reward_rec.user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 
     * {@linkplain #userId}
     * @param userId the value for olive_reward_rec.user_id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 
     * {@linkplain #score}
     *
     * @return the value of olive_reward_rec.Score
     */
    public Integer getScore() {
        return score;
    }

    /**
     * 
     * {@linkplain #score}
     * @param score the value for olive_reward_rec.Score
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     * 
     * {@linkplain #content}
     *
     * @return the value of olive_reward_rec.content
     */
    public String getContent() {
        return content;
    }

    /**
     * 
     * {@linkplain #content}
     * @param content the value for olive_reward_rec.content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 
     * {@linkplain #rewardTime}
     *
     * @return the value of olive_reward_rec.reward_time
     */
    public Date getRewardTime() {
        return rewardTime;
    }

    /**
     * 
     * {@linkplain #rewardTime}
     * @param rewardTime the value for olive_reward_rec.reward_time
     */
    public void setRewardTime(Date rewardTime) {
        this.rewardTime = rewardTime;
    }

    /**
     * 
     * {@linkplain #creator}
     *
     * @return the value of olive_reward_rec.creator
     */
    public Integer getCreator() {
        return creator;
    }

    /**
     * 
     * {@linkplain #creator}
     * @param creator the value for olive_reward_rec.creator
     */
    public void setCreator(Integer creator) {
        this.creator = creator;
    }
}