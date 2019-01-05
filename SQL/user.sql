/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80013
Source Host           : localhost:3306
Source Database       : nowfitness

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2018-12-31 00:44:39
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
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'huitaa', 'c71f6', '8229B6C3599507E0E5A710FFEAE376D9', '175', '69.1', '女', '99', '6c17447a612e4843b08c0b786b112d49.jpg', '1', '472B317787D84C1F850CF205B81DD469', '臭弟弟4515151');
INSERT INTO `user` VALUES ('2', 'huitaaa', '', '1234', null, null, '女', null, '60528.png', '0', '', '小龙女');
INSERT INTO `user` VALUES ('3', 'omf', '439c3', '946B7E9A0EE5CF859DE11724CA9F5DD2', '180', '68', '男', '20', '60528.png', '0', '4D1EF249ADFE3236BA502A21560C8334', '陆无双');
INSERT INTO `user` VALUES ('4', 'liuke', '', '123456', '111', '10000', '男', '91', '60528.png', '0', '', '郭靖');
INSERT INTO `user` VALUES ('5', 'bbb', '', '1234567', '110', '1', '男', '0', '60528.png', '0', '', 'huangrong');
INSERT INTO `user` VALUES ('6', 'luoyu', '', '12345678', '11', '10', '男', '9', '60528.png', '0', '', '金轮法王');
INSERT INTO `user` VALUES ('7', 'lyyy', '', '123456', null, null, '女', null, '60528.png', '0', '', '令狐冲');
INSERT INTO `user` VALUES ('8', 'omf2333', '', '1234567', null, null, '女', null, '60528.png', '1', '', '任盈盈');
INSERT INTO `user` VALUES ('10', 'fangpei', '8aa0e', 'B8B319E369C2C1C146AC5E27233A6C18', '175', '69.1', '男', '1', '60528.png', '0', '31547458E324BD892BD552C68908E777', '岳灵珊');
INSERT INTO `user` VALUES ('11', 'bbbbbb', 'd25e3', 'C6F1882E255BA536B30854D615F40592', '0', '0', '无', '0', '60528.png', '0', '1A314D8BFE73AC79B1423A261DF055A7', '张无忌');
INSERT INTO `user` VALUES ('12', 'bbbbbbhh', 'b32ca', '28B80B080B1A4CD788944AC86ED2FE1F', '0', '0', '无', '0', '60528.png', '0', 'EDC5B8D5323DB6032ED1B7AB4EDA2826', '张三丰');
INSERT INTO `user` VALUES ('13', 'bbbhhh', '7e7a9', '1E9993DC19B211880718D05D17813DFD', '0', '0', '无', '0', '60528.png', '0', '88CA4BC71325BFA58C2F068E56DF5BEC', '貂蝉');
INSERT INTO `user` VALUES ('14', 'aiiiiii', '257f4', 'EF81CF1F931BB74A8C04A62BF14EDC13', '0', '0', '无', '0', '60528.png', '0', 'A4E2091CB6F8E0EFAE0085E572EF027C', null);
