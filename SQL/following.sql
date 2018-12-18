/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80013
Source Host           : localhost:3306
Source Database       : nowfitness

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2018-11-26 21:00:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for following
-- ----------------------------
DROP TABLE IF EXISTS `following`;
CREATE TABLE `following` (
  `userId` int(11) NOT NULL,
  `followId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of following
-- ----------------------------
INSERT INTO `following` VALUES ('1', '2');
INSERT INTO `following` VALUES ('2', '1');
INSERT INTO `following` VALUES ('1', '3');
INSERT INTO `following` VALUES ('1', '4');
INSERT INTO `following` VALUES ('1', '5');
