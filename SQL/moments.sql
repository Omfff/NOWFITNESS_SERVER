/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80013
Source Host           : localhost:3306
Source Database       : nowfitness

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2018-11-26 21:00:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for moments
-- ----------------------------
DROP TABLE IF EXISTS `moments`;
CREATE TABLE `moments` (
  `momentsId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `content` text NOT NULL,
  `releaseTime` datetime NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  `likes` int(11) DEFAULT NULL,
  PRIMARY KEY (`momentsId`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of moments
-- ----------------------------
INSERT INTO `moments` VALUES ('1', '1', 'my first moments', '2018-11-20 16:47:37', '', '3');
INSERT INTO `moments` VALUES ('4', '1', '1my first moments', '2018-11-20 16:49:40', null, '0');
INSERT INTO `moments` VALUES ('5', '1', '2my first moments', '2018-11-20 16:49:47', null, '0');
INSERT INTO `moments` VALUES ('6', '1', '3my first moments', '2018-11-20 16:49:56', null, '0');
INSERT INTO `moments` VALUES ('7', '1', '3my first moments', '2018-11-21 07:51:32', null, '0');
INSERT INTO `moments` VALUES ('8', '2', 'hhh', '2018-11-21 07:51:45', null, '0');
INSERT INTO `moments` VALUES ('9', '3', 'hhh', '2018-11-21 07:52:02', null, '0');
INSERT INTO `moments` VALUES ('10', '4', 'xixixi', '2018-11-21 07:52:16', null, '0');
INSERT INTO `moments` VALUES ('11', '5', 'wwww', '2018-11-21 07:52:25', null, '0');
INSERT INTO `moments` VALUES ('12', '6', 'biubiubiubiu', '2018-11-21 07:52:37', null, '0');
INSERT INTO `moments` VALUES ('13', '6', 'biubiubiubiu', '2018-11-21 08:19:01', null, '0');
