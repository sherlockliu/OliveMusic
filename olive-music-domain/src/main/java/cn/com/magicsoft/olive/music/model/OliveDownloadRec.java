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
public class OliveDownloadRec implements Serializable {
    /**
     * id
     */
    private Integer downloadId;

    /**
     * ������id
     */
    private Integer userId;

    /**
     * ר��id
     */
    private Integer albumId;

    /**
     * ����ʱ��
     */
    private Date downloadTime;

    /**
     * 
     * {@linkplain #downloadId}
     *
     * @return the value of olive_download_rec.download_id
     */
    public Integer getDownloadId() {
        return downloadId;
    }

    /**
     * 
     * {@linkplain #downloadId}
     * @param downloadId the value for olive_download_rec.download_id
     */
    public void setDownloadId(Integer downloadId) {
        this.downloadId = downloadId;
    }

    /**
     * 
     * {@linkplain #userId}
     *
     * @return the value of olive_download_rec.user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 
     * {@linkplain #userId}
     * @param userId the value for olive_download_rec.user_id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 
     * {@linkplain #albumId}
     *
     * @return the value of olive_download_rec.album_id
     */
    public Integer getAlbumId() {
        return albumId;
    }

    /**
     * 
     * {@linkplain #albumId}
     * @param albumId the value for olive_download_rec.album_id
     */
    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    /**
     * 
     * {@linkplain #downloadTime}
     *
     * @return the value of olive_download_rec.download_time
     */
    public Date getDownloadTime() {
        return downloadTime;
    }

    /**
     * 
     * {@linkplain #downloadTime}
     * @param downloadTime the value for olive_download_rec.download_time
     */
    public void setDownloadTime(Date downloadTime) {
        this.downloadTime = downloadTime;
    }
}