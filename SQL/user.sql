/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80013
Source Host           : localhost:3306
Source Database       : nowfitness

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2018-12-18 11:26:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) NOT NULL,
  `salt` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `height` double DEFAULT NULL,
  `weight` double DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `picture` varchar(255) DEFAULT NULL,
  `states` tinyint(4) NOT NULL,
  `token` varchar(255) NOT NULL,
  `nickName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'huita', '', '1234', '175', '69.1', '男', '1', '7a00cfec10c8459f835ce8d1074bf7f0.jpg', '1', '', null);
INSERT INTO `user` VALUES ('2', 'huitaaa', '', '1234', null, null, null, null, '63bf800f22b64c53a1391a9e782d9112.JPG', '0', '', null);
INSERT INTO `user` VALUES ('3', 'omf', '', '12345', '180', '68', 'man', '20', 'aecb5cd433f643aba18aee7557558ef3.JPG', '0', '', null);
INSERT INTO `user` VALUES ('4', 'liuke', '', '123456', '111', '10000', 'man', '91', null, '0', '', null);
INSERT INTO `user` VALUES ('5', 'bbb', '', '1234567', '110', '1', 'man', '0', '4604f7044a7a4fccbd942e50d7dc23ef.jpg', '0', '', null);
INSERT INTO `user` VALUES ('6', 'luoyu', '', '12345678', '11', '10', 'man', '9', null, '0', '', null);
INSERT INTO `user` VALUES ('7', 'lyyy', '', '123456', null, null, null, null, null, '0', '', null);
INSERT INTO `user` VALUES ('8', 'omf2333', '', '1234567', null, null, null, null, null, '1', '', null);
INSERT INTO `user` VALUES ('10', 'fangpei', '8aa0e', 'B8B319E369C2C1C146AC5E27233A6C18', '175', '69.1', '男', '1', '', '0', '31547458E324BD892BD552C68908E777', '');
INSERT INTO `user` VALUES ('11', 'bbbbbb', 'd25e3', 'C6F1882E255BA536B30854D615F40592', '0', '0', '无', '0', '', '0', '1A314D8BFE73AC79B1423A261DF055A7', null);
INSERT INTO `user` VALUES ('12', 'bbbbbbhh', 'b32ca', '28B80B080B1A4CD788944AC86ED2FE1F', '0', '0', '无', '0', '60528.png', '0', 'EDC5B8D5323DB6032ED1B7AB4EDA2826', null);
