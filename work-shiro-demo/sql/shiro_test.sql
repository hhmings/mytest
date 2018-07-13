/*
Navicat MySQL Data Transfer

Source Server         : hou
Source Server Version : 50707
Source Host           : localhost:3306
Source Database       : shiro_test

Target Server Type    : MYSQL
Target Server Version : 50707
File Encoding         : 65001

Date: 2018-07-13 15:44:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_msg
-- ----------------------------
DROP TABLE IF EXISTS `sys_msg`;
CREATE TABLE `sys_msg` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `msg` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_msg
-- ----------------------------
INSERT INTO `sys_msg` VALUES ('1', 'aaa');

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `p_id` int(11) NOT NULL AUTO_INCREMENT,
  `p_name` varchar(32) DEFAULT NULL,
  `url` varchar(100) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `permissions` varchar(300) DEFAULT NULL,
  `type` int(11) DEFAULT '0' COMMENT '0-目录；1-菜单；2-按钮',
  PRIMARY KEY (`p_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('1', '系统管理', null, '0', '', '0');
INSERT INTO `sys_permission` VALUES ('2', '用户管理', '/user/page', '1', 'sys:user:user', '1');
INSERT INTO `sys_permission` VALUES ('3', '添加', '/user/add', '2', 'sys:user:add', '2');
INSERT INTO `sys_permission` VALUES ('4', '编辑', '/user/edit', '2', 'sys:user:edit', '2');
INSERT INTO `sys_permission` VALUES ('5', '删除', '/user/del', '2', 'sys:user:del', '2');
INSERT INTO `sys_permission` VALUES ('6', '信息管理', '/msg/page', '1', 'sys:msg:msg', '1');
INSERT INTO `sys_permission` VALUES ('7', '添加', '/msg/add', '6', 'sys:msg:add', '2');
INSERT INTO `sys_permission` VALUES ('8', '编辑', '/msg/edit', '6', 'sys:msg:edit', '2');
INSERT INTO `sys_permission` VALUES ('9', '删除', '/msg/del', '6', 'sys:msg:del', '2');
INSERT INTO `sys_permission` VALUES ('10', '财务管理', '/money/page', '1', 'sys:money:money', '1');
INSERT INTO `sys_permission` VALUES ('11', '其它管理', null, '0', null, '0');
INSERT INTO `sys_permission` VALUES ('12', 'other管理', '/other/page', '11', 'sys:othre:other', '1');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '超级管理员');
INSERT INTO `sys_role` VALUES ('2', '普通用户');

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `permission_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES ('1', '1', '1');
INSERT INTO `sys_role_permission` VALUES ('2', '1', '2');
INSERT INTO `sys_role_permission` VALUES ('3', '1', '3');
INSERT INTO `sys_role_permission` VALUES ('4', '1', '4');
INSERT INTO `sys_role_permission` VALUES ('5', '1', '5');
INSERT INTO `sys_role_permission` VALUES ('6', '1', '6');
INSERT INTO `sys_role_permission` VALUES ('7', '1', '7');
INSERT INTO `sys_role_permission` VALUES ('8', '1', '8');
INSERT INTO `sys_role_permission` VALUES ('9', '1', '9');
INSERT INTO `sys_role_permission` VALUES ('10', '3', '10');
INSERT INTO `sys_role_permission` VALUES ('11', '3', '11');
INSERT INTO `sys_role_permission` VALUES ('12', '3', '12');
INSERT INTO `sys_role_permission` VALUES ('13', '2', '1');
INSERT INTO `sys_role_permission` VALUES ('14', '2', '6');
INSERT INTO `sys_role_permission` VALUES ('15', '3', '7');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id，主键',
  `username` varchar(32) DEFAULT NULL,
  `passwd` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', '123');
INSERT INTO `sys_user` VALUES ('2', 'abc', '123');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1', '1');
INSERT INTO `sys_user_role` VALUES ('2', '2', '2');
SET FOREIGN_KEY_CHECKS=1;
