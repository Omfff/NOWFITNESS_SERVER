/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80013
Source Host           : localhost:3306
Source Database       : nowfitness

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2018-12-31 00:44:31
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
