/*
Navicat MySQL Data Transfer

Source Server         : damu
Source Server Version : 50636
Source Host           : localhost:3306
Source Database       : myschool

Target Server Type    : MYSQL
Target Server Version : 50636
File Encoding         : 65001

Date: 2019-07-10 17:34:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tjtb
-- ----------------------------
DROP TABLE IF EXISTS `tjtb`;
CREATE TABLE `tjtb` (
  `id` varchar(200) NOT NULL,
  `oprt_id` varchar(200) DEFAULT NULL,
  `x1_eName` varchar(255) DEFAULT NULL,
  `x1_cName` varchar(255) DEFAULT NULL,
  `x1_value` varchar(255) DEFAULT NULL,
  `x2_eName` varchar(255) DEFAULT NULL,
  `x2_cName` varchar(255) DEFAULT NULL,
  `x2_value` varchar(255) DEFAULT NULL,
  `x3_eName` varchar(255) DEFAULT NULL,
  `x3_cName` varchar(255) DEFAULT NULL,
  `x3_value` varchar(255) DEFAULT NULL,
  `y_eName` varchar(255) DEFAULT NULL,
  `y_cName` varchar(255) DEFAULT NULL,
  `y_value` varchar(255) DEFAULT NULL,
  `chartIndex` varchar(255) DEFAULT NULL,
  `version` varchar(255) DEFAULT NULL,
  `sum` int(255) DEFAULT NULL,
  `num` int(20) DEFAULT NULL,
  `min` int(20) DEFAULT NULL,
  `max` int(20) DEFAULT NULL,
  `percent_1` int(20) DEFAULT NULL,
  `percent_5` int(20) DEFAULT NULL,
  `percent_10` int(20) DEFAULT NULL,
  `percent_25` int(20) DEFAULT NULL,
  `percent_50` int(20) DEFAULT NULL,
  `percent_75` int(20) DEFAULT NULL,
  `percent_90` int(20) DEFAULT NULL,
  `percent_100` int(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tjtb
-- ----------------------------
INSERT INTO `tjtb` VALUES ('10010d', '1001', 'ccpl', '客户永久调额', '10000-20000', 'ccvi', '客户有效标志', '0', '', '', '', 'ccai', '客户激活标志', 'percent_25', '1', 'A001', null, null, '1', null, null, '12888', null, '12888', null, null, null, null);
INSERT INTO `tjtb` VALUES ('1006d', '1001', 'ccpl', '客户永久调额', '0-5000', 'ccvi', '客户有效标志', '0', '', '', '', 'ccai', '客户激活标志', 'percent_25', '1', 'A001', null, null, '1', null, null, '5001', null, '5001', null, null, null, null);
INSERT INTO `tjtb` VALUES ('1007d', '1001', 'ccpl', '客户永久调额', '10000-20000', 'ccvi', '客户有效标志', '1', '', '', '', 'ccai', '客户激活标志', 'percent_25', '1', 'A001', null, null, '1', null, null, '15555', null, '15555', null, null, null, null);
INSERT INTO `tjtb` VALUES ('1008d', '1001', 'ccpl', '客户永久调额', '5000-10000', 'ccvi', '客户有效标志', '1', '', '', '', 'ccai', '客户激活标志', 'percent_25', '1', 'A001', null, null, '1', null, null, '5555', null, '5555', null, null, null, null);
INSERT INTO `tjtb` VALUES ('1009d', '1001', 'ccpl', '客户永久调额', '0-5000', 'ccvi', '客户有效标志', '1', '', '', '', 'ccai', '客户激活标志', 'percent_25', '1', 'A001', null, null, '1', null, null, '555', null, '555', null, null, null, null);
