/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80013
Source Host           : localhost:3306
Source Database       : nowfitness

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2018-11-21 18:16:08
*/

SET FOREIGN_KEY_CHECKS=0;

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
