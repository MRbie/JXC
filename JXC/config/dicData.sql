/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : jxc

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2018-03-05 18:07:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `jxc_datadictionary`
-- ----------------------------
DROP TABLE IF EXISTS `jxc_datadictionary`;
CREATE TABLE `jxc_datadictionary` (
  `datadictionary_id` int(11) NOT NULL AUTO_INCREMENT,
  `datadictionary_code` varchar(255) DEFAULT NULL,
  `datadictionary_extend` varchar(255) DEFAULT NULL,
  `datadictionary_desc` varchar(255) DEFAULT NULL,
  `datadictionary_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`datadictionary_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jxc_datadictionary
-- ----------------------------
INSERT INTO `jxc_datadictionary` VALUES ('12', 'admin_type', 'admin_type', 'admin_type', '管理员类别');
INSERT INTO `jxc_datadictionary` VALUES ('13', 'color', '颜色', '颜色', '颜色');
INSERT INTO `jxc_datadictionary` VALUES ('14', 'address', '地区', '地区', '地区');
INSERT INTO `jxc_datadictionary` VALUES ('15', 'sex', '性别', '性别', '性别');
INSERT INTO `jxc_datadictionary` VALUES ('16', 'employee_type', '员工类型', '员工类型', '员工类型');

-- ----------------------------
-- Table structure for `jxc_dicdata`
-- ----------------------------
DROP TABLE IF EXISTS `jxc_dicdata`;
CREATE TABLE `jxc_dicdata` (
  `dicdata_id` int(11) NOT NULL AUTO_INCREMENT,
  `dicdata_name` varchar(255) DEFAULT NULL,
  `dicdata_code` varchar(255) DEFAULT NULL,
  `dicdata_desc` varchar(255) DEFAULT NULL,
  `dicdata_extend` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`dicdata_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jxc_dicdata
-- ----------------------------
INSERT INTO `jxc_dicdata` VALUES ('14', '一级管理员', 'admin_type', '一级管理员', '一级管理员');
INSERT INTO `jxc_dicdata` VALUES ('15', '三级管理员', 'admin_type', '三级管理员', '三级管理员');
INSERT INTO `jxc_dicdata` VALUES ('16', '红色', 'color', '红色', '红色');
INSERT INTO `jxc_dicdata` VALUES ('17', '4级管理员', 'admin_type', '4级管理员', '4级管理员');
INSERT INTO `jxc_dicdata` VALUES ('18', '蓝色', 'color', '蓝色', '蓝色');
INSERT INTO `jxc_dicdata` VALUES ('19', '河南省', 'address', '河南省', '河南省');
INSERT INTO `jxc_dicdata` VALUES ('20', '男', 'sex', '男', '男');
INSERT INTO `jxc_dicdata` VALUES ('24', '女', 'sex', '女', '女');
INSERT INTO `jxc_dicdata` VALUES ('25', '采购员', 'employee_type', '采购员', '采购员');
INSERT INTO `jxc_dicdata` VALUES ('26', '销售员', 'employee_type', '销售员', '销售员');
INSERT INTO `jxc_dicdata` VALUES ('27', '仓库员', 'employee_type', '仓库员', '仓库员');
