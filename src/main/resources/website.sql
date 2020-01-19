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
  `websiteid` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '����',
  `companyName` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '��˾��',
  `companyAddr` text CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '��˾��ַ',
  `companyInfo` text CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '��˾��Ϣ',
  `jobInfo` text CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '��λְ��',  
  `JobAddr` text CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '������ַ',
  `jobName` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT 'ְλ����',
  `salary` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '����',
  PRIMARY KEY (`websiteid`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='��ȡվ��֮�ҵ���վ��Ϣ		';
