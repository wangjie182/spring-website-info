/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80016
Source Host           : localhost:3306
Source Database       : spider

Target Server Type    : MYSQL
Target Server Version : 80016
File Encoding         : 65001

Date: 2019-09-16 16:45:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for website
-- ----------------------------
DROP TABLE IF EXISTS `website`;
CREATE TABLE `website` (
  `websiteid` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `companyName` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '公司名',
  `companyAddr` text CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '公司地址',
  `companyInfo` text CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '公司信息',
  `jobInfo` text CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '岗位职责',  
  `JobAddr` text CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '工作地址',
  `jobName` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '职位名称',
  `salary` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '工资',
  PRIMARY KEY (`websiteid`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='爬取站长之家的网站信息		';
