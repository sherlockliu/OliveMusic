package cn.com.magicsoft.olive.music.service;

import cn.com.magicsoft.framework.dal.BaseCrudMapper;
import cn.com.magicsoft.framework.service.BaseCrudServiceImpl;
import cn.com.magicsoft.olive.music.dal.database.OliveAlbumTagMapper;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

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
@Service("oliveAlbumTagService")
class OliveAlbumTagServiceImpl extends BaseCrudServiceImpl implements OliveAlbumTagService {
    @Resource
    private OliveAlbumTagMapper oliveAlbumTagMapper;

    @Override
    public BaseCrudMapper init() {
        return oliveAlbumTagMapper;
    }
}