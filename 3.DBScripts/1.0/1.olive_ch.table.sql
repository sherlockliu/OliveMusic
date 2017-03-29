USE `olive_ch`;

-- sys_InternalUser 用户信息表
DROP TABLE IF EXISTS `sys_internal_user`;
CREATE TABLE IF NOT EXISTS `sys_internal_user` (
	`user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
	`user_account` varchar(50) NOT NULL COMMENT '用户登录名',
	`user_name` varchar(50) NOT NULL COMMENT '用户名',
	`password` varchar(32) NOT NULL COMMENT '密码',
	`invalid` tinyint(4) NOT NULL DEFAULT 0   COMMENT '是否禁用',
	`last_login_time` datetime NOT NULL COMMENT '上次登录时间',
	`modify_time` datetime NOT NULL COMMENT '修改时间',
	`create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- sys_MenuInfo 菜单信息表
DROP TABLE IF EXISTS `sys_MenuInfo`;
CREATE TABLE IF NOT EXISTS `sys_MenuInfo` (
	`MenuID` int(11) NOT NULL AUTO_INCREMENT,
	`MenuName` varchar(50) NOT NULL,
	`ParentID` int(11) NOT NULL DEFAULT 0,
	`MenuURL` varchar(200) DEFAULT NULL,
	`MenuOrder` tinyint(4) NOT NULL,
	`MenuIcon` varchar(200) DEFAULT NULL, -- 菜单图标
	`MenuType` tinyint(4) NOT NULL, -- 菜单类型 后台管理菜单（1）/前端网页（2）
	`IsSystem` tinyint(4) NOT NULL,
	`Invalid` tinyint(4) NOT NULL DEFAULT 0 ,
	`ModifyTime` datetime NOT NULL COMMENT '修改时间',
	`CreateTime` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`MenuID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE `sys_MenuInfo` AUTO_INCREMENT 100001;

-- sys_FunctionInfo 权限信息表
DROP TABLE IF EXISTS `sys_FunctionInfo`;
CREATE TABLE IF NOT EXISTS `sys_FunctionInfo` (
	`FuncID` int(11) NOT NULL AUTO_INCREMENT,
	`FuncCode` varchar(40) DEFAULT NULL,
	`FuncName` varchar(60) NOT NULL,
	`FuncDescription` varchar(200) DEFAULT NULL,
	`FuncOrder` tinyint(4) DEFAULT NULL,
	`CreateTime` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`FuncID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- sys_MenuFunction 权限菜单关联表
DROP TABLE IF EXISTS `sys_MenuFunction`;
CREATE TABLE IF NOT EXISTS `sys_MenuFunction` (
	`MenuFuncID` int(11) NOT NULL AUTO_INCREMENT,
	`MenuID` int(11) NOT NULL,
	`FuncID` int(11) NOT NULL,
	`CreateTime` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`MenuFuncID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# Data exporting was unselected.

-- sys_RoleInfo 用户角色表
DROP TABLE IF EXISTS `sys_RoleInfo`;
CREATE TABLE IF NOT EXISTS `sys_RoleInfo` (
	`RoleID` int(11) NOT NULL AUTO_INCREMENT,
	`RoleName` varchar(20) NOT NULL,
	`RoleDescription` varchar(200) DEFAULT NULL,
	`RoleType` tinyint(4) NOT NULL, -- 角色类型 后台管理角色类型（1）/前端用户角色类型（2）
	`Creator` int(11)  NOT NULL COMMENT '创建人',
	`Invalid` tinyint(4) NOT NULL DEFAULT 0 ,
	`ModifyTime` datetime NOT NULL COMMENT '修改时间',
	`CreateTime` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`RoleID`),
  KEY `iRoleName` (`RoleName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE `sys_RoleInfo` AUTO_INCREMENT 1101;

-- sys_InternalUserRole 用户角色关联表
DROP TABLE IF EXISTS `sys_InternalUserRole`;
CREATE TABLE IF NOT EXISTS `sys_InternalUserRole` (
	`InternalUserRoleID` int(11) NOT NULL AUTO_INCREMENT,
	`RoleID` int(11) NOT NULL,
	`UserID` int(11) NOT NULL,
	`CreateTime` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`InternalUserRoleID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- sys_RoleMenuInfo 菜单角色关联表
DROP TABLE IF EXISTS `sys_RoleMenuInfo`;
CREATE TABLE IF NOT EXISTS `sys_RoleMenuInfo` (
	`RoleMenuID` int(11) NOT NULL AUTO_INCREMENT,
	`RoleID` int(11) NOT NULL,
	`MenuID` int(11) NOT NULL,
	`CreateTime` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`RoleMenuID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- sys_RoleFuncInfo 菜单权限关联表
DROP TABLE IF EXISTS `sys_RoleFuncInfo`;
CREATE TABLE IF NOT EXISTS `sys_RoleFuncInfo` (
	`RoleFuncID` int(11) NOT NULL AUTO_INCREMENT,
	`RoleID` int(11) NOT NULL,
	`FuncID` int(11) NOT NULL,
	`CreateTime` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`RoleFuncID`),
  KEY `iRoleID` (`RoleID`),
  KEY `iFuncID` (`FuncID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AVG_ROW_LENGTH=50;

-- sys_Category 字典类别表
DROP TABLE IF EXISTS `sys_Category`;
CREATE TABLE IF NOT EXISTS `sys_Category` (
	`CategoryID` int(11) NOT NULL AUTO_INCREMENT,
	`CategoryCode` varchar(50) NOT NULL,
	`CategoryName` varchar(50) NOT NULL,
	`CategoryDesc` varchar(255) DEFAULT NULL,
	`ModifyTime` datetime NOT NULL COMMENT '修改时间',
	`CreateTime` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`CategoryID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- sys_CategoryItem 字典项表
DROP TABLE IF EXISTS `sys_CategoryItem`;
CREATE TABLE IF NOT EXISTS `sys_CategoryItem` (
	`CategoryItemID` int(11) NOT NULL AUTO_INCREMENT,
	`CategoryItemCode` varchar(50) NOT NULL,
	`CategoryItemName` varchar(50) NOT NULL,
	`CategoryID` int(11) NOT NULL,
	`ParentItemID` int(11) NOT NULL DEFAULT 0,
	`OrderNo` int(4) NOT NULL DEFAULT 0,
	`IsDefault` tinyint(4) NOT NULL DEFAULT 0,
	`Invalid` tinyint(4) NOT NULL DEFAULT 0,
	`ModifyTime` datetime NOT NULL COMMENT '修改时间',
	`CreateTime` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`CategoryItemID`),
  UNIQUE KEY `CategoryValue` (`CategoryItemCode`,`CategoryID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- mordor_User 用户信息表
DROP TABLE IF EXISTS `mordor_User`;
CREATE TABLE IF NOT EXISTS `mordor_User` (
	`UserID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
	`UserName` varchar(50) NOT NULL COMMENT '用户名',
	`Password` varchar(32) NOT NULL COMMENT '密码',
	`Email` varchar(120) NOT NULL COMMENT '邮箱',
	`Score` int NOT NULL DEFAULT 0 COMMENT '积分',
	`QQ` varchar(32)  COMMENT 'QQ',
	`Tel` varchar(32)  COMMENT '电话',
	`Avatar` varchar(200) not null default '/Images/User/noAvatar.jpg'   COMMENT '头像',
	`Gender` tinyint(4) default 0  COMMENT '性别', -- Unknow=0 Male=1 Female=2 
	`Birthday` DATE   COMMENT '生日',
	`Residence` int(11)   COMMENT '居住地',
	`SelfIntro` varchar(200)   COMMENT '自我简介',
	`Invalid` tinyint(4) NOT NULL DEFAULT 0  COMMENT '是否禁用',
	`ModifyTime` datetime NOT NULL COMMENT '修改时间',
	`CreateTime` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`UserID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- mordor_Artist 表演者
DROP TABLE IF EXISTS `mordor_Artist`;
CREATE TABLE IF NOT EXISTS `mordor_Artist` (
	`ArtistID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
	`GUID` varchar(64) NOT NULL COMMENT 'GUID',
	`Name` varchar(50) NOT NULL COMMENT '姓名',
	`Alias` varchar(50) NOT NULL COMMENT '别名',
	`Gender` tinyint(4) default 0  COMMENT '性别', -- Unknow=0 Male=1 Female=2 
	`Country` int(11)   COMMENT '国家 ',
	`Birthday` DATE   COMMENT '出生日期',
	`Description` LONGTEXT  COMMENT '简介',
	`Avatar` varchar(200)  COMMENT '图片',	
	`Creator` int(11)  NOT NULL COMMENT '创建人',
	`Invalid` tinyint(4) NOT NULL DEFAULT 0  COMMENT '是否禁用',
	`ModifyTime` datetime NOT NULL COMMENT '修改时间',
	`CreateTime` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`ArtistID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- mordor_Album 专辑
DROP TABLE IF EXISTS `mordor_Album`;
CREATE TABLE IF NOT EXISTS `mordor_Album` (
	`AlbumID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
	`GUID` varchar(64) NOT NULL COMMENT 'GUID',
	`Name` varchar(50) NOT NULL COMMENT '专辑名称',
	`ArtistID` int(11) NOT NULL COMMENT '表演者',
	`MusicStyle` int(11) NOT NULL COMMENT '音乐类型',
	`Area` int(11) NOT NULL COMMENT '所属区域',
	`PublishYear` int(11) NOT NULL COMMENT '发行年',
	`Slogan` varchar(200)  COMMENT '标语',
	`Playlist` varchar(1000)  COMMENT '歌曲列表',
	`Cover` varchar(200)  COMMENT '专辑封面',	
	`Description` LONGTEXT  COMMENT '简介',	
	`Creator` int(11)  NOT NULL COMMENT '创建人',
	`Invalid` tinyint(4) NOT NULL DEFAULT 0   COMMENT '是否禁用',
	`ModifyTime` datetime NOT NULL COMMENT '修改时间',
	`CreateTime` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`AlbumID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- mordor_AlbumExt 专辑扩展表
DROP TABLE IF EXISTS `mordor_AlbumExt`;
CREATE TABLE IF NOT EXISTS `mordor_AlbumExt` (
	`AlbumID` int(11) NOT NULL  COMMENT 'ID',
	`StarCount` int(11) NOT NULL DEFAULT 0 COMMENT '评分值',
	`ViewCount` int(11) NOT NULL DEFAULT 0 COMMENT '浏览次数',
	`DownloadCount` int(11) NOT NULL DEFAULT 0  COMMENT '下载次数',
	`FavoriteCount` int(11) NOT NULL DEFAULT 0 COMMENT '收藏次数',
	`ShareCount` int(11) NOT NULL DEFAULT 0 COMMENT '分享次数',
	`CommentCount` int(11) NOT NULL DEFAULT 0 COMMENT '评论次数',
	`ModifyTime` datetime NOT NULL COMMENT '修改时间',
	`CreateTime` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`AlbumID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- mordor_Comment 评论
DROP TABLE IF EXISTS `mordor_Comment`;
CREATE TABLE IF NOT EXISTS `mordor_Comment` (
	`CommentID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
	`UserID` int(11) NOT NULL  COMMENT '评论人ID',
	`AlbumID` int(11) NOT NULL  COMMENT '专辑ID',
	`Content` varchar(2000)  NOT NULL  COMMENT '评论内容',
	`Invalid` tinyint(4) NOT NULL DEFAULT 0 COMMENT '是否禁用',
	`ModifyTime` datetime NOT NULL COMMENT '修改时间',
	`CreateTime` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`CommentID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- mordor_DownLoadRec 下载记录
DROP TABLE IF EXISTS `mordor_DownLoadRec`;
CREATE TABLE IF NOT EXISTS `mordor_DownLoadRec` (
	`DownLoadID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
	`UserID` int(11) NOT NULL  COMMENT '下载人ID',
	`AlbumID` int(11) NOT NULL  COMMENT '专辑ID',
	`DownLoadTime` datetime NOT NULL COMMENT '下载时间',
  PRIMARY KEY (`DownLoadID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- mordor_FavoriteRec 收藏记录
DROP TABLE IF EXISTS `mordor_FavoriteRec`;
CREATE TABLE IF NOT EXISTS `mordor_FavoriteRec` (
	`FavoriteID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
	`UserID` int(11) NOT NULL  COMMENT '收藏人ID',
	`AlbumID` int(11) NOT NULL  COMMENT '专辑ID',
	`FavoriteTime` datetime NOT NULL COMMENT '收藏时间',
  PRIMARY KEY (`FavoriteID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- mordor_ShareRec 分享记录
DROP TABLE IF EXISTS `mordor_ShareRec`;
CREATE TABLE IF NOT EXISTS `mordor_ShareRec` (
	`ShareID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
	`UserID` int(11) NOT NULL  COMMENT '分享人ID',
	`AlbumID` int(11) NOT NULL  COMMENT '专辑ID',
	`ShareTime` datetime NOT NULL COMMENT '分享时间',
  PRIMARY KEY (`ShareID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- mordor_ViewRec 浏览记录
DROP TABLE IF EXISTS `mordor_ViewRec`;
CREATE TABLE IF NOT EXISTS `mordor_ViewRec` (
	`ViewID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
	`UserID` int(11) NOT NULL  COMMENT '浏览人ID',
	`AlbumID` int(11) NOT NULL  COMMENT '专辑ID',
	`ViewTime` datetime NOT NULL COMMENT '浏览时间',
  PRIMARY KEY (`ViewID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- mordor_StarRec 评分记录
DROP TABLE IF EXISTS `mordor_StarRec`;
CREATE TABLE IF NOT EXISTS `mordor_StarRec` (
	`StarID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
	`UserID` int(11) NOT NULL  COMMENT '评分人ID',
	`AlbumID` int(11) NOT NULL  COMMENT '专辑ID',
	`Score` int(11) NOT NULL  COMMENT '分值',
	`StarTime` datetime NOT NULL COMMENT '评分时间',
  PRIMARY KEY (`StarID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- mordor_RewardRec 奖惩记录
DROP TABLE IF EXISTS `mordor_RewardRec`;
CREATE TABLE IF NOT EXISTS `mordor_RewardRec` (
	`RewardID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
	`UserID` int(11) NOT NULL  COMMENT '被奖惩人ID',
	`Score` int NOT NULL  COMMENT '分值',
	`Content` varchar(100)  NOT NULL  COMMENT '奖惩原因',
	`RewardTime` datetime NOT NULL COMMENT '奖惩时间',
	`Creator` int(11)  NOT NULL COMMENT '创建人',
  PRIMARY KEY (`RewardID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- mordor_Tag 标签
DROP TABLE IF EXISTS `mordor_Tag`;
CREATE TABLE IF NOT EXISTS `mordor_Tag` (
	`TagID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
	`Name` varchar(50) NOT NULL COMMENT '标签名称',
	`TagDesc` varchar(255) DEFAULT NULL COMMENT '标签描述',
	`TagType` tinyint(4) default 0  COMMENT '标签类别', -- 专辑=0 表演者=1
	`Invalid` tinyint(4) NOT NULL DEFAULT 0   COMMENT '是否禁用',
	`ModifyTime` datetime NOT NULL COMMENT '修改时间',
	`CreateTime` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`TagID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- mordor_ArtistTag 表演者标签关联表
DROP TABLE IF EXISTS `mordor_ArtistTag`;
CREATE TABLE IF NOT EXISTS `mordor_ArtistTag` (
	`ArtistTagID` int(11) NOT NULL AUTO_INCREMENT,
	`ArtistID` int(11) NOT NULL,
	`TagID` int(11) NOT NULL,
	`CreateTime` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`ArtistTagID`),
  KEY `ArtistID` (`ArtistID`),
  KEY `TagID` (`TagID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AVG_ROW_LENGTH=50;

-- mordor_AlbumTag 专辑标签关联表
DROP TABLE IF EXISTS `mordor_AlbumTag`;
CREATE TABLE IF NOT EXISTS `mordor_AlbumTag` (
	`AlbumTagID` int(11) NOT NULL AUTO_INCREMENT,
	`AlbumID` int(11) NOT NULL,
	`TagID` int(11) NOT NULL,
	`CreateTime` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`AlbumTagID`),
  KEY `AlbumID` (`AlbumID`),
  KEY `TagID` (`TagID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AVG_ROW_LENGTH=50;

-- mordor_File 文件
DROP TABLE IF EXISTS `mordor_File`;
CREATE TABLE IF NOT EXISTS `mordor_File` (
	`FileID` varchar(64) NOT NULL COMMENT 'ID',
	`FileName` varchar(100) NOT NULL COMMENT '文件名称',
	`FilePath` varchar(255) NOT NULL COMMENT '文件路径',
	`FileType` tinyint(4) NOT NULL COMMENT '文件类型', --  0=图片，1=视频，2=文档
	`FileExtension` varchar(32) NOT NULL COMMENT '文件扩展名',
	`FileSize` int(11) NOT NULL COMMENT '文件大小',	
	`ModifyTime` datetime NOT NULL COMMENT '修改时间',
	`CreateTime` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`FileID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- mordor_DownloadURL 下载链接地址
DROP TABLE IF EXISTS `mordor_DownloadURL`;
CREATE TABLE IF NOT EXISTS `mordor_DownloadURL` (
	`DLURLID` int(11) NOT NULL AUTO_INCREMENT,
	`AlbumID` int(11) NOT NULL COMMENT '专辑ID',
	`DLURL` varchar(255) NOT NULL COMMENT '链接地址',
	`DLURLName` varchar(100) NOT NULL COMMENT '链接地址名称',
	`DLURLType` tinyint(4) NOT NULL COMMENT '链接地址类型', --  0=Baidu，1=115，2=360	
	`ModifyTime` datetime NOT NULL COMMENT '修改时间',
	`CreateTime` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`DLURLID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- mordor_Score 权重分值配置表
DROP TABLE IF EXISTS `mordor_Score`;
CREATE TABLE `mordor_Score` (
  `ScoreID` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `ScoreType` varchar(45) NOT NULL COMMENT '类型',
  `Score` int(11) NOT NULL COMMENT '分值',
  `ModifyTime` datetime NOT NULL COMMENT '修改时间',
  `CreateTime` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`ScoreID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权重分值配置表';

-- mordor_AlbumRelated 相关专辑
DROP TABLE IF EXISTS `mordor_AlbumRelated`;
CREATE TABLE `mordor_AlbumRelated` (
  `RelatedID` int(11) NOT NULL AUTO_INCREMENT,
  `AlbumID` int(11) NOT NULL COMMENT '专辑ID',
  `RelatedAlbumID` int(11) NOT NULL COMMENT '相关专辑ID',
  `Score` int(11) NOT NULL COMMENT '分值',
  `CreateTime` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`RelatedID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- mordor_AlbumScore专辑关键字与权重对应表
DROP TABLE IF EXISTS `mordor_AlbumScore`;
CREATE TABLE `mordor_AlbumScore` (
  `AlbumScoreID` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `AlbumID` int(11) NOT NULL COMMENT '专辑ID',
  `ScoreID` int(11) NOT NULL COMMENT '评分项ID',
  `Content` varchar(150) NOT NULL COMMENT '关键字',
  `Score` int(11) NOT NULL COMMENT '分值',
  `CreateTime` datetime NOT NULL COMMENT '创建时间',
   PRIMARY KEY (`AlbumScoreID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='专辑关键字与权重对应表';



