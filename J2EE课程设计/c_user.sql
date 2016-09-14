/*
MySQL Data Transfer
Source Host: localhost
Source Database: test
Target Host: localhost
Target Database: test
Date: 2014/1/7 13:49:53
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for c_user
-- ----------------------------
DROP TABLE IF EXISTS `c_user`;
CREATE TABLE `c_user` (
  `id` int(11) NOT NULL auto_increment,
  `userName` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `c_user` VALUES ('1', 'admin', 'admin');
INSERT INTO `c_user` VALUES ('8', 'e', '');
INSERT INTO `c_user` VALUES ('2', 'test', '123');
INSERT INTO `c_user` VALUES ('3', 't1', '123');
INSERT INTO `c_user` VALUES ('4', 't2', '123');
INSERT INTO `c_user` VALUES ('5', '1', '1');
INSERT INTO `c_user` VALUES ('9', 'test2', '123');
INSERT INTO `c_user` VALUES ('10', 'test3', '123');
INSERT INTO `c_user` VALUES ('11', 'test4', '123');
INSERT INTO `c_user` VALUES ('12', 't3', '123');
INSERT INTO `c_user` VALUES ('13', 't4', '123');
