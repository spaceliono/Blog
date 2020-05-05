-- ----------------------------
-- Table structure for role
-- ----------------------------
CREATE TABLE `role` (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '��ɫID',
  `uid` int(8) DEFAULT NULL COMMENT '�û�ID',
  `roleName` VARCHAR(20) DEFAULT NULL COMMENT '��ɫ��',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ----------------------------
-- Records of role
-- ----------------------------
BEGIN;
INSERT INTO `role`(uid,roleName) VALUES (1, "Admin");
INSERT INTO `role`(uid,roleName) VALUES (2, "User");
COMMIT;
-- ----------------------------
-- Table structure for user
-- ----------------------------
CREATE TABLE `user`(
	`id` int(8) NOT NULL AUTO_INCREMENT COMMENT '�û�ID',
	`userName` VARCHAR(20) DEFAULT NULL COMMENT '�û���',
	`password`	VARCHAR(200) DEFAULT NULL COMMENT '����',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ----------------------------
-- Records of user
-- ----------------------------
begin;
INSERT into `user`(userName,password) VALUES ('admin','$2a$10$on7jUGJN.4CyjPZzyroZce0ugjCQFzA6dRuOTcEFTBLLhe3oYe5Gu');
INSERT into `user`(userName,password) VALUES ('user','$2a$10$on7jUGJN.4CyjPZzyroZce0ugjCQFzA6dRuOTcEFTBLLhe3oYe5Gu');
COMMIT;
-- ----------------------------
-- Table structure for menu
-- ----------------------------
CREATE TABLE `menu`(
	`id` int(8) NOT NULL AUTO_INCREMENT COMMENT '�˵�ID',
	`menuName` VARCHAR(20) DEFAULT NULL COMMENT '�˵���',
	`menuUrl`	VARCHAR(200) DEFAULT NULL COMMENT '�˵�Url',
	`rid` int(8) DEFAULT NULL COMMENT '��ɫID',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ----------------------------
-- Records of menu
-- ----------------------------
begin;
insert into `menu`(menuName,menuUrl,rid) value('����˵�','/admin/**',1);
insert into `menu`(menuName,menuUrl,rid) value('���Ͳ˵�','/article/**',2);
COMMIT;
-- ----------------------------
-- Table structure for articles
-- ----------------------------
CREATE TABLE `articles` (
  `article_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `article_title` varchar(100) NOT NULL,
  `create_date` date NOT NULL,
  `markdown` text NOT NULL,
  PRIMARY KEY (`article_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;