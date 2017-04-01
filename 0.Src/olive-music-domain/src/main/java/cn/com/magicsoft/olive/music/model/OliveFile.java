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
public class OliveFile implements Serializable {
    /**
     * id
     */
    private String fileId;

    /**
     * 文件名称
     */
    private String fileName;

    /**
     * 文件路径
     */
    private String filePath;

    /**
     * 文件类型
     */
    private Byte fileType;

    /**
     * 文件扩展名
     */
    private String fileExtension;

    /**
     * 文件大小
     */
    private Integer fileSize;

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
     * {@linkplain #fileId}
     *
     * @return the value of olive_file.file_id
     */
    public String getFileId() {
        return fileId;
    }

    /**
     * 
     * {@linkplain #fileId}
     * @param fileId the value for olive_file.file_id
     */
    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    /**
     * 
     * {@linkplain #fileName}
     *
     * @return the value of olive_file.file_name
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * 
     * {@linkplain #fileName}
     * @param fileName the value for olive_file.file_name
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * 
     * {@linkplain #filePath}
     *
     * @return the value of olive_file.file_path
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * 
     * {@linkplain #filePath}
     * @param filePath the value for olive_file.file_path
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     * 
     * {@linkplain #fileType}
     *
     * @return the value of olive_file.file_type
     */
    public Byte getFileType() {
        return fileType;
    }

    /**
     * 
     * {@linkplain #fileType}
     * @param fileType the value for olive_file.file_type
     */
    public void setFileType(Byte fileType) {
        this.fileType = fileType;
    }

    /**
     * 
     * {@linkplain #fileExtension}
     *
     * @return the value of olive_file.file_extension
     */
    public String getFileExtension() {
        return fileExtension;
    }

    /**
     * 
     * {@linkplain #fileExtension}
     * @param fileExtension the value for olive_file.file_extension
     */
    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    /**
     * 
     * {@linkplain #fileSize}
     *
     * @return the value of olive_file.file_size
     */
    public Integer getFileSize() {
        return fileSize;
    }

    /**
     * 
     * {@linkplain #fileSize}
     * @param fileSize the value for olive_file.file_size
     */
    public void setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
    }

    /**
     * 
     * {@linkplain #modifyTime}
     *
     * @return the value of olive_file.modify_time
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 
     * {@linkplain #modifyTime}
     * @param modifyTime the value for olive_file.modify_time
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 
     * {@linkplain #createTime}
     *
     * @return the value of olive_file.create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 
     * {@linkplain #createTime}
     * @param createTime the value for olive_file.create_time
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}