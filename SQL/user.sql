/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80013
Source Host           : localhost:3306
Source Database       : nowfitness

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2018-11-21 18:16:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `height` int(11) DEFAULT NULL,
  `weight` double DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `picture` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'huita', '1234', '175', '69.1', '男', '10', null);
INSERT INTO `user` VALUES ('2', 'huitaaa', '1234', null, null, null, null, null);
INSERT INTO `user` VALUES ('3', 'omf', '12345', null, null, null, null, null);
INSERT INTO `user` VALUES ('4', 'liuke', '123456', null, null, null, null, null);
INSERT INTO `user` VALUES ('5', 'bbb', '1234567', null, null, null, null, null);
INSERT INTO `user` VALUES ('6', 'luoyu', '12345678', null, null, null, null, null);
