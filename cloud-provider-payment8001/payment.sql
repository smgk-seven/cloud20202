/*
Navicat MySQL Data Transfer

Source Server         : local_db
Source Server Version : 50711
Source Host           : localhost:3306
Source Database       : cloud2020

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2020-03-09 20:43:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `payment`
-- ----------------------------
DROP TABLE IF EXISTS `payment`;
CREATE TABLE `payment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `serial` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of payment
-- ----------------------------
