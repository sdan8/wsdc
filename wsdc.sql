/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50611
Source Host           : localhost:3306
Source Database       : wsdc

Target Server Type    : MYSQL
Target Server Version : 50611
File Encoding         : 65001

*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tb_introduce`
-- ----------------------------
DROP TABLE IF EXISTS `tb_introduce`;
CREATE TABLE `tb_introduce` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `content` varchar(255) NOT NULL DEFAULT '' COMMENT '商家介绍信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='商家介绍';


-- ----------------------------
-- Table structure for `tb_menu`
-- ----------------------------
DROP TABLE IF EXISTS `tb_menu`;
CREATE TABLE `tb_menu` (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `menu_name` varchar(50) NOT NULL DEFAULT '' COMMENT '菜单名',
  `menu_content` varchar(50) NOT NULL DEFAULT '' COMMENT '菜单简介',
  `menu_price` double(5,2) NOT NULL DEFAULT '0.00' COMMENT '菜单单价',
  `menu_image` varchar(255) DEFAULT NULL COMMENT '菜单图片名称',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='菜单表';



-- ----------------------------
-- Table structure for `tb_menu_top`
-- ----------------------------
DROP TABLE IF EXISTS `tb_menu_top`;
CREATE TABLE `tb_menu_top` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_id` int(11) NOT NULL DEFAULT '0' COMMENT '菜单ID，参考菜单表',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='推荐的菜品';



-- ----------------------------
-- Table structure for `tb_message`
-- ----------------------------
DROP TABLE IF EXISTS `tb_message`;
CREATE TABLE `tb_message` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '留言ID',
  `user_id` int(11) NOT NULL DEFAULT '0' COMMENT '用户ID，参照用户表',
  `menu_id` int(11) NOT NULL DEFAULT '0' COMMENT '菜品ID，参照菜单表',
  `content` varchar(200) DEFAULT NULL COMMENT '内容',
  `mg_date` varchar(45) DEFAULT NULL COMMENT '留言时间',
  PRIMARY KEY (`id`),
  KEY `foreign_key_msg_userId` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='留言信息表';


-- ----------------------------
-- Table structure for `tb_orders`
-- ----------------------------
DROP TABLE IF EXISTS `tb_orders`;
CREATE TABLE `tb_orders` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单ID',
  `user_id` int(11) NOT NULL DEFAULT '0' COMMENT '用户ID，参照用户表',
  `menu_id` int(11) NOT NULL DEFAULT '0' COMMENT '菜单ID，参照菜单表',
  `order_num` int(255) NOT NULL DEFAULT '0' COMMENT '订购菜品数量',
  `order_notice` varchar(45) DEFAULT NULL COMMENT '口味要求',
  `other_notice` varchar(100) DEFAULT NULL COMMENT '其他要求',
  `states` varchar(4) NOT NULL DEFAULT '' COMMENT '订单付款状态',
  PRIMARY KEY (`order_id`),
  KEY `foreign_key_userId` (`user_id`),
  KEY `foreign_key_menuId` (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='订单表';


-- ----------------------------
-- Table structure for `tb_user`
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `user_name` varchar(30) NOT NULL DEFAULT '' COMMENT '用户名',
  `user_password` varchar(30) NOT NULL DEFAULT '' COMMENT '用户密码',
  `user_realname` varchar(50) DEFAULT NULL COMMENT '用户真实姓名',
  `user_sex` varchar(30) DEFAULT NULL COMMENT '性别',
  `user_flag` varchar(4) NOT NULL DEFAULT '' COMMENT '身份',
  `user_mail` varchar(50) NOT NULL DEFAULT '' COMMENT 'E-mail',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', '张三', '123456', '张三疯', '女', '普通用户', 'abc@qq.com');
INSERT INTO `tb_user` VALUES ('2', '李四', '12345', '毛毛', '男', '管理员', 'abc123@163.com');

-- ----------------------------
-- Table structure for `user_info`
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '配送信息ID',
  `user_id` int(11) NOT NULL DEFAULT '0' COMMENT '用户ID，参照用户表',
  `address` varchar(100) NOT NULL DEFAULT '' COMMENT '送货地址',
  `tel` varchar(15) DEFAULT NULL COMMENT '用户电话',
  `mobile` varchar(11) NOT NULL DEFAULT '' COMMENT '用户手机',
  `notice` varchar(150) DEFAULT NULL COMMENT '备注',
  `send_date` varchar(45) DEFAULT NULL COMMENT '送货时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户配送信息表';


