/*
MySQL Data Transfer
Source Host: localhost
Source Database: test
Target Host: localhost
Target Database: test
Date: 2014/1/7 13:49:46
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for c_rec_card
-- ----------------------------
DROP TABLE IF EXISTS `c_rec_card`;
CREATE TABLE `c_rec_card` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(255) NOT NULL,
  `sex` varchar(255) NOT NULL,
  `phone` varchar(255) default NULL,
  `email` varchar(255) default NULL,
  `address` varchar(255) default NULL,
  `userId` int(11) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=64 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `c_rec_card` VALUES ('47', '123', '男', '', '', '', '0');
INSERT INTO `c_rec_card` VALUES ('35', '13', '男', '', '', '', '2');
INSERT INTO `c_rec_card` VALUES ('34', '11', '男', '', '', '', '2');
INSERT INTO `c_rec_card` VALUES ('62', '李天祎', '女', '18653814817', 'noclyt@yeah.com', '山东省菏泽市', '1');
INSERT INTO `c_rec_card` VALUES ('61', '陈阳', '男', '18764881031', 'cy@163.com', '山东省滕州市', '1');
INSERT INTO `c_rec_card` VALUES ('42', '石头', '男', '18763899999', 'st@163.com', '美国', '0');
INSERT INTO `c_rec_card` VALUES ('60', '侯承尚', '男', '18763897269', 'houchengshang@gmail.com', '山东省枣庄市', '1');
INSERT INTO `c_rec_card` VALUES ('59', '徐逸群', '男', '18764889999', 'xyq11@qq.com', '江苏省淮安市', '1');
INSERT INTO `c_rec_card` VALUES ('63', '李岚鹏', '男', '15888520909', 'lyp@163.com', '山东省济宁市', '1');
