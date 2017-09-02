/*
Navicat MySQL Data Transfer

Source Server         : forliu
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : forliu

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-08-19 23:52:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for checkupdate
-- ----------------------------
DROP TABLE IF EXISTS `checkupdate`;
CREATE TABLE `checkupdate` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` text,
  `url` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
