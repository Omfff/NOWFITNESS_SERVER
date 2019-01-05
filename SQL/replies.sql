/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80013
Source Host           : localhost:3306
Source Database       : nowfitness

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2018-12-31 00:44:47
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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of replies
-- ----------------------------
INSERT INTO `replies` VALUES ('2', '4', '2', '3', 'reply', 'haofangaaaa', '2018-11-25 12:47:47', '1');
INSERT INTO `replies` VALUES ('4', '6', '4', '2', 'reply', 'haaaaa', '2018-11-25 12:48:43', '1');
INSERT INTO `replies` VALUES ('5', '6', '2', '4', 'reply', 'hafgdfsgha', '2018-11-25 12:49:16', '5');
INSERT INTO `replies` VALUES ('6', '6', '3', '4', 'reply', 'hwytufsgha', '2018-11-25 12:49:42', '5');
INSERT INTO `replies` VALUES ('9', '3', '1', '4', null, 'I hate u', '2018-12-23 11:19:34', '0');
INSERT INTO `replies` VALUES ('10', '5', '1', '4', null, 'love me once more', '2018-12-23 11:19:52', '0');
