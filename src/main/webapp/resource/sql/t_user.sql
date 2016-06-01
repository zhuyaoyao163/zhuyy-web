/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : plusoft_test

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2016-06-01 18:12:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `login_name` varchar(50) DEFAULT NULL COMMENT '帐号',
  `pass_word` varchar(50) DEFAULT NULL COMMENT '密码',
  `name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `age` int(11) DEFAULT NULL COMMENT '年龄(number)',
  `birthday` datetime DEFAULT NULL COMMENT '生日(datetime)',
  `dept_id` varchar(50) DEFAULT NULL COMMENT '部门(combobox)',
  `position` varchar(50) DEFAULT NULL COMMENT '职位(combobox)',
  `gender` int(11) DEFAULT NULL COMMENT '性别：1男；2女',
  `married` int(11) DEFAULT NULL COMMENT '0未婚；1已婚',
  `salary` varchar(20) DEFAULT NULL COMMENT '薪资',
  `educational` varchar(20) DEFAULT NULL COMMENT '学历',
  `country` varchar(20) DEFAULT NULL COMMENT '国家',
  `city` varchar(20) DEFAULT NULL COMMENT '城市',
  `remarks` varchar(2000) DEFAULT NULL COMMENT '备注',
  `school` varchar(20) DEFAULT NULL COMMENT '毕业学校',
  `createtime` datetime DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='InnoDB free: 6144 kB; InnoDB free: 7168 kB; InnoDB free: 7168 kB';

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'zm@163.com', '123', '张明', '27', '1983-01-13 00:00:00', 'cw', 'cw2', '1', '0', '3839', '2', '', '', '爱好足球', '贵州财经大学', '2012-01-31 10:50:12', 'zm@163.com');
INSERT INTO `t_user` VALUES ('2', 'sww@163.com', '123', '宋蔚伟', '25', '1987-01-21 00:00:00', 'sc', 'sc3', '1', '0', '3681', '2', '', '', '爱好篮球', '天津科技大学', '2012-01-31 10:53:35', 'sww@163.com');
INSERT INTO `t_user` VALUES ('3', 'cyj@163.com', '123', '陈英杰', '25', '1987-01-21 00:00:00', 'sc', 'sc3', '1', '0', '3681', '2', '', '', '', '南京审计学院', '2012-01-31 10:53:55', 'cyj@qq.com');
INSERT INTO `t_user` VALUES ('4', 'zw@hotmail.com', '123', '张伟', '31', '1981-01-14 00:00:00', 'rs', 'rs2', '1', '1', '4760', '2', '', '', '', '南京工业大学', '2012-01-31 11:04:18', 'zw@hotmail.com');
