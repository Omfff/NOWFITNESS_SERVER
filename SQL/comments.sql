/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80013
Source Host           : localhost:3306
Source Database       : nowfitness

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2018-12-31 00:45:24
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
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comments
-- ----------------------------
INSERT INTO `comments` VALUES ('3', '11', 'asdgqrqtr', '4', '2018-11-25 12:40:24');
INSERT INTO `comments` VALUES ('5', '11', 'asdgqrqtr', '4', '2018-11-25 13:20:52');
INSERT INTO `comments` VALUES ('7', '11', 'fdgs', '4', '2018-11-28 16:25:21');
INSERT INTO `comments` VALUES ('10', '9', 'fjooowwoof', '3', '2018-12-19 16:08:13');
INSERT INTO `comments` VALUES ('11', '9', 'fjooowwoof', '3', '2018-12-23 00:15:31');
INSERT INTO `comments` VALUES ('12', '9', 'fjooowwoof', '3', '2018-12-23 00:17:41');
INSERT INTO `comments` VALUES ('15', '21', 'I love you baby', '1', '2018-12-23 11:16:50');
INSERT INTO `comments` VALUES ('16', '21', 'emmmm', '1', '2018-12-23 15:19:35');
INSERT INTO `comments` VALUES ('17', '21', 'haliluya', '1', '2018-12-23 15:31:52');
INSERT INTO `comments` VALUES ('18', '19', 'asdfqwer', '1', '2018-12-25 11:13:34');
INSERT INTO `comments` VALUES ('19', '19', 'asdfeqwf', '1', '2018-12-25 11:13:48');
INSERT INTO `comments` VALUES ('20', '19', 'wwww', '1', '2018-12-25 11:15:00');
INSERT INTO `comments` VALUES ('21', '19', 'qwerq', '1', '2018-12-25 11:25:27');
INSERT INTO `comments` VALUES ('22', '18', 'fwww', '1', '2018-12-25 11:26:22');
INSERT INTO `comments` VALUES ('23', '19', 'qqq', '1', '2018-12-25 12:16:14');
INSERT INTO `comments` VALUES ('24', '18', 'wuwuwuwu', '1', '2018-12-25 12:19:09');
INSERT INTO `comments` VALUES ('25', '19', 'zcxv', '1', '2018-12-25 12:36:45');
INSERT INTO `comments` VALUES ('26', '18', 'zxcv', '1', '2018-12-25 12:46:37');
INSERT INTO `comments` VALUES ('27', '14', 'sdf', '1', '2018-12-25 12:46:43');
INSERT INTO `comments` VALUES ('28', '13', 'wwwww', '1', '2018-12-25 12:46:53');
INSERT INTO `comments` VALUES ('29', '18', 'df', '1', '2018-12-25 12:48:17');
INSERT INTO `comments` VALUES ('30', '19', 'emmmm', '1', '2018-12-25 13:01:40');
INSERT INTO `comments` VALUES ('32', '13', 'sdfqwe', '1', '2018-12-25 13:32:24');
INSERT INTO `comments` VALUES ('33', '13', 'asdfqwe', '1', '2018-12-25 13:34:46');
INSERT INTO `comments` VALUES ('34', '8', 'qewrqwer', '1', '2018-12-29 12:57:59');
INSERT INTO `comments` VALUES ('35', '8', 'ss', '1', '2018-12-29 13:03:41');
INSERT INTO `comments` VALUES ('37', '8', 'ewr', '1', '2018-12-29 13:03:47');
INSERT INTO `comments` VALUES ('38', '8', '你在哪三年前', '1', '2018-12-29 21:14:44');
INSERT INTO `comments` VALUES ('39', '21', 'uehrhrgr', '1', '2018-12-30 15:16:23');
