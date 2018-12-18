/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80013
Source Host           : localhost:3306
Source Database       : nowfitness

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2018-11-26 21:00:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for replies
-- ----------------------------
DROP TABLE IF EXISTS `replies`;
CREATE TABLE `replies` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `commentId` int(11) NOT NULL,
  `fromUserId` int(11) NOT NULL,
  `toUserId` int(11) NOT NULL,
  `replyType` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `content` varchar(255) NOT NULL,
  `replyTime` datetime NOT NULL,
  `replyId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of replies
-- ----------------------------
INSERT INTO `replies` VALUES ('1', '3', '3', '2', 'reply', 'haofangaaaa', '2018-11-25 12:45:05', '1');
INSERT INTO `replies` VALUES ('2', '3', '2', '3', 'reply', 'haofangaaaa', '2018-11-25 12:47:47', '1');
INSERT INTO `replies` VALUES ('4', '3', '4', '2', 'reply', 'haaaaa', '2018-11-25 12:48:43', '1');
INSERT INTO `replies` VALUES ('5', '3', '2', '4', 'reply', 'hafgdfsgha', '2018-11-25 12:49:16', '5');
INSERT INTO `replies` VALUES ('6', '3', '3', '4', 'reply', 'hwytufsgha', '2018-11-25 12:49:42', '5');
