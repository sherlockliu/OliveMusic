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
public class OliveComment implements Serializable {
    /**
     * id
     */
    private Integer commentId;

    /**
     * 评论人id
     */
    private Integer userId;

    /**
     * 专辑id
     */
    private Integer albumId;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 是否禁用
     */
    private Byte invalid;

    /**
     * 修改时间
     */
    private Date modifyTime;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 
     * {@linkplain #commentId}
     *
     * @return the value of olive_comment.comment_id
     */
    public Integer getCommentId() {
        return commentId;
    }

    /**
     * 
     * {@linkplain #commentId}
     * @param commentId the value for olive_comment.comment_id
     */
    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    /**
     * 
     * {@linkplain #userId}
     *
     * @return the value of olive_comment.user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 
     * {@linkplain #userId}
     * @param userId the value for olive_comment.user_id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 
     * {@linkplain #albumId}
     *
     * @return the value of olive_comment.album_id
     */
    public Integer getAlbumId() {
        return albumId;
    }

    /**
     * 
     * {@linkplain #albumId}
     * @param albumId the value for olive_comment.album_id
     */
    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    /**
     * 
     * {@linkplain #content}
     *
     * @return the value of olive_comment.content
     */
    public String getContent() {
        return content;
    }

    /**
     * 
     * {@linkplain #content}
     * @param content the value for olive_comment.content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 
     * {@linkplain #invalid}
     *
     * @return the value of olive_comment.invalid
     */
    public Byte getInvalid() {
        return invalid;
    }

    /**
     * 
     * {@linkplain #invalid}
     * @param invalid the value for olive_comment.invalid
     */
    public void setInvalid(Byte invalid) {
        this.invalid = invalid;
    }

    /**
     * 
     * {@linkplain #modifyTime}
     *
     * @return the value of olive_comment.modify_time
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 
     * {@linkplain #modifyTime}
     * @param modifyTime the value for olive_comment.modify_time
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 
     * {@linkplain #createTime}
     *
     * @return the value of olive_comment.create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 
     * {@linkplain #createTime}
     * @param createTime the value for olive_comment.create_time
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}