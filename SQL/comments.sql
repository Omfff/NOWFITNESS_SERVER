/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80013
Source Host           : localhost:3306
Source Database       : nowfitness

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2018-11-26 21:00:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for comments
-- ----------------------------
DROP TABLE IF EXISTS `comments`;
CREATE TABLE `comments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `momentsId` int(11) NOT NULL,
  `content` varchar(255) NOT NULL,
  `commentUserId` int(11) NOT NULL,
  `commentTime` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comments
-- ----------------------------
INSERT INTO `comments` VALUES ('3', '1', 'asdgqrqtr', '4', '2018-11-25 12:40:24');
INSERT INTO `comments` VALUES ('4', '1', 'asdgqrqtr', '4', '2018-11-25 13:20:41');
INSERT INTO `comments` VALUES ('5', '1', 'asdgqrqtr', '4', '2018-11-25 13:20:52');
