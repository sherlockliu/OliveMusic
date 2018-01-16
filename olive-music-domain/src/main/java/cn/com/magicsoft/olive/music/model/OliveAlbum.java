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
public class OliveAlbum implements Serializable {
    /**
     * id
     */
    private Integer albumId;

    /**
     * GUid
     */
    private String guid;

    /**
     * 专辑名称
     */
    private String name;

    /**
     * 表演者
     */
    private Integer artistId;

    /**
     * 音乐类型
     */
    private Integer musicStyle;

    /**
     * 所属区域
     */
    private Integer area;

    /**
     * 发行年
     */
    private Integer publishYear;

    /**
     * 标语
     */
    private String slogan;

    /**
     * 歌曲列表
     */
    private String playList;

    /**
     * 专辑封面
     */
    private String cover;

    /**
     * 创建人
     */
    private Integer creator;

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
     * 简介
     */
    private String description;

    /**
     * 
     * {@linkplain #albumId}
     *
     * @return the value of olive_album.album_id
     */
    public Integer getAlbumId() {
        return albumId;
    }

    /**
     * 
     * {@linkplain #albumId}
     * @param albumId the value for olive_album.album_id
     */
    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    /**
     * 
     * {@linkplain #guid}
     *
     * @return the value of olive_album.guid
     */
    public String getGuid() {
        return guid;
    }

    /**
     * 
     * {@linkplain #guid}
     * @param guid the value for olive_album.guid
     */
    public void setGuid(String guid) {
        this.guid = guid;
    }

    /**
     * 
     * {@linkplain #name}
     *
     * @return the value of olive_album.name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * {@linkplain #name}
     * @param name the value for olive_album.name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * {@linkplain #artistId}
     *
     * @return the value of olive_album.artist_id
     */
    public Integer getArtistId() {
        return artistId;
    }

    /**
     * 
     * {@linkplain #artistId}
     * @param artistId the value for olive_album.artist_id
     */
    public void setArtistId(Integer artistId) {
        this.artistId = artistId;
    }

    /**
     * 
     * {@linkplain #musicStyle}
     *
     * @return the value of olive_album.music_style
     */
    public Integer getMusicStyle() {
        return musicStyle;
    }

    /**
     * 
     * {@linkplain #musicStyle}
     * @param musicStyle the value for olive_album.music_style
     */
    public void setMusicStyle(Integer musicStyle) {
        this.musicStyle = musicStyle;
    }

    /**
     * 
     * {@linkplain #area}
     *
     * @return the value of olive_album.area
     */
    public Integer getArea() {
        return area;
    }

    /**
     * 
     * {@linkplain #area}
     * @param area the value for olive_album.area
     */
    public void setArea(Integer area) {
        this.area = area;
    }

    /**
     * 
     * {@linkplain #publishYear}
     *
     * @return the value of olive_album.publish_year
     */
    public Integer getPublishYear() {
        return publishYear;
    }

    /**
     * 
     * {@linkplain #publishYear}
     * @param publishYear the value for olive_album.publish_year
     */
    public void setPublishYear(Integer publishYear) {
        this.publishYear = publishYear;
    }

    /**
     * 
     * {@linkplain #slogan}
     *
     * @return the value of olive_album.slogan
     */
    public String getSlogan() {
        return slogan;
    }

    /**
     * 
     * {@linkplain #slogan}
     * @param slogan the value for olive_album.slogan
     */
    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    /**
     * 
     * {@linkplain #playList}
     *
     * @return the value of olive_album.play_list
     */
    public String getPlayList() {
        return playList;
    }

    /**
     * 
     * {@linkplain #playList}
     * @param playList the value for olive_album.play_list
     */
    public void setPlayList(String playList) {
        this.playList = playList;
    }

    /**
     * 
     * {@linkplain #cover}
     *
     * @return the value of olive_album.cover
     */
    public String getCover() {
        return cover;
    }

    /**
     * 
     * {@linkplain #cover}
     * @param cover the value for olive_album.cover
     */
    public void setCover(String cover) {
        this.cover = cover;
    }

    /**
     * 
     * {@linkplain #creator}
     *
     * @return the value of olive_album.creator
     */
    public Integer getCreator() {
        return creator;
    }

    /**
     * 
     * {@linkplain #creator}
     * @param creator the value for olive_album.creator
     */
    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    /**
     * 
     * {@linkplain #invalid}
     *
     * @return the value of olive_album.invalid
     */
    public Byte getInvalid() {
        return invalid;
    }

    /**
     * 
     * {@linkplain #invalid}
     * @param invalid the value for olive_album.invalid
     */
    public void setInvalid(Byte invalid) {
        this.invalid = invalid;
    }

    /**
     * 
     * {@linkplain #modifyTime}
     *
     * @return the value of olive_album.modify_time
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 
     * {@linkplain #modifyTime}
     * @param modifyTime the value for olive_album.modify_time
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 
     * {@linkplain #createTime}
     *
     * @return the value of olive_album.create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 
     * {@linkplain #createTime}
     * @param createTime the value for olive_album.create_time
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 
     * {@linkplain #description}
     *
     * @return the value of olive_album.description
     */
    public String getDescription() {
        return description;
    }

    /**
     * 
     * {@linkplain #description}
     * @param description the value for olive_album.description
     */
    public void setDescription(String description) {
        this.description = description;
    }
}