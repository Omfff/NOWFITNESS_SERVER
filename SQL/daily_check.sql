/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80013
Source Host           : localhost:3306
Source Database       : nowfitness

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2018-12-31 00:45:16
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
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of daily_check
-- ----------------------------
INSERT INTO `daily_check` VALUES ('2', '1', '2018-11-26');
INSERT INTO `daily_check` VALUES ('3', '1', '2018-11-25');
INSERT INTO `daily_check` VALUES ('4', '1', '2018-11-24');
INSERT INTO `daily_check` VALUES ('5', '1', '2018-11-23');
INSERT INTO `daily_check` VALUES ('6', '1', '2018-11-17');
INSERT INTO `daily_check` VALUES ('7', '1', '2018-12-06');
INSERT INTO `daily_check` VALUES ('8', '1', '2018-12-11');
INSERT INTO `daily_check` VALUES ('9', '1', '2018-12-20');
INSERT INTO `daily_check` VALUES ('10', '1', '2018-12-19');
INSERT INTO `daily_check` VALUES ('11', '1', '2018-12-18');
INSERT INTO `daily_check` VALUES ('12', '1', '2018-12-17');
INSERT INTO `daily_check` VALUES ('13', '1', '2018-12-16');
INSERT INTO `daily_check` VALUES ('14', '1', '2018-12-29');
INSERT INTO `daily_check` VALUES ('15', '1', '2018-12-30');
INSERT INTO `daily_check` VALUES ('16', '1', '2018-12-31');
INSERT INTO `daily_check` VALUES ('17', '1', '2019-01-01');
INSERT INTO `daily_check` VALUES ('18', '1', '2019-01-03');
INSERT INTO `daily_check` VALUES ('19', '1', '2019-01-06');
