/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : jxc

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-04-17 20:22:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `jxc_admin`
-- ----------------------------
DROP TABLE IF EXISTS `jxc_admin`;
CREATE TABLE `jxc_admin` (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(20) DEFAULT NULL,
  `admin_type` varchar(20) DEFAULT NULL,
  `admin_status` varchar(20) DEFAULT NULL,
  `admin_extend` varchar(20) DEFAULT NULL,
  `admin_account` varchar(255) DEFAULT NULL,
  `admin_password` varchar(255) DEFAULT NULL,
  `admin_age` int(11) DEFAULT NULL,
  `admin_sex` varchar(255) DEFAULT NULL,
  `admin_phone` varchar(255) DEFAULT NULL,
  `admin_email` varchar(255) DEFAULT NULL,
  `admin_birthday` varchar(255) DEFAULT NULL,
  `admin_code` varchar(255) DEFAULT NULL,
  `admin_cardno` varchar(255) DEFAULT NULL,
  `admin_address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jxc_admin
-- ----------------------------
INSERT INTO `jxc_admin` VALUES ('1', 'admin', '111', '2000', '222', 'admin', '123456', '22', '保密', '15236083001', '174871328@qq.com', '1994-04-20', '10010', '410************', null);
INSERT INTO `jxc_admin` VALUES ('2', '别先生', 'admin', '2000', 'aa', '别先生', '123456', '22', '男', '15236083001', 'aaa', '2018-02-13', '10010', 'aa', null);
INSERT INTO `jxc_admin` VALUES ('3', '', '', '2001', '', 'aaaa', 'aaa', null, '保密', '', '', '', '', '', null);
INSERT INTO `jxc_admin` VALUES ('4', 'bbb', null, '2001', null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `jxc_admin` VALUES ('5', 'ccc', '111', '2001', 'ccc', 'ccc', 'ccc', '33', '女', '15236083001', '174871328@qq.com', '2018-02-26', '10010', 'ccc', null);
INSERT INTO `jxc_admin` VALUES ('6', 'ddd', null, '2001', null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `jxc_admin` VALUES ('7', 'eee', null, '2001', null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `jxc_admin` VALUES ('8', 'ffff', '', '2001', '', '', '', null, '保密', '', '', '', '', '', null);
INSERT INTO `jxc_admin` VALUES ('9', 'qqqq', null, '2001', null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `jxc_admin` VALUES ('10', 'ffff', '111', '2001', '222', '111', 'ccc', '22', '男', '111', '111', '2018-01-30', '10010', '410************', null);
INSERT INTO `jxc_admin` VALUES ('13', 'kkkk', null, '2001', null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `jxc_admin` VALUES ('14', 'llll', null, '2001', null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `jxc_admin` VALUES ('15', 'oooo', null, '2001', null, null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for `jxc_customer`
-- ----------------------------
DROP TABLE IF EXISTS `jxc_customer`;
CREATE TABLE `jxc_customer` (
  `customer_id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_name` varchar(20) DEFAULT NULL,
  `customer_iphone` varchar(20) DEFAULT NULL,
  `customer_email` varchar(20) DEFAULT NULL,
  `customer_address` varchar(20) DEFAULT NULL,
  `customer_desc` varchar(500) DEFAULT NULL,
  `customer_status` varchar(20) DEFAULT NULL,
  `customer_updater` varchar(20) DEFAULT NULL,
  `customer_updatetime` varchar(20) DEFAULT NULL,
  `customer_extends` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jxc_customer
-- ----------------------------
INSERT INTO `jxc_customer` VALUES ('1', 'a', '', '', '', 'a', '7001', '', '', '');
INSERT INTO `jxc_customer` VALUES ('2', 'rrr', 'rrr', 'rrr', 'rrr', 'rrr', '7001', 'rrr', 'rrr', 'rrr');
INSERT INTO `jxc_customer` VALUES ('5', 'a', '', '', '', 'a', '7001', '', '', '');
INSERT INTO `jxc_customer` VALUES ('6', '张三', '15236083001', 'zhangsan@qq.com', '河南省新乡市', '张三', '7000', '张三', '2018-04-11 22:41:17', '张三');
INSERT INTO `jxc_customer` VALUES ('7', 'aaa', '15236083001', 'aa@qq.com', '河南省新乡市', '张三', '7001', 'aa', '2018-04-11 22:17:18', 'qqq');
INSERT INTO `jxc_customer` VALUES ('8', '李四', '15236083001', 'lisi@qq.com', '河南省新乡市', 'aaa', '7000', '张三', '2018-04-12 11:00:00', 'lisi');

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
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jxc_datadictionary
-- ----------------------------
INSERT INTO `jxc_datadictionary` VALUES ('12', 'admin_type', 'admin_type', 'admin_type', '管理员类别');
INSERT INTO `jxc_datadictionary` VALUES ('13', 'goods_color', '颜色', '颜色', '颜色');
INSERT INTO `jxc_datadictionary` VALUES ('14', 'address', '地区', '地区', '地区');
INSERT INTO `jxc_datadictionary` VALUES ('15', 'sex', '性别', '性别', '性别');
INSERT INTO `jxc_datadictionary` VALUES ('16', 'employee_type', '员工类型', '员工类型', '员工类型');
INSERT INTO `jxc_datadictionary` VALUES ('17', 'warehouse_type', '仓库类型', '仓库类型', '仓库类型');
INSERT INTO `jxc_datadictionary` VALUES ('18', 'goods_type', '商品类型', '商品类型', '商品类型');

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
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jxc_dicdata
-- ----------------------------
INSERT INTO `jxc_dicdata` VALUES ('14', '高级管理员', 'admin_type', '高级管理员', '高级管理员');
INSERT INTO `jxc_dicdata` VALUES ('16', '红色', 'color', '红色', '红色');
INSERT INTO `jxc_dicdata` VALUES ('18', '蓝色', 'color', '蓝色', '蓝色');
INSERT INTO `jxc_dicdata` VALUES ('19', '河南省', 'address', '河南省', '河南省');
INSERT INTO `jxc_dicdata` VALUES ('20', '男', 'sex', '男', '男');
INSERT INTO `jxc_dicdata` VALUES ('24', '女', 'sex', '女', '女');
INSERT INTO `jxc_dicdata` VALUES ('25', '采购员', 'employee_type', '采购员', '采购员');
INSERT INTO `jxc_dicdata` VALUES ('26', '销售员', 'employee_type', '销售员', '销售员');
INSERT INTO `jxc_dicdata` VALUES ('27', '仓库员', 'employee_type', '仓库员', '仓库员');
INSERT INTO `jxc_dicdata` VALUES ('28', '电器类仓库', 'warehouse_type', '电器类仓库', '电器类仓库');
INSERT INTO `jxc_dicdata` VALUES ('29', '手机类仓库', 'warehouse_type', '手机类仓库', '手机类仓库');
INSERT INTO `jxc_dicdata` VALUES ('30', '食品类仓库', 'warehouse_type', '食品类仓库', '食品类仓库');
INSERT INTO `jxc_dicdata` VALUES ('31', '海鲜类仓库', 'warehouse_type', '海鲜类仓库', '海鲜类仓库');
INSERT INTO `jxc_dicdata` VALUES ('35', '一级管理员', 'admin_type', '一级管理员', '一级管理员');
INSERT INTO `jxc_dicdata` VALUES ('38', '手机类商品', 'goods_type', '手机类商品', '手机类商品');
INSERT INTO `jxc_dicdata` VALUES ('39', '电脑类商品', 'goods_type', '电脑类商品', '电脑类商品');
INSERT INTO `jxc_dicdata` VALUES ('40', '海鲜类商品', 'goods_type', '海鲜类商品', '海鲜类商品');
INSERT INTO `jxc_dicdata` VALUES ('41', '食品类商品', 'goods_type', '食品类商品', '食品类商品');
INSERT INTO `jxc_dicdata` VALUES ('42', '玩具类商品', 'goods_type', '玩具类商品', '玩具类商品');
INSERT INTO `jxc_dicdata` VALUES ('43', '饮料类商品', 'goods_type', '饮料类商品', '饮料类商品');
INSERT INTO `jxc_dicdata` VALUES ('44', '书本类商品', 'goods_type', '书本类商品', '书本类商品');
INSERT INTO `jxc_dicdata` VALUES ('45', '红色', 'goods_color', '红色', '红色');
INSERT INTO `jxc_dicdata` VALUES ('46', '绿色', 'goods_color', '绿色', '绿色');
INSERT INTO `jxc_dicdata` VALUES ('47', '白色', 'goods_color', '白色', '白色');
INSERT INTO `jxc_dicdata` VALUES ('48', '黑色', 'goods_color', '黑色', '黑色');
INSERT INTO `jxc_dicdata` VALUES ('49', '橙色', 'goods_color', '橙色', '橙色');

-- ----------------------------
-- Table structure for `jxc_employee`
-- ----------------------------
DROP TABLE IF EXISTS `jxc_employee`;
CREATE TABLE `jxc_employee` (
  `employee_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `employee_name` varchar(20) DEFAULT NULL,
  `employee_account` varchar(20) DEFAULT NULL,
  `employee_password` varchar(20) DEFAULT NULL,
  `employee_age` int(11) DEFAULT NULL,
  `employee_sex` varchar(20) DEFAULT NULL,
  `employee_birthday` varchar(20) DEFAULT NULL,
  `employee_address` varchar(20) DEFAULT NULL,
  `employee_status` varchar(20) DEFAULT NULL,
  `employee_code` varchar(20) DEFAULT NULL,
  `employee_cardNo` varchar(20) DEFAULT NULL,
  `employee_phone` varchar(20) DEFAULT NULL,
  `employee_email` varchar(20) DEFAULT NULL,
  `employee_type` varchar(20) DEFAULT NULL,
  `employee_updater` varchar(20) DEFAULT NULL,
  `employee_updatetime` varchar(20) DEFAULT NULL,
  `employee_extend` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`employee_id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `jxc_employee_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `jxc_role` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jxc_employee
-- ----------------------------
INSERT INTO `jxc_employee` VALUES ('1', '11', 'admin', 'admin', '123456', '22', '保密', '张三', '张三', '3000', '张三', '张三', '张三', '张三', '仓库管理者', null, null, '3000');
INSERT INTO `jxc_employee` VALUES ('4', '1', '', 'a', '123456', null, '保密', '', '', '3001', '', '', '', '小鱼', '', null, null, '1000');
INSERT INTO `jxc_employee` VALUES ('5', '7', '小鱼', '小鱼', null, null, '保密', '小鱼', '小鱼', '3000', '小鱼', '小鱼', '小鱼', '小鱼', '小鱼', null, null, '9000');
INSERT INTO `jxc_employee` VALUES ('9', '6', '', 'g', '123456', null, '保密', '', '', '3001', '', '', '', '小鱼', '', null, null, '7000');
INSERT INTO `jxc_employee` VALUES ('11', '4', '', 'aaa', '123456', null, '保密', '', '', '3001', '', '', '', '小鱼', '', null, null, '2000');
INSERT INTO `jxc_employee` VALUES ('12', '1', '', 'a', '123456', null, '保密', '', '', '3001', '', '', '', '小鱼', '', null, null, '4000');
INSERT INTO `jxc_employee` VALUES ('13', '5', '', 'a', '123456', null, '保密', '', '', '3001', '', '', '', '小鱼', '', null, null, '5000');
INSERT INTO `jxc_employee` VALUES ('14', '1', '', 'a', '123456', null, '保密', '', '', '3001', '', '', '', '小鱼', '', null, null, '3000');
INSERT INTO `jxc_employee` VALUES ('15', '8', '李四', '李四', '123456', '22', '保密', '2018-03-22', '李四', '3000', '李四', '李四', '李四', '李四', '仓库管理者', null, null, '1000');
INSERT INTO `jxc_employee` VALUES ('16', '8', '王五', '王五', '123456', '22', '保密', '2018-03-14', '王五', '3000', '', '王五', '王五', '王五', '仓库管理者', null, null, '3000');
INSERT INTO `jxc_employee` VALUES ('17', '9', '别先生', '别先生', '123456', '22', '男', '2018-02-27', 'a', '3000', 'aa', 'a', 'a', 'a', null, null, null, '1000');
INSERT INTO `jxc_employee` VALUES ('18', '10', '庄周', '庄周', '123456', '22', '保密', '2018-03-15', '河南省郑州市', '3000', '庄周庄周庄周', '410725199304162874', '15236083001', 'biehl@koal.com', null, null, null, '3000');

-- ----------------------------
-- Table structure for `jxc_employee_warehouse`
-- ----------------------------
DROP TABLE IF EXISTS `jxc_employee_warehouse`;
CREATE TABLE `jxc_employee_warehouse` (
  `employee_id` int(11) DEFAULT NULL,
  `warehouse_id` int(11) DEFAULT NULL,
  KEY `employee_id` (`employee_id`),
  KEY `warehouse_id` (`warehouse_id`),
  CONSTRAINT `jxc_employee_warehouse_ibfk_1` FOREIGN KEY (`employee_id`) REFERENCES `jxc_employee` (`employee_id`),
  CONSTRAINT `jxc_employee_warehouse_ibfk_2` FOREIGN KEY (`warehouse_id`) REFERENCES `jxc_warehouse` (`warehouse_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jxc_employee_warehouse
-- ----------------------------

-- ----------------------------
-- Table structure for `jxc_financialstatement`
-- ----------------------------
DROP TABLE IF EXISTS `jxc_financialstatement`;
CREATE TABLE `jxc_financialstatement` (
  `financialstatement_id` int(11) NOT NULL AUTO_INCREMENT,
  `supplier_id` int(11) DEFAULT NULL,
  `financialstatement_date` varchar(255) DEFAULT NULL,
  `financialstatement_status` varchar(255) DEFAULT NULL,
  `financialstatement_extend` varchar(255) DEFAULT NULL,
  `financialstatement_update` varchar(255) DEFAULT NULL,
  `financialstatement_updatetime` varchar(255) DEFAULT NULL,
  `financialstatement_shouldpay` decimal(10,0) DEFAULT NULL,
  `financialstatement_actualpay` decimal(10,0) DEFAULT NULL,
  `financialstatement_discountmoney` decimal(10,0) DEFAULT NULL,
  `financialstatement_remark` varchar(255) DEFAULT NULL,
  `financialstatement_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`financialstatement_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jxc_financialstatement
-- ----------------------------

-- ----------------------------
-- Table structure for `jxc_goods`
-- ----------------------------
DROP TABLE IF EXISTS `jxc_goods`;
CREATE TABLE `jxc_goods` (
  `goods_id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_name` varchar(20) DEFAULT NULL,
  `goods_code` varchar(20) DEFAULT NULL,
  `goods_type` varchar(20) DEFAULT NULL,
  `goods_brand` varchar(20) DEFAULT NULL,
  `goods_color` varchar(20) DEFAULT NULL,
  `goods_specifications` varchar(20) DEFAULT NULL,
  `goods_picture` varchar(5000) DEFAULT NULL,
  `goods_material` varchar(20) DEFAULT NULL,
  `goods_buyPrice` double(10,0) DEFAULT NULL,
  `goods_salePrice` double(10,0) DEFAULT NULL,
  `goods_model` varchar(20) DEFAULT NULL,
  `goods_desc` varchar(500) DEFAULT NULL,
  `goods_updater` varchar(20) DEFAULT NULL,
  `goods_updatetime` varchar(20) DEFAULT NULL,
  `goods_status` varchar(20) DEFAULT NULL,
  `goods_extend` varchar(20) DEFAULT NULL,
  `goods_producer` varchar(20) DEFAULT NULL,
  `goods_lowerlimit` int(11) DEFAULT NULL,
  PRIMARY KEY (`goods_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jxc_goods
-- ----------------------------
INSERT INTO `jxc_goods` VALUES ('1', 'aa', '', '', '', '', '', '', '', null, null, '', 'aa', '', '', '5001', '', '', null);
INSERT INTO `jxc_goods` VALUES ('2', '小米平板', '小米平板', '小米平板', '小米平板', '小米平板', '小米平板', '小米平板', '小米平板', '699', '999', '小米平板', '小米平板', '小米平板', '小米平板', '5001', '小米平板', '小米平板', '100');
INSERT INTO `jxc_goods` VALUES ('3', '小米电脑', '小米电脑', '小米电脑', '小米电脑', '小米电脑', '小米电脑', '小米电脑', '小米电脑', '699', '999', '小米电脑', '小米电脑', '小米电脑', '小米电脑', '小米电脑', '小米电脑', '小米电脑', '100');
INSERT INTO `jxc_goods` VALUES ('4', '小米平板', '小米电扇', '手机类商品', '小米电扇', '绿色', '小米电扇', '小米电扇', '小米电扇', '699', '999', '小米电扇', '小米电扇', '小米电扇', '小米电扇', '5000', '小米电扇', '小米电扇', '100');
INSERT INTO `jxc_goods` VALUES ('5', '小米电扇', '小米电扇小米电扇', '电脑类商品', '小米电扇小米电扇', '红色', '小米电扇', '小米电扇', '小米电扇', '22', '22', '小米电扇', '小米电扇', '小米电扇', '2018-03-15 16:55:46', '5000', '22', '小米电扇', '100');
INSERT INTO `jxc_goods` VALUES ('6', '小米电脑', '小米电脑小米电脑', '电脑类商品', '小米电脑', '红色', '小米电脑', '小米电脑', '小米电扇', '22', '999', '小米电脑', '小米电脑', '小米电脑', '2018-03-15 16:25:47', '5000', '22', '小米电脑', '22');

-- ----------------------------
-- Table structure for `jxc_log`
-- ----------------------------
DROP TABLE IF EXISTS `jxc_log`;
CREATE TABLE `jxc_log` (
  `log_id` int(11) NOT NULL AUTO_INCREMENT,
  `log_name` varchar(20) DEFAULT NULL,
  `log_content` text,
  `log_time` datetime DEFAULT NULL,
  `log_status` varchar(20) DEFAULT NULL,
  `log_extend` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jxc_log
-- ----------------------------

-- ----------------------------
-- Table structure for `jxc_menu`
-- ----------------------------
DROP TABLE IF EXISTS `jxc_menu`;
CREATE TABLE `jxc_menu` (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_name` varchar(20) DEFAULT NULL,
  `menu_upId` varchar(20) DEFAULT NULL,
  `menu_path` varchar(20) DEFAULT NULL,
  `menu_status` varchar(20) DEFAULT NULL,
  `menu_isLeaf` varchar(20) DEFAULT NULL,
  `menu_updater` varchar(20) DEFAULT NULL,
  `menu_updatetime` varchar(0) DEFAULT NULL,
  `menu_extend` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jxc_menu
-- ----------------------------
INSERT INTO `jxc_menu` VALUES ('1', 'aaaa', 'aaaa', 'admin/list', '9000', 'no', null, null, null);
INSERT INTO `jxc_menu` VALUES ('2', 'aaaa', 'aaaa', 'admin/list', '9001', 'yes', null, null, null);
INSERT INTO `jxc_menu` VALUES ('3', 'aaaa', 'aaaa', 'admin/list', '9000', 'no', null, null, null);
INSERT INTO `jxc_menu` VALUES ('4', 'qqq', 'qqqq', 'qqq', '9000', 'yes', null, null, null);
INSERT INTO `jxc_menu` VALUES ('7', 'tt', 'ttt', 'tt', '9000', 'no', null, null, null);
INSERT INTO `jxc_menu` VALUES ('8', 'yyy', 'yyyy', 'yyy', '9000', 'no', null, null, null);
INSERT INTO `jxc_menu` VALUES ('9', 'ddddddddd', 'ddd', 'ddd', '9000', 'yes', null, null, null);

-- ----------------------------
-- Table structure for `jxc_menu_role`
-- ----------------------------
DROP TABLE IF EXISTS `jxc_menu_role`;
CREATE TABLE `jxc_menu_role` (
  `menu_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  KEY `menu_id` (`menu_id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `jxc_menu_role_ibfk_1` FOREIGN KEY (`menu_id`) REFERENCES `jxc_menu` (`menu_id`),
  CONSTRAINT `jxc_menu_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `jxc_role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jxc_menu_role
-- ----------------------------

-- ----------------------------
-- Table structure for `jxc_purchaseorder`
-- ----------------------------
DROP TABLE IF EXISTS `jxc_purchaseorder`;
CREATE TABLE `jxc_purchaseorder` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_id` int(11) DEFAULT NULL,
  `goods_id` int(11) DEFAULT NULL,
  `warehouse_id` int(11) DEFAULT NULL,
  `supplier_id` int(11) DEFAULT NULL,
  `order_code` varchar(20) DEFAULT NULL,
  `order_number` int(11) DEFAULT NULL,
  `order_price` decimal(5,2) DEFAULT NULL,
  `order_tolePrice` decimal(5,2) DEFAULT NULL,
  `order_status` varchar(20) DEFAULT NULL,
  `order_checkMan` varchar(20) DEFAULT NULL,
  `order_checkResult` varchar(20) DEFAULT NULL,
  `order_checkStatus` varchar(20) DEFAULT NULL,
  `order_desc` varchar(200) DEFAULT NULL,
  `order_updater` varchar(20) DEFAULT NULL,
  `order_updatetime` varchar(20) DEFAULT NULL,
  `order_type` varchar(20) DEFAULT NULL,
  `order_storageTime` varchar(20) DEFAULT NULL,
  `order_createTime` varchar(20) DEFAULT NULL,
  `order_extends` varchar(20) DEFAULT NULL,
  `order_shouldPay` varchar(20) DEFAULT NULL,
  `order_actualPayment` varchar(20) DEFAULT NULL,
  `order_arrears` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `FK_Reference_10` (`supplier_id`),
  KEY `FK_Reference_3` (`employee_id`),
  KEY `FK_Reference_4` (`warehouse_id`),
  KEY `goods_id` (`goods_id`),
  CONSTRAINT `FK_Reference_10` FOREIGN KEY (`supplier_id`) REFERENCES `jxc_supplier` (`supplier_id`),
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`employee_id`) REFERENCES `jxc_employee` (`employee_id`),
  CONSTRAINT `FK_Reference_4` FOREIGN KEY (`warehouse_id`) REFERENCES `jxc_warehouse` (`warehouse_id`),
  CONSTRAINT `jxc_purchaseorder_ibfk_1` FOREIGN KEY (`goods_id`) REFERENCES `jxc_goods` (`goods_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jxc_purchaseorder
-- ----------------------------
INSERT INTO `jxc_purchaseorder` VALUES ('1', '16', '4', '1', '1', 'çµå¨ç±»', '0', null, null, '1001', null, null, null, null, null, null, null, null, '2018-03-15 15:24:24', 'çµæ', null, null, null);
INSERT INTO `jxc_purchaseorder` VALUES ('2', '16', '5', '1', '1', 'çµå¨ç±»', '13', null, null, '1001', null, null, null, null, null, null, null, null, '2018-03-15 16:12:48', 'çµæ', null, null, null);
INSERT INTO `jxc_purchaseorder` VALUES ('3', '15', '3', '6', '2', 'çµå¨ç±»', '36', null, null, '1001', null, null, null, null, null, null, null, null, '2018-03-15 16:37:48', 'çµæ', null, null, null);
INSERT INTO `jxc_purchaseorder` VALUES ('4', '17', '3', '6', '2', 'çµå¨ç±»', '22', null, null, '1001', null, null, null, null, null, null, null, null, '2018-03-15 16:34:53', 'çµæ', null, null, null);
INSERT INTO `jxc_purchaseorder` VALUES ('5', '16', '5', '6', '3', 'çµå¨ç±»', '44', null, null, '1001', null, null, null, null, null, null, null, null, '2018-03-15 17:53:01', 'çµå¨ç±»', null, null, null);
INSERT INTO `jxc_purchaseorder` VALUES ('6', '17', '1', '1', '1', 'çµå¨ç±»', '22', null, null, '1001', null, null, null, null, null, null, null, null, '2018-03-15 17:40:04', 'çµæ', null, null, null);
INSERT INTO `jxc_purchaseorder` VALUES ('7', '18', '1', '1', '1', 'çµæ', '22', null, null, '1001', null, null, null, null, null, null, null, null, '2018-04-11 20:59:53', 'çµæ', null, null, null);
INSERT INTO `jxc_purchaseorder` VALUES ('8', '18', '1', '1', '1', 'çµå¨ç±»', '33', null, null, '1001', null, null, null, null, null, null, null, null, '2018-04-11 20:51:55', 'çµå¨ç±»', null, null, null);
INSERT INTO `jxc_purchaseorder` VALUES ('9', '18', '5', '1', '1', 'çµå¨ç±»', '22', null, null, '1001', null, null, null, null, null, null, null, null, '2018-04-11 21:43:01', 'çµæ', null, null, null);
INSERT INTO `jxc_purchaseorder` VALUES ('10', '18', '5', '7', '3', '111111111', '33', null, null, '1001', null, null, null, null, null, null, null, null, '2018-04-11 21:40:17', '1111', null, null, null);

-- ----------------------------
-- Table structure for `jxc_purchaseorderdetail`
-- ----------------------------
DROP TABLE IF EXISTS `jxc_purchaseorderdetail`;
CREATE TABLE `jxc_purchaseorderdetail` (
  `orderdetail_id` int(11) NOT NULL AUTO_INCREMENT,
  `good_id` int(11) DEFAULT NULL,
  `order_id` int(11) DEFAULT NULL,
  `orderdetail_number` int(11) DEFAULT NULL,
  `orderdetail_buyprice` decimal(10,0) DEFAULT NULL,
  `orderdetail_totalprice` decimal(10,0) DEFAULT NULL,
  `orderdetail_status` varchar(255) DEFAULT NULL,
  `orderdetail_extend` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`orderdetail_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jxc_purchaseorderdetail
-- ----------------------------

-- ----------------------------
-- Table structure for `jxc_returnorder`
-- ----------------------------
DROP TABLE IF EXISTS `jxc_returnorder`;
CREATE TABLE `jxc_returnorder` (
  `returnorder_id` int(11) NOT NULL AUTO_INCREMENT,
  `returnorder_date` varchar(255) DEFAULT NULL,
  `returnorder_shouldmoney` decimal(10,0) DEFAULT NULL,
  `returnorder_actualmoney` decimal(10,0) DEFAULT NULL,
  `returnorder_status` varchar(255) DEFAULT NULL,
  `returnorder_extend` varchar(255) DEFAULT NULL,
  `returnorder_desc` varchar(255) DEFAULT NULL,
  `returnorder_update` varchar(255) DEFAULT NULL,
  `returnorder_updatetime` varchar(255) DEFAULT NULL,
  `supplier_id` int(11) DEFAULT NULL,
  `warehouse_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`returnorder_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jxc_returnorder
-- ----------------------------

-- ----------------------------
-- Table structure for `jxc_returnorderdetail`
-- ----------------------------
DROP TABLE IF EXISTS `jxc_returnorderdetail`;
CREATE TABLE `jxc_returnorderdetail` (
  `returnorderdetail_id` int(11) DEFAULT NULL,
  `good_id` int(11) DEFAULT NULL,
  `returnorderdetail_singleprice` decimal(10,0) DEFAULT NULL,
  `returnorderdetail_totalprice` decimal(10,0) DEFAULT NULL,
  `returnorderdetail_status` varchar(255) DEFAULT NULL,
  `returnorderdetail_extend` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jxc_returnorderdetail
-- ----------------------------

-- ----------------------------
-- Table structure for `jxc_role`
-- ----------------------------
DROP TABLE IF EXISTS `jxc_role`;
CREATE TABLE `jxc_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(20) DEFAULT NULL,
  `role_code` varchar(20) DEFAULT NULL,
  `role_desc` varchar(500) DEFAULT NULL,
  `role_status` varchar(20) DEFAULT NULL,
  `role_updater` varchar(20) DEFAULT NULL,
  `role_updatetime` varchar(20) DEFAULT NULL,
  `role_extend` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jxc_role
-- ----------------------------
INSERT INTO `jxc_role` VALUES ('1', 'aaa', 'aaaa', 'aaa', '4001', 'aa', '2018-02-06', 'aaa');
INSERT INTO `jxc_role` VALUES ('4', '2级经销商', '2级经销商', '2级经销商', '4001', '2级经销商', '2018-01-30', '2级经销商');
INSERT INTO `jxc_role` VALUES ('5', '一级经销商', '一级经销商', '一级经销商', '4001', '一级经销商', '2018-02-05', '一级经销商');
INSERT INTO `jxc_role` VALUES ('6', 'aa', '', 'aa', '4001', '', '', '');
INSERT INTO `jxc_role` VALUES ('7', '吖吖', '', '', '4001', '', '', '');
INSERT INTO `jxc_role` VALUES ('8', '仓库管理员', '仓库管理者', '仓库管理者', '4000', '仓库管理者', '2018-03-08', '仓库管理者');
INSERT INTO `jxc_role` VALUES ('9', '销售管理员', '销售管理员', '销售管理员', '4000', '销售管理员', '2018-03-08', '销售管理员');
INSERT INTO `jxc_role` VALUES ('10', '采购管理员', '采购管理员', '采购管理员', '4000', '采购管理员', '2018-03-01', '采购管理员');
INSERT INTO `jxc_role` VALUES ('11', '高级管理员', '666666', '高级管理员', '4000', '高级管理员', '2018-03-16 13:41:14', '高级管理员');
INSERT INTO `jxc_role` VALUES ('12', '一级管理员', '666666', '一级管理员', '4000', '666666', '2018-03-19 16:51:04', '一级管理员');

-- ----------------------------
-- Table structure for `jxc_role_employee`
-- ----------------------------
DROP TABLE IF EXISTS `jxc_role_employee`;
CREATE TABLE `jxc_role_employee` (
  `role_id` int(11) DEFAULT NULL,
  `employee_id` int(11) DEFAULT NULL,
  KEY `role_id` (`role_id`),
  KEY `employee_id` (`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jxc_role_employee
-- ----------------------------

-- ----------------------------
-- Table structure for `jxc_salesorder`
-- ----------------------------
DROP TABLE IF EXISTS `jxc_salesorder`;
CREATE TABLE `jxc_salesorder` (
  `salesOrder_id` int(11) NOT NULL AUTO_INCREMENT,
  `supplier_id` int(11) DEFAULT NULL,
  `employee_id` int(11) DEFAULT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `warehouse_id` int(11) DEFAULT NULL,
  `goods_id` int(11) DEFAULT NULL,
  `salesOrder_num` int(11) DEFAULT NULL,
  `salesOrder_code` varchar(20) DEFAULT NULL,
  `salesOrder_price` decimal(5,2) DEFAULT NULL,
  `salesOrder_totalPrice` decimal(5,2) DEFAULT NULL,
  `salesOrder_desc` varchar(500) DEFAULT NULL,
  `salesOrder_status` varchar(20) DEFAULT NULL,
  `salesOrder_extends` varchar(20) DEFAULT NULL,
  `salesOrder_checkStatus` varchar(20) DEFAULT NULL,
  `salesOrder_checkMan` varchar(20) DEFAULT NULL,
  `salesOrder_result` varchar(20) DEFAULT NULL,
  `salesOrder_type` varchar(20) DEFAULT NULL,
  `salesOrder_updater` varchar(20) DEFAULT NULL,
  `salesOrder_updatetime` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`salesOrder_id`),
  KEY `FK_Reference_6` (`customer_id`),
  KEY `FK_Reference_7` (`warehouse_id`),
  KEY `FK_Reference_8` (`goods_id`),
  KEY `supplier_id` (`supplier_id`),
  KEY `employee_id` (`employee_id`),
  CONSTRAINT `FK_Reference_6` FOREIGN KEY (`customer_id`) REFERENCES `jxc_customer` (`customer_id`),
  CONSTRAINT `FK_Reference_7` FOREIGN KEY (`warehouse_id`) REFERENCES `jxc_warehouse` (`warehouse_id`),
  CONSTRAINT `FK_Reference_8` FOREIGN KEY (`goods_id`) REFERENCES `jxc_goods` (`goods_id`),
  CONSTRAINT `jxc_salesorder_ibfk_1` FOREIGN KEY (`supplier_id`) REFERENCES `jxc_supplier` (`supplier_id`),
  CONSTRAINT `jxc_salesorder_ibfk_2` FOREIGN KEY (`employee_id`) REFERENCES `jxc_employee` (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jxc_salesorder
-- ----------------------------
INSERT INTO `jxc_salesorder` VALUES ('1', '1', '16', '6', '1', '5', null, null, null, null, null, '500', null, null, null, null, null, null, null);
INSERT INTO `jxc_salesorder` VALUES ('2', '1', '16', '6', '1', '5', null, null, null, null, null, '500', null, null, null, null, null, null, null);
INSERT INTO `jxc_salesorder` VALUES ('3', '2', '15', '8', '6', '3', null, null, null, null, null, '501', null, null, null, null, null, null, null);
INSERT INTO `jxc_salesorder` VALUES ('4', '2', '15', '6', '6', '3', null, null, null, null, null, '501', null, null, null, null, null, null, null);
INSERT INTO `jxc_salesorder` VALUES ('5', '2', '15', '8', '6', '3', null, null, null, null, null, '501', null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for `jxc_stock`
-- ----------------------------
DROP TABLE IF EXISTS `jxc_stock`;
CREATE TABLE `jxc_stock` (
  `stock_id` int(11) NOT NULL AUTO_INCREMENT,
  `warehouse_id` int(11) DEFAULT NULL,
  `goods_id` int(11) DEFAULT NULL,
  `stock_code` varchar(20) DEFAULT NULL,
  `stock_allowance` int(11) DEFAULT NULL,
  `stock_saleCount` int(11) DEFAULT NULL,
  `stock_buyPrice` decimal(5,2) DEFAULT NULL,
  `stock_salePrice` decimal(5,2) DEFAULT NULL,
  `stock_upBuyPrice` decimal(5,2) DEFAULT NULL,
  `stock_avgBuyPrice` decimal(5,2) DEFAULT NULL,
  `stock_cost` decimal(5,2) DEFAULT NULL,
  `stock_totalCost` decimal(5,2) DEFAULT NULL,
  `stock_updater` varchar(20) DEFAULT NULL,
  `stock_updatetime` datetime DEFAULT NULL,
  `stock_status` varchar(20) DEFAULT NULL,
  `stock_extends` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`stock_id`),
  KEY `FK_Reference_11` (`goods_id`),
  KEY `FK_Reference_9` (`warehouse_id`),
  CONSTRAINT `FK_Reference_11` FOREIGN KEY (`goods_id`) REFERENCES `jxc_goods` (`goods_id`),
  CONSTRAINT `FK_Reference_9` FOREIGN KEY (`warehouse_id`) REFERENCES `jxc_warehouse` (`warehouse_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jxc_stock
-- ----------------------------

-- ----------------------------
-- Table structure for `jxc_supplier`
-- ----------------------------
DROP TABLE IF EXISTS `jxc_supplier`;
CREATE TABLE `jxc_supplier` (
  `supplier_id` int(11) NOT NULL AUTO_INCREMENT,
  `supplier_name` varchar(20) DEFAULT NULL,
  `supplier_ipone` varchar(20) DEFAULT NULL,
  `supplier_address` varchar(20) DEFAULT NULL,
  `supplier_email` varchar(20) DEFAULT NULL,
  `supplier_status` varchar(20) DEFAULT NULL,
  `supplier_extends` varchar(20) DEFAULT NULL,
  `supplier_updater` varchar(20) DEFAULT NULL,
  `supplier_updatetime` varchar(20) DEFAULT NULL,
  `supplier_type` varchar(20) DEFAULT NULL,
  `supplier_remark` varchar(20) DEFAULT NULL,
  `supplier_account` varchar(20) DEFAULT NULL,
  `supplier_password` varchar(20) DEFAULT NULL,
  `supplier_startpay` varchar(20) DEFAULT NULL,
  `supplier_endpay` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`supplier_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jxc_supplier
-- ----------------------------
INSERT INTO `jxc_supplier` VALUES ('1', '王五', '', '', 'admin', '6000', '', '', '李四', '李四', '', '李四', '123456', null, null);
INSERT INTO `jxc_supplier` VALUES ('2', '李四', '', '', 'admin', '6000', '', '', '', '李四', '', '李四', '123456', null, null);
INSERT INTO `jxc_supplier` VALUES ('3', '张三', '', '', '', '6000', '', '', '', '张三', '', '张三', '123456', null, null);

-- ----------------------------
-- Table structure for `jxc_warehouse`
-- ----------------------------
DROP TABLE IF EXISTS `jxc_warehouse`;
CREATE TABLE `jxc_warehouse` (
  `warehouse_id` int(11) NOT NULL AUTO_INCREMENT,
  `warehouse_name` varchar(20) DEFAULT NULL,
  `warehouse_code` varchar(20) DEFAULT NULL,
  `warehouse_address` varchar(20) DEFAULT NULL,
  `warehouse_desc` varchar(20) DEFAULT NULL,
  `warehouse_updater` varchar(20) DEFAULT NULL,
  `warehouse_updatetime` varchar(20) DEFAULT NULL,
  `warehouse_status` varchar(20) DEFAULT NULL,
  `warehouse_extends` varchar(20) DEFAULT NULL,
  `warehouse_personLiable` varchar(20) DEFAULT NULL,
  `warehouse_type` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`warehouse_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jxc_warehouse
-- ----------------------------
INSERT INTO `jxc_warehouse` VALUES ('1', '智能手机仓库', '智能手机仓库', '智能手机仓库', '智能手机仓库', '智能手机仓库', '2018-03-08', '8000', '智能手机仓库', '王五', '手机类仓库');
INSERT INTO `jxc_warehouse` VALUES ('2', 'a', '', '', 'a', '', '', '8001', '', '', '');
INSERT INTO `jxc_warehouse` VALUES ('6', '电器类仓库', '电器类仓库', '电器类仓库', '电器类仓库', '电器类仓库', '2018-03-08', '8000', '电器类仓库', '张三', '电器类仓库');
INSERT INTO `jxc_warehouse` VALUES ('7', '食品类仓库', '食品类仓库', '食品类仓库', '食品类仓库', '食品类仓库', '2018-03-08', '8000', '食品类仓库', '王五', '食品类仓库');
INSERT INTO `jxc_warehouse` VALUES ('8', 'aa', 'aaa', 'aa', 'aaa', 'aaa', '2018-04-11', '8001', 'aa', 'admin', '电器类仓库');
