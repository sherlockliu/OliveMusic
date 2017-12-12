
-- sys_InternalUser 用户信息表
DROP TABLE IF EXISTS `sys_internal_user`;
CREATE TABLE IF NOT EXISTS `sys_internal_user` (
	`user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
	`user_account` varchar(50) NOT NULL COMMENT '用户登录名',
	`user_name` varchar(50) NOT NULL COMMENT '用户名',
	`password` varchar(32) NOT NULL COMMENT '密码',
	`invalid` tinyint(4) NOT NULL DEFAULT 0   COMMENT '是否禁用',
	`last_login_time` datetime NOT NULL DEFAULT NOW() COMMENT '上次登录时间',
	`modify_time` datetime NOT NULL DEFAULT NOW() COMMENT '修改时间',
	`create_time` datetime NOT NULL DEFAULT NOW() COMMENT '创建时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- sys_MenuInfo 菜单信息表
DROP TABLE IF EXISTS `sys_menu_info`;
CREATE TABLE IF NOT EXISTS `sys_menu_info` (
	`menu_id` int(11) NOT NULL AUTO_INCREMENT,
	`menu_name` varchar(50) NOT NULL,
	`parent_id` int(11) NOT NULL DEFAULT 0,
	`menu_url` varchar(200) DEFAULT NULL,
	`menu_order` tinyint(4) NOT NULL,
	`menu_icon` varchar(200) DEFAULT NULL, -- 菜单图标
	`menu_type` tinyint(4) NOT NULL, -- 菜单类型 后台管理菜单（1）/前端网页（2）
	`is_system` tinyint(4) NOT NULL,
	`invalid` tinyint(4) NOT NULL DEFAULT 0 ,
	`modify_time` datetime NOT NULL COMMENT '修改时间',
	`create_time` datetime NOT NULL COMMENT '创建时间',
	`is_parent` tinyint(4) NOT NULL COMMENT '是否为父菜单',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE `sys_menu_info` AUTO_INCREMENT 100001;

-- sys_FunctionInfo 权限信息表
DROP TABLE IF EXISTS `sys_function_info`;
CREATE TABLE IF NOT EXISTS `sys_function_info` (
	`func_id` int(11) NOT NULL AUTO_INCREMENT,
	`func_code` varchar(40) DEFAULT NULL,
	`func_name` varchar(60) NOT NULL,
	`func_description` varchar(200) DEFAULT NULL,
	`func_order` tinyint(4) DEFAULT NULL,
	`create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`func_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- sys_MenuFunction 权限菜单关联表
DROP TABLE IF EXISTS `sys_menu_function`;
CREATE TABLE IF NOT EXISTS `sys_menu_function` (
	`menu_func_id` int(11) NOT NULL AUTO_INCREMENT,
	`menu_id` int(11) NOT NULL,
	`func_id` int(11) NOT NULL,
	`create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`menu_func_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# Data exporting was unselected.

-- sys_RoleInfo 用户角色表
DROP TABLE IF EXISTS `sys_role_info`;
CREATE TABLE IF NOT EXISTS `sys_role_info` (
	`role_id` int(11) NOT NULL AUTO_INCREMENT,
	`role_name` varchar(20) NOT NULL,
	`role_description` varchar(200) DEFAULT NULL,
	`role_type` tinyint(4) NOT NULL, -- 角色类型 后台管理角色类型（1）/前端用户角色类型（2）
	`creator` int(11)  NOT NULL COMMENT '创建人',
	`invalid` tinyint(4) NOT NULL DEFAULT 0 ,
	`modify_time` datetime NOT NULL COMMENT '修改时间',
	`create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`role_id`),
  KEY `iRolename` (`role_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE `sys_role_info` AUTO_INCREMENT 1101;

-- sys_internal_user_role 用户角色关联表
DROP TABLE IF EXISTS `sys_internal_user_role`;
CREATE TABLE IF NOT EXISTS `sys_internal_user_role` (
	`internal_user_role_id` int(11) NOT NULL AUTO_INCREMENT,
	`role_id` int(11) NOT NULL,
	`user_id` int(11) NOT NULL,
	`create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`internal_user_role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- sys_RoleMenuInfo 菜单角色关联表
DROP TABLE IF EXISTS `sys_role_menu_info`;
CREATE TABLE IF NOT EXISTS `sys_role_menu_info` (
	`role_menu_id` int(11) NOT NULL AUTO_INCREMENT,
	`role_id` int(11) NOT NULL,
	`menu_id` int(11) NOT NULL,
	`create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`role_menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- sys_RoleFuncInfo 菜单权限关联表
DROP TABLE IF EXISTS `sys_role_func_info`;
CREATE TABLE IF NOT EXISTS `sys_role_func_info` (
	`role_func_id` int(11) NOT NULL AUTO_INCREMENT,
	`role_id` int(11) NOT NULL,
	`func_id` int(11) NOT NULL,
	`create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`role_func_id`),
  KEY `iRoleid` (`role_id`),
  KEY `iFuncid` (`func_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AVG_ROW_LENGTH=50;

-- sys_category 字典类别表
DROP TABLE IF EXISTS `sys_category`;
CREATE TABLE IF NOT EXISTS `sys_category` (
	`category_id` int(11) NOT NULL AUTO_INCREMENT,
	`category_code` varchar(50) NOT NULL,
	`category_name` varchar(50) NOT NULL,
	`category_desc` varchar(255) DEFAULT NULL,
	`modify_time` datetime NOT NULL COMMENT '修改时间',
	`create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- sys_CategoryItem 字典项表
DROP TABLE IF EXISTS `sys_category_item`;
CREATE TABLE IF NOT EXISTS `sys_category_item` (
	`category_item_id` int(11) NOT NULL AUTO_INCREMENT,
	`category_item_code` varchar(50) NOT NULL,
	`category_item_name` varchar(50) NOT NULL,
	`category_id` int(11) NOT NULL,
	`parent_item_id` int(11) NOT NULL DEFAULT 0,
	`order_no` int(4) NOT NULL DEFAULT 0,
	`is_default` tinyint(4) NOT NULL DEFAULT 0,
	`invalid` tinyint(4) NOT NULL DEFAULT 0,
	`modify_time` datetime NOT NULL COMMENT '修改时间',
	`create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`category_item_id`),
  UNIQUE KEY `CategoryValue` (`category_item_code`,`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- olive_User 用户信息表
DROP TABLE IF EXISTS `olive_user`;
CREATE TABLE IF NOT EXISTS `olive_user` (
	`user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
	`user_name` varchar(50) NOT NULL COMMENT '用户名',
	`password` varchar(32) NOT NULL COMMENT '密码',
	`email` varchar(120) NOT NULL COMMENT '邮箱',
	`score` int NOT NULL DEFAULT 0 COMMENT '积分',
	`qq` varchar(32)  COMMENT 'QQ',
	`tel` varchar(32)  COMMENT '电话',
	`avatar` varchar(200) not null default '/Images/User/noAvatar.jpg'   COMMENT '头像',
	`gender` tinyint(4) default 0  COMMENT '性别', -- Unknow=0 Male=1 Female=2 
	`birthday` DATE   COMMENT '生日',
	`residence` int(11)   COMMENT '居住地',
	`self_intro` varchar(200)   COMMENT '自我简介',
	`invalid` tinyint(4) NOT NULL DEFAULT 0  COMMENT '是否禁用',
	`modify_time` datetime NOT NULL COMMENT '修改时间',
	`create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- olive_Artist 表演者
DROP TABLE IF EXISTS `olive_artist`;
CREATE TABLE IF NOT EXISTS `olive_artist` (
	`artist_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
	`guid` varchar(64) NOT NULL COMMENT 'GUid',
	`name` varchar(50) NOT NULL COMMENT '姓名',
	`alias` varchar(50) NOT NULL COMMENT '别名',
	`gender` tinyint(4) default 0  COMMENT '性别', -- Unknow=0 Male=1 Female=2 
	`country` int(11)   COMMENT '国家 ',
	`birthday` DATE   COMMENT '出生日期',
	`description` LONGTEXT  COMMENT '简介',
	`avatar` varchar(200)  COMMENT '图片',	
	`creator` int(11)  NOT NULL COMMENT '创建人',
	`invalid` tinyint(4) NOT NULL DEFAULT 0  COMMENT '是否禁用',
	`modify_time` datetime NOT NULL COMMENT '修改时间',
	`create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`artist_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- olive_Album 专辑
DROP TABLE IF EXISTS `olive_album`;
CREATE TABLE IF NOT EXISTS `olive_album` (
	`album_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
	`guid` varchar(64) NOT NULL COMMENT 'GUid',
	`name` varchar(50) NOT NULL COMMENT '专辑名称',
	`artist_id` int(11) NOT NULL COMMENT '表演者',
	`music_style` int(11) NOT NULL COMMENT '音乐类型',
	`area` int(11) NOT NULL COMMENT '所属区域',
	`publish_year` int(11) NOT NULL COMMENT '发行年',
	`slogan` varchar(200)  COMMENT '标语',
	`play_list` varchar(1000)  COMMENT '歌曲列表',
	`cover` varchar(200)  COMMENT '专辑封面',	
	`description` LONGTEXT  COMMENT '简介',	
	`creator` int(11)  NOT NULL COMMENT '创建人',
	`invalid` tinyint(4) NOT NULL DEFAULT 0   COMMENT '是否禁用',
	`modify_time` datetime NOT NULL COMMENT '修改时间',
	`create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`album_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- olive_album_ext 专辑扩展表
DROP TABLE IF EXISTS `olive_album_ext`;
CREATE TABLE IF NOT EXISTS `olive_album_ext` (
	`album_id` int(11) NOT NULL  COMMENT 'id',
	`star_count` int(11) NOT NULL DEFAULT 0 COMMENT '评分值',
	`view_count` int(11) NOT NULL DEFAULT 0 COMMENT '浏览次数',
	`download_count` int(11) NOT NULL DEFAULT 0  COMMENT '下载次数',
	`favorite_count` int(11) NOT NULL DEFAULT 0 COMMENT '收藏次数',
	`share_count` int(11) NOT NULL DEFAULT 0 COMMENT '分享次数',
	`comment_count` int(11) NOT NULL DEFAULT 0 COMMENT '评论次数',
	`modify_time` datetime NOT NULL COMMENT '修改时间',
	`create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`album_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- olive_comment 评论
DROP TABLE IF EXISTS `olive_comment`;
CREATE TABLE IF NOT EXISTS `olive_comment` (
	`comment_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
	`user_id` int(11) NOT NULL  COMMENT '评论人id',
	`album_id` int(11) NOT NULL  COMMENT '专辑id',
	`content` varchar(2000)  NOT NULL  COMMENT '评论内容',
	`invalid` tinyint(4) NOT NULL DEFAULT 0 COMMENT '是否禁用',
	`modify_time` datetime NOT NULL COMMENT '修改时间',
	`create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`comment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- olive_download_rec 下载记录
DROP TABLE IF EXISTS `olive_download_rec`;
CREATE TABLE IF NOT EXISTS `olive_download_rec` (
	`download_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
	`user_id` int(11) NOT NULL  COMMENT '下载人id',
	`album_id` int(11) NOT NULL  COMMENT '专辑id',
	`download_time` datetime NOT NULL COMMENT '下载时间',
  PRIMARY KEY (`download_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- olive_favorite_rec 收藏记录
DROP TABLE IF EXISTS `olive_favorite_rec`;
CREATE TABLE IF NOT EXISTS `olive_favorite_rec` (
	`favorite_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
	`user_id` int(11) NOT NULL  COMMENT '收藏人id',
	`album_id` int(11) NOT NULL  COMMENT '专辑id',
	`favorite_time` datetime NOT NULL COMMENT '收藏时间',
  PRIMARY KEY (`favorite_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- olive_share_rec 分享记录
DROP TABLE IF EXISTS `olive_share_rec`;
CREATE TABLE IF NOT EXISTS `olive_share_rec` (
	`share_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
	`user_id` int(11) NOT NULL  COMMENT '分享人id',
	`album_id` int(11) NOT NULL  COMMENT '专辑id',
	`share_time` datetime NOT NULL COMMENT '分享时间',
  PRIMARY KEY (`share_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- olive_view_rec 浏览记录
DROP TABLE IF EXISTS `olive_view_rec`;
CREATE TABLE IF NOT EXISTS `olive_view_rec` (
	`view_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
	`user_id` int(11) NOT NULL  COMMENT '浏览人id',
	`album_id` int(11) NOT NULL  COMMENT '专辑id',
	`view_time` datetime NOT NULL COMMENT '浏览时间',
  PRIMARY KEY (`view_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- olive_star_rec 评分记录
DROP TABLE IF EXISTS `olive_star_rec`;
CREATE TABLE IF NOT EXISTS `olive_star_rec` (
	`star_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
	`user_id` int(11) NOT NULL  COMMENT '评分人id',
	`album_id` int(11) NOT NULL  COMMENT '专辑id',
	`Score` int(11) NOT NULL  COMMENT '分值',
	`star_time` datetime NOT NULL COMMENT '评分时间',
  PRIMARY KEY (`star_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- olive_reward_rec 奖惩记录
DROP TABLE IF EXISTS `olive_reward_rec`;
CREATE TABLE IF NOT EXISTS `olive_reward_rec` (
	`reward_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
	`user_id` int(11) NOT NULL  COMMENT '被奖惩人id',
	`Score` int NOT NULL  COMMENT '分值',
	`content` varchar(100)  NOT NULL  COMMENT '奖惩原因',
	`reward_time` datetime NOT NULL COMMENT '奖惩时间',
	`creator` int(11)  NOT NULL COMMENT '创建人',
  PRIMARY KEY (`reward_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- olive_tag 标签
DROP TABLE IF EXISTS `olive_tag`;
CREATE TABLE IF NOT EXISTS `olive_tag` (
	`tag_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
	`name` varchar(50) NOT NULL COMMENT '标签名称',
	`tag_desc` varchar(255) DEFAULT NULL COMMENT '标签描述',
	`tag_type` tinyint(4) default 0  COMMENT '标签类别', -- 专辑=0 表演者=1
	`invalid` tinyint(4) NOT NULL DEFAULT 0   COMMENT '是否禁用',
	`modify_time` datetime NOT NULL COMMENT '修改时间',
	`create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`tag_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- olive_artist_tag 表演者标签关联表
DROP TABLE IF EXISTS `olive_artist_tag`;
CREATE TABLE IF NOT EXISTS `olive_artist_tag` (
	`artist_tag_id` int(11) NOT NULL AUTO_INCREMENT,
	`artist_id` int(11) NOT NULL,
	`tag_id` int(11) NOT NULL,
	`create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`artist_tag_id`),
  KEY `artist_id` (`artist_id`),
  KEY `tag_id` (`tag_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AVG_ROW_LENGTH=50;

-- olive_album_tag 专辑标签关联表
DROP TABLE IF EXISTS `olive_album_tag`;
CREATE TABLE IF NOT EXISTS `olive_album_tag` (
	`album_tag_id` int(11) NOT NULL AUTO_INCREMENT,
	`album_id` int(11) NOT NULL,
	`tag_id` int(11) NOT NULL,
	`create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`album_tag_id`),
  KEY `album_id` (`album_id`),
  KEY `tag_id` (`tag_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AVG_ROW_LENGTH=50;

-- olive_file 文件
DROP TABLE IF EXISTS `olive_file`;
CREATE TABLE IF NOT EXISTS `olive_file` (
	`file_id` varchar(64) NOT NULL COMMENT 'id',
	`file_name` varchar(100) NOT NULL COMMENT '文件名称',
	`file_path` varchar(255) NOT NULL COMMENT '文件路径',
	`file_type` tinyint(4) NOT NULL COMMENT '文件类型', --  0=图片，1=视频，2=文档
	`file_extension` varchar(32) NOT NULL COMMENT '文件扩展名',
	`file_size` int(11) NOT NULL COMMENT '文件大小',	
	`modify_time` datetime NOT NULL COMMENT '修改时间',
	`create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`file_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- olive_download_url 下载链接地址
DROP TABLE IF EXISTS `olive_download_url`;
CREATE TABLE IF NOT EXISTS `olive_download_url` (
	`download_url_id` int(11) NOT NULL AUTO_INCREMENT,
	`album_id` int(11) NOT NULL COMMENT '专辑id',
	`download_url` varchar(255) NOT NULL COMMENT '链接地址',
	`download_url_name` varchar(100) NOT NULL COMMENT '链接地址名称',
	`download_url_type` tinyint(4) NOT NULL COMMENT '链接地址类型', --  0=Baidu，1=115，2=360	
	`modify_time` datetime NOT NULL COMMENT '修改时间',
	`create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`download_url_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- olive_score 权重分值配置表
DROP TABLE IF EXISTS `olive_score`;
CREATE TABLE `olive_score` (
  `score_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `score_type` varchar(45) NOT NULL COMMENT '类型',
  `Score` int(11) NOT NULL COMMENT '分值',
  `modify_time` datetime NOT NULL COMMENT '修改时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`score_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权重分值配置表';

-- olive_album_related 相关专辑
DROP TABLE IF EXISTS `olive_album_related`;
CREATE TABLE `olive_album_related` (
  `related_id` int(11) NOT NULL AUTO_INCREMENT,
  `album_id` int(11) NOT NULL COMMENT '专辑id',
  `related_album_id` int(11) NOT NULL COMMENT '相关专辑id',
  `Score` int(11) NOT NULL COMMENT '分值',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`related_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- olive_album_score专辑关键字与权重对应表
DROP TABLE IF EXISTS `olive_album_score`;
CREATE TABLE `olive_album_score` (
  `album_score_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `album_id` int(11) NOT NULL COMMENT '专辑id',
  `score_id` int(11) NOT NULL COMMENT '评分项id',
  `content` varchar(150) NOT NULL COMMENT '关键字',
  `Score` int(11) NOT NULL COMMENT '分值',
  `create_time` datetime NOT NULL COMMENT '创建时间',
   PRIMARY KEY (`album_score_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='专辑关键字与权重对应表';



