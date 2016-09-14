/*
MySQL Data Transfer
Source Host: localhost
Source Database: test
Target Host: localhost
Target Database: test
Date: 2014/1/7 13:49:40
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for c_card
-- ----------------------------
DROP TABLE IF EXISTS `c_card`;
CREATE TABLE `c_card` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(255) NOT NULL,
  `sex` varchar(255) NOT NULL,
  `phone` varchar(255) default NULL,
  `email` varchar(255) default NULL,
  `address` varchar(255) default NULL,
  `userId` int(11) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=58 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `c_card` VALUES ('33', '12', '男', '', '', '', '2');
INSERT INTO `c_card` VALUES ('31', '4', '男', '', '', '', '2');
INSERT INTO `c_card` VALUES ('32', '1', '男', '', '', '', '2');
