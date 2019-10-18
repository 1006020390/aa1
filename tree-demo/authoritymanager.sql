/*
Navicat MySQL Data Transfer

Source Server         : 长路漫漫
Source Server Version : 50714
Source Host           : localhost:3306
Source Database       : authoritymanager

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2019-10-11 10:18:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for childrenmanagements
-- ----------------------------
DROP TABLE IF EXISTS `childrenmanagements`;
CREATE TABLE `childrenmanagements` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `father_id` int(10) NOT NULL,
  `tree_url` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of childrenmanagements
-- ----------------------------
INSERT INTO `childrenmanagements` VALUES ('1', '新增装备', '1', '###');
INSERT INTO `childrenmanagements` VALUES ('4', '修改装备属性', '1', '###');
INSERT INTO `childrenmanagements` VALUES ('5', '修改金币数量', '2', '###');
INSERT INTO `childrenmanagements` VALUES ('6', '修改图片', '3', '###');
INSERT INTO `childrenmanagements` VALUES ('7', '新增管理员', '4', 'addAdmin.html');
INSERT INTO `childrenmanagements` VALUES ('9', '新增会员', '5', '###');
INSERT INTO `childrenmanagements` VALUES ('10', '修改会员时限', '5', '###');
INSERT INTO `childrenmanagements` VALUES ('11', '修改金币上限', '2', '###');
INSERT INTO `childrenmanagements` VALUES ('12', '添加权限节点', '4', 'managements.html');
INSERT INTO `childrenmanagements` VALUES ('13', '修改装备介绍', '1', '###');
INSERT INTO `childrenmanagements` VALUES ('14', '修改管理员权限', '4', '###');
INSERT INTO `childrenmanagements` VALUES ('15', '修改4', '1', '###');
INSERT INTO `childrenmanagements` VALUES ('16', '版面设计', '6', '###');

-- ----------------------------
-- Table structure for managements
-- ----------------------------
DROP TABLE IF EXISTS `managements`;
CREATE TABLE `managements` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `managements_name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of managements
-- ----------------------------
INSERT INTO `managements` VALUES ('1', '装备管理');
INSERT INTO `managements` VALUES ('2', '金币管理');
INSERT INTO `managements` VALUES ('3', '图片管理');
INSERT INTO `managements` VALUES ('4', '管理员管理');
INSERT INTO `managements` VALUES ('5', '会员管理');
INSERT INTO `managements` VALUES ('6', '宣传海报管理');
INSERT INTO `managements` VALUES ('8', '帅帅帅');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(10) NOT NULL,
  `password` varchar(10) NOT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `status` int(1) NOT NULL DEFAULT '1',
  `role_name` varchar(10) NOT NULL,
  `authority_level` int(3) NOT NULL DEFAULT '100',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', '亚索', 'hasaki', '2019-09-25 14:48:59', '1', '超级管理员', '1');
INSERT INTO `users` VALUES ('2', '剑圣', 'wuji', '2019-09-26 10:34:53', '1', '二级管理员', '2');
INSERT INTO `users` VALUES ('3', 'gay伦', 'misscarter', '2019-09-24 16:28:11', '1', '三级狗管理', '3');
INSERT INTO `users` VALUES ('4', '阿木木', 'friends', '2019-09-24 16:28:16', '1', '普通用户', '5');
INSERT INTO `users` VALUES ('5', '赵信', 'wuwei', '2019-09-24 16:28:20', '1', '三级', '3');
INSERT INTO `users` VALUES ('6', '蛮王', 'rage', '2019-09-24 19:30:23', '1', '普通用户', '5');
INSERT INTO `users` VALUES ('7', '德莱厄斯', 'bleed', '2019-09-24 19:31:06', '1', '普通用户', '5');
INSERT INTO `users` VALUES ('8', '德莱文', 'wensente', '2019-09-24 19:31:25', '1', '普通用户', '5');
INSERT INTO `users` VALUES ('9', '卡特琳娜', 'ansha', '2019-09-24 19:31:45', '1', '普通用户', '5');
INSERT INTO `users` VALUES ('10', '玛尔扎哈', 'xukongworm', '2019-09-24 19:32:29', '1', '普通用户', '5');
INSERT INTO `users` VALUES ('11', '劫', 'twosolider', '2019-09-24 19:34:13', '1', '普通用户', '5');
INSERT INTO `users` VALUES ('12', '内瑟斯', 'doghead', '2019-09-24 19:35:00', '1', '普通用户', '5');
INSERT INTO `users` VALUES ('13', '喔鱼', 'killAll', '2019-09-27 10:54:33', '1', '普通用户', '5');

-- ----------------------------
-- Table structure for user_authority
-- ----------------------------
DROP TABLE IF EXISTS `user_authority`;
CREATE TABLE `user_authority` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) NOT NULL,
  `managements_id` int(10) NOT NULL,
  `childManagements_id` int(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_authority
-- ----------------------------
INSERT INTO `user_authority` VALUES ('21', '1', '1', '1');
INSERT INTO `user_authority` VALUES ('22', '1', '1', '4');
INSERT INTO `user_authority` VALUES ('23', '1', '2', '5');
INSERT INTO `user_authority` VALUES ('24', '1', '2', '11');
INSERT INTO `user_authority` VALUES ('25', '1', '3', '6');
INSERT INTO `user_authority` VALUES ('26', '1', '4', '7');
INSERT INTO `user_authority` VALUES ('27', '1', '4', '8');
INSERT INTO `user_authority` VALUES ('28', '1', '4', '12');
INSERT INTO `user_authority` VALUES ('29', '1', '5', '9');
INSERT INTO `user_authority` VALUES ('31', '1', '5', '10');
INSERT INTO `user_authority` VALUES ('37', '5', '1', '1');
INSERT INTO `user_authority` VALUES ('38', '5', '1', '4');
INSERT INTO `user_authority` VALUES ('39', '5', '1', '13');
INSERT INTO `user_authority` VALUES ('40', '5', '4', '7');
INSERT INTO `user_authority` VALUES ('41', '5', '4', '12');
INSERT INTO `user_authority` VALUES ('42', '5', '4', '14');
INSERT INTO `user_authority` VALUES ('43', '2', '1', '1');
INSERT INTO `user_authority` VALUES ('44', '2', '1', '4');
INSERT INTO `user_authority` VALUES ('45', '2', '1', '13');
INSERT INTO `user_authority` VALUES ('46', '2', '4', '7');
INSERT INTO `user_authority` VALUES ('47', '2', '4', '12');
