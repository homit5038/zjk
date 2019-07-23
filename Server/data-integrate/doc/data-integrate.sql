/*
Navicat MySQL Data Transfer

Source Server         : 本地连接
Source Server Version : 80014
Source Host           : localhost:3306
Source Database       : data-integrate

Target Server Type    : MYSQL
Target Server Version : 80014
File Encoding         : 65001

Date: 2019-07-22 17:33:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_area
-- ----------------------------
DROP TABLE IF EXISTS `t_area`;
CREATE TABLE `t_area` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(500) DEFAULT NULL COMMENT '区域名称',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_del` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除(0-false 1-true 默认0)',
  `is_enable` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否启用(0-false 1-true 默认1)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户工作区域表';

-- ----------------------------
-- Records of t_area
-- ----------------------------

-- ----------------------------
-- Table structure for t_legal_case
-- ----------------------------
DROP TABLE IF EXISTS `t_legal_case`;
CREATE TABLE `t_legal_case` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '违章名称 命名规则：日期+区域+摄像机名称+违章类型',
  `user_id` int(11) DEFAULT NULL COMMENT '上报人ID',
  `area_id` int(11) DEFAULT NULL COMMENT '区域ID',
  `monitor_id` int(11) DEFAULT NULL COMMENT '监控ID',
  `legal_case_type_id` int(11) DEFAULT NULL COMMENT '案件ID',
  `other` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '其他',
  `site` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '违章位置',
  `img` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '违章截图,以|号分割多个图片',
  `video` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '违章视频',
  `create_time` datetime DEFAULT NULL COMMENT '上传日期',
  `is_del` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除(0-false 1-true 默认0)',
  `is_enable` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否启用(0-false 1-true 默认1)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='案件\r\n';

-- ----------------------------
-- Records of t_legal_case
-- ----------------------------

-- ----------------------------
-- Table structure for t_legal_case_type
-- ----------------------------
DROP TABLE IF EXISTS `t_legal_case_type`;
CREATE TABLE `t_legal_case_type` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '分类名称',
  `pid` int(11) DEFAULT NULL COMMENT '父ID',
  `type` int(11) DEFAULT NULL COMMENT '分类(0-一级分类 1-二级分类)',
  `is_del` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除(0-false 1-true 默认0)',
  `is_enable` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否启用(0-false 1-true 默认1)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_legal_case_type
-- ----------------------------
INSERT INTO `t_legal_case_type` VALUES ('1', '修改测试1', null, '0', '0', '1');
INSERT INTO `t_legal_case_type` VALUES ('2', '分类2', null, '0', '0', '1');
INSERT INTO `t_legal_case_type` VALUES ('3', '子分类1', '1', '1', '0', '1');

-- ----------------------------
-- Table structure for t_monitor
-- ----------------------------
DROP TABLE IF EXISTS `t_monitor`;
CREATE TABLE `t_monitor` (
  `id` int(11) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '监控名称',
  `area_id` int(11) DEFAULT NULL COMMENT '区域ID',
  `is_del` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除(0-false 1-true 默认0)',
  `is_enable` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否启用(0-false 1-true 默认1)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='监控信息';

-- ----------------------------
-- Records of t_monitor
-- ----------------------------

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
  `alias` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '别名(中文名)',
  `is_del` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除(0-false 1-true 默认0)',
  `is_enable` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否启用(0-false 1-true 默认1)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', 'admin', '管理员', '0', '1');
INSERT INTO `t_role` VALUES ('2', 'patrol', '巡查员', '0', '1');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登陆名称(最低6位-最高16位',
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登陆密码(MD5+salt进行加密后的值,固定64位)',
  `salt` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '盐值',
  `is_del` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除(0-false 1-true 默认0)',
  `is_enable` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否启用(0-false 1-true 默认1)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'root', 'a8140fed36a07865e115124ef482ea9a', '123', '0', '1');
INSERT INTO `t_user` VALUES ('2', '19988721260', 'a8140fed36a07865e115124ef482ea9a', '123', '0', '1');

-- ----------------------------
-- Table structure for t_user_position
-- ----------------------------
DROP TABLE IF EXISTS `t_user_position`;
CREATE TABLE `t_user_position` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
  `lng` double(10,6) DEFAULT NULL COMMENT '经度',
  `lat` double(10,6) DEFAULT NULL COMMENT '纬度',
  `upload_time` datetime DEFAULT NULL COMMENT '上传时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户定位表';

-- ----------------------------
-- Records of t_user_position
-- ----------------------------

-- ----------------------------
-- Table structure for t_user_to_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_to_role`;
CREATE TABLE `t_user_to_role` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_to_role
-- ----------------------------
INSERT INTO `t_user_to_role` VALUES ('1', '1', '1');
INSERT INTO `t_user_to_role` VALUES ('2', '2', '2');
