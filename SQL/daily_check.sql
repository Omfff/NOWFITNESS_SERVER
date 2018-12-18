/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80013
Source Host           : localhost:3306
Source Database       : nowfitness

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2018-11-26 20:59:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for daily_check
-- ----------------------------
DROP TABLE IF EXISTS `daily_check`;
CREATE TABLE `daily_check` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of daily_check
-- ----------------------------
INSERT INTO `daily_check` VALUES ('2', '1', '2018-11-26');
INSERT INTO `daily_check` VALUES ('3', '1', '2018-11-25');
INSERT INTO `daily_check` VALUES ('4', '1', '2018-11-24');
INSERT INTO `daily_check` VALUES ('5', '1', '2018-11-23');
INSERT INTO `daily_check` VALUES ('6', '1', '2018-11-17');
