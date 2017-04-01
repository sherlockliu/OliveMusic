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
public class OliveDownloadUrl implements Serializable {
    /**
     * 
     */
    private Integer downloadUrlId;

    /**
     * ר��id
     */
    private Integer albumId;

    /**
     * ���ӵ�ַ
     */
    private String downloadUrl;

    /**
     * ���ӵ�ַ����
     */
    private String downloadUrlName;

    /**
     * ���ӵ�ַ����
     */
    private Byte downloadUrlType;

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
     * {@linkplain #downloadUrlId}
     *
     * @return the value of olive_download_url.download_url_id
     */
    public Integer getDownloadUrlId() {
        return downloadUrlId;
    }

    /**
     * 
     * {@linkplain #downloadUrlId}
     * @param downloadUrlId the value for olive_download_url.download_url_id
     */
    public void setDownloadUrlId(Integer downloadUrlId) {
        this.downloadUrlId = downloadUrlId;
    }

    /**
     * 
     * {@linkplain #albumId}
     *
     * @return the value of olive_download_url.album_id
     */
    public Integer getAlbumId() {
        return albumId;
    }

    /**
     * 
     * {@linkplain #albumId}
     * @param albumId the value for olive_download_url.album_id
     */
    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    /**
     * 
     * {@linkplain #downloadUrl}
     *
     * @return the value of olive_download_url.download_url
     */
    public String getDownloadUrl() {
        return downloadUrl;
    }

    /**
     * 
     * {@linkplain #downloadUrl}
     * @param downloadUrl the value for olive_download_url.download_url
     */
    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    /**
     * 
     * {@linkplain #downloadUrlName}
     *
     * @return the value of olive_download_url.download_url_name
     */
    public String getDownloadUrlName() {
        return downloadUrlName;
    }

    /**
     * 
     * {@linkplain #downloadUrlName}
     * @param downloadUrlName the value for olive_download_url.download_url_name
     */
    public void setDownloadUrlName(String downloadUrlName) {
        this.downloadUrlName = downloadUrlName;
    }

    /**
     * 
     * {@linkplain #downloadUrlType}
     *
     * @return the value of olive_download_url.download_url_type
     */
    public Byte getDownloadUrlType() {
        return downloadUrlType;
    }

    /**
     * 
     * {@linkplain #downloadUrlType}
     * @param downloadUrlType the value for olive_download_url.download_url_type
     */
    public void setDownloadUrlType(Byte downloadUrlType) {
        this.downloadUrlType = downloadUrlType;
    }

    /**
     * 
     * {@linkplain #modifyTime}
     *
     * @return the value of olive_download_url.modify_time
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 
     * {@linkplain #modifyTime}
     * @param modifyTime the value for olive_download_url.modify_time
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 
     * {@linkplain #createTime}
     *
     * @return the value of olive_download_url.create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 
     * {@linkplain #createTime}
     * @param createTime the value for olive_download_url.create_time
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}