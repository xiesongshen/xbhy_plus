/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 50540
 Source Host           : localhost:3306
 Source Schema         : xbhy

 Target Server Type    : MySQL
 Target Server Version : 50540
 File Encoding         : 65001

 Date: 03/09/2020 09:57:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文章标题',
  `content` varchar(5000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文章内容',
  `browse_count` int(11) NULL DEFAULT NULL COMMENT '浏览次数',
  `publish_date` datetime NULL DEFAULT NULL COMMENT '发布时间',
  `publish_real_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发布人名称',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '发布人id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 40 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES (1, '如何做一名合格的Java工程师？', '如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师', 1188, '2019-07-11 16:30:21', '超级管理员', 1);
INSERT INTO `article` VALUES (2, '学会自立', '学会自立', 302, '2019-01-11 21:30:29', '超级管理员', 1);
INSERT INTO `article` VALUES (3, '在逆境中生长', '在逆境中生长', 766, '2018-01-11 16:14:11', '东方标准', 6);
INSERT INTO `article` VALUES (4, '阳光总在风雨后', '阳光总在风雨后', 164, '2019-07-11 16:30:21', '小标', 4);
INSERT INTO `article` VALUES (5, '我真的很不错', '我真的很不错', 263, '2019-07-11 16:30:21', '小东', 2);
INSERT INTO `article` VALUES (6, '你若安好便是晴天', '你若安好便是晴天', 161, '2019-06-08 16:12:21', '小准', 5);
INSERT INTO `article` VALUES (8, '入门到精通', '删库跑路(rm /rf /*)', 2589548, '2019-07-24 10:52:31', '小准', 5);
INSERT INTO `article` VALUES (9, 'Java入门到精通', 'Java入门到精通', 114, '2019-07-14 10:52:31', '小准', 5);
INSERT INTO `article` VALUES (10, 'Spring入门到精通', 'Java入门到精通', 544, '2019-04-24 10:52:31', '小准', 5);
INSERT INTO `article` VALUES (11, 'SpringMVC入门到精通', 'Java入门到精通', 34, '2019-02-24 10:52:31', '小准', 5);
INSERT INTO `article` VALUES (12, 'SpringBoot入门到精通', 'Java入门到精通', 51, '2019-01-24 10:52:31', '小准', 5);
INSERT INTO `article` VALUES (13, 'MyBatis入门到精通', 'Java入门到精通', 232, '2019-07-24 10:52:31', '小准', 5);
INSERT INTO `article` VALUES (14, '23423424', '23423', 21, '2019-12-03 10:47:54', '超级管理员', 1);
INSERT INTO `article` VALUES (15, '东方标准', '东方标准真好', 23, '2019-07-25 10:55:06', '超级管理员', 1);
INSERT INTO `article` VALUES (16, '今天天气好晴朗', '今天天气好晴朗，处处好风光，好风光', 0, '2019-07-25 12:48:34', '超级管理员', 1);
INSERT INTO `article` VALUES (17, '不要抱怨', '不要抱怨啊', 0, '2019-12-05 18:26:34', '超级管理员', 1);
INSERT INTO `article` VALUES (18, '如何生存', '如何生存', 0, '2019-12-05 18:27:11', '超级管理员', 1);
INSERT INTO `article` VALUES (19, '学会自律', '学会自律', 1, '2019-12-05 18:28:49', '超级管理员', 1);
INSERT INTO `article` VALUES (20, '如何稳定情绪', '如何稳定情绪', 3, '2019-12-05 18:29:09', '超级管理员', 1);
INSERT INTO `article` VALUES (21, '关于升级问题标题', 'aaa', 2, '2019-12-06 20:17:51', '超级管理员', 1);
INSERT INTO `article` VALUES (28, '电话费哈佛ID婆婆', '福建省金额破姐夫破碎机', NULL, '2020-08-15 17:08:37', '5', NULL);
INSERT INTO `article` VALUES (29, '我是你一问饿哦我在赶设么么呢', '是咯计算机后品种ifhiof电话', NULL, '2020-08-15 17:21:56', '5', NULL);
INSERT INTO `article` VALUES (30, '是的发顺丰', '发我的', NULL, '2020-08-17 09:54:53', '5', NULL);
INSERT INTO `article` VALUES (31, '325434', '5345', NULL, '2020-08-17 11:53:21', '5', NULL);
INSERT INTO `article` VALUES (32, 'aaaa', 'aaa', NULL, '2020-08-17 11:53:28', '5', NULL);
INSERT INTO `article` VALUES (36, '程俊傑', '我也不知道爲何是呢嘛', NULL, '2020-08-21 18:19:29', '程俊傑', NULL);
INSERT INTO `article` VALUES (37, '56', '56', NULL, '2020-08-22 17:10:26', '程俊傑', NULL);
INSERT INTO `article` VALUES (38, 'aa', 'aaa', NULL, '2020-08-24 12:01:23', '程俊傑', NULL);
INSERT INTO `article` VALUES (39, 'cc', 'ccc', NULL, '2020-08-24 12:01:33', '程俊傑', NULL);

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES (1, '研发部');
INSERT INTO `dept` VALUES (2, '推广部');
INSERT INTO `dept` VALUES (3, '行政部');
INSERT INTO `dept` VALUES (4, '财务部');
INSERT INTO `dept` VALUES (5, '总裁办公室');
INSERT INTO `dept` VALUES (7, '秘书部');
INSERT INTO `dept` VALUES (8, '市场部');
INSERT INTO `dept` VALUES (9, '宣传部');
INSERT INTO `dept` VALUES (10, '销售部');

-- ----------------------------
-- Table structure for favorite
-- ----------------------------
DROP TABLE IF EXISTS `favorite`;
CREATE TABLE `favorite`  (
  `u_id` int(11) NOT NULL COMMENT '收藏用户id',
  `a_id` int(11) NOT NULL COMMENT '文章id',
  PRIMARY KEY (`u_id`, `a_id`) USING BTREE,
  INDEX `u_id_favorite_rk`(`u_id`) USING BTREE,
  INDEX `a_id_favorite_rk`(`a_id`) USING BTREE,
  CONSTRAINT `c` FOREIGN KEY (`u_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `d` FOREIGN KEY (`a_id`) REFERENCES `article` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of favorite
-- ----------------------------
INSERT INTO `favorite` VALUES (1, 2);
INSERT INTO `favorite` VALUES (1, 3);
INSERT INTO `favorite` VALUES (1, 4);
INSERT INTO `favorite` VALUES (1, 5);
INSERT INTO `favorite` VALUES (1, 6);
INSERT INTO `favorite` VALUES (1, 8);
INSERT INTO `favorite` VALUES (1, 10);
INSERT INTO `favorite` VALUES (2, 1);
INSERT INTO `favorite` VALUES (3, 1);
INSERT INTO `favorite` VALUES (3, 3);
INSERT INTO `favorite` VALUES (5, 1);
INSERT INTO `favorite` VALUES (7, 1);
INSERT INTO `favorite` VALUES (29, 2);

-- ----------------------------
-- Table structure for meeting
-- ----------------------------
DROP TABLE IF EXISTS `meeting`;
CREATE TABLE `meeting`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门名称',
  `dept_id` int(11) NULL DEFAULT NULL COMMENT '部门id',
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '会议标题',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '会议内容',
  `publish_date` datetime NULL DEFAULT NULL COMMENT '发布时间',
  `start_time` datetime NULL DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime NULL DEFAULT NULL COMMENT '结束时间',
  `status` int(1) NOT NULL COMMENT '会议状态 0:未开始 1:进行中 2:已结束',
  `make_user` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '抄送人id，以逗号分隔',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `dept_id_conference_rk`(`dept_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 66 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of meeting
-- ----------------------------
INSERT INTO `meeting` VALUES (1, '研发部', 1, '关于小标交友部门功能升级', '小标交友有如下问题：1、会议模块需要升级，2、文章模块需要升级，3、用户模块需要升级', '2019-12-04 00:00:00', '2019-12-16 21:07:00', '2019-12-16 12:43:00', 2, '[1,2,3]');
INSERT INTO `meeting` VALUES (2, '研发部', 1, '客户需求变更', '客户需求变更', '2019-12-05 00:00:00', '2019-12-05 20:23:28', '2019-12-05 20:23:31', 2, '[1,2,3,4]');
INSERT INTO `meeting` VALUES (30, '研发部', 1, '今天下午五点临时会议', '客户来了新需求，Java和产品留下讨论需求', '2019-12-06 00:00:00', '2019-12-06 17:00:50', '2019-12-06 18:30:50', 2, '[3, 5, 6]');
INSERT INTO `meeting` VALUES (31, '研发部', 1, '测试会议', 'aa', '2019-12-06 00:00:00', '2019-12-06 16:55:02', '2019-12-06 16:56:10', 2, '[2, 3, 4, 5, 6, 7]');
INSERT INTO `meeting` VALUES (32, '研发部', 1, '会议标题', 'asdasd', '2019-12-06 00:00:00', '2020-01-04 15:15:29', '2020-02-07 06:50:29', 2, '[2, 3, 4, 5]');
INSERT INTO `meeting` VALUES (33, '研发部', 1, 'Java1908班会议', 'asdasd', '2019-12-06 00:00:00', '2019-12-06 20:28:29', '2019-12-12 20:29:00', 2, '[2, 3, 4]');
INSERT INTO `meeting` VALUES (34, '研发部', 1, '哈哈哈哈哈', '哈哈哈哈哈', '2019-12-06 20:29:30', '2019-12-04 09:45:00', '2019-12-06 16:56:10', 2, '[2, 4, 5, 6]');
INSERT INTO `meeting` VALUES (35, '研发部', 1, '研发部留下开会', '讨论研发部加薪问题', '2020-01-03 11:47:15', '2020-01-03 15:15:29', '2020-01-03 15:55:29', 2, '[3, 4, 5, 6]');
INSERT INTO `meeting` VALUES (62, NULL, 4, 'hello', '哈哈哈哈哈哈哈', '2020-08-22 10:28:40', '2020-08-22 10:28:32', '2020-08-22 12:28:35', 2, '[1]');
INSERT INTO `meeting` VALUES (63, NULL, 7, '6565', '55', '2020-08-29 15:58:01', '2020-08-29 15:59:19', '2020-08-29 17:59:59', 2, '[1]');
INSERT INTO `meeting` VALUES (64, NULL, 1, 'hello', '111', '2020-08-29 15:50:05', '2020-08-29 15:50:51', '2020-08-29 15:51:00', 2, '[2, 3]');
INSERT INTO `meeting` VALUES (65, NULL, 1, 'hello', '111', '2020-08-29 16:07:43', '2020-08-29 16:09:29', '2020-08-29 16:10:33', 2, '[3]');

-- ----------------------------
-- Table structure for meeting_join
-- ----------------------------
DROP TABLE IF EXISTS `meeting_join`;
CREATE TABLE `meeting_join`  (
  `u_id` int(11) NULL DEFAULT NULL COMMENT '需参加人id',
  `c_id` int(11) NULL DEFAULT NULL COMMENT '会议id',
  INDEX `u_id_con_join_rk`(`u_id`) USING BTREE,
  INDEX `c_id_con_join_rk`(`c_id`) USING BTREE,
  CONSTRAINT `meeting_join_ibfk_1` FOREIGN KEY (`u_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `meeting_join_ibfk_2` FOREIGN KEY (`c_id`) REFERENCES `meeting` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of meeting_join
-- ----------------------------
INSERT INTO `meeting_join` VALUES (1, 2);
INSERT INTO `meeting_join` VALUES (1, 62);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `qq_openid` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'QQ登录标识符',
  `wx_openid` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '微信登录标识符',
  `real_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `age` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `phone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `gender` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别 1:男 0:女',
  `desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '简介',
  `register_time` datetime NULL DEFAULT NULL COMMENT '注册时间',
  `login_time` datetime NULL DEFAULT NULL COMMENT '上次登录时间',
  `pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `look` int(11) NULL DEFAULT NULL COMMENT '查看数',
  `is_secret` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否私密 0：私密 1：公开',
  `dept_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门名称',
  `dept_id` int(11) NULL DEFAULT NULL COMMENT '部门id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', 'a906449d5769fa7361d7ecc6aa3f6d28', '1692495161@qq.com', NULL, NULL, '程俊傑', 20, '5248596', '1', NULL, '2019-12-01 10:51:50', '2020-08-29 17:07:34', '/uploadImage/58a39942-0f8e-4c23-9b4e-1c51c742a173.jpg', 136, '0', '总裁办公室', 7);
INSERT INTO `user` VALUES (2, 'xiaodong', 'admin', 'xiaobiao@dfbz.com', NULL, NULL, '小东', 18, '110', '1', '我很帅啊', '2019-12-02 12:35:10', '2019-11-20 10:51:53', 'http://localhost:8080/upload/def.png', 32, '1', '研发部', 1);
INSERT INTO `user` VALUES (3, 'xiaofang', 'admin', 'xiaofang@dfbz.com', NULL, NULL, '小方', 18, '110', '1', '我很帅啊', '2019-12-02 12:35:10', '2019-11-20 10:51:53', 'http://localhost:8080/upload/def.png', 90, '0', '研发部', 1);
INSERT INTO `user` VALUES (4, 'xiaobiao', 'admin', 'xiaobiao@dfbz.com', NULL, NULL, '小标', 18, '110', '1', '我很帅啊', '2019-12-02 12:35:10', '2019-11-20 10:51:53', 'http://localhost:8080/upload/def.png', 27, '1', '研发部', 1);
INSERT INTO `user` VALUES (5, 'xiaozhun', 'admin', 'xiaozhun@dfbz.com', NULL, NULL, '小准', 18, '110', '1', '我很帅啊', '2019-12-02 12:35:10', '2019-11-20 10:51:53', 'http://localhost:8080/upload/def.png', 31, '1', '研发部', 1);
INSERT INTO `user` VALUES (6, 'dfbz', 'admin', 'dfbz@dfbz.com', NULL, NULL, '东方标准', 18, '110', '1', '我很帅啊', '2019-11-28 11:30:24', '2019-11-20 10:51:53', 'http://localhost:8080/upload/def.png', 20, '1', '研发部', 1);
INSERT INTO `user` VALUES (7, 'xiaoming', 'admin', 'xm@dfbz.com', NULL, NULL, '小明', 18, '110', '1', '我很帅啊', '2019-12-04 07:30:28', '2019-11-20 10:51:53', 'http://localhost:8080/upload/def.png', 21, '1', '研发部', 1);
INSERT INTO `user` VALUES (8, 'root', 'admin', 'root@dfbz.com', NULL, NULL, '管理员', 28, '110', '0', NULL, '2019-12-06 12:33:41', '2019-12-06 00:00:00', 'http://localhost:8080/upload/22892836-ed70-4039-8558-69dc81dd676b.png', 66, '0', '总裁办公室', 3);
INSERT INTO `user` VALUES (9, 'root_1', 'admin', 'root_1@dfbz.com', NULL, NULL, '管理员1号', 18, '119', '0', NULL, '2019-12-06 12:37:29', '2019-12-06 00:00:00', 'http://localhost:8080/upload/def.png', 29, '0', NULL, NULL);
INSERT INTO `user` VALUES (17, 'cc-475fd36f42ef', NULL, NULL, '3584F8F99BE67A5254A122D123B2BE24', NULL, 'Cool', 3332, '111', NULL, NULL, '2019-12-27 12:07:54', '2019-12-27 00:00:00', 'http://localhost:8080/upload/f1a3139d-d51a-4376-9ad7-90a4f2aa28de.png', 21, NULL, '秘书部', 7);
INSERT INTO `user` VALUES (18, 'af-845c0bfa13d5', NULL, NULL, '80303D26E1091C58F41FFAB08123F427', NULL, 'qq', 11, '110', NULL, NULL, '2019-12-27 15:30:53', '2020-01-03 00:00:00', 'http://thirdqq.qlogo.cn/g?b=oidb&k=7ywAfU4U8EOKpibrQ2UXibkw&s=100&t=1556885708', 29, NULL, '财务部', 4);
INSERT INTO `user` VALUES (19, 'a9-4b9ef510e8a9', NULL, NULL, NULL, 'oQ4QeuPW7WL6ZwKt4Dc9wlc8WjRY', 'For', NULL, NULL, '1', NULL, '2019-12-31 10:49:37', '2020-01-03 00:00:00', 'http://thirdwx.qlogo.cn/mmopen/vi_32/icxlG7XRNqvQ4gUhgicXlz0oH4icR2E2MH8T0qic2X2KdbIiaKGlp9FQ91qnHjr2KW2uBBOZyfia7WOasvgIjgh3yK4A/132', 3, '0', NULL, NULL);
INSERT INTO `user` VALUES (20, '7f-3ea444301d8d', NULL, NULL, '01CC173B24CFE00ABD613E6AB58CED54', NULL, '嘿嘿嘿', NULL, NULL, NULL, NULL, '2019-12-31 16:45:47', '2019-12-31 00:00:00', 'http://thirdqq.qlogo.cn/g?b=oidb&k=IMauKBZYyia9kUL43DEiaMOQ&s=100&t=1557174653', 10, '0', NULL, NULL);
INSERT INTO `user` VALUES (21, '8a-6e107a887a55', NULL, NULL, NULL, 'oQ4QeuNRR9S_4IyRzkJbNRoPNSH4', '嘿嘿嘿', 1, '234234234', NULL, NULL, '2019-12-31 16:46:20', '2019-12-31 00:00:00', 'http://localhost:8080/upload/a3fb2503-b1b1-46e1-854a-8051c7368b41.jpg', 1, '1', '财务部', 4);
INSERT INTO `user` VALUES (25, 'aaa', 'c1942ee4200b10f6890abc0544646ecd', '386999091@qq.com', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (26, 'admin1', 'd1bed66f2b4d161d6fe10eab459e087', '11', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL);
INSERT INTO `user` VALUES (27, 'admin2', '8e6a5100f09253b2c4d9de5cf2af556e', '11', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2020-08-23 12:58:41', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (28, 'a11', 'a906449d5769fa7361d7ecc6aa3f6d28', '386999091@qq.com11', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2020-08-24 11:38:39', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (29, 'admin3', '8ead19ac784929f84da7a71f30de2049', 'zijun1024@aliyun.com', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2020-08-24 12:12:25', '/uploadImage/5638bc21-eb2b-4271-9d06-23ab96a2a726.png', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for userfocus
-- ----------------------------
DROP TABLE IF EXISTS `userfocus`;
CREATE TABLE `userfocus`  (
  `user_id` int(10) NOT NULL COMMENT '用户id',
  `user_focus_id` int(10) NOT NULL COMMENT '用户关注的朋友id',
  PRIMARY KEY (`user_id`, `user_focus_id`) USING BTREE,
  INDEX `fk_userFocus_user_1`(`user_id`) USING BTREE,
  INDEX `fk_userFocus_user_2`(`user_focus_id`) USING BTREE,
  CONSTRAINT `a` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `b` FOREIGN KEY (`user_focus_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of userfocus
-- ----------------------------
INSERT INTO `userfocus` VALUES (1, 2);
INSERT INTO `userfocus` VALUES (1, 4);
INSERT INTO `userfocus` VALUES (1, 5);
INSERT INTO `userfocus` VALUES (1, 6);
INSERT INTO `userfocus` VALUES (1, 7);
INSERT INTO `userfocus` VALUES (1, 8);
INSERT INTO `userfocus` VALUES (1, 9);
INSERT INTO `userfocus` VALUES (1, 17);
INSERT INTO `userfocus` VALUES (1, 18);
INSERT INTO `userfocus` VALUES (1, 19);
INSERT INTO `userfocus` VALUES (1, 20);
INSERT INTO `userfocus` VALUES (1, 21);
INSERT INTO `userfocus` VALUES (1, 25);
INSERT INTO `userfocus` VALUES (1, 26);
INSERT INTO `userfocus` VALUES (1, 27);
INSERT INTO `userfocus` VALUES (1, 28);
INSERT INTO `userfocus` VALUES (1, 29);
INSERT INTO `userfocus` VALUES (3, 1);
INSERT INTO `userfocus` VALUES (4, 1);
INSERT INTO `userfocus` VALUES (5, 1);
INSERT INTO `userfocus` VALUES (18, 9);
INSERT INTO `userfocus` VALUES (18, 17);

-- ----------------------------
-- Event structure for auto_update_status
-- ----------------------------
DROP EVENT IF EXISTS `auto_update_status`;
delimiter ;;
CREATE DEFINER = `root`@`localhost` EVENT `auto_update_status`
ON SCHEDULE
EVERY '1' SECOND STARTS '2019-12-13 12:36:21'
DO begin
	-- 修改使用子查询,否则报错(You can't specify target table 'meeting' for update in FROM clause) 不可以在update语句中使用本表查询
	update meeting set status = 1 where id in (
	
		select a.id from (
			select id from meeting where DATE_FORMAT(start_time,'%Y-%m-%d %H:%i')=DATE_FORMAT(now(),'%Y-%m-%d %H:%i')
		
		) a
	
	);
	update meeting set status = 2 where id in (
	
		select a.id from (
			select id from meeting where DATE_FORMAT(end_time,'%Y-%m-%d %H:%i')=DATE_FORMAT(now(),'%Y-%m-%d %H:%i')
		) a
	
	);
end
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
