package cn.com.magicsoft.olive.music.manager;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.magicsoft.framework.manager.BaseCrudManagerImpl;
import cn.com.magicsoft.framework.service.BaseCrudService;
import cn.com.magicsoft.olive.music.manager.api.OliveAlbumExtManager;
import cn.com.magicsoft.olive.music.service.OliveAlbumExtService;

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
@Service("oliveAlbumExtManager")
class OliveAlbumExtManagerImpl extends BaseCrudManagerImpl implements OliveAlbumExtManager {
    @Resource
    private OliveAlbumExtService oliveAlbumExtService;

    @Override
    public BaseCrudService init() {
        return oliveAlbumExtService;
    }
}