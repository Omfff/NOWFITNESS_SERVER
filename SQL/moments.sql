/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80013
Source Host           : localhost:3306
Source Database       : nowfitness

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2018-12-31 00:44:55
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
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of moments
-- ----------------------------
INSERT INTO `moments` VALUES ('1', '1', 'my first moments', '2018-11-20 16:47:37', '', '3');
INSERT INTO `moments` VALUES ('4', '1', '1my first moments', '2018-11-20 16:49:40', null, '0');
INSERT INTO `moments` VALUES ('5', '1', '2my first moments', '2018-11-20 16:49:47', null, '0');
INSERT INTO `moments` VALUES ('6', '1', '3my first moments', '2018-11-20 16:49:56', null, '0');
INSERT INTO `moments` VALUES ('7', '1', '3my first moments', '2018-11-21 07:51:32', null, '0');
INSERT INTO `moments` VALUES ('8', '2', 'hhh', '2018-11-21 07:51:45', '13f2a7b09d5f4d2dae42196816a03bee.JPG', '0');
INSERT INTO `moments` VALUES ('9', '3', 'hhh', '2018-11-21 07:52:02', '305c7356abaa4625a894db45a7f64dcd.JPG', '0');
INSERT INTO `moments` VALUES ('11', '5', 'wwww', '2018-11-21 07:52:25', 'afe0e62b1102496da21686662c2a3caf.png', '0');
INSERT INTO `moments` VALUES ('12', '6', 'biubiubiubiu', '2018-11-21 07:52:37', null, '0');
INSERT INTO `moments` VALUES ('13', '6', 'biubiubiubiu', '2018-11-21 08:19:01', null, '0');
INSERT INTO `moments` VALUES ('14', '4', 'adfgaefqrwer', '2018-11-28 22:58:08', null, '1');
INSERT INTO `moments` VALUES ('15', '1', '好烦烦', '2018-12-19 16:09:52', null, '0');
INSERT INTO `moments` VALUES ('16', '5', 'qqqqqqqqq', '2018-12-20 20:40:19', '', '2');
INSERT INTO `moments` VALUES ('17', '7', 'wwwwwwwww', '2018-12-20 20:40:37', null, '0');
INSERT INTO `moments` VALUES ('18', '8', 'tyutyut', '2018-12-20 20:40:56', null, '1');
INSERT INTO `moments` VALUES ('19', '10', 'qwwwwww', '2018-12-20 20:41:11', null, '3');
INSERT INTO `moments` VALUES ('20', '7', 'afdgadf', '2018-12-20 20:41:26', null, '6');
INSERT INTO `moments` VALUES ('21', '5', 'fjkfhkj', '2018-12-20 20:41:55', null, '10');
INSERT INTO `moments` VALUES ('22', '1', '好烦烦', '2018-12-22 13:58:49', null, '0');
INSERT INTO `moments` VALUES ('23', '1', 'jehehe', '2018-12-22 14:38:50', 'b2e1df6344284812a0b350d93774c0ff.jpg', '0');
INSERT INTO `moments` VALUES ('24', '1', '好烦烦', '2018-12-22 14:52:55', null, '0');
INSERT INTO `moments` VALUES ('25', '1', '好烦烦', '2018-12-22 14:53:02', null, '0');
INSERT INTO `moments` VALUES ('26', '1', 'hrh4hr', '2018-12-22 14:53:13', null, '0');
INSERT INTO `moments` VALUES ('27', '1', '海牛', '2018-12-23 11:34:27', '48976c4ffed44888b086c46523a61113.jpg', '0');
INSERT INTO `moments` VALUES ('28', '1', 'wuwuwuw', '2018-12-28 12:24:01', null, '0');
INSERT INTO `moments` VALUES ('29', '1', 'dsaf', '2018-12-28 12:26:32', null, '0');
INSERT INTO `moments` VALUES ('30', '1', '欧明锋臭弟弟', '2018-12-29 14:29:07', '5229d1bad5234f6eb33ac738452b62df.jpg', '0');
INSERT INTO `moments` VALUES ('31', '1', '欧明锋臭弟弟', '2018-12-29 14:29:07', 'bb485dfa6f9a464f8b14947ce87acb7f.jpg', '0');
INSERT INTO `moments` VALUES ('32', '1', '测试realease版本', '2018-12-30 13:39:03', '856b5b9c07e848e9a6001594a7a345e1.jpg', '1');
