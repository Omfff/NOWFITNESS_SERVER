/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80013
Source Host           : localhost:3306
Source Database       : nowfitness

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2018-12-31 00:41:11
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

-- ----------------------------
-- Table structure for daily_check
-- ----------------------------
DROP TABLE IF EXISTS `daily_check`;
CREATE TABLE `daily_check` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of daily_check
-- ----------------------------
INSERT INTO `daily_check` VALUES ('2', '1', '2018-11-26');
INSERT INTO `daily_check` VALUES ('3', '1', '2018-11-25');
INSERT INTO `daily_check` VALUES ('4', '1', '2018-11-24');
INSERT INTO `daily_check` VALUES ('5', '1', '2018-11-23');
INSERT INTO `daily_check` VALUES ('6', '1', '2018-11-17');
INSERT INTO `daily_check` VALUES ('7', '1', '2018-12-06');
INSERT INTO `daily_check` VALUES ('8', '1', '2018-12-11');
INSERT INTO `daily_check` VALUES ('9', '1', '2018-12-20');
INSERT INTO `daily_check` VALUES ('10', '1', '2018-12-19');
INSERT INTO `daily_check` VALUES ('11', '1', '2018-12-18');
INSERT INTO `daily_check` VALUES ('12', '1', '2018-12-17');
INSERT INTO `daily_check` VALUES ('13', '1', '2018-12-16');
INSERT INTO `daily_check` VALUES ('14', '1', '2018-12-29');
INSERT INTO `daily_check` VALUES ('15', '1', '2018-12-30');
INSERT INTO `daily_check` VALUES ('16', '1', '2018-12-31');
INSERT INTO `daily_check` VALUES ('17', '1', '2019-01-01');
INSERT INTO `daily_check` VALUES ('18', '1', '2019-01-03');
INSERT INTO `daily_check` VALUES ('19', '1', '2019-01-06');

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
INSERT INTO `following` VALUES ('2', '1');
INSERT INTO `following` VALUES ('1', '7');
INSERT INTO `following` VALUES ('1', '5');

-- ----------------------------
-- Table structure for likes
-- ----------------------------
DROP TABLE IF EXISTS `likes`;
CREATE TABLE `likes` (
  `momentsId` int(11) NOT NULL,
  `likesId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of likes
-- ----------------------------
INSERT INTO `likes` VALUES ('1', '1');
INSERT INTO `likes` VALUES ('1', '5');
INSERT INTO `likes` VALUES ('1', '3');
INSERT INTO `likes` VALUES ('32', '1');
INSERT INTO `likes` VALUES ('21', '1');

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

-- ----------------------------
-- Table structure for steps_data
-- ----------------------------
DROP TABLE IF EXISTS `steps_data`;
CREATE TABLE `steps_data` (
  `id` int(11) NOT NULL,
  `date` date NOT NULL,
  `steps` int(11) NOT NULL,
  `calories` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of steps_data
-- ----------------------------
INSERT INTO `steps_data` VALUES ('1', '2018-11-18', '12', '0');
INSERT INTO `steps_data` VALUES ('2', '2018-11-18', '12', '0');
INSERT INTO `steps_data` VALUES ('1', '2017-11-18', '20', '0');
INSERT INTO `steps_data` VALUES ('3', '2018-12-07', '10000', '2500');
INSERT INTO `steps_data` VALUES ('2', '2018-12-07', '100', '250');
INSERT INTO `steps_data` VALUES ('3', '2018-12-20', '10000', '2500');
INSERT INTO `steps_data` VALUES ('2', '2018-12-20', '100', '250');
INSERT INTO `steps_data` VALUES ('2', '2018-12-19', '21021', '42545');
INSERT INTO `steps_data` VALUES ('2', '2018-12-18', '45', '6786');
INSERT INTO `steps_data` VALUES ('2', '2018-12-17', '575876', '786978');
INSERT INTO `steps_data` VALUES ('2', '2018-12-16', '897', '789789');
INSERT INTO `steps_data` VALUES ('2', '2018-12-15', '78966', '789');
INSERT INTO `steps_data` VALUES ('2', '2018-12-14', '85544', '7789');
INSERT INTO `steps_data` VALUES ('2', '2018-12-13', '8897', '889');
INSERT INTO `steps_data` VALUES ('2', '2018-12-11', '8989', '222');
INSERT INTO `steps_data` VALUES ('2', '2018-12-10', '78944', '44646');
INSERT INTO `steps_data` VALUES ('1', '2018-12-25', '0', '0');
INSERT INTO `steps_data` VALUES ('1', '2018-12-26', '0', '0');
INSERT INTO `steps_data` VALUES ('1', '2018-12-27', '1000', '250');
INSERT INTO `steps_data` VALUES ('2', '2018-12-27', '100', '250');
INSERT INTO `steps_data` VALUES ('1', '2018-12-28', '2678', '134');
INSERT INTO `steps_data` VALUES ('3', '2018-12-28', '100', '2500');
INSERT INTO `steps_data` VALUES ('2', '2018-12-28', '100', '25021');
INSERT INTO `steps_data` VALUES ('1', '2018-12-29', '71', '3');
INSERT INTO `steps_data` VALUES ('1', '2018-12-30', '0', '0');
INSERT INTO `steps_data` VALUES ('1', '2018-12-30', '0', '0');

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
