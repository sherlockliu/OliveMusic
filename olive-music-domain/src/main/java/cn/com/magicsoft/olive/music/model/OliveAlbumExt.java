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
public class OliveAlbumExt implements Serializable {
    /**
     * id
     */
    private Integer albumId;

    /**
     * 评分值
     */
    private Integer starCount;

    /**
     * 浏览次数
     */
    private Integer viewCount;

    /**
     * 下载次数
     */
    private Integer downloadCount;

    /**
     * 收藏次数
     */
    private Integer favoriteCount;

    /**
     * 分享次数
     */
    private Integer shareCount;

    /**
     * 评论次数
     */
    private Integer commentCount;

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
     * {@linkplain #albumId}
     *
     * @return the value of olive_album_ext.album_id
     */
    public Integer getAlbumId() {
        return albumId;
    }

    /**
     * 
     * {@linkplain #albumId}
     * @param albumId the value for olive_album_ext.album_id
     */
    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    /**
     * 
     * {@linkplain #starCount}
     *
     * @return the value of olive_album_ext.star_count
     */
    public Integer getStarCount() {
        return starCount;
    }

    /**
     * 
     * {@linkplain #starCount}
     * @param starCount the value for olive_album_ext.star_count
     */
    public void setStarCount(Integer starCount) {
        this.starCount = starCount;
    }

    /**
     * 
     * {@linkplain #viewCount}
     *
     * @return the value of olive_album_ext.view_count
     */
    public Integer getViewCount() {
        return viewCount;
    }

    /**
     * 
     * {@linkplain #viewCount}
     * @param viewCount the value for olive_album_ext.view_count
     */
    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    /**
     * 
     * {@linkplain #downloadCount}
     *
     * @return the value of olive_album_ext.download_count
     */
    public Integer getDownloadCount() {
        return downloadCount;
    }

    /**
     * 
     * {@linkplain #downloadCount}
     * @param downloadCount the value for olive_album_ext.download_count
     */
    public void setDownloadCount(Integer downloadCount) {
        this.downloadCount = downloadCount;
    }

    /**
     * 
     * {@linkplain #favoriteCount}
     *
     * @return the value of olive_album_ext.favorite_count
     */
    public Integer getFavoriteCount() {
        return favoriteCount;
    }

    /**
     * 
     * {@linkplain #favoriteCount}
     * @param favoriteCount the value for olive_album_ext.favorite_count
     */
    public void setFavoriteCount(Integer favoriteCount) {
        this.favoriteCount = favoriteCount;
    }

    /**
     * 
     * {@linkplain #shareCount}
     *
     * @return the value of olive_album_ext.share_count
     */
    public Integer getShareCount() {
        return shareCount;
    }

    /**
     * 
     * {@linkplain #shareCount}
     * @param shareCount the value for olive_album_ext.share_count
     */
    public void setShareCount(Integer shareCount) {
        this.shareCount = shareCount;
    }

    /**
     * 
     * {@linkplain #commentCount}
     *
     * @return the value of olive_album_ext.comment_count
     */
    public Integer getCommentCount() {
        return commentCount;
    }

    /**
     * 
     * {@linkplain #commentCount}
     * @param commentCount the value for olive_album_ext.comment_count
     */
    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    /**
     * 
     * {@linkplain #modifyTime}
     *
     * @return the value of olive_album_ext.modify_time
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 
     * {@linkplain #modifyTime}
     * @param modifyTime the value for olive_album_ext.modify_time
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 
     * {@linkplain #createTime}
     *
     * @return the value of olive_album_ext.create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 
     * {@linkplain #createTime}
     * @param createTime the value for olive_album_ext.create_time
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}